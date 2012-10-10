// $ANTLR 3.4 CMM.g 2012-09-16 10:35:47

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class CMMParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "INT", "WS", "';'", "'='", "'int'", "'public'", "'static'"
    };

    public static final int EOF=-1;
    public static final int T__7=7;
    public static final int T__8=8;
    public static final int T__9=9;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int ID=4;
    public static final int INT=5;
    public static final int WS=6;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public CMMParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public CMMParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return CMMParser.tokenNames; }
    public String getGrammarFileName() { return "CMM.g"; }



    // $ANTLR start "def"
    // CMM.g:2:1: def : ( ( modifier )+ 'int' ID '=' ( INT )+ ';' | ( modifier )+ 'int' ID ';' );
    public final void def() throws RecognitionException {
        try {
            // CMM.g:2:5: ( ( modifier )+ 'int' ID '=' ( INT )+ ';' | ( modifier )+ 'int' ID ';' )
            int alt4=2;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // CMM.g:2:7: ( modifier )+ 'int' ID '=' ( INT )+ ';'
                    {
                    // CMM.g:2:7: ( modifier )+
                    int cnt1=0;
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( ((LA1_0 >= 10 && LA1_0 <= 11)) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // CMM.g:2:7: modifier
                    	    {
                    	    pushFollow(FOLLOW_modifier_in_def9);
                    	    modifier();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt1 >= 1 ) break loop1;
                                EarlyExitException eee =
                                    new EarlyExitException(1, input);
                                throw eee;
                        }
                        cnt1++;
                    } while (true);


                    match(input,9,FOLLOW_9_in_def13); 

                    match(input,ID,FOLLOW_ID_in_def15); 

                    match(input,8,FOLLOW_8_in_def17); 

                    // CMM.g:2:31: ( INT )+
                    int cnt2=0;
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==INT) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // CMM.g:2:31: INT
                    	    {
                    	    match(input,INT,FOLLOW_INT_in_def19); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt2 >= 1 ) break loop2;
                                EarlyExitException eee =
                                    new EarlyExitException(2, input);
                                throw eee;
                        }
                        cnt2++;
                    } while (true);


                    match(input,7,FOLLOW_7_in_def23); 

                    }
                    break;
                case 2 :
                    // CMM.g:3:4: ( modifier )+ 'int' ID ';'
                    {
                    // CMM.g:3:4: ( modifier )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0 >= 10 && LA3_0 <= 11)) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // CMM.g:3:4: modifier
                    	    {
                    	    pushFollow(FOLLOW_modifier_in_def28);
                    	    modifier();

                    	    state._fsp--;


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


                    match(input,9,FOLLOW_9_in_def32); 

                    match(input,ID,FOLLOW_ID_in_def34); 

                    match(input,7,FOLLOW_7_in_def36); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "def"



    // $ANTLR start "modifier"
    // CMM.g:5:1: modifier : ( 'public' | 'static' );
    public final void modifier() throws RecognitionException {
        try {
            // CMM.g:5:10: ( 'public' | 'static' )
            // CMM.g:
            {
            if ( (input.LA(1) >= 10 && input.LA(1) <= 11) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "modifier"

    // Delegated rules


    protected DFA4 dfa4 = new DFA4(this);
    static final String DFA4_eotS =
        "\6\uffff";
    static final String DFA4_eofS =
        "\6\uffff";
    static final String DFA4_minS =
        "\1\12\1\11\1\4\1\7\2\uffff";
    static final String DFA4_maxS =
        "\2\13\1\4\1\10\2\uffff";
    static final String DFA4_acceptS =
        "\4\uffff\1\1\1\2";
    static final String DFA4_specialS =
        "\6\uffff}>";
    static final String[] DFA4_transitionS = {
            "\2\1",
            "\1\2\2\1",
            "\1\3",
            "\1\5\1\4",
            "",
            ""
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "2:1: def : ( ( modifier )+ 'int' ID '=' ( INT )+ ';' | ( modifier )+ 'int' ID ';' );";
        }
    }
 

    public static final BitSet FOLLOW_modifier_in_def9 = new BitSet(new long[]{0x0000000000000E00L});
    public static final BitSet FOLLOW_9_in_def13 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_def15 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_def17 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_INT_in_def19 = new BitSet(new long[]{0x00000000000000A0L});
    public static final BitSet FOLLOW_7_in_def23 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_def28 = new BitSet(new long[]{0x0000000000000E00L});
    public static final BitSet FOLLOW_9_in_def32 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_def34 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_7_in_def36 = new BitSet(new long[]{0x0000000000000002L});

}