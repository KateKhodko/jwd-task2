package com.epam.jwd.parser;

import com.epam.jwd.exception.ParseException;
import com.epam.jwd.model.Lexeme;
import com.epam.jwd.model.Node;

public class SentenceParser extends Parser {

    private static final String LEXEME_SPLITTER = "(\\s+)";

    @Override
    public void parse(Node sentence, String... strings) throws ParseException {
        super.parse(sentence, strings);
        for (String str : strings) {
            String[] lexemes = str.split(LEXEME_SPLITTER);
            for (String lexemeStr : lexemes) {
                Lexeme lexeme = new Lexeme();
                sentence.addNode(lexeme);
                nextParser.parse(lexeme, lexemeStr);
            }
        }
    }
}
