package ru.job4j.files;

import java.util.NoSuchElementException;

public class MiniScanner {

    private String[] date;
    private int i;

    public MiniScanner(String str) {
        if (str == null || str.trim().isEmpty()) {
            date = new String[0];
        } else {
            date = str.trim().split("\\s+");
        }
    }

    public boolean hasNext() {
        return i < date.length;
    }

    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more tokens");
        }
        return date[i++];
    }

    public static void main(String[] args) {
        MiniScanner scanner = new MiniScanner("Привет как дела");
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
    }
}
