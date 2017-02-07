package test.by.malinouski.infohandling.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import by.malinouski.infohandling.composite.Letter;
import by.malinouski.infohandling.composite.Numeric;
import by.malinouski.infohandling.composite.Punctuation;
import by.malinouski.infohandling.composite.TextComponent;
import by.malinouski.infohandling.composite.TextComposite;
import by.malinouski.infohandling.parser.ParagraphParser;
import by.malinouski.infohandling.parser.WordParser;

public class WordParserTest {

    private static final String SIMPLE_WORD = "s";
    public final static String WORD = "Got.";
    public static final String MATH_EXPR = "(2+3.4)/sin(4)"; // -7
    private static WordParser parser;
    
    
    @BeforeClass
    public static void initParser() {
        parser = new WordParser();
    }
    
    @Test
    public void parserTestSimple() {
        
        Letter letter = new Letter('s');

        TextComposite text = new TextComposite();
        text.add(letter);
        
        assertEquals(text, parser.parse(SIMPLE_WORD));
    }
    
    @Test
    public void parseTest() {
        Letter capG = new Letter('G');
        Letter o = new Letter('o');
        Letter t = new Letter('t');
        Punctuation dot = new Punctuation('.');
        
        TextComposite text = new TextComposite();
        
        text.add(capG);
        text.add(o);
        text.add(t);
        text.add(dot);
        
        assertEquals(text, parser.parse(WORD));
    }
    
    @Test
    public void parseTestMathExpr() {
        TextComposite num = new TextComposite();
        Numeric m = new Numeric('-'); 
        Numeric n = new Numeric('7'); 
        num.add(m);
        num.add(n);
        
        assertEquals(num, parser.parse(MATH_EXPR));
    }

}
