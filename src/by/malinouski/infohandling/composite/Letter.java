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
public class Letter implements TextComponent {

    private Character character;

    public Letter(Character ch) {
        this.character = ch;
    }

    @Override
    public int count() {
        return 1;
    }

    @Override
    public void add(TextComponent component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(TextComponent component) {
        throw new UnsupportedOperationException();
    }
    
    public Character getCharacter() {
        return character;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Letter)) {
            return false;
        }
        
        return character.equals(((Letter) obj).character);
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
