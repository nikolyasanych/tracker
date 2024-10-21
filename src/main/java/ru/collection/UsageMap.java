package ru.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("pochta@yandex.ru", "Olivka");
        for (String key : map.keySet()) {
            String name = map.get(key);
            System.out.println("key: " + key + "\nname: " + name);
        }
    }
}
