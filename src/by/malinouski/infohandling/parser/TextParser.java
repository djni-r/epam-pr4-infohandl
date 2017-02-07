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

import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.malinouski.infohandling.composite.TextComponent;
import by.malinouski.infohandling.composite.TextComposite;

/**
 * @author makarymalinouski
 * 
 * Class for parsing text String into a Composite Object
 */
public class TextParser implements ParserChain {

    private static final Logger LOGGER = LogManager.getLogger(TextParser.class);
    private static final String PARAGRAPH_REGEX = "\r";
    private static final ParagraphParser pParser = new ParagraphParser();

    /**
     * Parses text String into an object of type Component
     * broken into paragraphs, sentences, words and letters or punctuation
     */
    public TextComponent parse(String text) {
        TextComposite fullText = new TextComposite();
        
        for (String paragraph : text.split(PARAGRAPH_REGEX)) {
            LOGGER.debug("PARAGRAPH");
            fullText.add(pParser.parse(paragraph));
        }
        
        return fullText;
    }
}
