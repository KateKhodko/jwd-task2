package com.epam.jwd.sort;

import com.epam.jwd.model.NodeInterface;
import com.epam.jwd.model.Paragraph;
import com.epam.jwd.model.Text;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class SortSentences implements Sort {

    protected abstract Comparator<NodeInterface> getComparator();

    @Override
    public Text sort(Text text) {
        List<NodeInterface> paragraphs = text.getNodes();
        Text sortedText = new Text();
        for (NodeInterface paragraph : paragraphs) {
            Paragraph paragraphSorted = new Paragraph();
            List<NodeInterface> sortedNodes = paragraph.getNodes().stream()
                    .sorted(getComparator())
                    .collect(Collectors.toList());
            paragraphSorted.addNodes(sortedNodes);
            sortedText.addNode(paragraphSorted);
        }
        return sortedText;
    }
}
