package com.epam.jwd.parser.statement;

public class ComplementExpression implements Expression {

    private final Expression expression;

    public ComplementExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public int interpret() {
        return ~expression.interpret();
    }
}
