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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.malinouski.infohandling.composite.TextComponent;
import by.malinouski.infohandling.composite.TextComposite;

/**
 * @author makarymalinouski
 *
 */
public class ParagraphParser implements ParserChain {

    private final static String SENTENCE_REGEX = "[\\p{Alnum}\\p{Upper}](\\w| )*[.]";
    
    /**
     * Parses paragraphs into sentences and words
     * @see by.malinouski.infohandling.parser.ParserChain#parse(java.lang.String)
     */
    @Override
    public TextComponent parse(String text) {
        SentenceParser sParser = new SentenceParser();
        TextComposite fullParagraph = new TextComposite();
        Matcher matcher = Pattern.compile(SENTENCE_REGEX).matcher(text);
        
        while (matcher.find()) {
            fullParagraph.add(sParser.parse(matcher.group()));
        }
        
        return fullParagraph;
    }

}
