package ru.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * класс представляет собой реализацию банковского сервиса
 */
public class BankService {
    /**
     * {@link Map} где ключ- это пользователь, значение- список счетов
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * добавление пользователя
     * @param user- пользователь, которого добавляем
     */
    public void addUser(User user) {
        if (user != null) {
            users.putIfAbsent(user, new ArrayList<>());
        }
    }

    /**
     * удаление пользователя
     * @param passport- паспорт пользователя
     */
    public void deleteUser(String passport) {
        User user = findByPassport(passport);
        users.remove(user);
    }

    /**
     * добавление счета к пользователю
     * @param passport- паспорт пользователя
     * @param account- счет пользователя
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = users.get(user);
            if (!list.contains(account)) {
                list.add(account);
                users.put(user, list);
            }
        }
    }

    /**
     * ищем пользователя по паспорту
     * @param passport- паспорт пользователя
     * @return User- возврат пользователя
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * ищем счет по реквезиту
     * @param passport- паспорт пользователя
     * @param requisite- реквизит счета
     * @return Account- счет пользователя
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * перевод между счетами
     * @param sourcePassport- паспорт пользователя, от которого идет перевод
     * @param sourceRequisite- реквизит откуда идет перевод
     * @param destinationPassport- паспорт пользователя, которому осуществляем перевод
     * @param destinationRequisite- реквизит куда осуществляем перевод
     * @param amount- сумма
     * @return boolean- true если перевод осуществился, false если перевод не состоялся
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        Account srcAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            return true;
        }
        return false;
    }

    /**
     * возвращает список счетов у пользователя
     * @param user- пользователь
     * @return List<Account>- список счетов
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}