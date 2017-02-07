package test.by.malinouski.infohandling.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import by.malinouski.infohandling.composite.Letter;
import by.malinouski.infohandling.composite.Numeric;
import by.malinouski.infohandling.composite.Punctuation;
import by.malinouski.infohandling.composite.TextComponent;
import by.malinouski.infohandling.composite.TextComposite;
import by.malinouski.infohandling.parser.TextParser;
import by.malinouski.infohandling.reader.TextReader;

public class TextParserTest {

    private static final String SIMPLE_TEXT = "K.";
    private static final String TABBED_TEXT = "I is.\rI. I is (2+3.4)/sin(4)."; // -7
    private static TextParser parser;
    
    
    @BeforeClass
    public static void initParser() {
        parser = new TextParser();
    }
    
    @Test
    public void parseTestSimple() {
        Letter letter = new Letter('K');
        Punctuation dot = new Punctuation('.');

        TextComposite word = new TextComposite();
        word.add(letter);
        word.add(dot);
        
        TextComposite sent = new TextComposite();
        sent.add(word);
        
        TextComposite par = new TextComposite();
        par.add(sent);
        
        TextComposite text = new TextComposite();
        text.add(par);
        
        assertEquals(text, parser.parse(SIMPLE_TEXT));
    }
    
    @Test
    public void parseTestHasTab() {
        Letter capI = new Letter('I');
        Letter i = new Letter('i');
        Letter s = new Letter('s');
        Punctuation dot = new Punctuation('.');
        Numeric minus = new Numeric('-');
        Numeric seven = new Numeric('7');
        
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
        
        // is
        TextComposite wordIs = new TextComposite();
        wordIs.add(i);
        wordIs.add(s);
        
        // -7
        TextComposite wordMinusSevenDot = new TextComposite();
        wordMinusSevenDot.add(minus);
        wordMinusSevenDot.add(seven);
        wordMinusSevenDot.add(dot);
        
        // I is.
        TextComposite firstSentence = new TextComposite();
        firstSentence.add(wordCapI);
        firstSentence.add(wordIsDot);
        
        // I.
        TextComposite secondSentence = new TextComposite();
        secondSentence.add(wordCapIDot);
        
        // I is -7.
        TextComposite thirdSentence = new TextComposite();
        thirdSentence.add(wordCapI);
        thirdSentence.add(wordIs);
        thirdSentence.add(wordMinusSevenDot);

        TextComposite firstParagraph = new TextComposite();
        firstParagraph.add(firstSentence);
        
        TextComposite secondParagraph = new TextComposite();
        secondParagraph.add(secondSentence);
        secondParagraph.add(thirdSentence);
        
        TextComposite fullText = new TextComposite();
        fullText.add(firstParagraph);
        fullText.add(secondParagraph);
        
        System.out.println(fullText);
        assertEquals(fullText, parser.parse(TABBED_TEXT));
    }
    
    @Test
    public void parseTestFromFile() {
        TextReader reader = new TextReader();
        System.out.println(parser.parse(reader.read("files/file.txt")));
    }

}
