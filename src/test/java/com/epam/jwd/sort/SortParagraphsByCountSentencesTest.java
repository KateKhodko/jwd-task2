package com.epam.jwd.sort;

import com.epam.jwd.exception.ParseException;
import com.epam.jwd.model.Node;
import com.epam.jwd.model.NodeInterface;
import com.epam.jwd.model.Text;
import com.epam.jwd.parser.ParserChain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SortParagraphsByCountSentencesTest {

    private final Text text = new Text();

    @BeforeEach
    void setUp() throws ParseException {
        String[] textStr = {
                "    Hello, world! This is simple test!",
                "    This is very simple test! This test! This test! This. This is test!",
                "    The end."
        };
        ParserChain.instance.parse(text, textStr);
    }

    @Test
    void sort() {
        Sort sort = new SortParagraphsByCountSentences();
        Text sortedText = sort.sort(text);
        List<NodeInterface> paragraphs = sortedText.getNodes();
        for (int i = 0; i < paragraphs.size() - 1; i++) {
            int sizePrev = paragraphs.get(i).getNodes().size();
            int sizeNext = paragraphs.get(i + 1).getNodes().size();
            assertTrue(sizePrev <= sizeNext);
        }
    }
}