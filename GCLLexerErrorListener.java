import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;

public class GCLLexerErrorListener extends BaseErrorListener {
    
    private GCL translator;

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