package org.yuyuan.datastructure.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SinglyLinkedListTest {


    @Test
    void addFirst() {
    }

    @Test
    void loop() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);

        System.out.println("使用方法引用、循环遍历元素");
        list.loop(System.out::println);

        System.out.println("实现迭代器接口、使用增强for循环遍历元素");
        for(Integer value : list) System.out.println(value);
     }

    private static SinglyLinkedList getIntegersList() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        return list;
    }

    @Test
    void addLast() {
        SinglyLinkedList list = getIntegersList();
        list.addLast(5);

        Assertions.assertIterableEquals(List.of(1,2,3,4,5), list);
    }

    @Test
    void get() {
        SinglyLinkedList list = getIntegersList();

        assertEquals(1,list.get(0));
        assertEquals(2,list.get(1));
        assertEquals(3,list.get(2));
        assertEquals(4,list.get(3));
    }

    @Test
    void insert() {
        SinglyLinkedList list = getIntegersList();
        System.out.println("插入元素前的链表：");
        list.loop(System.out::println);

        list.insert(2,999);
        assertEquals(999,list.get(2));
        System.out.println("插入元素后的链表：");
        for (Integer value : list) {
            System.out.println(value);
        }
    }

    @Test
    void removeFirst() {
        SinglyLinkedList list = getIntegersList();

        list.removeFirst();
        list.loop(System.out::println);
    }

    @Test
    void Remove() {
        SinglyLinkedList list = getIntegersList();

        // 删除非法下标的元素
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.remove(5));

        list.remove(2);// 2位置的元素是3

        Assertions.assertIterableEquals(List.of(1,2,4), list);
    }
}