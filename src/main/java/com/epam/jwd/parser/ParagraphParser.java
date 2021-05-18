package com.epam.jwd.parser;

import com.epam.jwd.exception.ParseException;
import com.epam.jwd.model.Node;
import com.epam.jwd.model.Sentence;

public class ParagraphParser extends Parser {

    private static final String SENTENCE_SPLITTER = "(?<=[?!.])";

    @Override
    public void parse(Node paragraph, String... str) throws ParseException {
        super.parse(paragraph, str);
        String paragraphStr = connectStrings(str);
        String[] sentences = paragraphStr.split(SENTENCE_SPLITTER);
        for (String sentenceStr : sentences) {
            if (!sentenceStr.isBlank()) {
                Sentence sentence = new Sentence();
                paragraph.addNode(sentence);
                nextParser.parse(sentence, sentenceStr.trim());
            }
        }
    }

    private String connectStrings(String[] strings) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strings) {
            stringBuilder.append(str).append(" ");
        }
        return stringBuilder.toString();
    }
}
