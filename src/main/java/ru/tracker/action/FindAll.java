package ru.tracker.action;

import ru.tracker.Input;
import ru.tracker.Item;
import ru.tracker.Output;
import ru.tracker.Tracker;

import java.util.List;

public class FindAll implements UserAction {
    private final Output output;

    public FindAll(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Вывод всех заявок";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        List<Item> items = tracker.findAll();
        if (!items.isEmpty()) {
            for (Item item : items) {
                output.println(item);
            }
        } else {
            output.println("Хранилище еще не содержит заявок");
        }
        return true;
    }
}
