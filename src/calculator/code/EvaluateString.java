package calculator.code;

import java.util.Stack;

public class EvaluateString {

    static String sbuf = "";
    static int pos = 0;

    public static Double evaluate(String expression) {
        char[] charsLitral = expression.toCharArray();

        Stack<Double> values = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (char ch : charsLitral) {

            if (Character.isWhitespace(ch) || Character.isAlphabetic(ch)) {
                continue;
            }


            if (Character.isDigit(ch)) {
                sbuf = sbuf + ch;

                if (ch == charsLitral[charsLitral.length - 1]) {
                    values.push(Double.parseDouble(sbuf));
                    sbuf = "";
                }
            } else {

                if (!sbuf.isEmpty()) {
                    values.push(Double.parseDouble(sbuf));
                    sbuf = "";
                }

                if (!ops.empty() && checkPrecence(ch, ops.peek()))
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));

                ops.push(ch);
            }

        }
        while (!ops.isEmpty()) {
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        }
        return values.pop();
    }

    private static Boolean checkPrecence(char op1, char op2) {
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else return true;
    }

    private static Double applyOp(char op, Double val1, Double val2) {
        switch (op) {
            case '/':
                if (val1 == 0)
                    throw new UnsupportedOperationException("cant divide by zero");
                return val2 / val1;
            case '*':
                return val2 * val1;
            case '+':
                return val2 + val1;
            case '-':
                return val2 - val1;
        }
        return null;
    }
}
