package ru.cast;

public class Airplane implements Vehicle {

    @Override
    public void move() {
        System.out.println("Я умею летать");
    }
}
