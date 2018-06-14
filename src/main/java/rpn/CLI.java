package rpn;

import rpn.events.EventDispatcher;
import rpn.events.InputEvent;
import rpn.events.OnEvent;
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
        EventDispatcher dispatcher = new EventDispatcher();

        System.out.println("About to evaluate '" + expression + "'");
        try
        {
            evaluate(dispatcher, expression);
        }
        catch (ArithmeticException e)
        {
            System.out.println("We don't know how to do this :s");
        }
        catch(Exception e)
        {
            System.out.println("> You can't do this");
        }
    }

    static void evaluate(EventDispatcher dispatcher, String expression) {

        SingleSpaceTokeniser tokeniser = new SingleSpaceTokeniser(dispatcher);
        dispatcher.registerChannel(tokeniser);

        PoloneseCalculStyle poloneseCalculStyle = new PoloneseCalculStyle(dispatcher);
        dispatcher.registerChannel(poloneseCalculStyle);

        Map<String, IOperation> dico = new HashMap<>();
        dico.put("+", new PlusOperation());
        dico.put("-", new MinusOperation());
        dico.put("*", new StarOperation());
        dico.put("/", new SlashOperation());
        Orchestrator orchestrator = new Orchestrator(dispatcher, dico);
        dispatcher.registerChannel(orchestrator);

        dispatcher.registerChannel(new WriteConsole());

        dispatcher.dispatch(new InputEvent(expression));
    }
}
