import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;

/** Error listener del parser completo */
public class GCLParserErrorListener extends BaseErrorListener {
    
    public boolean _errorInLexer = false;

    @Override
    public void syntaxError(Recognizer<?, ?> arg0, Object arg1, int arg2, int arg3, String arg4,
            RecognitionException arg5) {

        // Caso de lexer
        if (arg1 == null)
        {
            System.out.format("Error: Unexpected character \"%s\" in row %s, column %s\n", arg5.toString().split("'")[1], arg2, arg3 + 1);
            _errorInLexer = true;
            return;
        }

        if (_errorInLexer)
            System.exit(-1);

        System.out.format("Syntax error in row in row %s, column %s: Unexpected token: \'%s\'\n", 
            arg2, arg3 + 1, ((Token)arg1).getText());          
            
        System.exit(0);  
    }
}