package by.malinouski.infohandling.composite;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextComposite implements TextComponent {
    
    private static final Logger LOGGER = LogManager.getLogger(TextComposite.class);
    private List<TextComponent> components;
    
    public TextComposite() {
        components = new ArrayList<TextComponent>();
    }
    
    @Override
    public int count() {
        return 0;
    }

    @Override
    public void add(TextComponent component) {
        components.add(component);
    }

    @Override
    public void remove(TextComponent component) {
        components.remove(component);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof TextComposite)) {
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
        
        return result.toString();
    }
    
}
