import java.io.File;
import java.util.Scanner;
import java.util.Iterator;
import java.util.List;
import java.io.FileNotFoundException;

import com.parsing.GCLGrammarLexer;
import com.parsing.GCLGrammarParser;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.BufferedTokenStream;


public class GCL {

    /** Input recibido en forma de string */
    private String _input = null;
    /** Gramatica de GCL */
    private GCLGrammarLexer _gclLexer = null;
    private GCLGrammarParser _gclParser = null;
    /** Indica si hubo un error de lexeo */
    private boolean _lexerErrorFound = false;


    public static void main(String[] args) {
        if (args.length != 1) {
            // Print de instrucciones.
            return;
        }

        GCL translator;
        try {
            translator = new GCL(args[0]);
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
            return;
        } catch (IllegalArgumentException e) {
            System.out.println("Archivo no tiene formato .gcl");
            return;
        }

        translator.getLexerTokens();
        if (translator.getLexerErrorFound())
            return;

        ASTPrinter visitor = new ASTPrinter(); 
        visitor.visit(translator._gclParser.block());
    }


    /**
     * Abre un archivo y chequea si es de formato .gcl
     * @param filePath Path del archivo
     * @return Archivo abierto
     * @throws FileNotFoundException Si no se puede abrir el archivo.
     * @throws IllegalArgumentException Si el archivo no es .gcl
     */
    private static File openGCLFile(String filePath) throws FileNotFoundException, IllegalArgumentException {

        if (!filePath.endsWith(".gcl")) {
            throw new IllegalArgumentException();
        }

        File f = new File(filePath);
        if (!f.exists())
            throw new FileNotFoundException();

        return f;
    }


    public List<? extends Token> getLexerTokens()
    {
        return _gclLexer.getAllTokens();
    }

    
    public boolean getLexerErrorFound()
    {
        return _lexerErrorFound;
    }

    
    /**
     * Printea informacion sobre el proceso de lexeo
     */
    public void printLexerInfo()
    {
        if (_input == null) {
            return;
        }

        Iterator<? extends Token> tokens = _gclLexer.getAllTokens().iterator();
        
        if (_lexerErrorFound) {
            return;
        }
        
        Token cur = null;
        while (tokens.hasNext()) {
            cur = tokens.next();
            printToken(cur);
        }
    }

    
    /**
     * Función que recibe un token y lo imprime con el formato dado en el
     * enunciado del proyecto.
     * 
     * @param cur Token a imprimir, junto a su localización (fila y columna)
     * y su valor
     */
    public static void printToken(Token cur) {
        int num = cur.getType();
        switch (num) {
            case GCLGrammarLexer.TkString:
            case GCLGrammarLexer.TkNum:
                System.out.println(String.format("%s(%s) %s %s", GCLGrammarLexer.ruleNames[num - 1], cur.getText(),
                    cur.getLine(), cur.getCharPositionInLine() + 1));
                return;
            case GCLGrammarLexer.TkId:
                System.out.println(String.format("%s(\"%s\") %s %s", GCLGrammarLexer.ruleNames[num - 1], cur.getText(),
                    cur.getLine(), cur.getCharPositionInLine() + 1));
                return;
            default: 
                System.out.println(String.format("%s %s %s", GCLGrammarLexer.ruleNames[num - 1],
                    cur.getLine(), cur.getCharPositionInLine() + 1));
                return;
        } 
    }

    public void receiveLexerError()
    {
        _lexerErrorFound = true;
    }

    public void receiveParserError()
    {
        System.exit(0);
    }

    /**
     * Construye programa principal del lexeador y recibe el input
     * de un archivo.
     * 
     * @param filePath Path de archivo con input
     * @throws FileNotFoundException Si no se puede abrir el archivo
     * @throws IllegalArgumentException Si el archivo no es .gcl
     */
    public GCL(String filePath) throws FileNotFoundException, IllegalArgumentException {
        File f = openGCLFile(filePath);
        
        Scanner sc = new Scanner(f);
        sc.useDelimiter("\\Z"); // chequear si es multiplataforma
        StringBuilder sb = new StringBuilder();
        while (sc.hasNext()) {
            sb.append(sc.next());
        }
        
        _input = sb.toString();
        sc.close();
        
        _lexerErrorFound = false;

        _gclLexer = new GCLGrammarLexer(CharStreams.fromString(_input));
        _gclLexer.removeErrorListeners(); // quitar por los momentos ya que sino, no funciona en el parser!
        _gclLexer.addErrorListener(new GCLLexerErrorListener(this));

        _gclParser = new GCLGrammarParser(new BufferedTokenStream(_gclLexer));
        _gclParser.removeErrorListeners();
        _gclParser.addErrorListener(new GCLParserErrorListener(this)); //HACER OTRO ERROR LISTENER PARA EL PARSER PORQUE ESTE CRASHEA EL PARSER
    } 
}