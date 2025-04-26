package ru.job4j.assertj;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Tetrahedron");
    }

    @Test
    void isThisVertices() {
        Box box = new Box(4, 10);
        int vertex = box.getNumberOfVertices();
        assertThat(vertex).isNotZero()
                .isPositive()
                .isEven()
                .isGreaterThan(3)
                .isLessThan(5)
                .isEqualTo(4);
    }

    @Test
    void isThisVerticesUnknownObject() {
        Box box = new Box(2, 10);
        String name = box.whatsThis();
        int vertex = box.getNumberOfVertices();
        assertThat(name).isEqualTo("Unknown object");
        assertThat(vertex).isNotZero()
                .isEqualTo(-1);
    }

    @Test
    void isExistVerticeNot() {
        Box box = new Box(2, 10);
        boolean exist = box.isExist();
        assertThat(exist).isFalse();
    }

    @Test
    void isExistVerticeYes() {
        Box box = new Box(4, 10);
        boolean exist = box.isExist();
        assertThat(exist).isTrue();
    }

    @Test
    void whenAreaTetrahedron() {
        Box box = new Box(4, 10);
        double area = box.getArea();
        assertThat(area).isEqualTo(173.20d, withPrecision(0.06d))
                .isCloseTo(173.2d, withPrecision(0.6d))
                .isCloseTo(173.20d, Percentage.withPercentage(1.0d))
                .isGreaterThan(173.20d)
                .isLessThan(173.21d);
    }

    @Test
    void whenAreaSphere() {
        Box box = new Box(0, 10);
        double area = box.getArea();
        assertThat(area).isEqualTo(1256.63d, withPrecision(0.06d))
                .isCloseTo(1256.6d, withPrecision(0.1d))
                .isCloseTo(1256.63d, Percentage.withPercentage(1.0d))
                .isGreaterThan(1256.63d)
                .isLessThan(1256.64d);
    }


}