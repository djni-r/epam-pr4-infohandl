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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.malinouski.infohandling.composite.Letter;
import by.malinouski.infohandling.composite.Punctuation;
import by.malinouski.infohandling.composite.TextComponent;
import by.malinouski.infohandling.composite.TextComposite;

/**
 * @author makarymalinouski
 *
 */
public class WordParser implements ParserChain {
    
    private static final Logger LOGGER = LogManager.getLogger(WordParser.class);
    private static final String LETTER_REGEX = "\\p{Alpha}";
    private static final String PUNCT_REGEX = "\\p{Punct}";

    /**
     * Parse word into Letters and Punctuation
     * @see by.malinouski.infohandling.parser.ParserChain#parse(java.lang.String)
     */
    @Override
    public TextComponent parse(String text) {
        
        TextComposite fullWord = new TextComposite();
        
        for (char ch : text.toCharArray()) {
            LOGGER.debug(ch + "_");
            if (String.valueOf(ch).matches(LETTER_REGEX)) {
                fullWord.add(new Letter(ch));
            } else if (String.valueOf(ch).matches(PUNCT_REGEX)) {
                fullWord.add(new Punctuation(ch));
            }
        }
        LOGGER.debug(fullWord + "_");
        return fullWord;
    }

}
