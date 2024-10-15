package ru.tracker;

import java.util.List;

public final class SingleTracker {
    private Tracker tracker = new Tracker();
    private static SingleTracker singleTracker = null;

    private SingleTracker() {
    }

    public static SingleTracker getSingleTracker() {
        if (singleTracker == null) {
            singleTracker = new SingleTracker();
        }
        return singleTracker;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public void delete(int id) {
        tracker.delete(id);
    }

    public List<Item> findAll() {
        return tracker.findAll();
    }

    public List<Item> findByName(String key) {
        return tracker.findByName(key);
    }

    public Item findById(int id) {
        return tracker.findById(id);

    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }
}
