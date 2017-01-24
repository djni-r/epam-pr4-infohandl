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

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author makarymalinouski
 *
 */
public class Calculator {
    
    private static final Logger LOGGER = LogManager.getLogger();
    
    private static final String BLANK_REGEX = "\\p{Blank}";
    private static final String NUMBER_REGEX = "[\\d\\.]";
    private static final String OPEN_PARENTH_REGEX = "[(]";
    private static final String CLOSE_PARENTH_REGEX = "[)]";
    private static final String OPERATOR_REGEX = "[*/+-]";
    private static final String COS_SIN_REGEX = "[sc]";
    private static final String MULT_DIV_REGEX = "[*/]";
    private static final String ADD_SUBTR_REGEX = "[+-]";


    
    /**
     * Calculates math expression and returns the result
     */
    public Double calculate(String expression) {
        Stack<Double> context = new Stack<>();
        for(MathExpression expr : parseExpr(expression)) {
            expr.interpret(context);
        }
        
        return context.pop();
    }
    
    /**
     * Parses expression to be used as the interpreter pattern
     * @param expression
     * @return List of terminal and nonterminal MathExpressions
     */
    private List<MathExpression> parseExpr(String expression) {
        List<MathExpression> expressionList = new ArrayList<>(); 
        
        String newExpression = expression.replace("sin", "s").replace("cos", "c");
        LOGGER.debug(newExpression);
        for (String symbol : convertToRpn(newExpression).split(BLANK_REGEX)) {
            if (symbol.isEmpty()) {
                continue;
            }
            
            LOGGER.debug(symbol.charAt(0));
            switch (symbol.charAt(0)) {
                case '+':
                    expressionList.add(new TermExpressionAdd());
                    break;
                case '-':
                    expressionList.add(new TermExpressionSubtract());
                    break;
                case '*':
                    expressionList.add(new TermExpressionMultiply());
                    break;
                case '/':
                    expressionList.add(new TermExpressionDivide());
                    break;
                case 's':
                    expressionList.add(new TermExpressionSin());
                    break;
                case 'c':
                    expressionList.add(new TermExpressionCos());
                    break;
                default:
                    Scanner scan = new Scanner(symbol);
                    if (scan.hasNextDouble()) {
                        expressionList.add(new NonTermExpressionNumber(scan.nextDouble()));
                    }
            }
        }
        LOGGER.debug(expressionList);
        return expressionList;
    }
    
    /**
     * Converts normal math expression into a reverse polish notation (RPN) one
     *      2+3*4/(c(2+3)-3*(2.3-3.43)) 
     *      will become
     *      2 3 4 * 2 3 + c 3 2.3 3.43 - * - / +
     * @param expression to be converted
     * @return rpn expression
     */
    private String convertToRpn(String expression) {
        StringBuilder exit = new StringBuilder();
        Stack<String> stack = new Stack<>();
        
        Scanner sc = new Scanner(expression);
        sc.useDelimiter("");
        
        while (sc.hasNext()) {
            if (sc.hasNext(NUMBER_REGEX)) {
                while (sc.hasNext(NUMBER_REGEX)) {   // if it's number, add to exit
                    exit.append(sc.next(NUMBER_REGEX));
                }
                exit.append(" ");
                
            } else if (sc.hasNext(OPEN_PARENTH_REGEX)) {    // if open parenthesis push it to stack
                stack.push(sc.next(OPEN_PARENTH_REGEX));
                
            } else if (sc.hasNext(CLOSE_PARENTH_REGEX)) {   // if close parenth, pop everything 
                String item;                                // from stack to exit until next open parenth
                                                            
                while (!stack.isEmpty() && !(item = stack.pop()).matches(OPEN_PARENTH_REGEX)) {
                    exit.append(item).append(" ");
                }
                if (!stack.isEmpty() && stack.peek().matches(COS_SIN_REGEX)) {
                    exit.append(stack.pop()).append(" ");
                }
                sc.next(CLOSE_PARENTH_REGEX);
                
            } else if (sc.hasNext(COS_SIN_REGEX)) {
                stack.push(sc.next(COS_SIN_REGEX));

            } else if (sc.hasNext(OPERATOR_REGEX)) {    // if it's an operator
                String oper = sc.next(OPERATOR_REGEX);
                
                if (!stack.isEmpty() && isNotSmallerPrecedence(stack.peek(), oper)) {   // if operator on stack's precedence
                    exit.append(stack.pop()).append(" ");                       // is greater, pop it
                }
                
                stack.push(oper);
            }
        }
        
        while (!stack.isEmpty()) {
            exit.append(stack.pop()).append(" ");
        }
        
        return exit.toString();
    }
    
    /**
     * @param op1 first operator
     * @param op2 second operator
     * @return precedence of the first operator is not smaller 
     *         than that of the second one
     */
    private boolean isNotSmallerPrecedence(String op1, String op2) {
        return op1.matches(MULT_DIV_REGEX) || 
                    (op1.matches(ADD_SUBTR_REGEX) && op2.matches(ADD_SUBTR_REGEX));
    }

}
