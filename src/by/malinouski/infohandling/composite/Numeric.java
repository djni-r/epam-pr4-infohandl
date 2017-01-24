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
public class Numeric implements TextComponent {

    private final Character character;

    public Numeric(Character ch) {
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

}
