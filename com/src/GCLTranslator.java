package com.src;

import java.io.File;
import java.util.BitSet;
import java.util.Scanner;
import java.util.Iterator;
import java.io.FileNotFoundException;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.dfa.DFA;

import com.parsing.GCL;

import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.RecognitionException;


public class GCLTranslator implements ANTLRErrorListener {

    /** Input recibido en forma de string */
    private String _input = null;
    /** Gramatica de GCL */
    private GCL _gclGrammar = null;
    /** Indica si hubo un error de lexeo */
    private boolean _lexerErrorFound = false;


    public static void main(String[] args) {
        if (args.length != 1) {
            // Print de instrucciones.
            return;
        }

        GCLTranslator translator;
        try {
            translator = new GCLTranslator(args[0]);
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
            return;
        } catch (IllegalArgumentException e) {
            System.out.println("Archivo no tiene formato .gcl");
            return;
        }

        translator.printLexerInfo();
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


    /**
     * Printea informacion sobre el proceso de lexeo
     */
    public void printLexerInfo()
    {
        if (_input == null) {
            return;
        }

        Iterator<? extends Token> tokens = _gclGrammar.getAllTokens().iterator();
        
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
            case GCL.TkString:
            case GCL.TkNum:
                System.out.println(String.format("%s(%s) %s %s", GCL.ruleNames[num - 1], cur.getText(),
                    cur.getLine(), cur.getCharPositionInLine()));
                return;
            case GCL.TkId:
                System.out.println(String.format("%s(\"%s\") %s %s", GCL.ruleNames[num - 1], cur.getText(),
                    cur.getLine(), cur.getCharPositionInLine()));
                return;
            default: 
                System.out.println(String.format("%s %s %s", GCL.ruleNames[num - 1],
                    cur.getLine(), cur.getCharPositionInLine()));
                return;
        } 
    }


    @Override
    public void reportAmbiguity(Parser arg0, DFA arg1, int arg2, int arg3, boolean arg4, BitSet arg5,
            ATNConfigSet arg6) {
        // TODO No usado
        throw new UnsupportedOperationException("No implementado aun.");
    }


    @Override
    public void reportAttemptingFullContext(Parser arg0, DFA arg1, int arg2, int arg3, BitSet arg4, ATNConfigSet arg5) {
        // TODO No usado
        throw new UnsupportedOperationException("No implementado aun.");
    }


    @Override
    public void reportContextSensitivity(Parser arg0, DFA arg1, int arg2, int arg3, int arg4, ATNConfigSet arg5) {
        // TODO No usado
        throw new UnsupportedOperationException("No implementado aun.");
    }


    @Override
    public void syntaxError(Recognizer<?, ?> arg0, Object arg1, int arg2, int arg3, String arg4,
            RecognitionException arg5) {

        System.out.format("Error: Unexpected character \"%s\" in row %s, column %s\n", arg5.toString().split("'")[1], arg2, arg3);
        _lexerErrorFound = true;
    }


    /**
     * Construye programa principal del lexeador y recibe el input
     * de un archivo.
     * 
     * @param filePath Path de archivo con input
     * @throws FileNotFoundException Si no se puede abrir el archivo
     * @throws IllegalArgumentException Si el archivo no es .gcl
     */
    public GCLTranslator(String filePath) throws FileNotFoundException, IllegalArgumentException {
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

        _gclGrammar = new GCL(CharStreams.fromString(_input));
        _gclGrammar.removeErrorListeners();
        _gclGrammar.addErrorListener(this);
    } 
}