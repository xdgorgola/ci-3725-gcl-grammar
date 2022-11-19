import java.util.BitSet;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.dfa.DFA;

import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.RecognitionException;

public class GCLLexerErrorListener implements ANTLRErrorListener {
    
    private GCL translator;
    
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

        System.out.format("Error: Unexpected character \"%s\" in row %s, column %s\n", arg5.toString().split("'")[1], arg2, arg3 + 1);
        translator.receiveLexerError();
    }

    
    public GCLLexerErrorListener(GCL source)
    {
        translator = source;
    }
}