package ru.ex;

public class NPEx {
    public static void main(String[] args) {
        String[] shops = new String[5];
        shops[0] = "Ivan Ivanov";
        for (int index = 0; index < shops.length; index++) {
            String element = shops[index];
            if (element != null) {
                System.out.println(element + " has a size : " + element.length());
            }
        }
    }
}
