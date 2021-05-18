package com.epam.jwd.parser.statement;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InfixToPostfixConverterTest {

    @Test
    void infixToPostfix() {
        String infix = "5^(1&2&(3|(4&(5|6&47)|3)|2)|1)";
        InfixToPostfixConverter converter = new InfixToPostfixConverter();
        List<String> postfix = converter.infixToPostfix(infix);

        String[] expectedArr = {"5", "1", "2", "&", "3", "4", "5", "6", "47", "&", "|", "&", "3", "|", "|", "2", "|", "&", "1", "|", "^"};
        List<String> expected = Arrays.asList(expectedArr);
        assertEquals(expected, postfix);
    }
}