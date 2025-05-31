package ru.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список пользователей, которые прошли проверку.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> phonePredicate = person -> person.getPhone().contains(key);
        Predicate<Person> namePredicate = person -> person.getName().contains(key);
        Predicate<Person> surnamePredicate = person -> person.getSurname().contains(key);
        Predicate<Person> addressPredicate = person -> person.getAddress().contains(key);
        Predicate<Person> predicate = phonePredicate.or(namePredicate.or(surnamePredicate.or(addressPredicate)));
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (predicate.test(person)) {
                result.add(person);
            }
        }
        return result;
    }

}
