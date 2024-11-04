package ru.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemDescByNameTest {

    @Test
    void compare() {
        Item Ivan = new Item("Ivan");
        Item Nikolai = new Item("Nikolai");
        Item Dmitriy = new Item("Dmitriy");
        List<Item> items = Arrays.asList(
                Ivan,
                Nikolai,
                Dmitriy
        );
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                Nikolai,
                Ivan,
                Dmitriy
        );
        assertThat(items).isEqualTo(expected);
    }
}