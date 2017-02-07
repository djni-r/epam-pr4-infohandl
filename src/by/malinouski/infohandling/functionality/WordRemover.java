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
package by.malinouski.infohandling.functionality;

import java.util.List;

import by.malinouski.infohandling.composite.Letter;
import by.malinouski.infohandling.composite.TextComponent;
import by.malinouski.infohandling.composite.TextComposite;

/**
 * @author makarymalinouski
 *
 */
public class WordRemover {

    /**
     * Remove words that start with certain char and of certain length
     * !! unfortunately, it's very slow
     * @param text  the entire text, 
     *        ch    char that word starts with, 
     *        len   length
     * @return new TextComponent with removed words
     */
    public TextComponent removeWordsStartWithAndOfLen(TextComponent text, char ch, int len) {
        Letter letter = new Letter(ch);
        TextComponent newText = new TextComposite();

        for (TextComponent paragraph : text.getComponents()) {
            TextComponent newParagraph = new TextComposite();

            for (TextComponent sentence : paragraph.getComponents()) {
                TextComponent newSentence = new TextComposite();

                for (TextComponent word : sentence.getComponents()) {
                    List<TextComponent> components = word.getComponents();
                    
                    if (components.size() == len && !components.isEmpty() 
                            && components.get(0).equals(letter)) {
                        continue;
                    }
                    
                    TextComponent newWord = new TextComposite();
                    for (TextComponent c : components) {
                        newWord.add(c);
                    }
                    newSentence.add(newWord);
                }
                newParagraph.add(newSentence);
            }
            newText.add(newParagraph);
        }
        
        return newText;
    }

}
