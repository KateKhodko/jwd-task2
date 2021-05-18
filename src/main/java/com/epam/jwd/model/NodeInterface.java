package com.epam.jwd.model;

import java.util.List;

public interface NodeInterface {

    void show();

    String getText();

    List<NodeInterface> getNodes();
}
