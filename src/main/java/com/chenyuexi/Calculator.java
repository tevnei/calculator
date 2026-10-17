package com.chenyuexi;

import org.apache.commons.lang3.StringUtils;

public class Calculator {
    public double eval(String a, String op, String b) {
        if (StringUtils.isBlank(a) || StringUtils.isBlank(b)) {
            throw new IllegalArgumentException("input is blank");
        }
        if (StringUtils.isBlank(op)) {
            throw new IllegalArgumentException("operator is blank");
        }
        double x = Double.parseDouble(a);
        double y = Double.parseDouble(b);

        switch (op) {
            case "+":
                return x + y;
            case "-":
                return x - y;
            case "*":
                return x * y;
            case "/":
                if (y == 0.0) {
                    throw new IllegalArgumentException("Cannot divide by zero");
                }
                return x / y;
            case "^": return Math.pow(x, y);
            case "%": return x % y;
            default:
                throw new IllegalArgumentException(op);
        }
    }
}
