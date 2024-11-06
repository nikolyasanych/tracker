package ru.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int leftSize = left.length();
        int rightSize = right.length();
        int minSize = Math.min(leftSize, rightSize);
        int compareSize = Integer.compare(leftSize, rightSize);
        for (int i = 0; i < minSize; i++) {
            int result = Character.compare(left.charAt(i), right.charAt(i));
            if (result != 0) {
                return result;
            }
            if (compareSize < 0 && i == minSize - 1) {
                return -1;
            }
            if (compareSize > 0 && i == minSize - 1) {
                return 1;
            }
        }
        return 0;
    }
}