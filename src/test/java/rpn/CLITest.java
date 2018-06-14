package rpn;

import org.junit.Test;
import rpn.events.EventDispatcher;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static rpn.CLI.evaluate;

public class CLITest {

    @Test
    public void should_evaluate_single_digit_constant() {
        EventDispatcher dispatcher = new EventDispatcher();
        dispatcher.registerChannel(new TestResult(5));
        evaluate(dispatcher, "5");
    }

    @Test
    public void should_evaluate_multiple_digits_constant() {
        EventDispatcher dispatcher = new EventDispatcher();
        dispatcher.registerChannel(new TestResult(17));
        evaluate(dispatcher, "17");
    }

    @Test
    public void should_evaluate_simple_addition() {
        EventDispatcher dispatcher = new EventDispatcher();
        dispatcher.registerChannel(new TestResult(22));
        evaluate(dispatcher, "17 5 +");
    }

    @Test
    public void should_evaluate_more_complex_addition() {
        EventDispatcher dispatcher = new EventDispatcher();
        dispatcher.registerChannel(new TestResult(10));
        evaluate(dispatcher, "2 3 5 + +");
    }

    @Test
    public void should_evaluate_simple_soustraction() {

        EventDispatcher dispatcher = new EventDispatcher();
        dispatcher.registerChannel(new TestResult(12));
        evaluate(dispatcher, "17 5 -");
    }

    @Test
    public void should_evaluate_more_complex_soustraction() {
        EventDispatcher dispatcher = new EventDispatcher();
        dispatcher.registerChannel(new TestResult(-5));
        evaluate(dispatcher, "2 12 5 - -");
    }

    @Test
    public void should_evaluate_simple_division() {
        EventDispatcher dispatcher = new EventDispatcher();
        dispatcher.registerChannel(new TestResult(3.4));
        evaluate(dispatcher, "17 5 /");
    }

    /*@Test
    public void should_throw_excetion_when_divisible_by_zero_() {

        assertThatExceptionOfType(ArithmeticException.class).isThrownBy(() -> evaluate("12 0 /"));
    }*/

    @Test
    public void should_evaluate_more_complex_division() {
        EventDispatcher dispatcher = new EventDispatcher();
        dispatcher.registerChannel(new TestResult(1));
        evaluate(dispatcher, "2 20 10 / /");
    }

    @Test
    public void should_evaluate_simple_multiplication() {
        EventDispatcher dispatcher = new EventDispatcher();
        dispatcher.registerChannel(new TestResult(50));
        evaluate(dispatcher, "10 5 *");
    }

    @Test
    public void should_evaluate_more_complex_multiplication() {
        EventDispatcher dispatcher = new EventDispatcher();
        dispatcher.registerChannel(new TestResult(30));
        evaluate(dispatcher, "2 3 5 * *");
    }

    @Test
    public void should_evaluate_multiplication_then_addition() {
        EventDispatcher dispatcher = new EventDispatcher();
        dispatcher.registerChannel(new TestResult(22));
        evaluate(dispatcher, "2 4 5 * +");
    }

    @Test
    public void should_evaluate_addition_then_soustraction()
    {
        EventDispatcher dispatcher = new EventDispatcher();
        dispatcher.registerChannel(new TestResult(3));
        evaluate(dispatcher, "4 2 + 3 - ");
    }
}