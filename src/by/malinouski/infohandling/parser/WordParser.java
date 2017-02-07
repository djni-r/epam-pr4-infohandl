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
package by.malinouski.infohandling.parser;

import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.malinouski.infohandling.composite.Letter;
import by.malinouski.infohandling.composite.Numeric;
import by.malinouski.infohandling.composite.Punctuation;
import by.malinouski.infohandling.composite.TextComponent;
import by.malinouski.infohandling.composite.TextComposite;
import by.malinouski.infohandling.interpreter.Calculator;

/**
 * @author makarymalinouski
 *
 */
public class WordParser implements ParserChain {
    
    private static final Logger LOGGER = LogManager.getLogger(WordParser.class);

    private static final String LETTER_REGEX = "\\p{Alpha}";
    private static final String PUNCT_REGEX = "\\p{Punct}";
    private static final String NUMERIC_REGEX = "\\d+(\\.\\d+)?";
    private static final String NON_MATH_END_REGEX = "[^\\d)]";

//            "[(?<num>\\d+(\\.\\d+)?)[((cos|sin)\\(num\\))[(num(\\*|/|+|\\-)num)]]]";
    
    private static final Calculator calc = new Calculator();


    /**
     * Parse word into Letters and Punctuation
     * @see by.malinouski.infohandling.parser.ParserChain#parse(java.lang.String)
     */
    @Override
    public TextComponent parse(String text) {
        
        TextComposite fullWord = new TextComposite();
        
        // if it's math expression
        if (Pattern.compile(NUMERIC_REGEX).matcher(text).find()) {
            // if math expression ends with non math punctuation (. or , etc)
            String endSymb = text.substring(text.length() - 1, text.length());
            boolean isLast = false;
            
            if ((isLast = endSymb.matches(NON_MATH_END_REGEX))) {
                text = text.substring(0, text.length() - 1);
            }
            // perform calculation of the math expression
            for (Character ch : calc.calculate(text).toCharArray()) {
                fullWord.add(new Numeric(ch));
            }
            
            if (isLast) {
                fullWord.add(new Punctuation(endSymb.charAt(0)));
            }
            
        } else { 
            for (char ch : text.toCharArray()) {
                if (String.valueOf(ch).matches(LETTER_REGEX)) {
                    fullWord.add(new Letter(ch));
                } else if (String.valueOf(ch).matches(PUNCT_REGEX)) {
                    fullWord.add(new Punctuation(ch));
                }
            }
        }
        return fullWord;
    }

}
