package ru.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                return i;
            }
        }
        throw new ElementNotFoundException("Нет подходящего элемента");
    }

    public static void main(String[] args) {
        String[] array = {"a", "b", "c"};
        String key = "d";
        try {
            indexOf(array, key);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
