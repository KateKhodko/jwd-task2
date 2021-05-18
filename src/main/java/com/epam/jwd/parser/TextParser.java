package com.epam.jwd.parser;

import com.epam.jwd.exception.ParseException;
import com.epam.jwd.model.Node;
import com.epam.jwd.model.Paragraph;

import java.util.ArrayList;
import java.util.List;

public class TextParser extends Parser {

    private static final String PARAGRAPH_REGEXP = "[ ]{4}(.+)";

    @Override
    public void parse(Node text, String... strings) throws ParseException {
        super.parse(text, strings);
        List<String> pStrings = new ArrayList<>();
        for (String str : strings) {
            if (str.matches(PARAGRAPH_REGEXP)) {
                parseNext(text, pStrings);
                pStrings.clear();
            }
            pStrings.add(str);
        }
        parseNext(text, pStrings);
    }

    private void parseNext(Node text, List<String> pStrings) throws ParseException {
        if (!pStrings.isEmpty()) {
            Paragraph paragraph = new Paragraph();
            text.addNode(paragraph);
            String[] pStringsArr = new String[pStrings.size()];
            nextParser.parse(paragraph, pStrings.toArray(pStringsArr));
        }
    }
}
