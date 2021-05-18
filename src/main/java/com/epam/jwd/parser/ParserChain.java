package com.epam.jwd.parser;

import com.epam.jwd.exception.ParseException;
import com.epam.jwd.model.Node;

public class ParserChain {

    public static final ParserChain instance = new ParserChain();

    private final Parser textParser = new TextParser();
    private final Parser paragraphParser = new ParagraphParser();
    private final Parser sentenceParser = new SentenceParser();
    private final Parser lexemeParser = new LexemeParser();

    public ParserChain() {
        textParser.setNextParser(paragraphParser);
        paragraphParser.setNextParser(sentenceParser);
        sentenceParser.setNextParser(lexemeParser);
    }

    public void parse(Node node, String... strings) throws ParseException {
        textParser.parse(node, strings);
    }
}
