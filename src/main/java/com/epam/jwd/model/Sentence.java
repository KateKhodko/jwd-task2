package com.epam.jwd.model;

public class Sentence extends Node {

    @Override
    public String toString() {
        return "Sentence{" +
                "nodes=" + nodes +
                '}';
    }

    @Override
    public String getText() {
        StringBuilder stringBuilder = new StringBuilder();
        nodes.forEach(node -> stringBuilder.append(node.getText()).append(" "));
        return stringBuilder.toString();
    }
}
