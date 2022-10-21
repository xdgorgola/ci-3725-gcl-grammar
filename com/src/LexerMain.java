package com.src;

import com.parsing.GCL;

import java.io.File;
import java.util.Scanner;
import java.util.Iterator;
import java.io.FileNotFoundException;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;


/**
 * Clase principal
 */
public class LexerMain {

    /** Input recibido en forma de string */
    public String _input;
    

    public static void main(String[] args) {
        if (args.length != 1)
        {
            // Print de instrucciones.
            return;
        }

        LexerMain main;
        try {
            main = new LexerMain(args[0]);
        } catch (FileNotFoundException | IllegalArgumentException e) {
            // Print de instrucciones
            return;
        }

        CharStream input = CharStreams.fromString(main._input);
        
        GCL grammar = new GCL(input);
        grammar.removeErrorListeners();
        grammar.addErrorListener(new GCLErrorListener());
        
        Iterator<? extends Token> tokens = grammar.getAllTokens().iterator();
        Token cur = null;
        while (tokens.hasNext())
        {
            cur = tokens.next();
            System.out.println(String.format("%s %s %s --> %s", GCL.ruleNames[cur.getType() - 1], cur.getLine(),
                cur.getCharPositionInLine(), cur.getText()));
        }
    }


    /**
     * Abre un archivo y chequea si es de formato .gcl
     * @param filePath Path del archivo
     * @return Archivo abierto
     * @throws FileNotFoundException Si no se puede abrir el archivo.
     * @throws IllegalArgumentException Si el archivo no es .gcl
     */
    private File openGCLFile(String filePath) throws FileNotFoundException, IllegalArgumentException {

        if (!filePath.endsWith(".gcl")) {
            System.out.println("Archivo introducido no es de formato .gcl");
            throw new IllegalArgumentException();
        }

        File f = new File(filePath);
        if (!f.exists())
            throw new FileNotFoundException();

        return f;
    }


    /**
     * Construye programa principal del lexeador y recibe el input
     * de un archivo.
     * 
     * @param filePath Path de archivo con input
     * @throws FileNotFoundException Si no se puede abrir el archivo
     * @throws IllegalArgumentException Si el archivo no es .gcl
     */
    public LexerMain(String filePath) throws FileNotFoundException, IllegalArgumentException {
        File f = openGCLFile(filePath);
        
        Scanner sc = new Scanner(f);
        sc.useDelimiter("\\Z"); // chequear si es multiplataforma
        StringBuilder sb = new StringBuilder();
        while (sc.hasNext()) {
            sb.append(sc.next());
        }
        
        _input = sb.toString();
        //System.out.println(_input);
        sc.close();
    }   
}
