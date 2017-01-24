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
import by.malinouski.infohandling.parser.WordParser;

public class WordParserTest {

    public final static String WORD = "Got.";
    private static final String SIMPLE_WORD = "S.";
    public static TextComponent word;
    private static TextComponent simpleWord;
    private WordParser parser;
    
    @BeforeClass
    public static void createSimpleComponent() {
        Letter letter = new Letter('S');
        Punctuation dot = new Punctuation('.');

        TextComposite text = new TextComposite();
        text.add(letter);
        text.add(dot);
        simpleWord = text;
    }
    
    @Before
    public void initParser() {
        parser = new WordParser();
    }
    
    @Test
    public void parserTestSimple() {
        TextComponent parsedWord = parser.parse(SIMPLE_WORD);
        
        assertEquals(simpleWord, parsedWord);
    }
    
    @Test
    public void parseTest() {
        word = new TextComposite();
        Letter capG = new Letter('G');
        Letter o = new Letter('o');
        Letter t = new Letter('t');
        Punctuation dot = new Punctuation('.');
        
        word.add(capG);
        word.add(o);
        word.add(t);
        word.add(dot);
        
        WordParser parser = new WordParser();
        TextComponent component = parser.parse(WORD);
        
        assertEquals(component, word);
    }

}
