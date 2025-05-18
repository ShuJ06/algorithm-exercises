package org.yuyuan.datastructure.list;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 带哨兵单向链表
 */
public class SinglyLinkedListWithSentinel implements Iterable<Integer> {
      static class Node {
        public int value;
        public Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private final Node head = new Node(Integer.MAX_VALUE, null);

    /**
     * 向列表头增加元素
     *
     * @param value value
     */
    public void addFirst(int value) {
        insert(0, value);
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
        prev.next = new Node (value ,prev.next);
    }

    /**
     * 删除第一个节点
     *
     */
    public void removeFirst() {
        remove(0);
    }

    /**
     * 删除指定位置的节点
     *
     * @param index index
     */
    public void remove(int index) {
        Node prev = findNode(index -1);
        if(prev == null) {
            throw new IndexOutOfBoundsException();
        }
        Node removed = prev.next;
        if(removed == null) {
            throw new IndexOutOfBoundsException();
        }
        prev.next = removed.next;
    }

    private Node findLast() {
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        return p;
    }

    /**
     * 向列表末尾增加元素
     *
     * @param value value
     */
    public void addLast(int value) {
        Node last = findLast();
        last.next = new Node(value, null);
    }

    private Node findNode(int index) {
        // 头结点/哨兵节点的索引定为-1
        if (index < -1) {
            throw new IllegalArgumentException();
        }

        int i = -1;
        for (Node p = head; p != null; p = p.next, i++) {
            if (index == i) {
                return p;
            }
        }

        return null;
    }

    /**
     * 根据索引获取链表的值
     *
     * @param index index
     * @return int value
     */
    public int get(int index) {
        Node target = findNode(index);
        if (target == null) {
            throw new IndexOutOfBoundsException();
        }

        return target.value;
    }

    /**
     * 遍历
     *
     * @param consumer consumer
     */
    public void loop(Consumer<Integer> consumer) {
        Node p = head.next;
        while (p != null) {
            consumer.accept(p.value);
            p = p.next;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            Node p = head.next;

            @Override
            public boolean hasNext() {
                return p != null;
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
