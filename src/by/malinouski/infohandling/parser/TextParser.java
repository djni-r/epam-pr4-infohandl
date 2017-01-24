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

import by.malinouski.infohandling.composite.TextComponent;
import by.malinouski.infohandling.composite.TextComposite;

/**
 * @author makarymalinouski
 * 
 * Class for parsing text String into a Composite Object
 */
public class TextParser implements ParserChain {

    private static final String PARAGRAPH_REGEX = "\\r";

    /**
     * Parses text String into an object of type Component
     * broken into paragraphs, sentences, words and letters or punctuation
     */
    public TextComponent parse(String text) {
        ParagraphParser pParser = new ParagraphParser();
        TextComposite fullText = new TextComposite();
        
        for (String paragraph : text.split(PARAGRAPH_REGEX)) {
            fullText.add(pParser.parse(paragraph));
        }
        
        return fullText;
    }
}
