package com.epam.jwd.parser;

import com.epam.jwd.exception.InvalidOperatorException;
import com.epam.jwd.exception.ParseException;
import com.epam.jwd.model.BaseString;
import com.epam.jwd.model.Node;
import com.epam.jwd.model.Statement;
import com.epam.jwd.model.Symbol;
import com.epam.jwd.model.Word;
import com.epam.jwd.parser.statement.ExpressionFactory;
import com.epam.jwd.parser.statement.InfixToPostfixConverter;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser extends Parser {

    private static final String STATEMENT_PATTERN = ".*[&|^~><].*";
    private static final String END_SYMBOL_MATCHER = "[^,.?!:;]*[,.?!:;]+";
    private static final String END_SYMBOL_PATTERN = "[,.?!:;]+";
    private static final String WORD_MATCHER = "[(\"]?[A-Za-z-']+[)\"]?";
    private static final String WORD_PATTERN = "[A-Za-z-']+";
    private static final String SYMBOL_PATTERN = "—";

    @Override
    public void parse(Node lexeme, String... str) throws ParseException {
        String string = str[0];
        String endSymbol = findEndSymbol(string);
        if (endSymbol != null) {
            string = string.replaceAll(END_SYMBOL_PATTERN, "");
        }
        if (parseWord(lexeme, string) || parseSymbol(lexeme, string) || parseStatement(lexeme, string)) {
            addSymbol(lexeme, endSymbol);
        }
    }

    private void addSymbol(Node lexeme, String symbolStr) {
        if (symbolStr != null && !symbolStr.isBlank()) {
            BaseString symbol = new Symbol(symbolStr);
            lexeme.addNode(symbol);
        }
    }

    private void addWord(Node lexeme, String wordStr) {
        if (wordStr != null) {
            BaseString word = new Word(wordStr);
            lexeme.addNode(word);
        }
    }

    private void addStatement(Node lexeme, int number) {
        Statement statement = new Statement(String.valueOf(number));
        lexeme.addNode(statement);
    }

    private String findEndSymbol(String string) {
        String endSymbol = null;
        if (string.matches(END_SYMBOL_MATCHER)) {
            Pattern pattern = Pattern.compile(END_SYMBOL_PATTERN);
            Matcher matcher = pattern.matcher(string);
            while (matcher.find()) {
                endSymbol = matcher.group();
            }
        }
        return endSymbol;
    }

    private boolean parseWord(Node lexeme, String string) {
        if (string.matches(WORD_MATCHER)) {
            Pattern pattern = Pattern.compile(WORD_PATTERN);
            Matcher matcher = pattern.matcher(string);
            String wordStr = null;
            if (matcher.find()) {
                wordStr = matcher.group();
            }
            String replacedString = string.replaceAll(WORD_PATTERN, "");
            String firstSymbol = null;
            String lastSymbol = null;
            if (!replacedString.isBlank()) {
                firstSymbol = replacedString.substring(0, 1);
                lastSymbol = replacedString.substring(1);
            }
            if (Objects.equals(firstSymbol, string.substring(0, 1))) {
                addSymbol(lexeme, firstSymbol);
                addWord(lexeme, wordStr);
                addSymbol(lexeme, lastSymbol);
            } else {
                addWord(lexeme, wordStr);
                addSymbol(lexeme, firstSymbol);
            }
            return true;
        }
        return false;
    }

    private boolean parseSymbol(Node lexeme, String string) {
        if (string.matches(SYMBOL_PATTERN)) {
            addSymbol(lexeme, string);
            return true;
        }
        return false;
    }

    private boolean parseStatement(Node lexeme, String string) throws InvalidOperatorException {
        if (string.matches(STATEMENT_PATTERN)) {
            InfixToPostfixConverter converter = new InfixToPostfixConverter();
            List<String> tokens = converter.infixToPostfix(string);
            addStatement(lexeme, ExpressionFactory.instance.countResult(tokens));
            return true;
        }
        return false;
    }
}
