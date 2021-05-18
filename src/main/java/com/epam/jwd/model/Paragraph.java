package com.epam.jwd.model;

public class Paragraph extends Node {

    @Override
    public String toString() {
        return "Paragraph{" +
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
