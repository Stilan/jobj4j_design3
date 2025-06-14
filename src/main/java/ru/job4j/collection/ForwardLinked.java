package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ForwardLinked<E> implements Iterable<E> {
    private int size;
    private int modCount;
    private Node<E> head;

    public void add(E value) {
        Node<E> newNode = new Node<>(value, null);
        if (this.head == null) {
            this.head = newNode;
        } else {
            Node<E> cup = this.head;
            while (cup.next != null) {
                cup = cup.next;
            }
            cup.next = newNode;
        }
        size++;
        modCount++;
    }

    public void addFirst(E value) {
        Node<E> newNode = new Node<>(value, null);
        if (this.head == null) {
            this.head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
        modCount++;
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.item;
    }

    public E deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException("Queue is empty");
        }
        E e = head.item;
        head = head.next;
        size--;
        modCount++;
        return e;
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {
            int expectedModCount = modCount;
            int anInt = 0;
            Node<E> node = head;
            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return anInt < size;
            }

            @Override
            public E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E e = node.item;
                node = node.next;
                anInt++;
                return e;
            }
        };
    }

    private static class Node<E> {
        private E item;
        private Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }
}
