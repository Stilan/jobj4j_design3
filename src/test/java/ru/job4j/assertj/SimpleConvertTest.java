package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(list).hasSize(5)
                .contains("three")
                .containsOnly("first", "second", "three", "four", "five")
                .containsExactly("first", "second", "three", "four", "five")
                .containsExactlyInAnyOrder("first", "second", "three", "four", "five");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("first", "second", "three", "four", "five");
        assertThat(set).hasSize(5)
                .contains("three")
                .containsOnly("first", "second", "three", "four", "five")
                .containsExactlyInAnyOrder("first", "second", "three", "four", "five")
                .containsAnyOf("first1", "second2", "three", "four4", "five5")
                .doesNotContain("six", "seven");
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("first", "second", "three", "four", "five");
        assertThat(map).hasSize(5)
                .containsKeys("three")
                .containsValues(0, 1, 2, 3, 4)
                .doesNotContainKey("first1")
                .doesNotContainValue(8)
                .containsEntry("second", 1);
    }

    @Test
    void assertList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(list).first().isEqualTo("first");
        assertThat(list).element(0).isNotNull().isEqualTo("first");
        assertThat(list).startsWith("first", "second")
                .endsWith("four", "five");
    }

    @Test
    void assertSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("first", "second", "three", "four", "five");
        assertThat(set).size().isEqualTo(5);
    }

    @Test
    void assertMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("first", "second", "three", "four", "five");
        assertThat(map).size().isEqualTo(5);
    }
}