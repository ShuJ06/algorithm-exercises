package org.yuyuan.algorithm.binarysearch;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {

    @Test
    @DisplayName("测试 binarySearchBasic")
    void binarySearchBasic() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertEquals(0, BinarySearch.binarySearchBasic(array, 1));
        assertEquals(1, BinarySearch.binarySearchBasic(array, 2));
        assertEquals(2, BinarySearch.binarySearchBasic(array, 3));
        assertEquals(9, BinarySearch.binarySearchBasic(array, 10));
        assertEquals(-1, BinarySearch.binarySearchBasic(array, 11));
    }

    @Test
    @DisplayName("测试 binarySearchAlternative")
    void binarySearchAlternative() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertEquals(0, BinarySearch.binarySearchAlternative(array, 1));
        assertEquals(1, BinarySearch.binarySearchAlternative(array, 2));
        assertEquals(2, BinarySearch.binarySearchAlternative(array, 3));
        assertEquals(9, BinarySearch.binarySearchAlternative(array, 10));
        assertEquals(-1, BinarySearch.binarySearchAlternative(array, 11));
    }

    @Test
    @DisplayName("测试 binarySearchRight")
    void binarySearchBalanced() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertEquals(0, BinarySearch.binarySearchBalanced(array, 1));
        assertEquals(1, BinarySearch.binarySearchBalanced(array, 2));

        assertEquals(-1, BinarySearch.binarySearchBalanced(array, 11));
        Supplier<Double> supplier1 = Math::random;
        Supplier<Double> supplier2 = () -> Math.random();
    }

    @Test
    @DisplayName("测试 binarySearchLeftMost")
    void binarySearchLeftMost() {
        // 返回target出现的第一个位置
        int[] array = {1, 2, 3, 3, 4, 5};
        assertEquals(0, BinarySearch.binarySearchLeftMost(array, 1));
        assertEquals(1, BinarySearch.binarySearchLeftMost(array, 2));

        assertEquals(2, BinarySearch.binarySearchLeftMost(array, 3));

        assertEquals(4, BinarySearch.binarySearchLeftMost(array, 4));
        assertEquals(5, BinarySearch.binarySearchLeftMost(array, 5));
        assertEquals(-1, BinarySearch.binarySearchLeftMost(array, 6));
    }

    @Test
    @DisplayName("测试 binarySearchRightMost")
    void binarySearchRightMost() {
        // 返回target出现的最后一个位置
        int[] array = {1, 2, 3, 3, 3, 4, 5};
        assertEquals(0, BinarySearch.binarySearchRightMost(array, 1));
        assertEquals(1, BinarySearch.binarySearchRightMost(array, 2));
        assertEquals(4, BinarySearch.binarySearchRightMost(array, 3));

        assertEquals(6, BinarySearch.binarySearchRightMost(array, 6));
    }
}