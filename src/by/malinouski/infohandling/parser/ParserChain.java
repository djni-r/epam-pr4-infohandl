package by.malinouski.infohandling.parser;

import by.malinouski.infohandling.composite.TextComponent;

public interface ParserChain {
    TextComponent parse(String text);
}
