package org.yuyuan.datastructure.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class DoubleLinkedListSentinelTest {

    @Test
    void addFirst() {
        DoubleLinkedListSentinel list = new DoubleLinkedListSentinel();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        list.loop(System.out::println);
        Assertions.assertIterableEquals(List.of(3,2,1), list);
    }

    @Test
    void addLast() {
        DoubleLinkedListSentinel list = new DoubleLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        list.loop(System.out::println);
        Assertions.assertIterableEquals(List.of(1,2,3), list);
    }

    @Test
    void insert() {
        DoubleLinkedListSentinel list = new DoubleLinkedListSentinel();
        list.insert(0, 1);
        list.insert(1, 2);
        list.insert(2, 3);

        Assertions.assertIterableEquals(List.of(1,2,3), list);
    }

    @Test
    void removeFirst() {
        DoubleLinkedListSentinel list = new DoubleLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        list.removeFirst();
        Assertions.assertIterableEquals(List.of(2,3), list);
    }

    @Test
    void removeLast() {
        DoubleLinkedListSentinel list = new DoubleLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        list.removeLast();
        Assertions.assertIterableEquals(List.of(1,2), list);
    }

    @Test
    void remove() {
        DoubleLinkedListSentinel list = new DoubleLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        list.remove(1);
        Assertions.assertIterableEquals(List.of(1,3), list);
    }
}