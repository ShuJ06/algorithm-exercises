package org.yuyuan.algorithm.binarysearch;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}