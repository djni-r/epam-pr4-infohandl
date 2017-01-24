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
package by.malinouski.infohandling.composite;

/**
 * @author makarymalinouski
 *
 */
public class Punctuation implements TextComponent {

    private Character character;
    
    public Punctuation(Character ch) {
        character = ch;
    }

    @Override
    public void add(TextComponent component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(TextComponent component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int count() {
        return 1;
    }
    
    public Character getCharacter() {
        return character;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Punctuation)) {
            return false;
        }
        
        return character.equals(((Punctuation) obj).character);
    }
    
    @Override
    public int hashCode() {
        return 17 * 31 + (int) character;
    }
    
    @Override
    public String toString() {
        return character.toString();
    }

}
