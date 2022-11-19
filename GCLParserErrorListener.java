import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;

public class GCLParserErrorListener extends BaseErrorListener {
    
    private GCL translator;

    @Override
    public void syntaxError(Recognizer<?, ?> arg0, Object arg1, int arg2, int arg3, String arg4,
            RecognitionException arg5) {

        System.out.format("Syntax error in row in row %s, column %s: Unexpected token: \'%s\'\n", 
            arg2, arg3 + 1, arg5.getOffendingToken().getText());
            
        translator.receiveParserError();
    }
    
    public GCLParserErrorListener(GCL source)
    {
        translator = source;
    }
}