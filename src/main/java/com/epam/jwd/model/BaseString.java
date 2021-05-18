package com.epam.jwd.model;

import java.util.List;

public abstract class BaseString implements NodeInterface {

    private final String node;

    public BaseString(String node) {
        this.node = node;
    }

    @Override
    public void show() {
        System.out.print(node);
    }

    public String getNode() {
        return node;
    }

    @Override
    public List<NodeInterface> getNodes() {
        return null;
    }

    @Override
    public String getText() {
        return getNode();
    }
}
