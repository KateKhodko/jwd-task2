package com.epam.jwd.parser;

import com.epam.jwd.exception.HasNotNextParserException;
import com.epam.jwd.exception.ParseException;
import com.epam.jwd.model.Node;
import com.epam.jwd.repository.TextReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Parser {

    private static final Logger LOGGER = LogManager.getLogger(Parser.class);

    protected Parser nextParser;

    public void parse(Node node, String... str) throws ParseException {
        if (nextParser == null) {
            LOGGER.error("Has not next parser");
            throw new HasNotNextParserException();
        }
    }

    public void setNextParser(Parser nextParser) {
        this.nextParser = nextParser;
    }
}
