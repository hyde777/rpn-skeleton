package rpn;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static rpn.CLI.evaluate;

public class CLITest {

    @Test
    public void should_evaluate_single_digit_constant() {
        assertThat(evaluate("5")).isEqualTo(5d);
    }

    @Test
    public void should_evaluate_multiple_digits_constant() {
        assertThat(evaluate("17")).isEqualTo(17);
    }

    @Test
    public void should_evaluate_simple_addition() {
        assertThat(evaluate("17 5 +")).isEqualTo(22);
    }

    @Test
    public void should_evaluate_more_complex_addition() {
        assertThat(evaluate("2 3 5 + +")).isEqualTo(10);
    }

    @Test
    public void should_evaluate_simple_soustraction() {
        assertThat(evaluate("17 5 -")).isEqualTo(12);
    }

    @Test
    public void should_evaluate_more_complex_soustraction() {
        assertThat(evaluate("2 12 5 - -")).isEqualTo(-5);
    }

    @Test
    public void should_evaluate_simple_division() {
        assertThat(evaluate("17 5 /")).isEqualTo(3.4);
    }

    @Test
    public void should_throw_excetion_when_divisible_by_zero_() {
        assertThatExceptionOfType(ArithmeticException.class).isThrownBy(() -> evaluate("12 0 /"));
    }

    @Test
    public void should_evaluate_more_complex_division() {
        assertThat(evaluate("2 20 10 / /")).isEqualTo(1);
    }

    @Test
    public void should_evaluate_simple_multiplication() {
        assertThat(evaluate("10 5 *")).isEqualTo(50);
    }

    @Test
    public void should_evaluate_more_complex_multiplication() {
        assertThat(evaluate("2 3 5 * *")).isEqualTo(30);
    }

    @Test
    public void should_evaluate_multiplication_then_addition() {
        assertThat(evaluate("2 4 5 * +")).isEqualTo(22);
    }

    @Test
    public void should_evaluate_addition_then_soustraction()
    {
        assertThat(evaluate("4 2 + 3 - ")).isEqualTo(3);
    }
}