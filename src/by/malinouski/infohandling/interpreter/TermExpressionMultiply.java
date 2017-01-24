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
 */
public class TermExpressionMultiply extends MathExpression {

    /* (non-Javadoc)
     * @see by.malinouski.infohandling.interpreter.MathExpression#interpret(java.util.Stack)
     */
    @Override
    public void interpret(Stack<Double> context) {
        context.push(context.pop() * context.pop());
    }

}
