package ru.job4j.iterator;

import java.util.Iterator;

public class ArrayIterator implements Iterator<Integer> {
    private final int[] data;
    private int point;

    public ArrayIterator(int[] data) {
        this.data = data;
        this.point = data.length;
    }

    @Override
    public boolean hasNext() {
        return point < data.length;
    }

    @Override
    public Integer next() {
        return data[point++];
    }
}
