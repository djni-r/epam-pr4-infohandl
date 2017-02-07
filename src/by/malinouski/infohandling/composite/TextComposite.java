package by.malinouski.infohandling.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextComposite implements TextComponent {
    
    private static final Logger LOGGER = LogManager.getLogger(TextComposite.class);
    private static final String SPACE = " ";
    private static final String DOUBLE_SPACE_REGEX = "\\p{Blank}{2}";
    private static final String TRIPLE_SPACE = "   ";
    private static final String RETURN = "\r\r";

    private List<TextComponent> components;
    private boolean immutable = false;
    
    public TextComposite() {
        components = new ArrayList<TextComponent>();
    }
    
    public List<TextComponent> getComponents() {
        List<TextComponent> compList = Collections.unmodifiableList(components);
        for (TextComponent comp : compList) {
            comp.makeImmutable();
        }
        return compList;
    }
    
    @Override
    public int countComponents() {
        return components.size();
    }

    @Override
    public void add(TextComponent component) {
        if (!immutable) {
            components.add(component);
        }
    }

    @Override
    public void remove(TextComponent component) {
        if (!immutable) {
            components.remove(component);
        }
    }
    
    @Override
    public void makeImmutable() {
        immutable = true;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null || (obj.getClass() != getClass())) {
            return false;
        }
        
        LOGGER.debug(obj + "_");
        LOGGER.debug(this + "_");
        TextComposite text = (TextComposite) obj;
        for (int i = 0; i < components.size(); i++) {
            if (!components.get(i).equals(text.components.get(i))) {
                return false;
            }
        }
        
        return true;
        
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        for (TextComponent c : components) {
            result = 31 * result + c.hashCode();
        }
        
        return result;
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (TextComponent c : components) {
            result.append(c.toString());
        }
        result.append(SPACE);
        
        /*
         *  now after every word there will be one space
         *  after every sentence - two
         *  after every paragraph - three
         *  So we can replace them accordingly
         */
        String resultStr = result.toString();
        if (resultStr.endsWith(TRIPLE_SPACE)) {
            resultStr = resultStr.trim() + RETURN;
            resultStr.replaceAll(DOUBLE_SPACE_REGEX, SPACE);
        } 
        
        return resultStr;
    }
    
}
