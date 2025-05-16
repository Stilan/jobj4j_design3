package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Balancer {
    public static void split(List<ArrayList<Integer>> nodes, Iterator<Integer> source) {
        /* тут должна быть реализация */
        int total = 0;
        while (source.hasNext()) {
            if (total >= nodes.size()) {
                total = 0;
            }
            nodes.get(total).add(source.next());
            total++;
        }
    }
}
