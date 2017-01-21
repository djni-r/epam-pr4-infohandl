package test.by.malinouski.infohandling.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import by.malinouski.infohandling.composite.TextComponent;
import by.malinouski.infohandling.parser.WordParser;

public class WordParserTest {

    public final static String WORD = "Got1.";
    public static TextComponent word;
    
    @Test
    public void parseTest() {
        WordParser parser = new WordParser();
        TextComponent component = parser.parse(WORD);
        
        assertEquals(component, word);
    }

}
