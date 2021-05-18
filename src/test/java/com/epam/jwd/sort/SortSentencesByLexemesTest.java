package com.epam.jwd.sort;

import com.epam.jwd.exception.ParseException;
import com.epam.jwd.model.NodeInterface;
import com.epam.jwd.model.Text;
import com.epam.jwd.model.Word;
import com.epam.jwd.parser.ParserChain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortSentencesByLexemesTest {

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
        Sort sort = new SortSentencesByLexemes();
        Text sortedText = sort.sort(text);
        for (NodeInterface paragraph : sortedText.getNodes()) {
            int sizePrev = 0;
            for (NodeInterface sentence : paragraph.getNodes()) {
                int size = 0;
                for (NodeInterface lexeme : sentence.getNodes()) {
                    size += lexeme.getText().length();
                }
                assertTrue(sizePrev <= size);
                sizePrev = size;
            }
        }
    }
}