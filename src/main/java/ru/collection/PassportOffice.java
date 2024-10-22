package ru.collection;

import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
    private Map<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        String passport = citizen.getPassport();
        if (citizens.containsKey(passport)) {
            return false;
        }
        citizens.put(passport, citizen);
        return true;
    }

    public Citizen get(String passport) {
        return citizens.get(passport);
    }
}

