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

import java.util.SortedMap;
import java.util.TreeMap;

import by.malinouski.infohandling.composite.TextComponent;

/**
 * @author makarymalinouski
 *
 */
public class TextPrinter {

    /**
     * Prints words by alphabet (first letter of the word)
     * Each new letter starts from new line
     *    example:
     *      apple anthem art
     *      beta beer bird
     *      down dry dust
     * @param text the entire text
     */
    public void printWordsByAlphabet(TextComponent text) {
        SortedMap<Character, String> wordsMap = new TreeMap<>();
        
        for (TextComponent paragraph : text.getComponents()) {
            for (TextComponent sentence : paragraph.getComponents()) {
                for (TextComponent word : sentence.getComponents()) {
                    String wordStr = word.toString() + " ";
                    Character key = Character.toLowerCase(wordStr.charAt(0));
                    
                    wordsMap.merge(key, wordStr, String::concat);
                }
            }
        }
        
        for (String words : wordsMap.values()) {
            System.out.println(words);
        }
    }

}
