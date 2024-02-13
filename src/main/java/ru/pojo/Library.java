package ru.pojo;

public class Library {
    public static void swap(Book[] books, int source, int dest) {
        Book pr = books[source];
        books[source] = books[dest];
        books[dest] = pr;
    }

    public static void show(Book[] array) {
        for (int i = 0; i < array.length; i++) {
            Book pr = array[i];
            System.out.println(pr.getName() + " - " + pr.getPages());
        }
        System.out.println("-----------");
    }

    public static void showByName(Book[] array, String name) {
        for (int i = 0; i < array.length; i++) {
            Book pr = array[i];
            if (pr.getName().equals(name)) {
                System.out.println(pr.getName() + " - " + pr.getPages());
            }
        }
        System.out.println("-----------");
    }

    public static void main(String[] args) {
        Book book1 = new Book();
        book1.setPages(10);
        book1.setName("Clean code");
        Book book2 = new Book();
        book2.setPages(15);
        book2.setName("Esenin");
        Book book3 = new Book();
        book3.setPages(50);
        book3.setName("Onegin");
        Book book4 = new Book();
        book4.setPages(10);
        book4.setName("Tolstoy");
        Book[] array = {book1, book2, book3, book4};
        show(array);
        swap(array, 0, 3);
        show(array);
        showByName(array, "Clean code");
    }
}
