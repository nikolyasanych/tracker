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
            if (left.length() < right.length() && i == minSize - 1) {
                return -1;
            }
            if (left.length() > right.length() && i == minSize - 1) {
                return 1;
            }
        }
        return 0;
    }
}