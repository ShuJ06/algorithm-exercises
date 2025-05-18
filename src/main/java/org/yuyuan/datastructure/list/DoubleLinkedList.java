package org.yuyuan.datastructure.list;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 双向链表（带哨兵）
 */
public class DoubleLinkedList implements Iterable<Integer>{
    static class Node {
        Node prev;
        int value;
        Node next;

        /**
         * 构造函数
         * @param prev 前一个节点
         * @param value 值
         * @param next 后一个节点
         */
        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private final Node head;// 头部哨兵
    private final Node tail;// 尾部哨兵

    public DoubleLinkedList() {
        head = new Node(null, Integer.MIN_VALUE, null);
        tail = new Node(head, Integer.MAX_VALUE, null);
        head.next = tail;
        tail.prev = head;
    }

    private Node findNode(int index) {
        int i = -1;
        Node p = head;
        while (p !=tail) {
            if (i == index) {
                return p;
            }
            p = p.next;
            i++;
        }
        return null;
    }

    /**
     * 在头部添加一个值
     *
     * @param value 待添加的值
     */
    public void addFirst(int value) {
        insert(0, value);
    }

    public void addLast(int value) {
        Node last = tail.prev;
        Node inserted = new Node(last, value, tail);
        tail.prev = inserted;
        last.next = inserted;
    }

    /**
     * 向指定index位置插入值
     *
     * @param index 插入位置
     * @param value 待插入的值
     */
    public void insert(int index, int value) {
        Node prev = findNode(index -1);
        if (prev == null) {
            throw new IndexOutOfBoundsException();
        }
        Node next = prev.next;

        Node node = new Node(prev, value, next);
        prev.next = node;
        next.prev = node;
    }

    /**
     * 删除头部元素
     */
    public void removeFirst() {
        remove(0);
    }

    /**
     * 删除尾部元素
     */
    public void removeLast() {
        Node removed = tail.prev;
        if(removed == head) {
            throw new IndexOutOfBoundsException();
        }
        Node prev = removed.prev;
        prev.next = tail;
        tail.prev = prev;
    }
    public void loop(Consumer<Integer> consumer) {
        Node p = head.next;
        while (p != tail) {
            consumer.accept(p.value);
            p = p.next;
        }
    }

    /**
     * 删除指定index位置的元素
     *
     * @param index index
     */
    public void remove(int index) {
        Node prev = findNode(index -1);
        if(prev == null) {
            throw new IndexOutOfBoundsException();
        }

        Node removed = prev.next;

        if(removed == tail) {
            throw new IndexOutOfBoundsException();
        }

        Node next = removed.next;

        prev.next = next;
        next.prev = prev;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            Node p = head.next;
            @Override
            public boolean hasNext() {
                return p != tail;
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
