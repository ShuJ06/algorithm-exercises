package org.yuyuan.datastructure.list;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 环形链表
 */
public class CircularLinkedList implements Iterable<Integer>{

    static class Node {
        public Node prev;
        public int value;
        public Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private final Node sentinel;

    public CircularLinkedList() {
        Node sentinel = new Node(null, Integer.MIN_VALUE, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;

        this.sentinel = sentinel;
    }

    /**
     * 向链表头部（sentinel.next）添加元素
     *
     * @param value 待添加的元素
     */
    public void addFirst(int value) {
        Node prev = sentinel;
        Node next = sentinel.next;

        Node node = new Node(prev, value, next);
        prev.next = node;
        next.prev = node;
    }

    /**
     * 向链表尾部（sentinel.prev）添加元素
     *
     * @param value 待添加的元素
     */
    public void addLast(int value) {
        Node last = sentinel.prev;

        Node node = new Node(last, value, sentinel);
        last.next = node;
        sentinel.prev = node;
    }

    /**
     * 向链表指定位置添加元素
     *
     * @param index 待添加元素的位置
     * @param value 待添加的元素
     */
    public void insert(int index, int value) {
        Node prev = sentinel;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node next = prev.next;
        Node node = new Node(prev, value, next);

        prev.next = node;
        next.prev = node;
    }

    /**
     * 删除链表头部（sentinel.next）元素
     */
    public void removeFirst() {
        Node first = sentinel.next;
        if(first == sentinel) {
            throw new IndexOutOfBoundsException();
        }

        Node next = first.next;

        next.prev = sentinel;
        sentinel.next = next;
    }

    /**
     * 删除链表尾部（sentinel.prev）元素
     */
    public void removeLast() {
        Node last = sentinel.prev;
        if(last == sentinel) {
            throw new IndexOutOfBoundsException();
        }

        Node prev = last.prev;
        prev.next = sentinel;
        sentinel.prev = prev;
    }

    public void removeByValue(int value) {
        Node node = findByValue(value);
        if (node == null || node == sentinel) {
            throw new IllegalArgumentException();
        }

        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private Node findByValue(int value) {
        Node p = sentinel.next;
        while (p != sentinel) {
            if (p.value == value) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    public int get(int index) {
        Node node = sentinel.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        if (node == sentinel) {
            throw new IndexOutOfBoundsException();
        }
        return node.value;
    }

    public void loop(Consumer<Integer> consumer) {
        Node p = sentinel.next;
        while (p != sentinel) {
            consumer.accept(p.value);
            p = p.next;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            Node p = sentinel.next;
            @Override
            public boolean hasNext() {
                return p != sentinel;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }
}
