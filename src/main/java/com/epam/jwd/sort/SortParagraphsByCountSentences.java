package com.epam.jwd.sort;

import com.epam.jwd.model.NodeInterface;

import java.util.Comparator;

class SortParagraphsByCountSentences extends SortParagraphs {

    @Override
    protected Comparator<NodeInterface> getComparator() {
        return (o1, o2) -> {
            Integer size1 = o1.getNodes().size();
            Integer size2 = o2.getNodes().size();
            return size1.compareTo(size2);
        };
    }
}
