package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NameLoadTest {

    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void checkSymbolIsNot() {
        NameLoad nameLoad = new NameLoad();
        String[] strings = {"keyvalue", "key1value1", "key2=value2"};
        assertThatThrownBy(() -> nameLoad.parse(strings))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(strings[0])
                .hasMessageContaining("contain the symbol");
    }

    @Test
    void checkKeyIsNot() {
        NameLoad nameLoad = new NameLoad();
        String[] strings = {"=key=value", "key1value1", "key2=value2"};
        assertThatThrownBy(() -> nameLoad.parse(strings))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(strings[0])
                .hasMessageContaining("contain a key");
    }

    @Test
    void checkValueIsNot() {
        NameLoad nameLoad = new NameLoad();
        String[] strings = {"keyvalue=", "key1value1", "key2=value2"};
        assertThatThrownBy(() -> nameLoad.parse(strings))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(strings[0])
                .hasMessageContaining("contain a value");
    }

    @Test
    void checkParseEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Names array is empty");
    }
}