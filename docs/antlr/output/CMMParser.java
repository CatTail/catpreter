// $ANTLR 3.4 /home/cattail/project/catperter/CMM.g 2012-10-14 12:13:28

	import java.util.Set;
	import java.util.HashMap;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class CMMParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "EQ_OP", "IDENTIFIER", "INT_LITERAL", "LETTER", "LINE_COMMENT", "NE_OP", "REAL_LITERAL", "WS", "'('", "')'", "'*'", "'*='", "'+'", "'+='", "','", "'-'", "'-='", "'/'", "'/='", "';'", "'<'", "'='", "'['", "']'", "'else'", "'if'", "'int'", "'real'", "'while'", "'{'", "'}'"
    };

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
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators

    protected static class Symbols_scope {
        Set types;
        HashMap values;
    }
    protected Stack Symbols_stack = new Stack();



    public CMMParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public CMMParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.ruleMemo = new HashMap[57+1];
         

    }

    public String[] getTokenNames() { return CMMParser.tokenNames; }
    public String getGrammarFileName() { return "/home/cattail/project/catperter/CMM.g"; }


    	Object getValue(String name) {
    		for (int i = Symbols_stack.size()-1; i>=0; i--) {
    			Symbols_scope scope = (Symbols_scope)Symbols_stack.get(i);
    			if ( scope.values.containsKey(name) ) {
    				return scope.values.get(name);
    			}
    		}
    		return new Object();
    	}



    // $ANTLR start "prog"
    // /home/cattail/project/catperter/CMM.g:39:1: prog : statement ;
    public final void prog() throws RecognitionException {
        Symbols_stack.push(new Symbols_scope());

        int prog_StartIndex = input.index();


          ((Symbols_scope)Symbols_stack.peek()).values = new HashMap();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return ; }

            // /home/cattail/project/catperter/CMM.g:44:2: ( statement )
            // /home/cattail/project/catperter/CMM.g:44:4: statement
            {
            pushFollow(FOLLOW_statement_in_prog60);
            statement();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 1, prog_StartIndex); }

            Symbols_stack.pop();

        }
        return ;
    }
    // $ANTLR end "prog"



    // $ANTLR start "statement"
    // /home/cattail/project/catperter/CMM.g:46:1: statement : ( compound_statement | expression_statement | selection_statement | iteration_statement | declaration );
    public final void statement() throws RecognitionException {
        int statement_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return ; }

            // /home/cattail/project/catperter/CMM.g:47:2: ( compound_statement | expression_statement | selection_statement | iteration_statement | declaration )
            int alt1=5;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt1=1;
                }
                break;
            case IDENTIFIER:
            case INT_LITERAL:
            case REAL_LITERAL:
            case 13:
            case 17:
            case 20:
            case 24:
                {
                alt1=2;
                }
                break;
            case 30:
                {
                alt1=3;
                }
                break;
            case 33:
                {
                alt1=4;
                }
                break;
            case 31:
            case 32:
                {
                alt1=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }

            switch (alt1) {
                case 1 :
                    // /home/cattail/project/catperter/CMM.g:47:4: compound_statement
                    {
                    pushFollow(FOLLOW_compound_statement_in_statement70);
                    compound_statement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/cattail/project/catperter/CMM.g:48:4: expression_statement
                    {
                    pushFollow(FOLLOW_expression_statement_in_statement75);
                    expression_statement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /home/cattail/project/catperter/CMM.g:49:4: selection_statement
                    {
                    pushFollow(FOLLOW_selection_statement_in_statement80);
                    selection_statement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /home/cattail/project/catperter/CMM.g:50:4: iteration_statement
                    {
                    pushFollow(FOLLOW_iteration_statement_in_statement85);
                    iteration_statement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /home/cattail/project/catperter/CMM.g:51:4: declaration
                    {
                    pushFollow(FOLLOW_declaration_in_statement90);
                    declaration();

                    state._fsp--;
                    if (state.failed) return ;

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
            if ( state.backtracking>0 ) { memoize(input, 2, statement_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "statement"



    // $ANTLR start "compound_statement"
    // /home/cattail/project/catperter/CMM.g:53:1: compound_statement : ( '{' '}' | '{' statement_list '}' );
    public final void compound_statement() throws RecognitionException {
        Symbols_stack.push(new Symbols_scope());

        int compound_statement_StartIndex = input.index();


          ((Symbols_scope)Symbols_stack.peek()).values = new HashMap();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return ; }

            // /home/cattail/project/catperter/CMM.g:58:2: ( '{' '}' | '{' statement_list '}' )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==34) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==35) ) {
                    alt2=1;
                }
                else if ( ((LA2_1 >= IDENTIFIER && LA2_1 <= INT_LITERAL)||LA2_1==REAL_LITERAL||LA2_1==13||LA2_1==17||LA2_1==20||LA2_1==24||(LA2_1 >= 30 && LA2_1 <= 34)) ) {
                    alt2=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // /home/cattail/project/catperter/CMM.g:58:4: '{' '}'
                    {
                    match(input,34,FOLLOW_34_in_compound_statement111); if (state.failed) return ;

                    match(input,35,FOLLOW_35_in_compound_statement113); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/cattail/project/catperter/CMM.g:59:4: '{' statement_list '}'
                    {
                    match(input,34,FOLLOW_34_in_compound_statement118); if (state.failed) return ;

                    pushFollow(FOLLOW_statement_list_in_compound_statement120);
                    statement_list();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,35,FOLLOW_35_in_compound_statement122); if (state.failed) return ;

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
            if ( state.backtracking>0 ) { memoize(input, 3, compound_statement_StartIndex); }

            Symbols_stack.pop();

        }
        return ;
    }
    // $ANTLR end "compound_statement"



    // $ANTLR start "statement_list"
    // /home/cattail/project/catperter/CMM.g:61:1: statement_list : ( statement )+ ;
    public final void statement_list() throws RecognitionException {
        int statement_list_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return ; }

            // /home/cattail/project/catperter/CMM.g:62:2: ( ( statement )+ )
            // /home/cattail/project/catperter/CMM.g:62:4: ( statement )+
            {
            // /home/cattail/project/catperter/CMM.g:62:4: ( statement )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= IDENTIFIER && LA3_0 <= INT_LITERAL)||LA3_0==REAL_LITERAL||LA3_0==13||LA3_0==17||LA3_0==20||LA3_0==24||(LA3_0 >= 30 && LA3_0 <= 34)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /home/cattail/project/catperter/CMM.g:62:4: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_statement_list132);
            	    statement();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, statement_list_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "statement_list"



    // $ANTLR start "expression_statement"
    // /home/cattail/project/catperter/CMM.g:64:1: expression_statement : ( ';' | expression ';' );
    public final void expression_statement() throws RecognitionException {
        int expression_statement_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return ; }

            // /home/cattail/project/catperter/CMM.g:65:2: ( ';' | expression ';' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==24) ) {
                alt4=1;
            }
            else if ( ((LA4_0 >= IDENTIFIER && LA4_0 <= INT_LITERAL)||LA4_0==REAL_LITERAL||LA4_0==13||LA4_0==17||LA4_0==20) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // /home/cattail/project/catperter/CMM.g:65:4: ';'
                    {
                    match(input,24,FOLLOW_24_in_expression_statement143); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/cattail/project/catperter/CMM.g:66:4: expression ';'
                    {
                    pushFollow(FOLLOW_expression_in_expression_statement148);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,24,FOLLOW_24_in_expression_statement150); if (state.failed) return ;

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
            if ( state.backtracking>0 ) { memoize(input, 5, expression_statement_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "expression_statement"



    // $ANTLR start "selection_statement"
    // /home/cattail/project/catperter/CMM.g:68:1: selection_statement : 'if' '(' expression ')' statement ( options {k=1; backtrack=false; } : 'else' statement )? ;
    public final void selection_statement() throws RecognitionException {
        int selection_statement_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return ; }

            // /home/cattail/project/catperter/CMM.g:69:2: ( 'if' '(' expression ')' statement ( options {k=1; backtrack=false; } : 'else' statement )? )
            // /home/cattail/project/catperter/CMM.g:69:4: 'if' '(' expression ')' statement ( options {k=1; backtrack=false; } : 'else' statement )?
            {
            match(input,30,FOLLOW_30_in_selection_statement160); if (state.failed) return ;

            match(input,13,FOLLOW_13_in_selection_statement162); if (state.failed) return ;

            pushFollow(FOLLOW_expression_in_selection_statement164);
            expression();

            state._fsp--;
            if (state.failed) return ;

            match(input,14,FOLLOW_14_in_selection_statement166); if (state.failed) return ;

            pushFollow(FOLLOW_statement_in_selection_statement168);
            statement();

            state._fsp--;
            if (state.failed) return ;

            // /home/cattail/project/catperter/CMM.g:69:38: ( options {k=1; backtrack=false; } : 'else' statement )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==29) ) {
                int LA5_1 = input.LA(2);

                if ( (true) ) {
                    alt5=1;
                }
            }
            switch (alt5) {
                case 1 :
                    // /home/cattail/project/catperter/CMM.g:69:71: 'else' statement
                    {
                    match(input,29,FOLLOW_29_in_selection_statement183); if (state.failed) return ;

                    pushFollow(FOLLOW_statement_in_selection_statement185);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, selection_statement_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "selection_statement"



    // $ANTLR start "iteration_statement"
    // /home/cattail/project/catperter/CMM.g:71:1: iteration_statement : 'while' '(' expression ')' statement ;
    public final void iteration_statement() throws RecognitionException {
        int iteration_statement_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return ; }

            // /home/cattail/project/catperter/CMM.g:72:2: ( 'while' '(' expression ')' statement )
            // /home/cattail/project/catperter/CMM.g:72:4: 'while' '(' expression ')' statement
            {
            match(input,33,FOLLOW_33_in_iteration_statement197); if (state.failed) return ;

            match(input,13,FOLLOW_13_in_iteration_statement199); if (state.failed) return ;

            pushFollow(FOLLOW_expression_in_iteration_statement201);
            expression();

            state._fsp--;
            if (state.failed) return ;

            match(input,14,FOLLOW_14_in_iteration_statement203); if (state.failed) return ;

            pushFollow(FOLLOW_statement_in_iteration_statement205);
            statement();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, iteration_statement_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "iteration_statement"



    // $ANTLR start "expression"
    // /home/cattail/project/catperter/CMM.g:75:1: expression : assignment_expression ( ',' assignment_expression )* ;
    public final void expression() throws RecognitionException {
        int expression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return ; }

            // /home/cattail/project/catperter/CMM.g:76:2: ( assignment_expression ( ',' assignment_expression )* )
            // /home/cattail/project/catperter/CMM.g:76:4: assignment_expression ( ',' assignment_expression )*
            {
            pushFollow(FOLLOW_assignment_expression_in_expression216);
            assignment_expression();

            state._fsp--;
            if (state.failed) return ;

            // /home/cattail/project/catperter/CMM.g:76:26: ( ',' assignment_expression )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==19) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /home/cattail/project/catperter/CMM.g:76:28: ',' assignment_expression
            	    {
            	    match(input,19,FOLLOW_19_in_expression220); if (state.failed) return ;

            	    pushFollow(FOLLOW_assignment_expression_in_expression222);
            	    assignment_expression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 8, expression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "expression"



    // $ANTLR start "constant_expression"
    // /home/cattail/project/catperter/CMM.g:78:1: constant_expression : equality_expression ;
    public final void constant_expression() throws RecognitionException {
        int constant_expression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return ; }

            // /home/cattail/project/catperter/CMM.g:79:2: ( equality_expression )
            // /home/cattail/project/catperter/CMM.g:79:4: equality_expression
            {
            pushFollow(FOLLOW_equality_expression_in_constant_expression235);
            equality_expression();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, constant_expression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "constant_expression"



    // $ANTLR start "assignment_expression"
    // /home/cattail/project/catperter/CMM.g:81:1: assignment_expression : ( equality_expression | primary_expression assignment_operator assignment_expression );
    public final void assignment_expression() throws RecognitionException {
        int assignment_expression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return ; }

            // /home/cattail/project/catperter/CMM.g:82:2: ( equality_expression | primary_expression assignment_operator assignment_expression )
            int alt7=2;
            switch ( input.LA(1) ) {
            case INT_LITERAL:
                {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==EOF||LA7_1==EQ_OP||LA7_1==NE_OP||(LA7_1 >= 14 && LA7_1 <= 15)||LA7_1==17||(LA7_1 >= 19 && LA7_1 <= 20)||LA7_1==22||(LA7_1 >= 24 && LA7_1 <= 25)||(LA7_1 >= 27 && LA7_1 <= 28)) ) {
                    alt7=1;
                }
                else if ( (LA7_1==16||LA7_1==18||LA7_1==21||LA7_1==23||LA7_1==26) ) {
                    alt7=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;

                }
                }
                break;
            case REAL_LITERAL:
                {
                int LA7_2 = input.LA(2);

                if ( (LA7_2==EOF||LA7_2==EQ_OP||LA7_2==NE_OP||(LA7_2 >= 14 && LA7_2 <= 15)||LA7_2==17||(LA7_2 >= 19 && LA7_2 <= 20)||LA7_2==22||(LA7_2 >= 24 && LA7_2 <= 25)||(LA7_2 >= 27 && LA7_2 <= 28)) ) {
                    alt7=1;
                }
                else if ( (LA7_2==16||LA7_2==18||LA7_2==21||LA7_2==23||LA7_2==26) ) {
                    alt7=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 2, input);

                    throw nvae;

                }
                }
                break;
            case IDENTIFIER:
                {
                int LA7_3 = input.LA(2);

                if ( (LA7_3==EOF||LA7_3==EQ_OP||LA7_3==NE_OP||(LA7_3 >= 14 && LA7_3 <= 15)||LA7_3==17||(LA7_3 >= 19 && LA7_3 <= 20)||LA7_3==22||(LA7_3 >= 24 && LA7_3 <= 25)||(LA7_3 >= 27 && LA7_3 <= 28)) ) {
                    alt7=1;
                }
                else if ( (LA7_3==16||LA7_3==18||LA7_3==21||LA7_3==23||LA7_3==26) ) {
                    alt7=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 3, input);

                    throw nvae;

                }
                }
                break;
            case 13:
                {
                switch ( input.LA(2) ) {
                case INT_LITERAL:
                    {
                    int LA7_48 = input.LA(3);

                    if ( (synpred9_CMM()) ) {
                        alt7=1;
                    }
                    else if ( (true) ) {
                        alt7=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 48, input);

                        throw nvae;

                    }
                    }
                    break;
                case REAL_LITERAL:
                    {
                    int LA7_49 = input.LA(3);

                    if ( (synpred9_CMM()) ) {
                        alt7=1;
                    }
                    else if ( (true) ) {
                        alt7=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 49, input);

                        throw nvae;

                    }
                    }
                    break;
                case IDENTIFIER:
                    {
                    int LA7_50 = input.LA(3);

                    if ( (synpred9_CMM()) ) {
                        alt7=1;
                    }
                    else if ( (true) ) {
                        alt7=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 50, input);

                        throw nvae;

                    }
                    }
                    break;
                case 13:
                    {
                    int LA7_51 = input.LA(3);

                    if ( (synpred9_CMM()) ) {
                        alt7=1;
                    }
                    else if ( (true) ) {
                        alt7=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 51, input);

                        throw nvae;

                    }
                    }
                    break;
                case 17:
                case 20:
                    {
                    int LA7_52 = input.LA(3);

                    if ( (synpred9_CMM()) ) {
                        alt7=1;
                    }
                    else if ( (true) ) {
                        alt7=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 52, input);

                        throw nvae;

                    }
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 4, input);

                    throw nvae;

                }

                }
                break;
            case 17:
            case 20:
                {
                alt7=1;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }

            switch (alt7) {
                case 1 :
                    // /home/cattail/project/catperter/CMM.g:82:4: equality_expression
                    {
                    pushFollow(FOLLOW_equality_expression_in_assignment_expression245);
                    equality_expression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/cattail/project/catperter/CMM.g:83:4: primary_expression assignment_operator assignment_expression
                    {
                    pushFollow(FOLLOW_primary_expression_in_assignment_expression250);
                    primary_expression();

                    state._fsp--;
                    if (state.failed) return ;

                    pushFollow(FOLLOW_assignment_operator_in_assignment_expression252);
                    assignment_operator();

                    state._fsp--;
                    if (state.failed) return ;

                    pushFollow(FOLLOW_assignment_expression_in_assignment_expression254);
                    assignment_expression();

                    state._fsp--;
                    if (state.failed) return ;

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
            if ( state.backtracking>0 ) { memoize(input, 10, assignment_expression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "assignment_expression"



    // $ANTLR start "equality_expression"
    // /home/cattail/project/catperter/CMM.g:85:1: equality_expression : relational_expression ( EQ_OP relational_expression | NE_OP relational_expression )* ;
    public final void equality_expression() throws RecognitionException {
        int equality_expression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return ; }

            // /home/cattail/project/catperter/CMM.g:86:2: ( relational_expression ( EQ_OP relational_expression | NE_OP relational_expression )* )
            // /home/cattail/project/catperter/CMM.g:86:4: relational_expression ( EQ_OP relational_expression | NE_OP relational_expression )*
            {
            pushFollow(FOLLOW_relational_expression_in_equality_expression264);
            relational_expression();

            state._fsp--;
            if (state.failed) return ;

            // /home/cattail/project/catperter/CMM.g:86:26: ( EQ_OP relational_expression | NE_OP relational_expression )*
            loop8:
            do {
                int alt8=3;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==EQ_OP) ) {
                    alt8=1;
                }
                else if ( (LA8_0==NE_OP) ) {
                    alt8=2;
                }


                switch (alt8) {
            	case 1 :
            	    // /home/cattail/project/catperter/CMM.g:86:28: EQ_OP relational_expression
            	    {
            	    match(input,EQ_OP,FOLLOW_EQ_OP_in_equality_expression268); if (state.failed) return ;

            	    pushFollow(FOLLOW_relational_expression_in_equality_expression270);
            	    relational_expression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // /home/cattail/project/catperter/CMM.g:86:58: NE_OP relational_expression
            	    {
            	    match(input,NE_OP,FOLLOW_NE_OP_in_equality_expression274); if (state.failed) return ;

            	    pushFollow(FOLLOW_relational_expression_in_equality_expression276);
            	    relational_expression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 11, equality_expression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "equality_expression"



    // $ANTLR start "relational_expression"
    // /home/cattail/project/catperter/CMM.g:88:1: relational_expression : additive_expression ( '<' additive_expression )* ;
    public final void relational_expression() throws RecognitionException {
        int relational_expression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return ; }

            // /home/cattail/project/catperter/CMM.g:89:2: ( additive_expression ( '<' additive_expression )* )
            // /home/cattail/project/catperter/CMM.g:89:4: additive_expression ( '<' additive_expression )*
            {
            pushFollow(FOLLOW_additive_expression_in_relational_expression289);
            additive_expression();

            state._fsp--;
            if (state.failed) return ;

            // /home/cattail/project/catperter/CMM.g:89:24: ( '<' additive_expression )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==25) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /home/cattail/project/catperter/CMM.g:89:26: '<' additive_expression
            	    {
            	    match(input,25,FOLLOW_25_in_relational_expression293); if (state.failed) return ;

            	    pushFollow(FOLLOW_additive_expression_in_relational_expression295);
            	    additive_expression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 12, relational_expression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "relational_expression"



    // $ANTLR start "additive_expression"
    // /home/cattail/project/catperter/CMM.g:91:1: additive_expression : multiplicative_expression ( '+' multiplicative_expression | '-' multiplicative_expression )* ;
    public final void additive_expression() throws RecognitionException {
        int additive_expression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return ; }

            // /home/cattail/project/catperter/CMM.g:92:2: ( multiplicative_expression ( '+' multiplicative_expression | '-' multiplicative_expression )* )
            // /home/cattail/project/catperter/CMM.g:92:4: multiplicative_expression ( '+' multiplicative_expression | '-' multiplicative_expression )*
            {
            pushFollow(FOLLOW_multiplicative_expression_in_additive_expression308);
            multiplicative_expression();

            state._fsp--;
            if (state.failed) return ;

            // /home/cattail/project/catperter/CMM.g:92:30: ( '+' multiplicative_expression | '-' multiplicative_expression )*
            loop10:
            do {
                int alt10=3;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==17) ) {
                    alt10=1;
                }
                else if ( (LA10_0==20) ) {
                    alt10=2;
                }


                switch (alt10) {
            	case 1 :
            	    // /home/cattail/project/catperter/CMM.g:92:32: '+' multiplicative_expression
            	    {
            	    match(input,17,FOLLOW_17_in_additive_expression312); if (state.failed) return ;

            	    pushFollow(FOLLOW_multiplicative_expression_in_additive_expression314);
            	    multiplicative_expression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // /home/cattail/project/catperter/CMM.g:92:64: '-' multiplicative_expression
            	    {
            	    match(input,20,FOLLOW_20_in_additive_expression318); if (state.failed) return ;

            	    pushFollow(FOLLOW_multiplicative_expression_in_additive_expression320);
            	    multiplicative_expression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 13, additive_expression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "additive_expression"



    // $ANTLR start "multiplicative_expression"
    // /home/cattail/project/catperter/CMM.g:94:1: multiplicative_expression returns [Object value] : unary_expression ( '*' unary_expression | '/' unary_expression )* ;
    public final Object multiplicative_expression() throws RecognitionException {
        Object value = null;

        int multiplicative_expression_StartIndex = input.index();

        CMMParser.unary_expression_return unary_expression1 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return value; }

            // /home/cattail/project/catperter/CMM.g:95:2: ( unary_expression ( '*' unary_expression | '/' unary_expression )* )
            // /home/cattail/project/catperter/CMM.g:95:4: unary_expression ( '*' unary_expression | '/' unary_expression )*
            {
            pushFollow(FOLLOW_unary_expression_in_multiplicative_expression337);
            unary_expression1=unary_expression();

            state._fsp--;
            if (state.failed) return value;

            // /home/cattail/project/catperter/CMM.g:95:21: ( '*' unary_expression | '/' unary_expression )*
            loop11:
            do {
                int alt11=3;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==15) ) {
                    alt11=1;
                }
                else if ( (LA11_0==22) ) {
                    alt11=2;
                }


                switch (alt11) {
            	case 1 :
            	    // /home/cattail/project/catperter/CMM.g:95:23: '*' unary_expression
            	    {
            	    match(input,15,FOLLOW_15_in_multiplicative_expression341); if (state.failed) return value;

            	    pushFollow(FOLLOW_unary_expression_in_multiplicative_expression343);
            	    unary_expression();

            	    state._fsp--;
            	    if (state.failed) return value;

            	    }
            	    break;
            	case 2 :
            	    // /home/cattail/project/catperter/CMM.g:95:46: '/' unary_expression
            	    {
            	    match(input,22,FOLLOW_22_in_multiplicative_expression347); if (state.failed) return value;

            	    pushFollow(FOLLOW_unary_expression_in_multiplicative_expression349);
            	    unary_expression();

            	    state._fsp--;
            	    if (state.failed) return value;

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            if ( state.backtracking==0 ) {System.out.println((unary_expression1!=null?input.toString(unary_expression1.start,unary_expression1.stop):null));value =0;}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 14, multiplicative_expression_StartIndex); }

        }
        return value;
    }
    // $ANTLR end "multiplicative_expression"


    public static class unary_expression_return extends ParserRuleReturnScope {
        public Object value;
    };


    // $ANTLR start "unary_expression"
    // /home/cattail/project/catperter/CMM.g:98:1: unary_expression returns [Object value] : ( postfix_expression | unary_operator unary_expression );
    public final CMMParser.unary_expression_return unary_expression() throws RecognitionException {
        CMMParser.unary_expression_return retval = new CMMParser.unary_expression_return();
        retval.start = input.LT(1);

        int unary_expression_StartIndex = input.index();

        CMMParser.postfix_expression_return postfix_expression2 =null;

        CMMParser.unary_operator_return unary_operator3 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return retval; }

            // /home/cattail/project/catperter/CMM.g:99:2: ( postfix_expression | unary_operator unary_expression )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0 >= IDENTIFIER && LA12_0 <= INT_LITERAL)||LA12_0==REAL_LITERAL||LA12_0==13) ) {
                alt12=1;
            }
            else if ( (LA12_0==17||LA12_0==20) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;

            }
            switch (alt12) {
                case 1 :
                    // /home/cattail/project/catperter/CMM.g:99:4: postfix_expression
                    {
                    pushFollow(FOLLOW_postfix_expression_in_unary_expression370);
                    postfix_expression2=postfix_expression();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {retval.value =(postfix_expression2!=null?postfix_expression2.value:null);}

                    }
                    break;
                case 2 :
                    // /home/cattail/project/catperter/CMM.g:100:4: unary_operator unary_expression
                    {
                    pushFollow(FOLLOW_unary_operator_in_unary_expression377);
                    unary_operator3=unary_operator();

                    state._fsp--;
                    if (state.failed) return retval;

                    pushFollow(FOLLOW_unary_expression_in_unary_expression379);
                    unary_expression();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {
                    			switch((unary_operator3!=null?input.toString(unary_operator3.start,unary_operator3.stop):null)){
                    				case "-":
                    					retval.value =-(Float)retval.value;
                    					break;
                    				case "+":
                    					retval.value =retval.value;
                    					break;
                    			}
                    		}

                    }
                    break;

            }
            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 15, unary_expression_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "unary_expression"


    public static class postfix_expression_return extends ParserRuleReturnScope {
        public Object value;
    };


    // $ANTLR start "postfix_expression"
    // /home/cattail/project/catperter/CMM.g:112:1: postfix_expression returns [Object value] : primary_expression ( '[' expression ']' )* ;
    public final CMMParser.postfix_expression_return postfix_expression() throws RecognitionException {
        CMMParser.postfix_expression_return retval = new CMMParser.postfix_expression_return();
        retval.start = input.LT(1);

        int postfix_expression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return retval; }

            // /home/cattail/project/catperter/CMM.g:113:2: ( primary_expression ( '[' expression ']' )* )
            // /home/cattail/project/catperter/CMM.g:113:4: primary_expression ( '[' expression ']' )*
            {
            pushFollow(FOLLOW_primary_expression_in_postfix_expression397);
            primary_expression();

            state._fsp--;
            if (state.failed) return retval;

            // /home/cattail/project/catperter/CMM.g:113:23: ( '[' expression ']' )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==27) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /home/cattail/project/catperter/CMM.g:113:24: '[' expression ']'
            	    {
            	    match(input,27,FOLLOW_27_in_postfix_expression400); if (state.failed) return retval;

            	    pushFollow(FOLLOW_expression_in_postfix_expression402);
            	    expression();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    match(input,28,FOLLOW_28_in_postfix_expression404); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            if ( state.backtracking==0 ) {retval.value =getValue(input.toString(retval.start,input.LT(-1)));}

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 16, postfix_expression_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "postfix_expression"



    // $ANTLR start "primary_expression"
    // /home/cattail/project/catperter/CMM.g:116:1: primary_expression returns [Object value] : ( constant | IDENTIFIER | '(' expression ')' );
    public final Object primary_expression() throws RecognitionException {
        Object value = null;

        int primary_expression_StartIndex = input.index();

        Token IDENTIFIER5=null;
        Object constant4 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return value; }

            // /home/cattail/project/catperter/CMM.g:117:2: ( constant | IDENTIFIER | '(' expression ')' )
            int alt14=3;
            switch ( input.LA(1) ) {
            case INT_LITERAL:
            case REAL_LITERAL:
                {
                alt14=1;
                }
                break;
            case IDENTIFIER:
                {
                alt14=2;
                }
                break;
            case 13:
                {
                alt14=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return value;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;

            }

            switch (alt14) {
                case 1 :
                    // /home/cattail/project/catperter/CMM.g:117:4: constant
                    {
                    pushFollow(FOLLOW_constant_in_primary_expression424);
                    constant4=constant();

                    state._fsp--;
                    if (state.failed) return value;

                    if ( state.backtracking==0 ) {value =constant4;}

                    }
                    break;
                case 2 :
                    // /home/cattail/project/catperter/CMM.g:118:4: IDENTIFIER
                    {
                    IDENTIFIER5=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_primary_expression431); if (state.failed) return value;

                    if ( state.backtracking==0 ) {value =getValue((IDENTIFIER5!=null?IDENTIFIER5.getText():null));}

                    }
                    break;
                case 3 :
                    // /home/cattail/project/catperter/CMM.g:119:4: '(' expression ')'
                    {
                    match(input,13,FOLLOW_13_in_primary_expression438); if (state.failed) return value;

                    pushFollow(FOLLOW_expression_in_primary_expression440);
                    expression();

                    state._fsp--;
                    if (state.failed) return value;

                    match(input,14,FOLLOW_14_in_primary_expression442); if (state.failed) return value;

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
            if ( state.backtracking>0 ) { memoize(input, 17, primary_expression_StartIndex); }

        }
        return value;
    }
    // $ANTLR end "primary_expression"



    // $ANTLR start "declaration"
    // /home/cattail/project/catperter/CMM.g:121:1: declaration : declarator_specifiers init_declarator_list ';' ;
    public final void declaration() throws RecognitionException {
        int declaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return ; }

            // /home/cattail/project/catperter/CMM.g:122:2: ( declarator_specifiers init_declarator_list ';' )
            // /home/cattail/project/catperter/CMM.g:122:4: declarator_specifiers init_declarator_list ';'
            {
            pushFollow(FOLLOW_declarator_specifiers_in_declaration453);
            declarator_specifiers();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_init_declarator_list_in_declaration455);
            init_declarator_list();

            state._fsp--;
            if (state.failed) return ;

            match(input,24,FOLLOW_24_in_declaration457); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 18, declaration_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "declaration"



    // $ANTLR start "declarator_specifiers"
    // /home/cattail/project/catperter/CMM.g:124:1: declarator_specifiers : ( 'int' | 'real' );
    public final void declarator_specifiers() throws RecognitionException {
        int declarator_specifiers_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return ; }

            // /home/cattail/project/catperter/CMM.g:125:2: ( 'int' | 'real' )
            // /home/cattail/project/catperter/CMM.g:
            {
            if ( (input.LA(1) >= 31 && input.LA(1) <= 32) ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
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
            if ( state.backtracking>0 ) { memoize(input, 19, declarator_specifiers_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "declarator_specifiers"



    // $ANTLR start "init_declarator_list"
    // /home/cattail/project/catperter/CMM.g:128:1: init_declarator_list : init_declarator ( ',' init_declarator )* ;
    public final void init_declarator_list() throws RecognitionException {
        int init_declarator_list_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return ; }

            // /home/cattail/project/catperter/CMM.g:129:2: ( init_declarator ( ',' init_declarator )* )
            // /home/cattail/project/catperter/CMM.g:129:4: init_declarator ( ',' init_declarator )*
            {
            pushFollow(FOLLOW_init_declarator_in_init_declarator_list482);
            init_declarator();

            state._fsp--;
            if (state.failed) return ;

            // /home/cattail/project/catperter/CMM.g:129:20: ( ',' init_declarator )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==19) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /home/cattail/project/catperter/CMM.g:129:22: ',' init_declarator
            	    {
            	    match(input,19,FOLLOW_19_in_init_declarator_list486); if (state.failed) return ;

            	    pushFollow(FOLLOW_init_declarator_in_init_declarator_list488);
            	    init_declarator();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 20, init_declarator_list_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "init_declarator_list"



    // $ANTLR start "init_declarator"
    // /home/cattail/project/catperter/CMM.g:131:1: init_declarator : declarator ( '=' initializer )? ;
    public final void init_declarator() throws RecognitionException {
        int init_declarator_StartIndex = input.index();

        CMMParser.declarator_return declarator6 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return ; }

            // /home/cattail/project/catperter/CMM.g:132:2: ( declarator ( '=' initializer )? )
            // /home/cattail/project/catperter/CMM.g:132:4: declarator ( '=' initializer )?
            {
            pushFollow(FOLLOW_declarator_in_init_declarator501);
            declarator6=declarator();

            state._fsp--;
            if (state.failed) return ;

            // /home/cattail/project/catperter/CMM.g:132:15: ( '=' initializer )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==26) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // /home/cattail/project/catperter/CMM.g:132:16: '=' initializer
                    {
                    match(input,26,FOLLOW_26_in_init_declarator504); if (state.failed) return ;

                    pushFollow(FOLLOW_initializer_in_init_declarator506);
                    initializer();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            			((Symbols_scope)Symbols_stack.peek()).values.put((declarator6!=null?input.toString(declarator6.start,declarator6.stop):null),0);
            		}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 21, init_declarator_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "init_declarator"


    public static class declarator_return extends ParserRuleReturnScope {
    };


    // $ANTLR start "declarator"
    // /home/cattail/project/catperter/CMM.g:137:1: declarator : IDENTIFIER ( '[' ( constant_expression )? ']' )* ;
    public final CMMParser.declarator_return declarator() throws RecognitionException {
        CMMParser.declarator_return retval = new CMMParser.declarator_return();
        retval.start = input.LT(1);

        int declarator_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return retval; }

            // /home/cattail/project/catperter/CMM.g:138:2: ( IDENTIFIER ( '[' ( constant_expression )? ']' )* )
            // /home/cattail/project/catperter/CMM.g:138:4: IDENTIFIER ( '[' ( constant_expression )? ']' )*
            {
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declarator522); if (state.failed) return retval;

            // /home/cattail/project/catperter/CMM.g:138:15: ( '[' ( constant_expression )? ']' )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==27) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // /home/cattail/project/catperter/CMM.g:138:16: '[' ( constant_expression )? ']'
            	    {
            	    match(input,27,FOLLOW_27_in_declarator525); if (state.failed) return retval;

            	    // /home/cattail/project/catperter/CMM.g:138:20: ( constant_expression )?
            	    int alt17=2;
            	    int LA17_0 = input.LA(1);

            	    if ( ((LA17_0 >= IDENTIFIER && LA17_0 <= INT_LITERAL)||LA17_0==REAL_LITERAL||LA17_0==13||LA17_0==17||LA17_0==20) ) {
            	        alt17=1;
            	    }
            	    switch (alt17) {
            	        case 1 :
            	            // /home/cattail/project/catperter/CMM.g:138:20: constant_expression
            	            {
            	            pushFollow(FOLLOW_constant_expression_in_declarator527);
            	            constant_expression();

            	            state._fsp--;
            	            if (state.failed) return retval;

            	            }
            	            break;

            	    }


            	    match(input,28,FOLLOW_28_in_declarator530); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 22, declarator_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "declarator"



    // $ANTLR start "initializer"
    // /home/cattail/project/catperter/CMM.g:140:1: initializer : assignment_expression ;
    public final void initializer() throws RecognitionException {
        int initializer_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return ; }

            // /home/cattail/project/catperter/CMM.g:141:2: ( assignment_expression )
            // /home/cattail/project/catperter/CMM.g:141:4: assignment_expression
            {
            pushFollow(FOLLOW_assignment_expression_in_initializer542);
            assignment_expression();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 23, initializer_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "initializer"



    // $ANTLR start "constant"
    // /home/cattail/project/catperter/CMM.g:144:1: constant returns [Object value] : ( INT_LITERAL | REAL_LITERAL );
    public final Object constant() throws RecognitionException {
        Object value = null;

        int constant_StartIndex = input.index();

        Token INT_LITERAL7=null;
        Token REAL_LITERAL8=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return value; }

            // /home/cattail/project/catperter/CMM.g:145:2: ( INT_LITERAL | REAL_LITERAL )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==INT_LITERAL) ) {
                alt19=1;
            }
            else if ( (LA19_0==REAL_LITERAL) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return value;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;

            }
            switch (alt19) {
                case 1 :
                    // /home/cattail/project/catperter/CMM.g:145:4: INT_LITERAL
                    {
                    INT_LITERAL7=(Token)match(input,INT_LITERAL,FOLLOW_INT_LITERAL_in_constant558); if (state.failed) return value;

                    if ( state.backtracking==0 ) {value =Integer.parseInt((INT_LITERAL7!=null?INT_LITERAL7.getText():null));}

                    }
                    break;
                case 2 :
                    // /home/cattail/project/catperter/CMM.g:146:4: REAL_LITERAL
                    {
                    REAL_LITERAL8=(Token)match(input,REAL_LITERAL,FOLLOW_REAL_LITERAL_in_constant565); if (state.failed) return value;

                    if ( state.backtracking==0 ) {value =Float.parseFloat((REAL_LITERAL8!=null?REAL_LITERAL8.getText():null));}

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
            if ( state.backtracking>0 ) { memoize(input, 24, constant_StartIndex); }

        }
        return value;
    }
    // $ANTLR end "constant"



    // $ANTLR start "assignment_operator"
    // /home/cattail/project/catperter/CMM.g:161:1: assignment_operator : ( '=' | '+=' | '-=' | '*=' | '/=' );
    public final void assignment_operator() throws RecognitionException {
        int assignment_operator_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return ; }

            // /home/cattail/project/catperter/CMM.g:162:2: ( '=' | '+=' | '-=' | '*=' | '/=' )
            // /home/cattail/project/catperter/CMM.g:
            {
            if ( input.LA(1)==16||input.LA(1)==18||input.LA(1)==21||input.LA(1)==23||input.LA(1)==26 ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
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
            if ( state.backtracking>0 ) { memoize(input, 25, assignment_operator_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "assignment_operator"


    public static class unary_operator_return extends ParserRuleReturnScope {
    };


    // $ANTLR start "unary_operator"
    // /home/cattail/project/catperter/CMM.g:174:1: unary_operator : ( '+' | '-' );
    public final CMMParser.unary_operator_return unary_operator() throws RecognitionException {
        CMMParser.unary_operator_return retval = new CMMParser.unary_operator_return();
        retval.start = input.LT(1);

        int unary_operator_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return retval; }

            // /home/cattail/project/catperter/CMM.g:175:2: ( '+' | '-' )
            // /home/cattail/project/catperter/CMM.g:
            {
            if ( input.LA(1)==17||input.LA(1)==20 ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 26, unary_operator_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "unary_operator"

    // $ANTLR start synpred9_CMM
    public final void synpred9_CMM_fragment() throws RecognitionException {
        // /home/cattail/project/catperter/CMM.g:82:4: ( equality_expression )
        // /home/cattail/project/catperter/CMM.g:82:4: equality_expression
        {
        pushFollow(FOLLOW_equality_expression_in_synpred9_CMM245);
        equality_expression();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred9_CMM

    // Delegated rules

    public final boolean synpred9_CMM() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_CMM_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_statement_in_prog60 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compound_statement_in_statement70 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_statement_in_statement75 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_selection_statement_in_statement80 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_iteration_statement_in_statement85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_statement90 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_compound_statement111 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_compound_statement113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_compound_statement118 = new BitSet(new long[]{0x00000007C11228C0L});
    public static final BitSet FOLLOW_statement_list_in_compound_statement120 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_compound_statement122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_statement_list132 = new BitSet(new long[]{0x00000007C11228C2L});
    public static final BitSet FOLLOW_24_in_expression_statement143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_expression_statement148 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_expression_statement150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_selection_statement160 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_selection_statement162 = new BitSet(new long[]{0x00000000001228C0L});
    public static final BitSet FOLLOW_expression_in_selection_statement164 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_selection_statement166 = new BitSet(new long[]{0x00000007C11228C0L});
    public static final BitSet FOLLOW_statement_in_selection_statement168 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_selection_statement183 = new BitSet(new long[]{0x00000007C11228C0L});
    public static final BitSet FOLLOW_statement_in_selection_statement185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_iteration_statement197 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_iteration_statement199 = new BitSet(new long[]{0x00000000001228C0L});
    public static final BitSet FOLLOW_expression_in_iteration_statement201 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_iteration_statement203 = new BitSet(new long[]{0x00000007C11228C0L});
    public static final BitSet FOLLOW_statement_in_iteration_statement205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_expression_in_expression216 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_expression220 = new BitSet(new long[]{0x00000000001228C0L});
    public static final BitSet FOLLOW_assignment_expression_in_expression222 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_equality_expression_in_constant_expression235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_equality_expression_in_assignment_expression245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_expression_in_assignment_expression250 = new BitSet(new long[]{0x0000000004A50000L});
    public static final BitSet FOLLOW_assignment_operator_in_assignment_expression252 = new BitSet(new long[]{0x00000000001228C0L});
    public static final BitSet FOLLOW_assignment_expression_in_assignment_expression254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relational_expression_in_equality_expression264 = new BitSet(new long[]{0x0000000000000422L});
    public static final BitSet FOLLOW_EQ_OP_in_equality_expression268 = new BitSet(new long[]{0x00000000001228C0L});
    public static final BitSet FOLLOW_relational_expression_in_equality_expression270 = new BitSet(new long[]{0x0000000000000422L});
    public static final BitSet FOLLOW_NE_OP_in_equality_expression274 = new BitSet(new long[]{0x00000000001228C0L});
    public static final BitSet FOLLOW_relational_expression_in_equality_expression276 = new BitSet(new long[]{0x0000000000000422L});
    public static final BitSet FOLLOW_additive_expression_in_relational_expression289 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_relational_expression293 = new BitSet(new long[]{0x00000000001228C0L});
    public static final BitSet FOLLOW_additive_expression_in_relational_expression295 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_multiplicative_expression_in_additive_expression308 = new BitSet(new long[]{0x0000000000120002L});
    public static final BitSet FOLLOW_17_in_additive_expression312 = new BitSet(new long[]{0x00000000001228C0L});
    public static final BitSet FOLLOW_multiplicative_expression_in_additive_expression314 = new BitSet(new long[]{0x0000000000120002L});
    public static final BitSet FOLLOW_20_in_additive_expression318 = new BitSet(new long[]{0x00000000001228C0L});
    public static final BitSet FOLLOW_multiplicative_expression_in_additive_expression320 = new BitSet(new long[]{0x0000000000120002L});
    public static final BitSet FOLLOW_unary_expression_in_multiplicative_expression337 = new BitSet(new long[]{0x0000000000408002L});
    public static final BitSet FOLLOW_15_in_multiplicative_expression341 = new BitSet(new long[]{0x00000000001228C0L});
    public static final BitSet FOLLOW_unary_expression_in_multiplicative_expression343 = new BitSet(new long[]{0x0000000000408002L});
    public static final BitSet FOLLOW_22_in_multiplicative_expression347 = new BitSet(new long[]{0x00000000001228C0L});
    public static final BitSet FOLLOW_unary_expression_in_multiplicative_expression349 = new BitSet(new long[]{0x0000000000408002L});
    public static final BitSet FOLLOW_postfix_expression_in_unary_expression370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unary_operator_in_unary_expression377 = new BitSet(new long[]{0x00000000001228C0L});
    public static final BitSet FOLLOW_unary_expression_in_unary_expression379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_expression_in_postfix_expression397 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_postfix_expression400 = new BitSet(new long[]{0x00000000001228C0L});
    public static final BitSet FOLLOW_expression_in_postfix_expression402 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_postfix_expression404 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_constant_in_primary_expression424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_primary_expression431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_primary_expression438 = new BitSet(new long[]{0x00000000001228C0L});
    public static final BitSet FOLLOW_expression_in_primary_expression440 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_primary_expression442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declarator_specifiers_in_declaration453 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_init_declarator_list_in_declaration455 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_declaration457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_init_declarator_in_init_declarator_list482 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_init_declarator_list486 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_init_declarator_in_init_declarator_list488 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_declarator_in_init_declarator501 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_init_declarator504 = new BitSet(new long[]{0x00000000001228C0L});
    public static final BitSet FOLLOW_initializer_in_init_declarator506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_declarator522 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_declarator525 = new BitSet(new long[]{0x00000000101228C0L});
    public static final BitSet FOLLOW_constant_expression_in_declarator527 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_declarator530 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_assignment_expression_in_initializer542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_LITERAL_in_constant558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REAL_LITERAL_in_constant565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_equality_expression_in_synpred9_CMM245 = new BitSet(new long[]{0x0000000000000002L});

}