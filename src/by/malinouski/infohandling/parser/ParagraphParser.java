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

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.malinouski.infohandling.composite.TextComponent;
import by.malinouski.infohandling.composite.TextComposite;

/**
 * @author makarymalinouski
 *
 */
public class ParagraphParser implements ParserChain {

    private static final Logger LOGGER = LogManager.getLogger(TextParser.class);
    private static final String SENTENCE_REGEX = "\\p{Upper}([.&&[^\\.!\\?]])*\\.\\p{Blank}";//"([\\p{Upper}]|\\p{Alnum})([\\p{Alnum}\\p{Punct}[^\\.!?]])*[\\.!\\?]\\p{Blank}";
    private static final SentenceParser sParser = new SentenceParser();

    /**
     * Parses paragraphs into sentences and words
     * @see by.malinouski.infohandling.parser.ParserChain#parse(java.lang.String)
     */
    @Override
    public TextComponent parse(String text) {
        TextComposite fullParagraph = new TextComposite();
        Matcher matcher = Pattern.compile(SENTENCE_REGEX).matcher(text);
        Scanner scan = new Scanner(text);
        
        while (scan.hasNext(SENTENCE_REGEX)) {
            LOGGER.debug("SENTENCE");
            fullParagraph.add(sParser.parse(scan.next(SENTENCE_REGEX)));
        }
        
        return fullParagraph;
    }

}
