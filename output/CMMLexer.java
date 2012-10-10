// $ANTLR 3.4 /home/cattail/Desktop/catperter/CMM.g 2012-10-10 16:06:59

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class CMMLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int ASSIGNMENT_OPERATOR=4;
    public static final int COMMENT=5;
    public static final int EQ_OP=6;
    public static final int IDENTIFIER=7;
    public static final int INT_LITERAL=8;
    public static final int LINE_COMMENT=9;
    public static final int NE_OP=10;
    public static final int REAL_LITERAL=11;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public CMMLexer() {} 
    public CMMLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public CMMLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "/home/cattail/Desktop/catperter/CMM.g"; }

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cattail/Desktop/catperter/CMM.g:2:7: ( '(' )
            // /home/cattail/Desktop/catperter/CMM.g:2:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cattail/Desktop/catperter/CMM.g:3:7: ( ')' )
            // /home/cattail/Desktop/catperter/CMM.g:3:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cattail/Desktop/catperter/CMM.g:4:7: ( '*' )
            // /home/cattail/Desktop/catperter/CMM.g:4:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cattail/Desktop/catperter/CMM.g:5:7: ( '+' )
            // /home/cattail/Desktop/catperter/CMM.g:5:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cattail/Desktop/catperter/CMM.g:6:7: ( ',' )
            // /home/cattail/Desktop/catperter/CMM.g:6:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cattail/Desktop/catperter/CMM.g:7:7: ( '-' )
            // /home/cattail/Desktop/catperter/CMM.g:7:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cattail/Desktop/catperter/CMM.g:8:7: ( '/' )
            // /home/cattail/Desktop/catperter/CMM.g:8:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cattail/Desktop/catperter/CMM.g:9:7: ( ';' )
            // /home/cattail/Desktop/catperter/CMM.g:9:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cattail/Desktop/catperter/CMM.g:10:7: ( '<' )
            // /home/cattail/Desktop/catperter/CMM.g:10:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cattail/Desktop/catperter/CMM.g:11:7: ( '=' )
            // /home/cattail/Desktop/catperter/CMM.g:11:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cattail/Desktop/catperter/CMM.g:12:7: ( 'else' )
            // /home/cattail/Desktop/catperter/CMM.g:12:9: 'else'
            {
            match("else"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cattail/Desktop/catperter/CMM.g:13:7: ( 'if' )
            // /home/cattail/Desktop/catperter/CMM.g:13:9: 'if'
            {
            match("if"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cattail/Desktop/catperter/CMM.g:14:7: ( 'int' )
            // /home/cattail/Desktop/catperter/CMM.g:14:9: 'int'
            {
            match("int"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cattail/Desktop/catperter/CMM.g:15:7: ( 'real' )
            // /home/cattail/Desktop/catperter/CMM.g:15:9: 'real'
            {
            match("real"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cattail/Desktop/catperter/CMM.g:16:7: ( 'while' )
            // /home/cattail/Desktop/catperter/CMM.g:16:9: 'while'
            {
            match("while"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cattail/Desktop/catperter/CMM.g:17:7: ( '{' )
            // /home/cattail/Desktop/catperter/CMM.g:17:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cattail/Desktop/catperter/CMM.g:18:7: ( '}' )
            // /home/cattail/Desktop/catperter/CMM.g:18:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cattail/Desktop/catperter/CMM.g:89:5: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // /home/cattail/Desktop/catperter/CMM.g:89:9: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 



            // /home/cattail/Desktop/catperter/CMM.g:89:14: ( options {greedy=false; } : . )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='*') ) {
                    int LA1_1 = input.LA(2);

                    if ( (LA1_1=='/') ) {
                        alt1=2;
                    }
                    else if ( ((LA1_1 >= '\u0000' && LA1_1 <= '.')||(LA1_1 >= '0' && LA1_1 <= '\uFFFF')) ) {
                        alt1=1;
                    }


                }
                else if ( ((LA1_0 >= '\u0000' && LA1_0 <= ')')||(LA1_0 >= '+' && LA1_0 <= '\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/cattail/Desktop/catperter/CMM.g:89:42: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            match("*/"); 



            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "LINE_COMMENT"
    public final void mLINE_COMMENT() throws RecognitionException {
        try {
            int _type = LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cattail/Desktop/catperter/CMM.g:92:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // /home/cattail/Desktop/catperter/CMM.g:92:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 



            // /home/cattail/Desktop/catperter/CMM.g:92:12: (~ ( '\\n' | '\\r' ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '\u0000' && LA2_0 <= '\t')||(LA2_0 >= '\u000B' && LA2_0 <= '\f')||(LA2_0 >= '\u000E' && LA2_0 <= '\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/cattail/Desktop/catperter/CMM.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            // /home/cattail/Desktop/catperter/CMM.g:92:26: ( '\\r' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='\r') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /home/cattail/Desktop/catperter/CMM.g:92:26: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }


            match('\n'); 

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LINE_COMMENT"

    // $ANTLR start "IDENTIFIER"
    public final void mIDENTIFIER() throws RecognitionException {
        try {
            int _type = IDENTIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cattail/Desktop/catperter/CMM.g:99:2: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )? )
            // /home/cattail/Desktop/catperter/CMM.g:99:4: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )?
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /home/cattail/Desktop/catperter/CMM.g:99:23: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '0' && LA4_0 <= '9')||(LA4_0 >= 'A' && LA4_0 <= 'Z')||LA4_0=='_'||(LA4_0 >= 'a' && LA4_0 <= 'z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /home/cattail/Desktop/catperter/CMM.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            // /home/cattail/Desktop/catperter/CMM.g:99:56: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0 >= '0' && LA5_0 <= '9')||(LA5_0 >= 'A' && LA5_0 <= 'Z')||(LA5_0 >= 'a' && LA5_0 <= 'z')) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /home/cattail/Desktop/catperter/CMM.g:
                    {
                    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IDENTIFIER"

    // $ANTLR start "INT_LITERAL"
    public final void mINT_LITERAL() throws RecognitionException {
        try {
            int _type = INT_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cattail/Desktop/catperter/CMM.g:102:2: ( ( '+' | '-' )? ( '0' .. '9' )+ )
            // /home/cattail/Desktop/catperter/CMM.g:102:4: ( '+' | '-' )? ( '0' .. '9' )+
            {
            // /home/cattail/Desktop/catperter/CMM.g:102:4: ( '+' | '-' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='+'||LA6_0=='-') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /home/cattail/Desktop/catperter/CMM.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }


            // /home/cattail/Desktop/catperter/CMM.g:102:15: ( '0' .. '9' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0 >= '0' && LA7_0 <= '9')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /home/cattail/Desktop/catperter/CMM.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INT_LITERAL"

    // $ANTLR start "REAL_LITERAL"
    public final void mREAL_LITERAL() throws RecognitionException {
        try {
            int _type = REAL_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cattail/Desktop/catperter/CMM.g:105:2: ( INT_LITERAL '.' INT_LITERAL ( ( 'e' | 'E' ) ( '+' | '-' ) INT_LITERAL )? )
            // /home/cattail/Desktop/catperter/CMM.g:105:4: INT_LITERAL '.' INT_LITERAL ( ( 'e' | 'E' ) ( '+' | '-' ) INT_LITERAL )?
            {
            mINT_LITERAL(); 


            match('.'); 

            mINT_LITERAL(); 


            // /home/cattail/Desktop/catperter/CMM.g:105:32: ( ( 'e' | 'E' ) ( '+' | '-' ) INT_LITERAL )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='E'||LA8_0=='e') ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /home/cattail/Desktop/catperter/CMM.g:105:34: ( 'e' | 'E' ) ( '+' | '-' ) INT_LITERAL
                    {
                    if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    mINT_LITERAL(); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "REAL_LITERAL"

    // $ANTLR start "ASSIGNMENT_OPERATOR"
    public final void mASSIGNMENT_OPERATOR() throws RecognitionException {
        try {
            int _type = ASSIGNMENT_OPERATOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cattail/Desktop/catperter/CMM.g:108:2: ( '=' | '+=' | '-=' | '*=' | '/=' )
            int alt9=5;
            switch ( input.LA(1) ) {
            case '=':
                {
                alt9=1;
                }
                break;
            case '+':
                {
                alt9=2;
                }
                break;
            case '-':
                {
                alt9=3;
                }
                break;
            case '*':
                {
                alt9=4;
                }
                break;
            case '/':
                {
                alt9=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }

            switch (alt9) {
                case 1 :
                    // /home/cattail/Desktop/catperter/CMM.g:108:4: '='
                    {
                    match('='); 

                    }
                    break;
                case 2 :
                    // /home/cattail/Desktop/catperter/CMM.g:109:4: '+='
                    {
                    match("+="); 



                    }
                    break;
                case 3 :
                    // /home/cattail/Desktop/catperter/CMM.g:110:4: '-='
                    {
                    match("-="); 



                    }
                    break;
                case 4 :
                    // /home/cattail/Desktop/catperter/CMM.g:111:4: '*='
                    {
                    match("*="); 



                    }
                    break;
                case 5 :
                    // /home/cattail/Desktop/catperter/CMM.g:112:4: '/='
                    {
                    match("/="); 



                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ASSIGNMENT_OPERATOR"

    // $ANTLR start "EQ_OP"
    public final void mEQ_OP() throws RecognitionException {
        try {
            int _type = EQ_OP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cattail/Desktop/catperter/CMM.g:115:2: ( '==' )
            // /home/cattail/Desktop/catperter/CMM.g:115:4: '=='
            {
            match("=="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EQ_OP"

    // $ANTLR start "NE_OP"
    public final void mNE_OP() throws RecognitionException {
        try {
            int _type = NE_OP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/cattail/Desktop/catperter/CMM.g:118:2: ( '<>' )
            // /home/cattail/Desktop/catperter/CMM.g:118:4: '<>'
            {
            match("<>"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NE_OP"

    public void mTokens() throws RecognitionException {
        // /home/cattail/Desktop/catperter/CMM.g:1:8: ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | COMMENT | LINE_COMMENT | IDENTIFIER | INT_LITERAL | REAL_LITERAL | ASSIGNMENT_OPERATOR | EQ_OP | NE_OP )
        int alt10=25;
        alt10 = dfa10.predict(input);
        switch (alt10) {
            case 1 :
                // /home/cattail/Desktop/catperter/CMM.g:1:10: T__12
                {
                mT__12(); 


                }
                break;
            case 2 :
                // /home/cattail/Desktop/catperter/CMM.g:1:16: T__13
                {
                mT__13(); 


                }
                break;
            case 3 :
                // /home/cattail/Desktop/catperter/CMM.g:1:22: T__14
                {
                mT__14(); 


                }
                break;
            case 4 :
                // /home/cattail/Desktop/catperter/CMM.g:1:28: T__15
                {
                mT__15(); 


                }
                break;
            case 5 :
                // /home/cattail/Desktop/catperter/CMM.g:1:34: T__16
                {
                mT__16(); 


                }
                break;
            case 6 :
                // /home/cattail/Desktop/catperter/CMM.g:1:40: T__17
                {
                mT__17(); 


                }
                break;
            case 7 :
                // /home/cattail/Desktop/catperter/CMM.g:1:46: T__18
                {
                mT__18(); 


                }
                break;
            case 8 :
                // /home/cattail/Desktop/catperter/CMM.g:1:52: T__19
                {
                mT__19(); 


                }
                break;
            case 9 :
                // /home/cattail/Desktop/catperter/CMM.g:1:58: T__20
                {
                mT__20(); 


                }
                break;
            case 10 :
                // /home/cattail/Desktop/catperter/CMM.g:1:64: T__21
                {
                mT__21(); 


                }
                break;
            case 11 :
                // /home/cattail/Desktop/catperter/CMM.g:1:70: T__22
                {
                mT__22(); 


                }
                break;
            case 12 :
                // /home/cattail/Desktop/catperter/CMM.g:1:76: T__23
                {
                mT__23(); 


                }
                break;
            case 13 :
                // /home/cattail/Desktop/catperter/CMM.g:1:82: T__24
                {
                mT__24(); 


                }
                break;
            case 14 :
                // /home/cattail/Desktop/catperter/CMM.g:1:88: T__25
                {
                mT__25(); 


                }
                break;
            case 15 :
                // /home/cattail/Desktop/catperter/CMM.g:1:94: T__26
                {
                mT__26(); 


                }
                break;
            case 16 :
                // /home/cattail/Desktop/catperter/CMM.g:1:100: T__27
                {
                mT__27(); 


                }
                break;
            case 17 :
                // /home/cattail/Desktop/catperter/CMM.g:1:106: T__28
                {
                mT__28(); 


                }
                break;
            case 18 :
                // /home/cattail/Desktop/catperter/CMM.g:1:112: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 19 :
                // /home/cattail/Desktop/catperter/CMM.g:1:120: LINE_COMMENT
                {
                mLINE_COMMENT(); 


                }
                break;
            case 20 :
                // /home/cattail/Desktop/catperter/CMM.g:1:133: IDENTIFIER
                {
                mIDENTIFIER(); 


                }
                break;
            case 21 :
                // /home/cattail/Desktop/catperter/CMM.g:1:144: INT_LITERAL
                {
                mINT_LITERAL(); 


                }
                break;
            case 22 :
                // /home/cattail/Desktop/catperter/CMM.g:1:156: REAL_LITERAL
                {
                mREAL_LITERAL(); 


                }
                break;
            case 23 :
                // /home/cattail/Desktop/catperter/CMM.g:1:169: ASSIGNMENT_OPERATOR
                {
                mASSIGNMENT_OPERATOR(); 


                }
                break;
            case 24 :
                // /home/cattail/Desktop/catperter/CMM.g:1:189: EQ_OP
                {
                mEQ_OP(); 


                }
                break;
            case 25 :
                // /home/cattail/Desktop/catperter/CMM.g:1:195: NE_OP
                {
                mNE_OP(); 


                }
                break;

        }

    }


    protected DFA10 dfa10 = new DFA10(this);
    static final String DFA10_eotS =
        "\3\uffff\1\24\1\25\1\uffff\1\26\1\31\1\uffff\1\33\1\35\4\21\3\uffff"+
        "\1\43\13\uffff\1\21\1\46\3\21\2\uffff\1\21\1\uffff\1\53\2\21\1\56"+
        "\1\uffff\1\57\1\21\2\uffff\1\61\1\uffff";
    static final String DFA10_eofS =
        "\62\uffff";
    static final String DFA10_minS =
        "\1\50\2\uffff\1\75\1\60\1\uffff\1\60\1\52\1\uffff\1\76\1\75\1\154"+
        "\1\146\1\145\1\150\3\uffff\1\56\13\uffff\1\163\1\60\1\164\1\141"+
        "\1\151\2\uffff\1\145\1\uffff\1\60\2\154\1\60\1\uffff\1\60\1\145"+
        "\2\uffff\1\60\1\uffff";
    static final String DFA10_maxS =
        "\1\175\2\uffff\2\75\1\uffff\2\75\1\uffff\1\76\1\75\1\154\1\156\1"+
        "\145\1\150\3\uffff\1\71\13\uffff\1\163\1\172\1\164\1\141\1\151\2"+
        "\uffff\1\145\1\uffff\1\172\2\154\1\172\1\uffff\1\172\1\145\2\uffff"+
        "\1\172\1\uffff";
    static final String DFA10_acceptS =
        "\1\uffff\1\1\1\2\2\uffff\1\5\2\uffff\1\10\6\uffff\1\20\1\21\1\24"+
        "\1\uffff\1\27\1\3\1\4\1\6\1\22\1\23\1\7\1\31\1\11\1\30\1\12\5\uffff"+
        "\1\25\1\26\1\uffff\1\14\4\uffff\1\15\2\uffff\1\13\1\16\1\uffff\1"+
        "\17";
    static final String DFA10_specialS =
        "\62\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\1\1\2\1\3\1\4\1\5\1\6\1\uffff\1\7\12\22\1\uffff\1\10\1\11"+
            "\1\12\3\uffff\32\21\6\uffff\4\21\1\13\3\21\1\14\10\21\1\15\4"+
            "\21\1\16\3\21\1\17\1\uffff\1\20",
            "",
            "",
            "\1\23",
            "\12\22\3\uffff\1\23",
            "",
            "\12\22\3\uffff\1\23",
            "\1\27\4\uffff\1\30\15\uffff\1\23",
            "",
            "\1\32",
            "\1\34",
            "\1\36",
            "\1\37\7\uffff\1\40",
            "\1\41",
            "\1\42",
            "",
            "",
            "",
            "\1\44\1\uffff\12\22",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\45",
            "\12\21\7\uffff\32\21\4\uffff\1\21\1\uffff\32\21",
            "\1\47",
            "\1\50",
            "\1\51",
            "",
            "",
            "\1\52",
            "",
            "\12\21\7\uffff\32\21\4\uffff\1\21\1\uffff\32\21",
            "\1\54",
            "\1\55",
            "\12\21\7\uffff\32\21\4\uffff\1\21\1\uffff\32\21",
            "",
            "\12\21\7\uffff\32\21\4\uffff\1\21\1\uffff\32\21",
            "\1\60",
            "",
            "",
            "\12\21\7\uffff\32\21\4\uffff\1\21\1\uffff\32\21",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | COMMENT | LINE_COMMENT | IDENTIFIER | INT_LITERAL | REAL_LITERAL | ASSIGNMENT_OPERATOR | EQ_OP | NE_OP );";
        }
    }
 

}