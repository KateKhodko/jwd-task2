package com.epam.jwd.model;

public class Lexeme extends Node {

    @Override
    public String toString() {
        return "Lexeme{" +
                "nodes=" + nodes +
                '}';
    }

    @Override
    public String getText() {
        StringBuilder stringBuilder = new StringBuilder();
        nodes.forEach(node -> stringBuilder.append(node.getText()));
        return stringBuilder.toString();
    }
}
