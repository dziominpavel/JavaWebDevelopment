package by.dziomin.task3.entity;

import by.dziomin.task3.compostite.impl.Leaf;

public class Letter extends Leaf {
    private char letter;

    public Letter(final char newLetter) {
        letter = newLetter;
    }

    public char getLetter() {
        return letter;
    }
}
