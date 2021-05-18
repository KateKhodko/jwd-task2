package com.epam.jwd.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Node implements NodeInterface {

    protected final List<NodeInterface> nodes = new ArrayList<>();

    @Override
    public List<NodeInterface> getNodes() {
        return nodes;
    }

    @Override
    public void show() {
        nodes.forEach(NodeInterface::show);
    }

    public void addNode(NodeInterface node) {
        nodes.add(node);
    }

    public void addNodes(List<NodeInterface> nodes) {
        this.nodes.addAll(nodes);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(nodes, node.nodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodes);
    }
}
