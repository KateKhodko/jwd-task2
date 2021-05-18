package com.epam.jwd.sort;

import com.epam.jwd.model.NodeInterface;

import java.util.Comparator;

class SortSentencesByLexemes extends SortSentences {

    @Override
    protected Comparator<NodeInterface> getComparator() {
        return Comparator.comparing(this::getSize);
    }

    private Integer getSize(NodeInterface sentence) {
        int size = 0;
        for (NodeInterface lexeme : sentence.getNodes()) {
            size += lexeme.getText().length();
        }
        return size;
    }
}
