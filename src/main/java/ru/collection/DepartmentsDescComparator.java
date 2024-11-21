package ru.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftArray = left.split("/");
        String[] rightArray = right.split("/");
        return leftArray[0].equals(rightArray[0]) ? left.compareTo(right) : right.compareTo(left);
    }
}