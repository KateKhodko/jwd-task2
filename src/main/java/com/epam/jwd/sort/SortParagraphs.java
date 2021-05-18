package com.epam.jwd.sort;

import com.epam.jwd.model.NodeInterface;
import com.epam.jwd.model.Text;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class SortParagraphs implements Sort {

    protected abstract Comparator<NodeInterface> getComparator();

    @Override
    public Text sort(Text text) {
        List<NodeInterface> sortedNodes = text.getNodes().stream()
                .sorted(getComparator())
                .collect(Collectors.toList());
        Text sortedText = new Text();
        sortedText.addNodes(sortedNodes);
        return sortedText;
    }
}
