package test.by.malinouski.infohandling.interpreter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import by.malinouski.infohandling.interpreter.Calculator;

public class CalculatorTest {

    public static final String SINGLE_EXPR = "1";
    public static final String SIMPLE_EXPR = "2*4"; // 2 4 *
    public static final String SIN_EXPR = "sin(1)"; // 1 s
    public static final String FULL_EXPR = "2+3*4/(cos(2+3)-3*(2.3-3.43))"; // 2 3 4 * 2 3 + c 3 2.3 3.43 - * - / + 
    public static final Double SINGLE_EXPR_RESULT = new Double(1);
    public static final Double SIMPLE_EXPR_RESULT = new Double(8);
    public static final Double SIN_EXPR_RESULT = new Double(0.841);
    public static final Double FULL_EXPR_RESULT = new Double(5.266);
    public static Calculator calc = new Calculator();
    
    @Test
    public void calculateTestSingle() {
        assertEquals(SINGLE_EXPR_RESULT, calc.calculate(SINGLE_EXPR));
    }
    
    @Test
    public void calculateTestSimple() {
        assertEquals(SIMPLE_EXPR_RESULT, calc.calculate(SIMPLE_EXPR));
    }
    
    @Test
    public void calculateTestSin() {
        assertEquals(SIN_EXPR_RESULT, calc.calculate(SIN_EXPR), 0.001);
    }
    
    @Test
    public void calcualateTestFull() {
        assertEquals(FULL_EXPR_RESULT.doubleValue(), calc.calculate(FULL_EXPR), 0.001);
    }

}
