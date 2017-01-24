/**
 * Makary Malinouski
 *
 * EPAM 
 * Java Web Development
 * Task 4 
 * Information Handling
 *
 * An application that parses text
 * and allows three different operations on it

 */
package by.malinouski.infohandling.interpreter;

import java.util.Stack;


/**
 * @author makarymalinouski
 * 
 * Class for interpreting mathematica expressions
 */
public abstract class MathExpression {

    /**
     * Calculates mathematical expression and returns result as String
     */
    public abstract void interpret(Stack<Double> context);
}
