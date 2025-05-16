package org.yuyuan.datastructure.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicArrayTest {

    @Test
    void add() {
        DynamicArray dynamicArray = new DynamicArray();
        for (int i = 0; i < 100; i++) {
            dynamicArray.add(100 - i, i);
            // 测试添加
            assertEquals(100 - i, dynamicArray.get(i));
            // 测试扩容
            assertEquals(i + 1, dynamicArray.size());
        }
        for (int i = 0; i < 100; i++) {
            // 测试删除
            dynamicArray.remove(i);
            assertEquals(100 - i - 1, dynamicArray.get(i));
            // 测试删除
            assertEquals(100 - i - 1, dynamicArray.size());
        }
    }

    @Test
    void addLast() {
        DynamicArray dynamicArray = new DynamicArray();
        for (int i = 0; i < 100; i++) {
            dynamicArray.addLast(i);
            // 测试添加
            assertEquals(i, dynamicArray.get(i));
            // 测试扩容
            assertEquals(i + 1, dynamicArray.size());
        }
        int curSize = dynamicArray.size();
        for (int index = curSize - 1; index >= 0; index--) {
            // 测试删除
            dynamicArray.remove(index);
            assertEquals(index, dynamicArray.get(index));
            // 测试删除
            assertEquals(index, dynamicArray.size());
        }
    }
}