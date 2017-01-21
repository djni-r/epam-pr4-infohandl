package test.by.malinouski.infohandling.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import by.malinouski.infohandling.composite.Letter;
import by.malinouski.infohandling.composite.Punctuation;
import by.malinouski.infohandling.composite.TextComponent;
import by.malinouski.infohandling.composite.TextComposite;
import by.malinouski.infohandling.parser.TextParser;

public class TextParserTest {

    private static final String SIMPLE_TEXT = "S";
    private static final String TABBED_TEXT = "I is.\tI. I is.";
    private static TextComponent simpleText;
    private static TextComponent tabbedText;
    private TextParser parser;
    
    @BeforeClass
    public void createSimpleComponent() {
        Letter letter = new Letter('S');
        TextComposite text = new TextComposite();
        text.add(letter);
        simpleText = text;
    }
    
    @BeforeClass
    public void createTabbedComponent() {
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
        
        TextComposite firstParagraph = new TextComposite();
        firstParagraph.add(firstSentence);
        
        TextComposite secondParagraph = new TextComposite();
        secondParagraph.add(secondSentence);
        secondParagraph.add(firstSentence);
        
        TextComposite fullText = new TextComposite();
        fullText.add(firstParagraph);
        fullText.add(secondParagraph);
        
        tabbedText = fullText;
    }
    
    @Before
    public void initParser() {
        parser = new TextParser();
    }
    
    @Test
    public void parseTestSimple() {
        TextComponent text = parser.parse(SIMPLE_TEXT);
        
        assertEquals(text, simpleText);
    }
    
    @Test
    public void parseTestHasTab() {
        TextComponent text = parser.parse(TABBED_TEXT);
        
        assertEquals(text, tabbedText);
    }

}
