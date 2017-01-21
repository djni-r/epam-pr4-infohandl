package by.malinouski.infohandling.composite;

import java.util.List;

public class TextComposite implements TextComponent {
    
    private List<TextComponent> components;
    
    public TextComposite()  {
        // TODO Auto-generated constructor stub
    }

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
