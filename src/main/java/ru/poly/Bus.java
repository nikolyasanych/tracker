package ru.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Пристегнитесь, мы выезжаем!");
    }

    @Override
    public void passengers(int value) {
        System.out.printf("Число пассажиров: %d \n", value);
    }

    @Override
    public double gaz(double oil) {
        return oil * 50;
    }
}
