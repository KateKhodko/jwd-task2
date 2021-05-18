package com.epam.jwd.sort;

import com.epam.jwd.model.NodeInterface;
import com.epam.jwd.model.Word;

import java.util.Comparator;

class SortSentencesByWords extends SortSentences {

    @Override
    protected Comparator<NodeInterface> getComparator() {
        return Comparator.comparing(this::getSize);
    }

    private Integer getSize(NodeInterface sentence) {
        int size = 0;
        for (NodeInterface lexeme : sentence.getNodes()) {
            for (NodeInterface baseString : lexeme.getNodes()) {
                if (baseString instanceof Word) {
                    size += lexeme.getText().length();
                }
            }
        }
        return size;
    }
}
