package by.malinouski.infohandling.composite;

public interface TextComponent {
    void add(TextComponent component);
    void remove(TextComponent component);
    int count();
    boolean equals(Object obj);
}
