package ru.ex;

public class Factorial {
    public static int calc(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Входной параметр меньше нуля");
        }
        int result = 1;
        for (int index = 2; index <= number; index++) {
            result *= index;
        }
        return result;
    }

    public static void main(String[] args) {
        calc(-1);
    }
}
