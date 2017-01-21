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
    /**
     * 
     */
    public Punctuation(Character ch) {
        character = ch;
    }

    /* (non-Javadoc)
     * @see by.malinouski.infohandling.composite.TextComponent#add(by.malinouski.infohandling.composite.TextComponent)
     */
    @Override
    public void add(TextComponent component) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see by.malinouski.infohandling.composite.TextComponent#remove()
     */
    @Override
    public TextComponent remove() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see by.malinouski.infohandling.composite.TextComponent#count()
     */
    @Override
    public int count() {
        // TODO Auto-generated method stub
        return 0;
    }

}
