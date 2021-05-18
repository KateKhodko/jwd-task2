package com.epam.jwd.parser.statement;

import com.epam.jwd.exception.InvalidOperatorException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionFactoryTest {

    @Test
    void countResult() throws InvalidOperatorException {
        int expected = 5^(1&2&(3|(4&(5|6&47)|3)|2)|1);
        String[] expectedArr = {"5", "1", "2", "&", "3", "4", "5", "6", "47", "&", "|", "&", "3", "|", "|", "2", "|", "&", "1", "|", "^"};
        List<String> tokens = Arrays.asList(expectedArr);
        int result = ExpressionFactory.instance.countResult(tokens);
        assertEquals(expected, result);
    }
}