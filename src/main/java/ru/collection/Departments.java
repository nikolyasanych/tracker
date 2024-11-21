package ru.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> departments) {
        Set<String> temp = new LinkedHashSet<>();
        for (String departament : departments) {
            String[] array = departament.split("/");
            String str = "";
            for (int i = 0; i < array.length; i++) {
                str = i > 0 ? str.concat("/").concat(array[i]) : str.concat(array[i]);
                temp.add(str);
            }
        }
        return new ArrayList<>(temp);
    }

    public static void sortAsc(List<String> departments) {
        departments.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> departments) {
        departments.sort(new DepartmentsDescComparator());
    }
}