package com.epam.jwd.model;

public class Text extends Node {

    @Override
    public String getText() {
        StringBuilder stringBuilder = new StringBuilder();
        nodes.forEach(node -> stringBuilder.append("\t").append(node.getText()).append("\n"));
        int lastInd = stringBuilder.lastIndexOf("\n");
        if (lastInd != -1) {
            stringBuilder.deleteCharAt(lastInd);
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "Text{" +
                "nodes=" + nodes +
                '}';
    }
}
