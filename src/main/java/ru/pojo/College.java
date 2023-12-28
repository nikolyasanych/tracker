package ru.pojo;

import java.time.LocalDateTime;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Мирный Санек Петрович");
        student.setCreated(LocalDateTime.now());
        student.setGroup(1337);
        System.out.println("ФИО: " + student.getFullName()
                + "\nДата поступления: " + student.getCreated()
                + "\nГрупа: " + student.getGroup());
    }
}
