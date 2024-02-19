package ru.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        int len = 0;
        Item[] rsl = new Item[size];
        for (int i = 0; i < size; i++) {
            Item name = items[i];
            if (name != null) {
                rsl[len] = name;
                len++;
            }
        }
        return Arrays.copyOf(rsl, len);
    }

    public Item[] findByName(String key) {
        int len = 0;
        Item[] rsl = new Item[size];
        for (int i = 0; i < size; i++) {
            Item name = items[i];
            if (name.getName().equals(key)) {
                rsl[len] = name;
                len++;
            }
        }
        return Arrays.copyOf(rsl, len);
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}