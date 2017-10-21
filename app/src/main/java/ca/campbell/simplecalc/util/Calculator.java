package ca.campbell.simplecalc.util;

/**
 * Created by Lakshmikant Deshpande on 21/10/17.
 */

public class Calculator {

    public static double add(double one, double two) {
        return one + two;
    }

    public static double subtract(double one, double two) {
        return one - two;
    }

    public static double multiply(double one, double two) {
        return one * two;
    }

    public static double divide(double one, double two) {
        if (two == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return one / two;
    }
}
