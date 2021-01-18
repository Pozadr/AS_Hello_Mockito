package pl.pozadr.hellomockito.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.pozadr.hellomockito.model.Calculator;

public class CalculatorTests {

    @Test
    public void should_add_two_numbers() {
        Calculator calculator = new Calculator();
        Assertions.assertEquals(calculator.add(10, 15), 25);
        Assertions.assertEquals(calculator.add(0, 15), 15);
        Assertions.assertEquals(calculator.add(-10, 15), 5);
        Assertions.assertEquals(calculator.add(-10, -10), -20);
    }

    @Test
    public void should_not_add_two_numbers() {
        Calculator calculator = new Calculator();
        Assertions.assertNotEquals(calculator.add(0, 15), 0);
        Assertions.assertNotEquals(calculator.add(0, -15), 15);
        Assertions.assertNotEquals(calculator.add(-15, 15), 30);
        Assertions.assertNotEquals(calculator.add(0, 0), 1);
    }

    @Test
    public void should_divide_two_numbers() {
        Calculator calculator = new Calculator();
        Assertions.assertEquals(calculator.divide(10, 5), 2);
        Assertions.assertEquals(calculator.divide(100, 5), 20);
        Assertions.assertEquals(calculator.divide(-20, 5), -4);
        Assertions.assertEquals(calculator.divide(20, -5), -4);
    }

    @Test
    public void should_throw_exception_divide_two_numbers() {
        Calculator calculator = new Calculator();
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.divide(2,0));
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.divide(-50,0));
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.divide(0,0));
    }

}
