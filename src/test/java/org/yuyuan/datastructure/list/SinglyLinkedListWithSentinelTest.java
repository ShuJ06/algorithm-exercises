package org.yuyuan.datastructure.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class SinglyLinkedListWithSentinelTest {

    @Test
    void addFirst() {
        SinglyLinkedListWithSentinel list = new SinglyLinkedListWithSentinel();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        assertEquals(3, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(1, list.get(2));
    }

    @Test
    void insert() {
        SinglyLinkedListWithSentinel list = new SinglyLinkedListWithSentinel();
        list.insert(0, 1);
        list.insert(1, 2);
        list.insert(2, 3);

        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    void removeFirst() {
        SinglyLinkedListWithSentinel list = new SinglyLinkedListWithSentinel();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        list.removeFirst();
        Assertions.assertIterableEquals(List.of(2,1), list);
    }

    @Test
    void remove() {
        SinglyLinkedListWithSentinel list = new SinglyLinkedListWithSentinel();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        list.remove(1);
        Assertions.assertIterableEquals(List.of(3,1), list);
        assertThrows(IndexOutOfBoundsException.class, ()->list.remove(99));
    }

    @Test
    void loop() {
        SinglyLinkedListWithSentinel list = new SinglyLinkedListWithSentinel();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        list.loop(System.out::println);
    }

    @Test
    void addLast() {
        SinglyLinkedListWithSentinel list = new SinglyLinkedListWithSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    void get() {
        SinglyLinkedListWithSentinel list = new SinglyLinkedListWithSentinel();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        assertEquals(3, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(1, list.get(2));
    }
}