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

    /**
     * 
     */
    public Letter(Character ch) {
        this.character = ch;
    }

    /* (non-Javadoc)
     * @see by.malinouski.infohandling.composite.Component#count()
     */
    @Override
    public int count() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void add(TextComponent component) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public TextComponent remove() {
        // TODO Auto-generated method stub
        return null;
    }

}
