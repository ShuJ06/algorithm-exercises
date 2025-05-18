package org.yuyuan.datastructure.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CircularLinkedListTest {

    @Test
    void addFirst() {
        CircularLinkedList list = new CircularLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        list.loop(System.out::println);
        Assertions.assertIterableEquals(List.of(3,2,1), list);
    }

    @Test
    void addLast() {
        CircularLinkedList list = new CircularLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        Assertions.assertIterableEquals(List.of(1,2,3), list);
    }

    @Test
    void insert() {
        CircularLinkedList list = new CircularLinkedList();
        list.insert(0, 1);
        list.insert(1, 2);
        list.insert(2, 3);

        Assertions.assertIterableEquals(List.of(1,2,3), list);
    }

    @Test
    void removeFirst() {
        CircularLinkedList list = new CircularLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);


        list.removeFirst();
        Assertions.assertIterableEquals(List.of(2,1), list);
    }

    @Test
    void removeLast() {
        CircularLinkedList list = new CircularLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        list.removeLast();
        Assertions.assertIterableEquals(List.of(3,2), list);
    }

    @Test
    void removeByValue() {
        CircularLinkedList list = new CircularLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        list.removeByValue(2);
        Assertions.assertIterableEquals(List.of(3,1), list);
    }

    @Test
    void get() {
        CircularLinkedList list = new CircularLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        assertEquals(1, list.get(2));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(0));
    }
}