package ru.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchFolder {
    public static List<Folder> filterSize(List<Folder> list) {
        return filter(element -> element.getSize() > 100, list);
    }

    public static List<Folder> filterName(List<Folder> list) {
        return filter(element -> element.getName().contains("bug"), list);
    }

    private static List<Folder> filter(Predicate<Folder> predicate, List<Folder> list) {
        List<Folder> result = new ArrayList<>();
        for (Folder el : list) {
            if (predicate.test(el)) {
                result.add(el);
            }
        }
        return result;
    }
}