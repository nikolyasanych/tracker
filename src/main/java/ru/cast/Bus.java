package ru.cast;

public class Bus implements Vehicle {

    @Override
    public void move() {
        System.out.println("Я общественный транспорт");
    }
}
