package ru.job4j.collection;

public class SimpleStack<T> {

    private ForwardLinked<T> linked = new ForwardLinked<T>();
    private int inp;

    public T pop() {
        inp--;
        return linked.deleteFirst();
    }

    public void push(T value) {
         linked.addFirst(value);
         inp++;
    }

    public int getInp() {
        return inp;
    }

}
