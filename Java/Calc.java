import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Calc {
    public static void main(String[] args) throws Exception {
        EvalVisitor eval = new EvalVisitor();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Calculadora ANTLR4 (escribe 'exit' para salir)");
        System.out.println("Modo actual: GRADOS");
        System.out.println("Comandos: mode=deg | mode=rad");

        while (true) {
            System.out.print("> ");
            String line = reader.readLine();
            if (line == null || line.equalsIgnoreCase("exit")) break;

            if (line.equalsIgnoreCase("mode=deg")) {
                eval.setUseDegrees(true);
                System.out.println("Modo cambiado a GRADOS");
                continue;
            }
            if (line.equalsIgnoreCase("mode=rad")) {
                eval.setUseDegrees(false);
                System.out.println("Modo cambiado a RADIANES");
                continue;
            }

            CharStream input = CharStreams.fromString(line + "\n");
            LabeledExprLexer lexer = new LabeledExprLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            LabeledExprParser parser = new LabeledExprParser(tokens);
            ParseTree tree = parser.stat();
            System.out.println("Árbol sintáctico:");
            System.out.println(tree.toStringTree(parser));
            System.out.println("Resultado:");
            eval.visit(tree);
        }
    }
}
