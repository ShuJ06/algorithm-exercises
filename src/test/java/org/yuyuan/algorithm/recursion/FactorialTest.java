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

    @Test
    void fibonacci() {
        assertEquals(0, Factorial.fibonacci(0));
        assertEquals(1, Factorial.fibonacci(1));
        assertEquals(1, Factorial.fibonacci(2));
        assertEquals(2, Factorial.fibonacci(3));
        assertEquals(3, Factorial.fibonacci(4));
        assertEquals(5, Factorial.fibonacci(5));
        assertEquals(8, Factorial.fibonacci(6));
        assertEquals(13, Factorial.fibonacci(7));
    }

    @Test
    void fibonacciWithMemo() {
        assertEquals(13, Factorial.fibonacciWithMemo(7));
        assertEquals(21, Factorial.fibonacciWithMemo(8));
        assertEquals(34, Factorial.fibonacciWithMemo(9));
        assertEquals(55, Factorial.fibonacciWithMemo(10));
        assertEquals(89, Factorial.fibonacciWithMemo(11));
        assertEquals(144, Factorial.fibonacciWithMemo(12));
    }
}