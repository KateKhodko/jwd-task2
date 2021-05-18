package com.epam.jwd.parser;

import com.epam.jwd.exception.ParseException;
import com.epam.jwd.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TextParserTest {

    private final List<String> linesExpected = new ArrayList<>();

    @BeforeEach
    void setUp() {
        linesExpected.clear();
        linesExpected.add("    It has survived — not only (five) centuries, but also the leap into 13<<2 electronic typesetting,");
        linesExpected.add("remaining 3>>5 essentially ~6&9|(3&4) unchanged. It was popularized in the 5^(1&2&(3|(4&(5|6&47)|3)|2)|1) with the");
        linesExpected.add("release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like");
        linesExpected.add("Aldus PageMaker including versions of Lorem Ipsum.");
        linesExpected.add("    It is a long-established fact that a reader will be distracted by the readable content of a page when looking at");
        linesExpected.add("its layout. The point of using (~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78 Ipsum is that it has a more-or-less normal");
        linesExpected.add("distribution of letters, as opposed to using (Content here), content here', making it look like readable English.");
        linesExpected.add("It is a (5|1&2<<(2|5>>2&71))|1200 established fact that a reader will be of a page when looking at its layout.");
        linesExpected.add("    Bye.");
    }

    @Test
    void parse() throws ParseException {
        Text text = new Text();
        String[] textStr = new String[linesExpected.size()];
        linesExpected.toArray(textStr);
        ParserChain.instance.parse(text, textStr);

        Integer countParagraphs = 3;
        assertEquals(countParagraphs, text.getNodes().size());

        Integer countSentencesFirstParagraph = 2;
        NodeInterface paragraph = text.getNodes().get(0);
        assertEquals(countSentencesFirstParagraph, paragraph.getNodes().size());

        Integer countLexemesFirstSentence = 21;
        NodeInterface sentence = paragraph.getNodes().get(0);
        assertEquals(countLexemesFirstSentence, sentence.getNodes().size());

        String firstWordExpected = "It";
        String word = sentence.getNodes().get(0).getNodes().get(0).getText();
        assertEquals(firstWordExpected, word);
    }
}