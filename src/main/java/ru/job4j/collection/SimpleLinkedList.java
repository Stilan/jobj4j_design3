package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements SimpleLinked<E> {

    private int size;
    private int modCount;
    private Node<E> head;

    @Override
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

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.item;
    }

    public E remove(int index) {
        Objects.checkIndex(index, size);
        E e;
        if (index == 0) {
            e = head.item;
            this.head = this.head.next;
        } else {
            Node<E> node = this.head;
            for (int i = 0; i < index - 1; i++) {
                node = node.next;
            }
            Node<E> cup = node.next;
            e = cup.item;
            node.next = cup.next;
        }
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