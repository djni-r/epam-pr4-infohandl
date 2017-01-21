package by.malinouski.infohandling.composite;

public interface TextComponent {
    void add(TextComponent component);
    TextComponent remove();
    int count();
}
