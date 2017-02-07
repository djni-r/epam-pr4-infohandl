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

import by.malinouski.infohandling.composite.TextComponent;
import by.malinouski.infohandling.composite.TextComposite;

/**
 * @author makarymalinouski
 *
 */
public class SentenceParser implements ParserChain {

    private static final Logger LOGGER = LogManager.getLogger(SentenceParser.class);
    private static final String WORD_BREAK_REGEX = "\\p{Blank}";
    private static final WordParser wParser = new WordParser();

    /**
     * Parses sentences into words
     * @see by.malinouski.infohandling.parser.ParserChain#parse(java.lang.String)
     */
    @Override
    public TextComponent parse(String text) {
        TextComposite fullSentence = new TextComposite();
        
        for (String word : text.split(WORD_BREAK_REGEX)) {
            LOGGER.debug("WORD");
            fullSentence.add(wParser.parse(word));
        }
        
        return fullSentence;
    }

}
