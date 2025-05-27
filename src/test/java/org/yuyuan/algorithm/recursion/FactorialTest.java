package org.yuyuan.algorithm.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @Test
    void factorial() {
        assertEquals(1, Factorial.factorial(0));
        assertEquals(1, Factorial.factorial(1));
        assertEquals(2, Factorial.factorial(2));
        assertEquals(6, Factorial.factorial(3));
        assertEquals(24, Factorial.factorial(4));
        assertEquals(120, Factorial.factorial(5));
    }

    @Test
    void revertString() {
        Factorial.revertString(0,"!dlroW olleH");
    }

    @Test
    void binarySearch() {
        int[] arr = {1,2,3,4,5,6,7,8};

        assertEquals(0, Factorial.binarySearch(arr,1));
        assertEquals(1, Factorial.binarySearch(arr,2));
        assertEquals(2, Factorial.binarySearch(arr,3));

        assertEquals(-1, Factorial.binarySearch(arr,321));
    }

    @Test
    void bubbleSort() {
        int[] arr = {5,4,3,2,1};
        int[] expected = {1,2,3,4,5};
        Factorial.bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }
}