package ru.tracker;

import org.junit.jupiter.api.Test;
import ru.tracker.action.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {

    @Test
    void whenCreateItem() {
        Output output = new MockOutput();
        Input input = new MockInput(
                List.of("0", "Item name", "1")
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(
                new Create(output),
                new Exit(output));
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo("Item name");
    }

    @Test
    void whenReplaceItem() {
        Output output = new MockOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input input = new MockInput(
                 List.of("0", Integer.toString(item.getId()), replacedName, "1")
        );
        List<UserAction> actions = List.of(
                new Replace(output),
                new Exit(output));
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    void whenDeleteItem() {
        Output output = new MockOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input input = new MockInput(
                List.of("0", Integer.toString(item.getId()), "1")
        );
        List<UserAction> actions = List.of(
                new Delete(output),
                new Exit(output));
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    void whenReplaceItemTestOutputIsSuccessfully() {
        Output output = new MockOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input input = new MockInput(
                List.of("0", String.valueOf(one.getId()), replaceName, "1")
        );
        List<UserAction> actions = List.of(
                new Replace(output),
                new Exit(output));
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Редактирование заявки" + ln
                        + "1. Завершить программу" + ln
                        + "Заявка изменена успешно." + ln
                        + "Меню:" + ln
                        + "0. Редактирование заявки" + ln
                        + "1. Завершить программу" + ln
                        + "Завершение программы" + ln
        );
    }

    @Test
    void whenFindAllActionTestOutputIsSuccessfully() {
        Output output = new MockOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Item two = tracker.add(new Item("test2"));
        Input input = new MockInput(
                List.of("0", "1")
        );
        List<UserAction> actions = List.of(
                new FindAll(output),
                new Exit(output));
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Вывод всех заявок" + ln
                        + "1. Завершить программу" + ln
                        + one + ln
                        + two + ln
                        + "Меню:" + ln
                        + "0. Вывод всех заявок" + ln
                        + "1. Завершить программу" + ln
                        + "Завершение программы" + ln
        );
    }

    @Test
    void whenFindByNameActionTestOutputIsSuccessfully() {
        Output output = new MockOutput();
        Tracker tracker = new Tracker();
        String name = "test1";
        Item one = tracker.add(new Item(name));
        Item two = tracker.add(new Item(name));
        tracker.add(new Item("test3"));
        Input input = new MockInput(
                List.of("0", name, "1")
        );
        List<UserAction> actions = List.of(
                new FindByName(output),
                new Exit(output));
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Вывод заявок по имени" + ln
                        + "1. Завершить программу" + ln
                        + one + ln
                        + two + ln
                        + "Меню:" + ln
                        + "0. Вывод заявок по имени" + ln
                        + "1. Завершить программу" + ln
                        + "Завершение программы" + ln
        );
    }

    @Test
    void whenFindByIdActionTestOutputIsSuccessfully() {
        Output output = new MockOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("Test1"));
        tracker.add(new Item("Test2"));
        Input input = new MockInput(
                List.of("0", String.valueOf(one.getId()), "1")
        );
        List<UserAction> actions = List.of(
                new FindById(output),
                new Exit(output));
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Вывод заявки по id" + ln
                        + "1. Завершить программу" + ln
                        + one + ln
                        + "Меню:" + ln
                        + "0. Вывод заявки по id" + ln
                        + "1. Завершить программу" + ln
                        + "Завершение программы" + ln
        );
    }

    @Test
    void whenInvalidExit() {
        Input input = new MockInput(List.of("8", "0"));
        Output output = new MockOutput();
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(new Exit(output));
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Завершить программу" + ln
                        + "Неверный ввод, вы можете выбрать: 0 .. 0" + ln
                        + "Меню:" + ln
                        + "0. Завершить программу" + ln
                        + "Завершение программы" + ln
        );
    }

}