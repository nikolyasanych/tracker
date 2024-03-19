package ru.cast;

public class Main {
    public static void main(String[] args) {
        Vehicle airplane = new Airplane();
        Vehicle bus = new Bus();
        Vehicle train = new Train();
        Vehicle[] array = {airplane, bus, train};
        for (Vehicle a : array) {
            a.move();
        }
    }
}
