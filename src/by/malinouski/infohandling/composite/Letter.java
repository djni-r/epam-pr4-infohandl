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

import java.util.List;

/**
 * @author makarymalinouski
 *
 */
public class Letter implements TextComponent {

    private Character character;

    public Letter(Character ch) {
        this.character = ch;
    }
    
    public Character getCharacter() {
        return character;
    }

    @Override
    public int countComponents() {
        return 1;
    }

    @Override
    public void add(TextComponent component) {
        throw new UnsupportedOperationException("Cannot add components");
    }

    @Override
    public void remove(TextComponent component) {
        throw new UnsupportedOperationException("Cannot remove components");
    }
    
    @Override
    public List<TextComponent> getComponents() {
        throw new UnsupportedOperationException("Cannot remove component");
    }

    @Override
    public void makeImmutable() {
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj == null || (obj.getClass() != getClass())) {
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
