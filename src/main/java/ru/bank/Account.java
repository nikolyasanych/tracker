package ru.bank;

import java.util.Objects;

/**
 * класс представляет собой счет клиента
 */
public class Account {
    /**
     * реквизит
     */
    private String requisite;
    /**
     * баланс
     */
    private double balance;

    /**
     * канонический конструктор
     * @param requisite- реквизит пользователя
     * @param balance- баланс пользователя
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * возвращает поле реквизит
     * @return String
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * изменяем значение поля реквизит
     * @param requisite- реквизит пользователя
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * возвращает баланс
     * @return double
     */
    public double getBalance() {
        return balance;
    }

    /**
     * изменяет баланс клиента
     * @param balance- баланс пользователя
     */
    public void setBalance(double balance) {
        this.balance = balance;
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
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * переопределяем метод hashCode
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
