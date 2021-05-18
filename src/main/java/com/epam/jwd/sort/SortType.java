package com.epam.jwd.sort;

public enum SortType {
    PARAGRAPHS_BY_COUNT_SENTENCES(new SortParagraphsByCountSentences()),
    SENTENCES_BY_LEXEMES(new SortSentencesByLexemes()),
    SENTENCES_BY_WORDS(new SortSentencesByWords());

    private final Sort sort;

    SortType(Sort sort) {
        this.sort = sort;
    }

    public Sort getSort() {
        return sort;
    }
}

