package ru.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        LocalDateTime rsl = item.getLocalDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String data = rsl.format(formatter);
        System.out.println(data);
    }
}
