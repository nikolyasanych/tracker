package ru.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemDescByNameTest {

    @Test
    void compare() {
        Item ivan = new Item("Ivan");
        Item nikolai = new Item("Nikolai");
        Item dmitriy = new Item("Dmitriy");
        List<Item> items = Arrays.asList(
                ivan,
                nikolai,
                dmitriy
        );
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                nikolai,
                ivan,
                dmitriy
        );
        assertThat(items).isEqualTo(expected);
    }
}