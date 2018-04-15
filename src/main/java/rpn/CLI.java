package rpn;

import rpn.operation.*;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CLI {
    public static final void main(String[] args) {
        String expression = Stream.of(args).collect(Collectors.joining(" "));

        System.out.println("About to evaluate '" + expression + "'");
        double result = evaluate(expression);
        System.out.println("> " + result);
    }

    static double evaluate(String expression) {
        Map<String, IOperation> dico = new HashMap<>();
        dico.put("+", new PlusOperation());
        dico.put("-", new MinusOperation());
        dico.put("*", new StarOperation());
        dico.put("/", new SlashOperation());

        ICalculStyle poloneseCalculStyle = new PoloneseCalculStyle(dico, new SingleSpaceTokeniser());
        return poloneseCalculStyle.Calculate(expression);
    }
}
