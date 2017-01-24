package test.by.malinouski.infohandling.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import by.malinouski.infohandling.composite.Letter;
import by.malinouski.infohandling.composite.Punctuation;
import by.malinouski.infohandling.composite.TextComponent;
import by.malinouski.infohandling.composite.TextComposite;
import by.malinouski.infohandling.parser.ParagraphParser;

public class ParagraphParserTest {

    private static final String PARAGRAPH = "I is. I.";
    private static final String SIMPLE_TEXT = "S.";
    private static TextComponent simpleText;
    private ParagraphParser parser;


    @BeforeClass
    public static void createSimpleComponent() {
        Letter letter = new Letter('S');
        TextComposite text = new TextComposite();
        text.add(letter);
        simpleText = text;
    }
    
    @Before
    public void initParser() {
        parser = new ParagraphParser();
    }
    
    @Test
    public void parserTestSimple() {
        TextComponent text = parser.parse(SIMPLE_TEXT);
        
        assertEquals(text, simpleText);
    }
    
    @Test
    public void parserTest() {
        Letter capI = new Letter('I');
        Letter i = new Letter('i');
        Letter s = new Letter('s');
        Punctuation dot = new Punctuation('.');
        
        // I
        TextComposite wordCapI = new TextComposite();
        wordCapI.add(capI);
        
        // is.
        TextComposite wordIsDot = new TextComposite();
        wordIsDot.add(i);
        wordIsDot.add(s);
        wordIsDot.add(dot);
        
        // I.
        TextComposite wordCapIDot = new TextComposite();
        wordCapIDot.add(capI);
        wordCapIDot.add(dot);
        
        // I is.
        TextComposite firstSentence = new TextComposite();
        firstSentence.add(wordCapI);
        firstSentence.add(wordIsDot);
        
        // I.
        TextComposite secondSentence = new TextComposite();
        secondSentence.add(wordCapIDot);
        
        TextComposite paragraph = new TextComposite();
        paragraph.add(firstSentence);
        paragraph.add(secondSentence);
        
        assertEquals(paragraph, parser.parse(PARAGRAPH));
        
    }

}
