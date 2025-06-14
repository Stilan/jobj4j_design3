package ru.job4j.iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

class ListUtilsTestTest {

    private List<Integer> input;

    @BeforeEach
    void setUp() {
        input = new ArrayList<>(Arrays.asList(1, 3));
    }

    @Test
    void whenAddBefore() {
        ListUtils.addBefore(input, 1, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddBeforeWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddAfter() {
        ListUtils.addAfter(input, 0, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenRemoveIfEven() {
        input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ListUtils.removeIf(input, n -> n % 2 == 0);
        assertThat(input).containsExactly(1, 3, 5);
    }

    @Test
    void whenRemoveIfAllMatch() {
        input = new ArrayList<>(Arrays.asList(10, 20, 30));
        ListUtils.removeIf(input, n -> n > 0);
        assertThat(input).isEmpty();
    }

    @Test
    void whenReplaceIfGreaterThanTwo() {
        input = new ArrayList<>(Arrays.asList(1, 3, 4));
        ListUtils.replaceIf(input, n -> n > 2, 99);
        assertThat(input).containsExactly(1, 99, 99);
    }

    @Test
    void whenReplaceIfNoneMatch() {
        input = new ArrayList<>(Arrays.asList(1, 2));
        ListUtils.replaceIf(input, n -> n > 5, 99);
        assertThat(input).containsExactly(1, 2);
    }

    @Test
    void whenRemoveAllMatchingElements() {
        input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> toRemove = Arrays.asList(2, 4);
        ListUtils.removeAll(input, toRemove);
        assertThat(input).containsExactly(1, 3, 5);
    }

    @Test
    void whenRemoveAllEmptyTargetList() {
        input = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> toRemove = Collections.emptyList();
        ListUtils.removeAll(input, toRemove);
        assertThat(input).containsExactly(1, 2, 3);
    }

    @Test
    void whenRemoveAllWithDuplicatesInElements() {
        input = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 4));
        List<Integer> toRemove = Arrays.asList(2, 2);
        ListUtils.removeAll(input, toRemove);
        assertThat(input).containsExactly(1, 3, 4);
    }

}