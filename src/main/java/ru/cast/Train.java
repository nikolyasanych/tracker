package ru.cast;

public class Train implements Vehicle {

    @Override
    public void move() {
        System.out.println("Я двигаюсь по рельсам");
    }
}
