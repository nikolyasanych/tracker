package ru.inheritance;

public class JSONReport extends TextReport {
    @Override
    public String generate(String name, String body) {
        String transfer = System.lineSeparator();
        return "{" + transfer
                + "\t\"name\" : \"" + name + "\","
                + transfer
                + "\t\"body\" : \"" + body + "\""
                + transfer
                + "}";
    }
}
