package by.malinouski.infohandling.composite;

import java.util.List;

public interface TextComponent {
    void add(TextComponent component);
    void remove(TextComponent component);
    List<TextComponent> getComponents();
    int countComponents();
    void makeImmutable();
}
