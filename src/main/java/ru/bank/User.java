package ru.bank;

import java.util.Objects;

/**
 * класс представляет собой пользователя
 */
public class User {
    /**
     * паспорт
     */
    private String passport;
    /**
     * Имя пользователя
     */
    private String username;

    /**
     * представляет собой канонический конструктор
     * @param passport- паспорт пользователя
     * @param username- имя пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * возвращает паспорт
     * @return String
     */
    public String getPassport() {
        return passport;
    }

    /**
     * меняет значение поля паспорт
     * @param passport- паспорт пользователя
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * возвращает имя пользователя
     * @return String
     */
    public String getUsername() {
        return username;
    }

    /**
     * меняет значение поля имя пользователя
     * @param username- имя пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * переопределяем метод equals для корректного сравнения объектов
     * @param o- объект, с которым сравниваем
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * переопределяем метод hashCode
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
