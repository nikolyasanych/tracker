package ru.queue;

import java.util.Deque;
import java.util.Iterator;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder str = new StringBuilder();
        Iterator<Character> iterator = evenElements.iterator();
        char symbol;
        for (int i = 0; iterator.hasNext(); i++) {
            symbol = iterator.next();
            if (i % 2 == 0) {
                str.append(symbol);
            }
        }
        return str.toString();
    }

    private String getDescendingElements() {
        StringBuilder str = new StringBuilder();
        Iterator<Character> iterator = descendingElements.descendingIterator();
        for (int i = 0; iterator.hasNext(); i++) {
            str.append(iterator.next());
        }
        return str.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
