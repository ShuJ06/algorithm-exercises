package org.yuyuan.datastructure.list;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 单向链表
 */
public class SinglyLinkedList implements Iterable<Integer> {
    private Node head = null;

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            Node p = head;

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

    /**
     * 向列表头增加元素
     *
     * @param value value
     */
    public void addFirst(int value) {
        head = new Node(value, head);
    }

    /**
     * 查找最后一个节点
     *
     * @return last node
     */
    public Node findLast() {
        if (head == null) {
            return null;
        }

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
        if (last == null) {
            addFirst(value);
            return;
        }

        last.next = new Node(value, null);
    }

    /**
     * 向指定index位置插入值
     * @param index 插入位置
     * @param value 待插入的值
     */
    public void insert(int index, int value) {
        if (index ==0) {
            addFirst(value);
            return;
        }
        Node prev = findNode(index -1);
        if (prev == null) {
            throw new IndexOutOfBoundsException();
        }
        prev.next = new Node (value ,prev.next);
    }

    /**
     * 删除第一个节点
     */
    public void removeFirst() {
        if(head == null) {
            throw new IllegalArgumentException();
        }
        head = head.next;
    }

    /**
     * 删除指定index位置的节点
     * @param index index
     */
    public void remove(int index) {
        if(index == 0) {
            removeFirst();
            return;
        }

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

    /**
     * 遍历
     *
     * @param consumer consumer
     */
    public void loop(Consumer<Integer> consumer) {
        Node p = head;
        while (p != null) {
            consumer.accept(p.value);
            p = p.next;
        }
    }

    private Node findNode(int index) {
        if (index < 0) {
            throw new IllegalArgumentException();
        }

        int i = 0;
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
}
