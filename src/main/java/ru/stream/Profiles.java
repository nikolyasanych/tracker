package ru.stream;

import java.util.List;

public class Profiles {

    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(profile -> profile.getAddress())
                .toList();
    }

    public static List<Address> collectSortWithoutDuplicate(List<Profile> profiles) {
        return profiles.stream()
                .map(profile -> profile.getAddress())
                .distinct()
                .sorted((left, right) -> left.getCity().compareTo(right.getCity()))
                .toList();
    }
}