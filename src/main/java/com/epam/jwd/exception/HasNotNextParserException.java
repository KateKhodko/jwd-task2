package com.epam.jwd.exception;

public class HasNotNextParserException extends ParseException {

    private final static String message = "Parser has not next parser";

    public HasNotNextParserException() {
        super();
    }

    @Override
    public String getMessage() {
        return message;
    }
}
