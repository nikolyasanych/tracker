package ru.oop;

public class BallStory {
    public static void main(String[] args) {
        Wolf wolf = new Wolf();
        Ball kolobok = new Ball();
        Hare hare = new Hare();
        Fox fox = new Fox();
        hare.tryEat(kolobok);
        wolf.tryEat(kolobok);
        fox.tryEat(kolobok);
    }
}
