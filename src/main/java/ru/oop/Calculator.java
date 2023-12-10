package ru.oop;

public class Calculator {
    private static int x = 5;

    public static int minus(int y) {
        return y - x;
    }

    public static int sum(int y) {
        return x + y;
    }

    public int divide(int y) {
        return y / x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int sumAllOperation(int y) {
        return minus(y) + sum(y) + divide(y) + multiply(y);
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println(result);
        result = minus(9);
        System.out.println(result);
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(5);
        System.out.println(rsl);
        rsl = calculator.divide(10);
        System.out.println(rsl);
        rsl = calculator.sumAllOperation(10);
        System.out.println(rsl);
    }

}
