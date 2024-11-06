package ru.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int minSize = Math.min(left.length(), right.length());
        for (int i = 0; i < minSize; i++) {
            int result = Character.compare(left.charAt(i), right.charAt(i));
            if (result != 0) {
                return result;
            }
        }
        return left.length() == right.length() ? 0 : left.length() - right.length();
    }
}