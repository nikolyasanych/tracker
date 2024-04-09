package ru.ex;

public class FactorialRecursion {
    public static int calc(int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 0) {
            return 1;
        }
        return calc(n - 1) * n;
    }

    public static void main(String[] args) {
        int result = calc(4);
        System.out.println(result);
    }
}
