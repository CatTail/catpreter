import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
public class Test {
    public static void main(String args[]) throws Exception {
        CMMLexer lex = new CMMLexer(new ANTLRFileStream(args[0]));
        CommonTokenStream tokens = new CommonTokenStream(lex);
 
        CMMParser parser = new CMMParser(tokens);
		parser.prog(); // launch parsing
    }
}
