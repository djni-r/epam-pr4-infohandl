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

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

import by.malinouski.infohandling.composite.TextComponent;

/**
 * @author makarymalinouski
 *
 */
public class SentenceSorter {

    /**
     * Sort sentences by the amount of words in them
     * @param text the entire thext
     * @return list of sentences
     */
    public SortedSet<TextComponent> sortByWordCount(TextComponent text) {
        SortedSet<TextComponent> sentencesSet = new TreeSet<>(
                new Comparator<TextComponent>() {
                    @Override
                    public int compare(TextComponent o1, TextComponent o2) {
                        return o1.countComponents() - o2.countComponents();
                    }
                }); 
        
        for (TextComponent paragraph : text.getComponents()) {
            for (TextComponent sentence : paragraph.getComponents()) {
                sentencesSet.add(sentence);
            }
        }
        
        return sentencesSet;
    }
}
