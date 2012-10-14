import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
public class CTest {
    public static void main(String args[]) throws Exception {
        CLexer lex = new CLexer(new ANTLRFileStream(args[0]));
        CommonTokenStream tokens = new CommonTokenStream(lex);
 
        CParser parser = new CParser(tokens);
		parser.statement(); // launch parsing
    }
}
