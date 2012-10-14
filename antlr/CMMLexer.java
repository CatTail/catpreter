// $ANTLR 3.4 CMM.g 2012-10-14 12:33:57

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class CMMLexer extends Lexer {
    public static final int EOF=-1;
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
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int COMMENT=4;
    public static final int EQ_OP=5;
    public static final int IDENTIFIER=6;
    public static final int INT_LITERAL=7;
    public static final int LETTER=8;
    public static final int LINE_COMMENT=9;
    public static final int NE_OP=10;
    public static final int REAL_LITERAL=11;
    public static final int WS=12;

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
    public String getGrammarFileName() { return "CMM.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // CMM.g:2:7: ( '(' )
            // CMM.g:2:9: '('
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
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // CMM.g:3:7: ( ')' )
            // CMM.g:3:9: ')'
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
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // CMM.g:4:7: ( '*' )
            // CMM.g:4:9: '*'
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
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // CMM.g:5:7: ( '*=' )
            // CMM.g:5:9: '*='
            {
            match("*="); 



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
            // CMM.g:6:7: ( '+' )
            // CMM.g:6:9: '+'
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
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // CMM.g:7:7: ( '+=' )
            // CMM.g:7:9: '+='
            {
            match("+="); 



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
            // CMM.g:8:7: ( ',' )
            // CMM.g:8:9: ','
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
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // CMM.g:9:7: ( '-' )
            // CMM.g:9:9: '-'
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
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // CMM.g:10:7: ( '-=' )
            // CMM.g:10:9: '-='
            {
            match("-="); 



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
            // CMM.g:11:7: ( '/' )
            // CMM.g:11:9: '/'
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
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // CMM.g:12:7: ( '/=' )
            // CMM.g:12:9: '/='
            {
            match("/="); 



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
            // CMM.g:13:7: ( ';' )
            // CMM.g:13:9: ';'
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
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // CMM.g:14:7: ( '<' )
            // CMM.g:14:9: '<'
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
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // CMM.g:15:7: ( '=' )
            // CMM.g:15:9: '='
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
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // CMM.g:16:7: ( '[' )
            // CMM.g:16:9: '['
            {
            match('['); 

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
            // CMM.g:17:7: ( ']' )
            // CMM.g:17:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // CMM.g:18:7: ( 'else' )
            // CMM.g:18:9: 'else'
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
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // CMM.g:19:7: ( 'if' )
            // CMM.g:19:9: 'if'
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
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // CMM.g:20:7: ( 'int' )
            // CMM.g:20:9: 'int'
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
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // CMM.g:21:7: ( 'real' )
            // CMM.g:21:9: 'real'
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
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // CMM.g:22:7: ( 'while' )
            // CMM.g:22:9: 'while'
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
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // CMM.g:23:7: ( '{' )
            // CMM.g:23:9: '{'
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
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // CMM.g:24:7: ( '}' )
            // CMM.g:24:9: '}'
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
    // $ANTLR end "T__35"

    // $ANTLR start "IDENTIFIER"
    public final void mIDENTIFIER() throws RecognitionException {
        try {
            int _type = IDENTIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // CMM.g:148:2: ( LETTER ( LETTER | '0' .. '9' | '_' )* ( LETTER | '0' .. '9' )? )
            // CMM.g:148:4: LETTER ( LETTER | '0' .. '9' | '_' )* ( LETTER | '0' .. '9' )?
            {
            mLETTER(); 


            // CMM.g:148:11: ( LETTER | '0' .. '9' | '_' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // CMM.g:
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
            	    break loop1;
                }
            } while (true);


            // CMM.g:148:40: ( LETTER | '0' .. '9' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // CMM.g:
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


            System.out.println(getText());

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IDENTIFIER"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // CMM.g:154:2: ( ( 'a' .. 'z' | 'A' .. 'Z' ) )
            // CMM.g:
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "INT_LITERAL"
    public final void mINT_LITERAL() throws RecognitionException {
        try {
            int _type = INT_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // CMM.g:156:2: ( ( '0' .. '9' )+ )
            // CMM.g:156:4: ( '0' .. '9' )+
            {
            // CMM.g:156:4: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // CMM.g:
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
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            System.out.println(getText());

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
            // CMM.g:159:2: ( INT_LITERAL '.' INT_LITERAL ( ( 'e' | 'E' ) ( '+' | '-' ) INT_LITERAL )? )
            // CMM.g:159:4: INT_LITERAL '.' INT_LITERAL ( ( 'e' | 'E' ) ( '+' | '-' ) INT_LITERAL )?
            {
            mINT_LITERAL(); 


            match('.'); 

            mINT_LITERAL(); 


            // CMM.g:159:32: ( ( 'e' | 'E' ) ( '+' | '-' ) INT_LITERAL )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='E'||LA4_0=='e') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // CMM.g:159:34: ( 'e' | 'E' ) ( '+' | '-' ) INT_LITERAL
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


            System.out.println(getText());

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "REAL_LITERAL"

    // $ANTLR start "EQ_OP"
    public final void mEQ_OP() throws RecognitionException {
        try {
            int _type = EQ_OP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // CMM.g:169:2: ( '==' )
            // CMM.g:169:4: '=='
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
            // CMM.g:172:2: ( '<>' )
            // CMM.g:172:4: '<>'
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

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // CMM.g:178:5: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
            // CMM.g:178:8: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
            {
            if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // CMM.g:181:5: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // CMM.g:181:9: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 



            // CMM.g:181:14: ( options {greedy=false; } : . )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='*') ) {
                    int LA5_1 = input.LA(2);

                    if ( (LA5_1=='/') ) {
                        alt5=2;
                    }
                    else if ( ((LA5_1 >= '\u0000' && LA5_1 <= '.')||(LA5_1 >= '0' && LA5_1 <= '\uFFFF')) ) {
                        alt5=1;
                    }


                }
                else if ( ((LA5_0 >= '\u0000' && LA5_0 <= ')')||(LA5_0 >= '+' && LA5_0 <= '\uFFFF')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // CMM.g:181:42: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop5;
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
            // CMM.g:184:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // CMM.g:184:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 



            // CMM.g:184:12: (~ ( '\\n' | '\\r' ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0 >= '\u0000' && LA6_0 <= '\t')||(LA6_0 >= '\u000B' && LA6_0 <= '\f')||(LA6_0 >= '\u000E' && LA6_0 <= '\uFFFF')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // CMM.g:
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
            	    break loop6;
                }
            } while (true);


            // CMM.g:184:26: ( '\\r' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='\r') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // CMM.g:184:26: '\\r'
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

    public void mTokens() throws RecognitionException {
        // CMM.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | IDENTIFIER | INT_LITERAL | REAL_LITERAL | EQ_OP | NE_OP | WS | COMMENT | LINE_COMMENT )
        int alt8=31;
        alt8 = dfa8.predict(input);
        switch (alt8) {
            case 1 :
                // CMM.g:1:10: T__13
                {
                mT__13(); 


                }
                break;
            case 2 :
                // CMM.g:1:16: T__14
                {
                mT__14(); 


                }
                break;
            case 3 :
                // CMM.g:1:22: T__15
                {
                mT__15(); 


                }
                break;
            case 4 :
                // CMM.g:1:28: T__16
                {
                mT__16(); 


                }
                break;
            case 5 :
                // CMM.g:1:34: T__17
                {
                mT__17(); 


                }
                break;
            case 6 :
                // CMM.g:1:40: T__18
                {
                mT__18(); 


                }
                break;
            case 7 :
                // CMM.g:1:46: T__19
                {
                mT__19(); 


                }
                break;
            case 8 :
                // CMM.g:1:52: T__20
                {
                mT__20(); 


                }
                break;
            case 9 :
                // CMM.g:1:58: T__21
                {
                mT__21(); 


                }
                break;
            case 10 :
                // CMM.g:1:64: T__22
                {
                mT__22(); 


                }
                break;
            case 11 :
                // CMM.g:1:70: T__23
                {
                mT__23(); 


                }
                break;
            case 12 :
                // CMM.g:1:76: T__24
                {
                mT__24(); 


                }
                break;
            case 13 :
                // CMM.g:1:82: T__25
                {
                mT__25(); 


                }
                break;
            case 14 :
                // CMM.g:1:88: T__26
                {
                mT__26(); 


                }
                break;
            case 15 :
                // CMM.g:1:94: T__27
                {
                mT__27(); 


                }
                break;
            case 16 :
                // CMM.g:1:100: T__28
                {
                mT__28(); 


                }
                break;
            case 17 :
                // CMM.g:1:106: T__29
                {
                mT__29(); 


                }
                break;
            case 18 :
                // CMM.g:1:112: T__30
                {
                mT__30(); 


                }
                break;
            case 19 :
                // CMM.g:1:118: T__31
                {
                mT__31(); 


                }
                break;
            case 20 :
                // CMM.g:1:124: T__32
                {
                mT__32(); 


                }
                break;
            case 21 :
                // CMM.g:1:130: T__33
                {
                mT__33(); 


                }
                break;
            case 22 :
                // CMM.g:1:136: T__34
                {
                mT__34(); 


                }
                break;
            case 23 :
                // CMM.g:1:142: T__35
                {
                mT__35(); 


                }
                break;
            case 24 :
                // CMM.g:1:148: IDENTIFIER
                {
                mIDENTIFIER(); 


                }
                break;
            case 25 :
                // CMM.g:1:159: INT_LITERAL
                {
                mINT_LITERAL(); 


                }
                break;
            case 26 :
                // CMM.g:1:171: REAL_LITERAL
                {
                mREAL_LITERAL(); 


                }
                break;
            case 27 :
                // CMM.g:1:184: EQ_OP
                {
                mEQ_OP(); 


                }
                break;
            case 28 :
                // CMM.g:1:190: NE_OP
                {
                mNE_OP(); 


                }
                break;
            case 29 :
                // CMM.g:1:196: WS
                {
                mWS(); 


                }
                break;
            case 30 :
                // CMM.g:1:199: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 31 :
                // CMM.g:1:207: LINE_COMMENT
                {
                mLINE_COMMENT(); 


                }
                break;

        }

    }


    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA8_eotS =
        "\3\uffff\1\27\1\31\1\uffff\1\33\1\37\1\uffff\1\41\1\43\2\uffff\4"+
        "\23\3\uffff\1\51\17\uffff\1\23\1\54\3\23\2\uffff\1\23\1\uffff\1"+
        "\61\2\23\1\64\1\uffff\1\65\1\23\2\uffff\1\67\1\uffff";
    static final String DFA8_eofS =
        "\70\uffff";
    static final String DFA8_minS =
        "\1\11\2\uffff\2\75\1\uffff\1\75\1\52\1\uffff\1\76\1\75\2\uffff\1"+
        "\154\1\146\1\145\1\150\3\uffff\1\56\17\uffff\1\163\1\60\1\164\1"+
        "\141\1\151\2\uffff\1\145\1\uffff\1\60\2\154\1\60\1\uffff\1\60\1"+
        "\145\2\uffff\1\60\1\uffff";
    static final String DFA8_maxS =
        "\1\175\2\uffff\2\75\1\uffff\2\75\1\uffff\1\76\1\75\2\uffff\1\154"+
        "\1\156\1\145\1\150\3\uffff\1\71\17\uffff\1\163\1\172\1\164\1\141"+
        "\1\151\2\uffff\1\145\1\uffff\1\172\2\154\1\172\1\uffff\1\172\1\145"+
        "\2\uffff\1\172\1\uffff";
    static final String DFA8_acceptS =
        "\1\uffff\1\1\1\2\2\uffff\1\7\2\uffff\1\14\2\uffff\1\17\1\20\4\uffff"+
        "\1\26\1\27\1\30\1\uffff\1\35\1\4\1\3\1\6\1\5\1\11\1\10\1\13\1\36"+
        "\1\37\1\12\1\34\1\15\1\33\1\16\5\uffff\1\31\1\32\1\uffff\1\22\4"+
        "\uffff\1\23\2\uffff\1\21\1\24\1\uffff\1\25";
    static final String DFA8_specialS =
        "\70\uffff}>";
    static final String[] DFA8_transitionS = {
            "\2\25\1\uffff\2\25\22\uffff\1\25\7\uffff\1\1\1\2\1\3\1\4\1\5"+
            "\1\6\1\uffff\1\7\12\24\1\uffff\1\10\1\11\1\12\3\uffff\32\23"+
            "\1\13\1\uffff\1\14\3\uffff\4\23\1\15\3\23\1\16\10\23\1\17\4"+
            "\23\1\20\3\23\1\21\1\uffff\1\22",
            "",
            "",
            "\1\26",
            "\1\30",
            "",
            "\1\32",
            "\1\35\4\uffff\1\36\15\uffff\1\34",
            "",
            "\1\40",
            "\1\42",
            "",
            "",
            "\1\44",
            "\1\45\7\uffff\1\46",
            "\1\47",
            "\1\50",
            "",
            "",
            "",
            "\1\52\1\uffff\12\24",
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
            "",
            "",
            "",
            "",
            "\1\53",
            "\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "\1\55",
            "\1\56",
            "\1\57",
            "",
            "",
            "\1\60",
            "",
            "\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "\1\62",
            "\1\63",
            "\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "",
            "\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "\1\66",
            "",
            "",
            "\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            ""
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | IDENTIFIER | INT_LITERAL | REAL_LITERAL | EQ_OP | NE_OP | WS | COMMENT | LINE_COMMENT );";
        }
    }
 

}