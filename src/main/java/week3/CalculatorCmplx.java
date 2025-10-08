package week3;

public class CalculatorCmplx {

    int calculate(String expression) {
        if (expression == null) {
            throw new IllegalArgumentException("expression is null");
        }
        int n = expression.length();
        int i = 0;
        boolean hasNonWs = false;
        for (int k = 0; k < n; k++) {
            if (!Character.isWhitespace(expression.charAt(k))) {
                hasNonWs = true;
                break;
            }
        }
        if (!hasNonWs) {
            throw new IllegalArgumentException("Expression is empty");
        }
        long result = 0;
        int signOfNextNumber = +1;
        boolean expectNumber = true;
        boolean unaryMinusUsed = false;

        while (i < n) {
            char ch = expression.charAt(i);

            if (Character.isWhitespace(ch)) {
                i++;
                continue;
            }

            if (expectNumber) {
                if (ch == '-') {
                    if (unaryMinusUsed) {
                        throw error(expression, i, "Unexpected '-' (double unary minus not allowed)");
                    }
                    signOfNextNumber *= -1;
                    unaryMinusUsed = true;
                    i++;
                    continue;
                } else if (ch == '+') {

                    throw error(expression, i, "Unary '+' is not allowed");
                } else if (Character.isDigit(ch)) {
                    long value = 0;
                    while (i < n) {
                        char c2 = expression.charAt(i);
                        if (Character.isDigit(c2)) {
                            value = value * 10 + (c2 - '0');
                            i++;
                        } else if (Character.isWhitespace(c2)) {
                            break;
                        } else if (c2 == '+' || c2 == '-') {
                            break;
                        } else {
                            throw error(expression, i, "Invalid character in number");
                        }
                    }
                    result += signOfNextNumber * value;
                    expectNumber = false;
                    unaryMinusUsed = false;
                } else {
                    throw error(expression, i, "Expected a digit or unary '-'");
                }
            } else {

                if (ch == '+') {
                    signOfNextNumber = +1;
                    expectNumber = true;
                    unaryMinusUsed = false;
                    i++;
                } else if (ch == '-') {
                    signOfNextNumber = -1;
                    expectNumber = true;
                    unaryMinusUsed = false;
                    i++;
                } else {
                    throw error(expression, i, "Expected operator '+' or '-'");
                }
            }
        }

        if (expectNumber) {
            throw new IllegalArgumentException("Expression ends unexpectedly (missing number at the end)");
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Result overflows int range: " + result);
        }

        return (int) result;
    }

    private IllegalArgumentException error(String expr, int index, String message) {
        char bad = (index >= 0 && index < expr.length()) ? expr.charAt(index) : '?';
        return new IllegalArgumentException(
                message + " at position " + (index + 1) + " (found '" + bad + "')"
        );
    }
}