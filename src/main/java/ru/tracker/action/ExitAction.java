package ru.tracker.action;

import ru.tracker.Input;
import ru.tracker.Output;
import ru.tracker.Tracker;

public class ExitAction implements UserAction {
    private final Output output;

    public ExitAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Завершить программу";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("Завершение программы");
        return false;
    }

}
