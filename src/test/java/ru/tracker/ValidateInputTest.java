package ru.tracker;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
class ValidateInputTest {
    @Test
    void whenInvalidInput() {
        Output output = new MockOutput();
        Input in = new MockInput(
                List.of("one", "1"));
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenOneIntInvalidInput() {
        Output output = new MockOutput();
        Input in = new MockInput(
                List.of("5")
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(5);
    }

    @Test
    void whenSomeInvalidInput() {
        Output output = new MockOutput();
        Input in = new MockInput(
                List.of("1", "2", "3")
        );
        ValidateInput input = new ValidateInput(output, in);
        int selectedOne = input.askInt("Enter menu:");
        assertThat(selectedOne).isEqualTo(1);
        int selectedTwo = input.askInt("Enter menu:");
        assertThat(selectedTwo).isEqualTo(2);
        int selectedThree = input.askInt("Enter menu:");
        assertThat(selectedThree).isEqualTo(3);
    }

    @Test
    void whenNegativInvalidInput() {
        Output output = new MockOutput();
        Input in = new MockInput(
                List.of("-1")
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-1);
    }
}