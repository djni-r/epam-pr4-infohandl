package test.by.malinouski.infohandling.functionality;

import static org.junit.Assert.*;

import org.junit.Test;

import by.malinouski.infohandling.composite.Letter;
import by.malinouski.infohandling.composite.Numeric;
import by.malinouski.infohandling.composite.Punctuation;
import by.malinouski.infohandling.composite.TextComposite;
import by.malinouski.infohandling.functionality.TextPrinter;

public class TextPrinterTest {

    /*
     * Not a JUnit test --- no asserts
     */
    @Test
    public void printWordsByAlphabetTest() {
        TextPrinter printer = new TextPrinter();
        
        Letter capA = new Letter('A');
        Letter a = new Letter('a');
        Letter b = new Letter('b');
        Letter d = new Letter('d');
        Letter capG = new Letter('G');
        Letter p = new Letter('p');
        Punctuation dot = new Punctuation('.');
        
        // A
        TextComposite wordCapA = new TextComposite();
        wordCapA.add(capA);
        
        // ba
        TextComposite wordBa = new TextComposite();
        wordBa.add(b);
        wordBa.add(a);
        
        // b.
        TextComposite wordBDot = new TextComposite();
        wordBDot.add(b);
        wordBDot.add(dot);
        
        // d.
        TextComposite wordDDot = new TextComposite();
        wordDDot.add(d);
        wordDDot.add(dot);
        
        // Ga
        TextComposite wordGa = new TextComposite();
        wordGa.add(capG);
        wordGa.add(a);
        
        // Gp.
        TextComposite wordGpDot = new TextComposite();
        wordGpDot.add(capG);
        wordGpDot.add(p);
        wordGpDot.add(dot);
        
        
        // A ba d.
        TextComposite firstSentence = new TextComposite();
        firstSentence.add(wordCapA);
        firstSentence.add(wordBa);
        firstSentence.add(wordDDot);

        // Gp.
        TextComposite secondSentence = new TextComposite();
        secondSentence.add(wordGpDot);
        
        // Ga b.
        TextComposite thirdSentence = new TextComposite();
        thirdSentence.add(wordGa);
        thirdSentence.add(wordBDot);

        TextComposite firstParagraph = new TextComposite();
        firstParagraph.add(firstSentence);
        
        TextComposite secondParagraph = new TextComposite();
        secondParagraph.add(secondSentence);
        secondParagraph.add(firstSentence);
        secondParagraph.add(thirdSentence);
        
        TextComposite fullText = new TextComposite();
        fullText.add(firstParagraph);
        fullText.add(secondParagraph);
        
        printer.printWordsByAlphabet(fullText);
    }

}
