package org.yuyuan.algorithm.recursion;

public class Factorial {
    /**
     * 使用递归求解阶乘
     *
     * @param n Integer number
     * @return n的阶乘
     */
    public static int factorial(int n) {
        if (n == 0)
            return 1;
        else
            return n * factorial(n - 1);
    }

    /**
     * 递归求解字符串的倒置
     *
     * @param str 字符串
     */
    public static void revertString(int n, String str) {
        if (n == str.length())
            return;
        revertString(n + 1, str);
        System.out.print(str.charAt(n));
    }

    public static int binarySearch(int[] arr, int target) {
        return find(arr, target, 0, arr.length - 1);
    }

    private static int find(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) >>> 1;
        if (target < arr[mid]) {
            return find(arr, target, start, mid - 1);
        } else if (arr[mid] < target) {
            return find(arr, target, mid + 1, end);
        } else {
            return mid;
        }
    }
    public static void bubbleSort(int[] arr) {
        bubble(arr, arr.length-1);
    }

    /**
     * 冒泡排序递归版
     *
     * @param arr 数组
     * @param n 未排序区域右边界
     */
    private static void bubble(int[] arr, int n) {
        if (n == 0) {
            return;
        }

        int edge = 0;// 有序与无序的边界
        // edge 记录了在本轮遍历中最后一次发生交换的索引位置，表示该位置之后的元素已经有序，无需再参与下一轮排序。
        for (int i = 0; i < n; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                edge = i;
            }
        }
        bubble(arr, edge);
    }

    /**
     * 求斐波那契数列第n项
     *
     * 多路递归
     */
    public static int fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
