// $ANTLR 3.4 /home/cattail/Desktop/catperter/CMM.g 2012-10-10 16:06:59

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.debug.*;
import java.io.IOException;
@SuppressWarnings({"all", "warnings", "unchecked"})
public class CMMParser extends DebugParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGNMENT_OPERATOR", "COMMENT", "EQ_OP", "IDENTIFIER", "INT_LITERAL", "LINE_COMMENT", "NE_OP", "REAL_LITERAL", "'('", "')'", "'*'", "'+'", "','", "'-'", "'/'", "';'", "'<'", "'='", "'else'", "'if'", "'int'", "'real'", "'while'", "'{'", "'}'"
    };

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
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


public static final String[] ruleNames = new String[] {
    "invalidRule", "statement_list", "selection_statement", "constant", 
    "statement", "declarator", "prog", "synpred1_CMM", "initializer", "init_declarator_list", 
    "primary_expression", "assignment_expression", "multiplicative_expression", 
    "expression_statement", "relational_expression", "declarator_specifiers", 
    "equality_expression", "compound_statement", "iteration_statement", 
    "init_declarator", "expression", "declaration", "additive_expression"
};

public static final boolean[] decisionCanBacktrack = new boolean[] {
    false, // invalid decision
    false, false, false, false, false, false, true, false, false, false, 
        false, false, false, false
};

 
    public int ruleLevel = 0;
    public int getRuleLevel() { return ruleLevel; }
    public void incRuleLevel() { ruleLevel++; }
    public void decRuleLevel() { ruleLevel--; }
    public CMMParser(TokenStream input) {
        this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
    }
    public CMMParser(TokenStream input, int port, RecognizerSharedState state) {
        super(input, state);
        DebugEventSocketProxy proxy =
            new DebugEventSocketProxy(this, port, null);

        setDebugListener(proxy);
        try {
            proxy.handshake();
        }
        catch (IOException ioe) {
            reportError(ioe);
        }
    }

public CMMParser(TokenStream input, DebugEventListener dbg) {
    super(input, dbg, new RecognizerSharedState());
}

protected boolean evalPredicate(boolean result, String predicate) {
    dbg.semanticPredicate(result, predicate);
    return result;
}

    public String[] getTokenNames() { return CMMParser.tokenNames; }
    public String getGrammarFileName() { return "/home/cattail/Desktop/catperter/CMM.g"; }



    // $ANTLR start "prog"
    // /home/cattail/Desktop/catperter/CMM.g:14:1: prog : statement ;
    public final void prog() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "prog");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(14, 0);

        try {
            // /home/cattail/Desktop/catperter/CMM.g:15:2: ( statement )
            dbg.enterAlt(1);

            // /home/cattail/Desktop/catperter/CMM.g:15:4: statement
            {
            dbg.location(15,4);
            pushFollow(FOLLOW_statement_in_prog13);
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
        }
        dbg.location(16, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "prog");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "prog"



    // $ANTLR start "statement"
    // /home/cattail/Desktop/catperter/CMM.g:17:1: statement : ( compound_statement | expression_statement | selection_statement | iteration_statement | declaration );
    public final void statement() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "statement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(17, 0);

        try {
            // /home/cattail/Desktop/catperter/CMM.g:18:2: ( compound_statement | expression_statement | selection_statement | iteration_statement | declaration )
            int alt1=5;
            try { dbg.enterDecision(1, decisionCanBacktrack[1]);

            switch ( input.LA(1) ) {
            case 27:
                {
                alt1=1;
                }
                break;
            case IDENTIFIER:
            case INT_LITERAL:
            case REAL_LITERAL:
            case 12:
            case 19:
                {
                alt1=2;
                }
                break;
            case 23:
                {
                alt1=3;
                }
                break;
            case 26:
                {
                alt1=4;
                }
                break;
            case 24:
            case 25:
                {
                alt1=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(1);}

            switch (alt1) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/cattail/Desktop/catperter/CMM.g:18:4: compound_statement
                    {
                    dbg.location(18,4);
                    pushFollow(FOLLOW_compound_statement_in_statement23);
                    compound_statement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/cattail/Desktop/catperter/CMM.g:19:4: expression_statement
                    {
                    dbg.location(19,4);
                    pushFollow(FOLLOW_expression_statement_in_statement28);
                    expression_statement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /home/cattail/Desktop/catperter/CMM.g:20:4: selection_statement
                    {
                    dbg.location(20,4);
                    pushFollow(FOLLOW_selection_statement_in_statement33);
                    selection_statement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // /home/cattail/Desktop/catperter/CMM.g:21:4: iteration_statement
                    {
                    dbg.location(21,4);
                    pushFollow(FOLLOW_iteration_statement_in_statement38);
                    iteration_statement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 5 :
                    dbg.enterAlt(5);

                    // /home/cattail/Desktop/catperter/CMM.g:22:4: declaration
                    {
                    dbg.location(22,4);
                    pushFollow(FOLLOW_declaration_in_statement43);
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
        }
        dbg.location(23, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "statement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "statement"



    // $ANTLR start "compound_statement"
    // /home/cattail/Desktop/catperter/CMM.g:24:1: compound_statement : ( '{' '}' | '{' statement_list '}' );
    public final void compound_statement() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "compound_statement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(24, 0);

        try {
            // /home/cattail/Desktop/catperter/CMM.g:25:2: ( '{' '}' | '{' statement_list '}' )
            int alt2=2;
            try { dbg.enterDecision(2, decisionCanBacktrack[2]);

            int LA2_0 = input.LA(1);

            if ( (LA2_0==27) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==28) ) {
                    alt2=1;
                }
                else if ( ((LA2_1 >= IDENTIFIER && LA2_1 <= INT_LITERAL)||(LA2_1 >= REAL_LITERAL && LA2_1 <= 12)||LA2_1==19||(LA2_1 >= 23 && LA2_1 <= 27)) ) {
                    alt2=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    dbg.recognitionException(nvae);
                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(2);}

            switch (alt2) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/cattail/Desktop/catperter/CMM.g:25:4: '{' '}'
                    {
                    dbg.location(25,4);
                    match(input,27,FOLLOW_27_in_compound_statement53); if (state.failed) return ;
                    dbg.location(25,8);
                    match(input,28,FOLLOW_28_in_compound_statement55); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/cattail/Desktop/catperter/CMM.g:26:4: '{' statement_list '}'
                    {
                    dbg.location(26,4);
                    match(input,27,FOLLOW_27_in_compound_statement60); if (state.failed) return ;
                    dbg.location(26,8);
                    pushFollow(FOLLOW_statement_list_in_compound_statement62);
                    statement_list();

                    state._fsp--;
                    if (state.failed) return ;
                    dbg.location(26,23);
                    match(input,28,FOLLOW_28_in_compound_statement64); if (state.failed) return ;

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
        dbg.location(27, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "compound_statement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "compound_statement"



    // $ANTLR start "statement_list"
    // /home/cattail/Desktop/catperter/CMM.g:28:1: statement_list : ( statement )+ ;
    public final void statement_list() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "statement_list");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(28, 0);

        try {
            // /home/cattail/Desktop/catperter/CMM.g:29:2: ( ( statement )+ )
            dbg.enterAlt(1);

            // /home/cattail/Desktop/catperter/CMM.g:29:4: ( statement )+
            {
            dbg.location(29,4);
            // /home/cattail/Desktop/catperter/CMM.g:29:4: ( statement )+
            int cnt3=0;
            try { dbg.enterSubRule(3);

            loop3:
            do {
                int alt3=2;
                try { dbg.enterDecision(3, decisionCanBacktrack[3]);

                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= IDENTIFIER && LA3_0 <= INT_LITERAL)||(LA3_0 >= REAL_LITERAL && LA3_0 <= 12)||LA3_0==19||(LA3_0 >= 23 && LA3_0 <= 27)) ) {
                    alt3=1;
                }


                } finally {dbg.exitDecision(3);}

                switch (alt3) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/cattail/Desktop/catperter/CMM.g:29:4: statement
            	    {
            	    dbg.location(29,4);
            	    pushFollow(FOLLOW_statement_in_statement_list74);
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
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt3++;
            } while (true);
            } finally {dbg.exitSubRule(3);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(30, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "statement_list");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "statement_list"



    // $ANTLR start "expression_statement"
    // /home/cattail/Desktop/catperter/CMM.g:31:1: expression_statement : ( ';' | expression ';' );
    public final void expression_statement() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "expression_statement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(31, 0);

        try {
            // /home/cattail/Desktop/catperter/CMM.g:32:2: ( ';' | expression ';' )
            int alt4=2;
            try { dbg.enterDecision(4, decisionCanBacktrack[4]);

            int LA4_0 = input.LA(1);

            if ( (LA4_0==19) ) {
                alt4=1;
            }
            else if ( ((LA4_0 >= IDENTIFIER && LA4_0 <= INT_LITERAL)||(LA4_0 >= REAL_LITERAL && LA4_0 <= 12)) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(4);}

            switch (alt4) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/cattail/Desktop/catperter/CMM.g:32:4: ';'
                    {
                    dbg.location(32,4);
                    match(input,19,FOLLOW_19_in_expression_statement85); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/cattail/Desktop/catperter/CMM.g:33:4: expression ';'
                    {
                    dbg.location(33,4);
                    pushFollow(FOLLOW_expression_in_expression_statement90);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;
                    dbg.location(33,15);
                    match(input,19,FOLLOW_19_in_expression_statement92); if (state.failed) return ;

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
        dbg.location(34, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "expression_statement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "expression_statement"



    // $ANTLR start "selection_statement"
    // /home/cattail/Desktop/catperter/CMM.g:35:1: selection_statement : 'if' '(' expression ')' statement ( options {k=1; backtrack=false; } : 'else' statement )? ;
    public final void selection_statement() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "selection_statement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(35, 0);

        try {
            // /home/cattail/Desktop/catperter/CMM.g:36:2: ( 'if' '(' expression ')' statement ( options {k=1; backtrack=false; } : 'else' statement )? )
            dbg.enterAlt(1);

            // /home/cattail/Desktop/catperter/CMM.g:36:4: 'if' '(' expression ')' statement ( options {k=1; backtrack=false; } : 'else' statement )?
            {
            dbg.location(36,4);
            match(input,23,FOLLOW_23_in_selection_statement102); if (state.failed) return ;
            dbg.location(36,9);
            match(input,12,FOLLOW_12_in_selection_statement104); if (state.failed) return ;
            dbg.location(36,13);
            pushFollow(FOLLOW_expression_in_selection_statement106);
            expression();

            state._fsp--;
            if (state.failed) return ;
            dbg.location(36,24);
            match(input,13,FOLLOW_13_in_selection_statement108); if (state.failed) return ;
            dbg.location(36,28);
            pushFollow(FOLLOW_statement_in_selection_statement110);
            statement();

            state._fsp--;
            if (state.failed) return ;
            dbg.location(36,38);
            // /home/cattail/Desktop/catperter/CMM.g:36:38: ( options {k=1; backtrack=false; } : 'else' statement )?
            int alt5=2;
            try { dbg.enterSubRule(5);
            try { dbg.enterDecision(5, decisionCanBacktrack[5]);

            int LA5_0 = input.LA(1);

            if ( (LA5_0==22) ) {
                alt5=1;
            }
            } finally {dbg.exitDecision(5);}

            switch (alt5) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/cattail/Desktop/catperter/CMM.g:36:71: 'else' statement
                    {
                    dbg.location(36,71);
                    match(input,22,FOLLOW_22_in_selection_statement125); if (state.failed) return ;
                    dbg.location(36,78);
                    pushFollow(FOLLOW_statement_in_selection_statement127);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
            } finally {dbg.exitSubRule(5);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(37, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "selection_statement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "selection_statement"



    // $ANTLR start "iteration_statement"
    // /home/cattail/Desktop/catperter/CMM.g:38:1: iteration_statement : 'while' '(' expression ')' statement ;
    public final void iteration_statement() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "iteration_statement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(38, 0);

        try {
            // /home/cattail/Desktop/catperter/CMM.g:39:2: ( 'while' '(' expression ')' statement )
            dbg.enterAlt(1);

            // /home/cattail/Desktop/catperter/CMM.g:39:4: 'while' '(' expression ')' statement
            {
            dbg.location(39,4);
            match(input,26,FOLLOW_26_in_iteration_statement139); if (state.failed) return ;
            dbg.location(39,12);
            match(input,12,FOLLOW_12_in_iteration_statement141); if (state.failed) return ;
            dbg.location(39,16);
            pushFollow(FOLLOW_expression_in_iteration_statement143);
            expression();

            state._fsp--;
            if (state.failed) return ;
            dbg.location(39,27);
            match(input,13,FOLLOW_13_in_iteration_statement145); if (state.failed) return ;
            dbg.location(39,31);
            pushFollow(FOLLOW_statement_in_iteration_statement147);
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
        }
        dbg.location(40, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "iteration_statement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "iteration_statement"



    // $ANTLR start "expression"
    // /home/cattail/Desktop/catperter/CMM.g:42:1: expression : assignment_expression ( ',' assignment_expression )* ;
    public final void expression() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(42, 0);

        try {
            // /home/cattail/Desktop/catperter/CMM.g:43:2: ( assignment_expression ( ',' assignment_expression )* )
            dbg.enterAlt(1);

            // /home/cattail/Desktop/catperter/CMM.g:43:4: assignment_expression ( ',' assignment_expression )*
            {
            dbg.location(43,4);
            pushFollow(FOLLOW_assignment_expression_in_expression158);
            assignment_expression();

            state._fsp--;
            if (state.failed) return ;
            dbg.location(43,26);
            // /home/cattail/Desktop/catperter/CMM.g:43:26: ( ',' assignment_expression )*
            try { dbg.enterSubRule(6);

            loop6:
            do {
                int alt6=2;
                try { dbg.enterDecision(6, decisionCanBacktrack[6]);

                int LA6_0 = input.LA(1);

                if ( (LA6_0==16) ) {
                    alt6=1;
                }


                } finally {dbg.exitDecision(6);}

                switch (alt6) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/cattail/Desktop/catperter/CMM.g:43:28: ',' assignment_expression
            	    {
            	    dbg.location(43,28);
            	    match(input,16,FOLLOW_16_in_expression162); if (state.failed) return ;
            	    dbg.location(43,32);
            	    pushFollow(FOLLOW_assignment_expression_in_expression164);
            	    assignment_expression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);
            } finally {dbg.exitSubRule(6);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(44, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "expression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "expression"



    // $ANTLR start "assignment_expression"
    // /home/cattail/Desktop/catperter/CMM.g:45:1: assignment_expression options {backtrack=true; } : ( equality_expression | primary_expression ASSIGNMENT_OPERATOR assignment_expression );
    public final void assignment_expression() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "assignment_expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(45, 0);

        try {
            // /home/cattail/Desktop/catperter/CMM.g:47:2: ( equality_expression | primary_expression ASSIGNMENT_OPERATOR assignment_expression )
            int alt7=2;
            try { dbg.enterDecision(7, decisionCanBacktrack[7]);

            switch ( input.LA(1) ) {
            case INT_LITERAL:
            case REAL_LITERAL:
                {
                int LA7_1 = input.LA(2);

                if ( (synpred1_CMM()) ) {
                    alt7=1;
                }
                else if ( (true) ) {
                    alt7=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    dbg.recognitionException(nvae);
                    throw nvae;

                }
                }
                break;
            case IDENTIFIER:
                {
                int LA7_2 = input.LA(2);

                if ( (synpred1_CMM()) ) {
                    alt7=1;
                }
                else if ( (true) ) {
                    alt7=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 2, input);

                    dbg.recognitionException(nvae);
                    throw nvae;

                }
                }
                break;
            case 12:
                {
                int LA7_3 = input.LA(2);

                if ( (synpred1_CMM()) ) {
                    alt7=1;
                }
                else if ( (true) ) {
                    alt7=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 3, input);

                    dbg.recognitionException(nvae);
                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(7);}

            switch (alt7) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/cattail/Desktop/catperter/CMM.g:47:4: equality_expression
                    {
                    dbg.location(47,4);
                    pushFollow(FOLLOW_equality_expression_in_assignment_expression184);
                    equality_expression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/cattail/Desktop/catperter/CMM.g:48:4: primary_expression ASSIGNMENT_OPERATOR assignment_expression
                    {
                    dbg.location(48,4);
                    pushFollow(FOLLOW_primary_expression_in_assignment_expression189);
                    primary_expression();

                    state._fsp--;
                    if (state.failed) return ;
                    dbg.location(48,23);
                    match(input,ASSIGNMENT_OPERATOR,FOLLOW_ASSIGNMENT_OPERATOR_in_assignment_expression191); if (state.failed) return ;
                    dbg.location(48,43);
                    pushFollow(FOLLOW_assignment_expression_in_assignment_expression193);
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
        }
        dbg.location(49, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "assignment_expression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "assignment_expression"



    // $ANTLR start "equality_expression"
    // /home/cattail/Desktop/catperter/CMM.g:50:1: equality_expression : relational_expression ( EQ_OP relational_expression | NE_OP relational_expression )* ;
    public final void equality_expression() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "equality_expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(50, 0);

        try {
            // /home/cattail/Desktop/catperter/CMM.g:51:2: ( relational_expression ( EQ_OP relational_expression | NE_OP relational_expression )* )
            dbg.enterAlt(1);

            // /home/cattail/Desktop/catperter/CMM.g:51:4: relational_expression ( EQ_OP relational_expression | NE_OP relational_expression )*
            {
            dbg.location(51,4);
            pushFollow(FOLLOW_relational_expression_in_equality_expression203);
            relational_expression();

            state._fsp--;
            if (state.failed) return ;
            dbg.location(51,26);
            // /home/cattail/Desktop/catperter/CMM.g:51:26: ( EQ_OP relational_expression | NE_OP relational_expression )*
            try { dbg.enterSubRule(8);

            loop8:
            do {
                int alt8=3;
                try { dbg.enterDecision(8, decisionCanBacktrack[8]);

                int LA8_0 = input.LA(1);

                if ( (LA8_0==EQ_OP) ) {
                    alt8=1;
                }
                else if ( (LA8_0==NE_OP) ) {
                    alt8=2;
                }


                } finally {dbg.exitDecision(8);}

                switch (alt8) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/cattail/Desktop/catperter/CMM.g:51:28: EQ_OP relational_expression
            	    {
            	    dbg.location(51,28);
            	    match(input,EQ_OP,FOLLOW_EQ_OP_in_equality_expression207); if (state.failed) return ;
            	    dbg.location(51,34);
            	    pushFollow(FOLLOW_relational_expression_in_equality_expression209);
            	    relational_expression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    dbg.enterAlt(2);

            	    // /home/cattail/Desktop/catperter/CMM.g:51:58: NE_OP relational_expression
            	    {
            	    dbg.location(51,58);
            	    match(input,NE_OP,FOLLOW_NE_OP_in_equality_expression213); if (state.failed) return ;
            	    dbg.location(51,64);
            	    pushFollow(FOLLOW_relational_expression_in_equality_expression215);
            	    relational_expression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);
            } finally {dbg.exitSubRule(8);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(52, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "equality_expression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "equality_expression"



    // $ANTLR start "relational_expression"
    // /home/cattail/Desktop/catperter/CMM.g:53:1: relational_expression : additive_expression ( '<' additive_expression )* ;
    public final void relational_expression() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "relational_expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(53, 0);

        try {
            // /home/cattail/Desktop/catperter/CMM.g:54:2: ( additive_expression ( '<' additive_expression )* )
            dbg.enterAlt(1);

            // /home/cattail/Desktop/catperter/CMM.g:54:4: additive_expression ( '<' additive_expression )*
            {
            dbg.location(54,4);
            pushFollow(FOLLOW_additive_expression_in_relational_expression228);
            additive_expression();

            state._fsp--;
            if (state.failed) return ;
            dbg.location(54,24);
            // /home/cattail/Desktop/catperter/CMM.g:54:24: ( '<' additive_expression )*
            try { dbg.enterSubRule(9);

            loop9:
            do {
                int alt9=2;
                try { dbg.enterDecision(9, decisionCanBacktrack[9]);

                int LA9_0 = input.LA(1);

                if ( (LA9_0==20) ) {
                    alt9=1;
                }


                } finally {dbg.exitDecision(9);}

                switch (alt9) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/cattail/Desktop/catperter/CMM.g:54:26: '<' additive_expression
            	    {
            	    dbg.location(54,26);
            	    match(input,20,FOLLOW_20_in_relational_expression232); if (state.failed) return ;
            	    dbg.location(54,30);
            	    pushFollow(FOLLOW_additive_expression_in_relational_expression234);
            	    additive_expression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);
            } finally {dbg.exitSubRule(9);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(55, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "relational_expression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "relational_expression"



    // $ANTLR start "additive_expression"
    // /home/cattail/Desktop/catperter/CMM.g:56:1: additive_expression : multiplicative_expression ( '+' multiplicative_expression | '-' multiplicative_expression ) ;
    public final void additive_expression() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "additive_expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(56, 0);

        try {
            // /home/cattail/Desktop/catperter/CMM.g:57:2: ( multiplicative_expression ( '+' multiplicative_expression | '-' multiplicative_expression ) )
            dbg.enterAlt(1);

            // /home/cattail/Desktop/catperter/CMM.g:57:4: multiplicative_expression ( '+' multiplicative_expression | '-' multiplicative_expression )
            {
            dbg.location(57,4);
            pushFollow(FOLLOW_multiplicative_expression_in_additive_expression247);
            multiplicative_expression();

            state._fsp--;
            if (state.failed) return ;
            dbg.location(57,30);
            // /home/cattail/Desktop/catperter/CMM.g:57:30: ( '+' multiplicative_expression | '-' multiplicative_expression )
            int alt10=2;
            try { dbg.enterSubRule(10);
            try { dbg.enterDecision(10, decisionCanBacktrack[10]);

            int LA10_0 = input.LA(1);

            if ( (LA10_0==15) ) {
                alt10=1;
            }
            else if ( (LA10_0==17) ) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(10);}

            switch (alt10) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/cattail/Desktop/catperter/CMM.g:57:32: '+' multiplicative_expression
                    {
                    dbg.location(57,32);
                    match(input,15,FOLLOW_15_in_additive_expression251); if (state.failed) return ;
                    dbg.location(57,36);
                    pushFollow(FOLLOW_multiplicative_expression_in_additive_expression253);
                    multiplicative_expression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/cattail/Desktop/catperter/CMM.g:57:64: '-' multiplicative_expression
                    {
                    dbg.location(57,64);
                    match(input,17,FOLLOW_17_in_additive_expression257); if (state.failed) return ;
                    dbg.location(57,68);
                    pushFollow(FOLLOW_multiplicative_expression_in_additive_expression259);
                    multiplicative_expression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
            } finally {dbg.exitSubRule(10);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(58, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "additive_expression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "additive_expression"



    // $ANTLR start "multiplicative_expression"
    // /home/cattail/Desktop/catperter/CMM.g:59:1: multiplicative_expression : primary_expression ( '*' primary_expression | '/' primary_expression ) ;
    public final void multiplicative_expression() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "multiplicative_expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(59, 0);

        try {
            // /home/cattail/Desktop/catperter/CMM.g:60:2: ( primary_expression ( '*' primary_expression | '/' primary_expression ) )
            dbg.enterAlt(1);

            // /home/cattail/Desktop/catperter/CMM.g:60:4: primary_expression ( '*' primary_expression | '/' primary_expression )
            {
            dbg.location(60,4);
            pushFollow(FOLLOW_primary_expression_in_multiplicative_expression271);
            primary_expression();

            state._fsp--;
            if (state.failed) return ;
            dbg.location(60,23);
            // /home/cattail/Desktop/catperter/CMM.g:60:23: ( '*' primary_expression | '/' primary_expression )
            int alt11=2;
            try { dbg.enterSubRule(11);
            try { dbg.enterDecision(11, decisionCanBacktrack[11]);

            int LA11_0 = input.LA(1);

            if ( (LA11_0==14) ) {
                alt11=1;
            }
            else if ( (LA11_0==18) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(11);}

            switch (alt11) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/cattail/Desktop/catperter/CMM.g:60:25: '*' primary_expression
                    {
                    dbg.location(60,25);
                    match(input,14,FOLLOW_14_in_multiplicative_expression275); if (state.failed) return ;
                    dbg.location(60,29);
                    pushFollow(FOLLOW_primary_expression_in_multiplicative_expression277);
                    primary_expression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/cattail/Desktop/catperter/CMM.g:60:50: '/' primary_expression
                    {
                    dbg.location(60,50);
                    match(input,18,FOLLOW_18_in_multiplicative_expression281); if (state.failed) return ;
                    dbg.location(60,54);
                    pushFollow(FOLLOW_primary_expression_in_multiplicative_expression283);
                    primary_expression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
            } finally {dbg.exitSubRule(11);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(61, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "multiplicative_expression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "multiplicative_expression"



    // $ANTLR start "primary_expression"
    // /home/cattail/Desktop/catperter/CMM.g:62:1: primary_expression : ( constant | IDENTIFIER | '(' expression ')' );
    public final void primary_expression() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "primary_expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(62, 0);

        try {
            // /home/cattail/Desktop/catperter/CMM.g:63:2: ( constant | IDENTIFIER | '(' expression ')' )
            int alt12=3;
            try { dbg.enterDecision(12, decisionCanBacktrack[12]);

            switch ( input.LA(1) ) {
            case INT_LITERAL:
            case REAL_LITERAL:
                {
                alt12=1;
                }
                break;
            case IDENTIFIER:
                {
                alt12=2;
                }
                break;
            case 12:
                {
                alt12=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(12);}

            switch (alt12) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/cattail/Desktop/catperter/CMM.g:63:4: constant
                    {
                    dbg.location(63,4);
                    pushFollow(FOLLOW_constant_in_primary_expression295);
                    constant();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/cattail/Desktop/catperter/CMM.g:64:4: IDENTIFIER
                    {
                    dbg.location(64,4);
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_primary_expression300); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /home/cattail/Desktop/catperter/CMM.g:65:4: '(' expression ')'
                    {
                    dbg.location(65,4);
                    match(input,12,FOLLOW_12_in_primary_expression305); if (state.failed) return ;
                    dbg.location(65,8);
                    pushFollow(FOLLOW_expression_in_primary_expression307);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;
                    dbg.location(65,19);
                    match(input,13,FOLLOW_13_in_primary_expression309); if (state.failed) return ;

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
        dbg.location(66, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "primary_expression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "primary_expression"



    // $ANTLR start "declaration"
    // /home/cattail/Desktop/catperter/CMM.g:67:1: declaration : declarator_specifiers init_declarator_list ';' ;
    public final void declaration() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "declaration");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(67, 0);

        try {
            // /home/cattail/Desktop/catperter/CMM.g:68:2: ( declarator_specifiers init_declarator_list ';' )
            dbg.enterAlt(1);

            // /home/cattail/Desktop/catperter/CMM.g:68:4: declarator_specifiers init_declarator_list ';'
            {
            dbg.location(68,4);
            pushFollow(FOLLOW_declarator_specifiers_in_declaration319);
            declarator_specifiers();

            state._fsp--;
            if (state.failed) return ;
            dbg.location(68,26);
            pushFollow(FOLLOW_init_declarator_list_in_declaration321);
            init_declarator_list();

            state._fsp--;
            if (state.failed) return ;
            dbg.location(68,47);
            match(input,19,FOLLOW_19_in_declaration323); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(69, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "declaration");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "declaration"



    // $ANTLR start "declarator_specifiers"
    // /home/cattail/Desktop/catperter/CMM.g:70:1: declarator_specifiers : ( 'int' | 'real' );
    public final void declarator_specifiers() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "declarator_specifiers");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(70, 0);

        try {
            // /home/cattail/Desktop/catperter/CMM.g:71:2: ( 'int' | 'real' )
            dbg.enterAlt(1);

            // /home/cattail/Desktop/catperter/CMM.g:
            {
            dbg.location(71,2);
            if ( (input.LA(1) >= 24 && input.LA(1) <= 25) ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                dbg.recognitionException(mse);
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
        dbg.location(73, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "declarator_specifiers");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "declarator_specifiers"



    // $ANTLR start "init_declarator_list"
    // /home/cattail/Desktop/catperter/CMM.g:74:1: init_declarator_list : init_declarator ( ',' init_declarator )* ;
    public final void init_declarator_list() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "init_declarator_list");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(74, 0);

        try {
            // /home/cattail/Desktop/catperter/CMM.g:75:2: ( init_declarator ( ',' init_declarator )* )
            dbg.enterAlt(1);

            // /home/cattail/Desktop/catperter/CMM.g:75:4: init_declarator ( ',' init_declarator )*
            {
            dbg.location(75,4);
            pushFollow(FOLLOW_init_declarator_in_init_declarator_list348);
            init_declarator();

            state._fsp--;
            if (state.failed) return ;
            dbg.location(75,20);
            // /home/cattail/Desktop/catperter/CMM.g:75:20: ( ',' init_declarator )*
            try { dbg.enterSubRule(13);

            loop13:
            do {
                int alt13=2;
                try { dbg.enterDecision(13, decisionCanBacktrack[13]);

                int LA13_0 = input.LA(1);

                if ( (LA13_0==16) ) {
                    alt13=1;
                }


                } finally {dbg.exitDecision(13);}

                switch (alt13) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/cattail/Desktop/catperter/CMM.g:75:22: ',' init_declarator
            	    {
            	    dbg.location(75,22);
            	    match(input,16,FOLLOW_16_in_init_declarator_list352); if (state.failed) return ;
            	    dbg.location(75,26);
            	    pushFollow(FOLLOW_init_declarator_in_init_declarator_list354);
            	    init_declarator();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);
            } finally {dbg.exitSubRule(13);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(76, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "init_declarator_list");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "init_declarator_list"



    // $ANTLR start "init_declarator"
    // /home/cattail/Desktop/catperter/CMM.g:77:1: init_declarator : ( declarator | declarator '=' initializer );
    public final void init_declarator() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "init_declarator");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(77, 0);

        try {
            // /home/cattail/Desktop/catperter/CMM.g:78:2: ( declarator | declarator '=' initializer )
            int alt14=2;
            try { dbg.enterDecision(14, decisionCanBacktrack[14]);

            int LA14_0 = input.LA(1);

            if ( (LA14_0==IDENTIFIER) ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==16||LA14_1==19) ) {
                    alt14=1;
                }
                else if ( (LA14_1==21) ) {
                    alt14=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 1, input);

                    dbg.recognitionException(nvae);
                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(14);}

            switch (alt14) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/cattail/Desktop/catperter/CMM.g:78:4: declarator
                    {
                    dbg.location(78,4);
                    pushFollow(FOLLOW_declarator_in_init_declarator367);
                    declarator();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/cattail/Desktop/catperter/CMM.g:79:4: declarator '=' initializer
                    {
                    dbg.location(79,4);
                    pushFollow(FOLLOW_declarator_in_init_declarator372);
                    declarator();

                    state._fsp--;
                    if (state.failed) return ;
                    dbg.location(79,15);
                    match(input,21,FOLLOW_21_in_init_declarator374); if (state.failed) return ;
                    dbg.location(79,19);
                    pushFollow(FOLLOW_initializer_in_init_declarator376);
                    initializer();

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
        }
        dbg.location(80, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "init_declarator");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "init_declarator"



    // $ANTLR start "declarator"
    // /home/cattail/Desktop/catperter/CMM.g:81:1: declarator : IDENTIFIER ;
    public final void declarator() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "declarator");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(81, 0);

        try {
            // /home/cattail/Desktop/catperter/CMM.g:82:2: ( IDENTIFIER )
            dbg.enterAlt(1);

            // /home/cattail/Desktop/catperter/CMM.g:82:4: IDENTIFIER
            {
            dbg.location(82,4);
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declarator386); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(83, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "declarator");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "declarator"



    // $ANTLR start "initializer"
    // /home/cattail/Desktop/catperter/CMM.g:84:1: initializer : assignment_expression ;
    public final void initializer() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "initializer");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(84, 0);

        try {
            // /home/cattail/Desktop/catperter/CMM.g:85:2: ( assignment_expression )
            dbg.enterAlt(1);

            // /home/cattail/Desktop/catperter/CMM.g:85:4: assignment_expression
            {
            dbg.location(85,4);
            pushFollow(FOLLOW_assignment_expression_in_initializer396);
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
        }
        dbg.location(86, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "initializer");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "initializer"



    // $ANTLR start "constant"
    // /home/cattail/Desktop/catperter/CMM.g:94:1: constant : ( INT_LITERAL | REAL_LITERAL );
    public final void constant() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "constant");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(94, 0);

        try {
            // /home/cattail/Desktop/catperter/CMM.g:95:2: ( INT_LITERAL | REAL_LITERAL )
            dbg.enterAlt(1);

            // /home/cattail/Desktop/catperter/CMM.g:
            {
            dbg.location(95,2);
            if ( input.LA(1)==INT_LITERAL||input.LA(1)==REAL_LITERAL ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                dbg.recognitionException(mse);
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
        dbg.location(97, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "constant");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "constant"

    // $ANTLR start synpred1_CMM
    public final void synpred1_CMM_fragment() throws RecognitionException {
        // /home/cattail/Desktop/catperter/CMM.g:47:4: ( equality_expression )
        dbg.enterAlt(1);

        // /home/cattail/Desktop/catperter/CMM.g:47:4: equality_expression
        {
        dbg.location(47,4);
        pushFollow(FOLLOW_equality_expression_in_synpred1_CMM184);
        equality_expression();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred1_CMM

    // Delegated rules

    public final boolean synpred1_CMM() {
        state.backtracking++;
        dbg.beginBacktrack(state.backtracking);
        int start = input.mark();
        try {
            synpred1_CMM_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        dbg.endBacktrack(state.backtracking, success);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_statement_in_prog13 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compound_statement_in_statement23 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_statement_in_statement28 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_selection_statement_in_statement33 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_iteration_statement_in_statement38 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_statement43 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_compound_statement53 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_compound_statement55 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_compound_statement60 = new BitSet(new long[]{0x000000000F881980L});
    public static final BitSet FOLLOW_statement_list_in_compound_statement62 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_compound_statement64 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_statement_list74 = new BitSet(new long[]{0x000000000F881982L});
    public static final BitSet FOLLOW_19_in_expression_statement85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_expression_statement90 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_expression_statement92 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_selection_statement102 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_selection_statement104 = new BitSet(new long[]{0x0000000000001980L});
    public static final BitSet FOLLOW_expression_in_selection_statement106 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_selection_statement108 = new BitSet(new long[]{0x000000000F881980L});
    public static final BitSet FOLLOW_statement_in_selection_statement110 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_selection_statement125 = new BitSet(new long[]{0x000000000F881980L});
    public static final BitSet FOLLOW_statement_in_selection_statement127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_iteration_statement139 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_iteration_statement141 = new BitSet(new long[]{0x0000000000001980L});
    public static final BitSet FOLLOW_expression_in_iteration_statement143 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_iteration_statement145 = new BitSet(new long[]{0x000000000F881980L});
    public static final BitSet FOLLOW_statement_in_iteration_statement147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_expression_in_expression158 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_expression162 = new BitSet(new long[]{0x0000000000001980L});
    public static final BitSet FOLLOW_assignment_expression_in_expression164 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_equality_expression_in_assignment_expression184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_expression_in_assignment_expression189 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ASSIGNMENT_OPERATOR_in_assignment_expression191 = new BitSet(new long[]{0x0000000000001980L});
    public static final BitSet FOLLOW_assignment_expression_in_assignment_expression193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relational_expression_in_equality_expression203 = new BitSet(new long[]{0x0000000000000442L});
    public static final BitSet FOLLOW_EQ_OP_in_equality_expression207 = new BitSet(new long[]{0x0000000000001980L});
    public static final BitSet FOLLOW_relational_expression_in_equality_expression209 = new BitSet(new long[]{0x0000000000000442L});
    public static final BitSet FOLLOW_NE_OP_in_equality_expression213 = new BitSet(new long[]{0x0000000000001980L});
    public static final BitSet FOLLOW_relational_expression_in_equality_expression215 = new BitSet(new long[]{0x0000000000000442L});
    public static final BitSet FOLLOW_additive_expression_in_relational_expression228 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_relational_expression232 = new BitSet(new long[]{0x0000000000001980L});
    public static final BitSet FOLLOW_additive_expression_in_relational_expression234 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_multiplicative_expression_in_additive_expression247 = new BitSet(new long[]{0x0000000000028000L});
    public static final BitSet FOLLOW_15_in_additive_expression251 = new BitSet(new long[]{0x0000000000001980L});
    public static final BitSet FOLLOW_multiplicative_expression_in_additive_expression253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_additive_expression257 = new BitSet(new long[]{0x0000000000001980L});
    public static final BitSet FOLLOW_multiplicative_expression_in_additive_expression259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_expression_in_multiplicative_expression271 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_14_in_multiplicative_expression275 = new BitSet(new long[]{0x0000000000001980L});
    public static final BitSet FOLLOW_primary_expression_in_multiplicative_expression277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_multiplicative_expression281 = new BitSet(new long[]{0x0000000000001980L});
    public static final BitSet FOLLOW_primary_expression_in_multiplicative_expression283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_primary_expression295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_primary_expression300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_primary_expression305 = new BitSet(new long[]{0x0000000000001980L});
    public static final BitSet FOLLOW_expression_in_primary_expression307 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_primary_expression309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declarator_specifiers_in_declaration319 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_init_declarator_list_in_declaration321 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_declaration323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_init_declarator_in_init_declarator_list348 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_init_declarator_list352 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_init_declarator_in_init_declarator_list354 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_declarator_in_init_declarator367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declarator_in_init_declarator372 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_init_declarator374 = new BitSet(new long[]{0x0000000000001980L});
    public static final BitSet FOLLOW_initializer_in_init_declarator376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_declarator386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_expression_in_initializer396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_equality_expression_in_synpred1_CMM184 = new BitSet(new long[]{0x0000000000000002L});

}