package ru.job4j.collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Iterator;
import java.util.LinkedList;

class SimpleLinkedListTest {

    private SimpleLinked<Integer> list;

    @BeforeEach
    public void initData() {
        list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
    }

    @Test
    void checkIteratorSimple() {
        assertThat(list).hasSize(2);
        list.add(3);
        list.add(4);
        assertThat(list).hasSize(4);
    }

    @Test
    void whenAddAndGet() {
        list.add(3);
        list.add(4);
        assertThat(list.get(0)).isEqualTo(1);
        assertThat(list.get(1)).isEqualTo(2);
        assertThat(list.get(2)).isEqualTo(3);
        assertThat(list.get(3)).isEqualTo(4);
    }

    @Test
    void whenGetFromOutOfBoundThenExceptionThrown() {
        assertThatThrownBy(() -> list.get(2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddIterHasNextTrue() {
        Iterator<Integer> iterator = list.iterator();
        assertThat(iterator.hasNext()).isTrue();
    }

    @Test
    void whenAddIterNextOne() {
        Iterator<Integer> iterator = list.iterator();
        assertThat(iterator.next()).isEqualTo(1);
    }

//    @Test
//    void whenEmptyIterHashNextFalse() {
//        LinkedList<Integer> list = new SimpleLinkedList<>();
//        Iterator<Integer> iterator = list.iterator();
//        assertThat(iterator.hasNext()).isFalse();
//    }

    @Test
    void whenAddIterMultiHasNextTrue() {
        Iterator<Integer> iterator = list.iterator();
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.hasNext()).isTrue();
    }

    @Test
    void whenAddIterNextOneNextTwo() {
        Iterator<Integer> iterator = list.iterator();
        assertThat(iterator.next()).isEqualTo(1);
        assertThat(iterator.next()).isEqualTo(2);
    }

    @Test
    void whenGetIteratorTwiceThenEveryFromBegin() {
        Iterator<Integer> first = list.iterator();
        assertThat(first.hasNext()).isTrue();
        assertThat(first.next()).isEqualTo(1);
        assertThat(first.hasNext()).isTrue();
        assertThat(first.next()).isEqualTo(2);
        assertThat(first.hasNext()).isFalse();
        Iterator<Integer> second = list.iterator();
        assertThat(second.hasNext()).isTrue();
        assertThat(second.next()).isEqualTo(1);
        assertThat(second.hasNext()).isTrue();
        assertThat(second.next()).isEqualTo(2);
        assertThat(second.hasNext()).isFalse();
    }

    @Test
    void whenRemoveFirstThenSizeDecreasesAndHeadMoves() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        assertThat(list.remove(0)).isEqualTo(10);
        assertThat(list.get(0)).isEqualTo(20);
        assertThat(list.get(1)).isEqualTo(30);
        assertThat(list).hasSize(2);
    }

    @Test
    void whenRemoveMiddleThenNextLinksAreCorrect() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(100);
        list.add(200);
        list.add(300);

        assertThat(list.remove(1)).isEqualTo(200);
        assertThat(list.get(0)).isEqualTo(100);
        assertThat(list.get(1)).isEqualTo(300);
        assertThat(list).hasSize(2);
    }

    @Test
    void whenRemoveLastThenSecondLastNextBecomesNull() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertThat(list.remove(2)).isEqualTo(3);
        assertThat(list.get(0)).isEqualTo(1);
        assertThat(list.get(1)).isEqualTo(2);
        assertThat(list).hasSize(2);
    }

    @Test
    void whenRemoveFromEmptyThenThrowException() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        assertThatThrownBy(() -> list.remove(0))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenRemoveWithInvalidIndexThenThrowException() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(10);
        assertThatThrownBy(() -> list.remove(2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }
}