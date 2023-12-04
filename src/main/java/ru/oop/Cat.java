package ru.oop;

public class Cat {

    private String food;
    private String name;

    public String sound() {
        return "may-may";
    }

    public void show() {
        System.out.println("Name: " + name);
        System.out.println("Food: " + food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public static void main(String[] args) {
        Cat peppy = new Cat();
        Cat sparky = new Cat();
        String say = peppy.sound();
        sparky.giveNick("Sparky");
        sparky.eat("Fish");
        sparky.show();
    }
}
