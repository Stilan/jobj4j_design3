package ru.job4j.collection;

import java.util.Queue;

public class SimpleQueue<T> {
    private final SimpleStack<T> input = new SimpleStack<>();
    private final SimpleStack<T> output = new SimpleStack<>();

    /* добавьте переменные, если они требуются */

    public T poll() {
        if (output.getInp() == 0) {
            while (input.getInp() > 0) {
                output.push(input.pop());
            }
        }
        return output.pop();
    }

    public void push(T value) {
        input.push(value);
    }
}
