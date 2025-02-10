package org.yuyuan.algorithm.binarysearch;

public class BinarySearch {

    /**
     * 二分查找基础版
     *
     * @param array  待查询数组
     * @param target 目标数
     * @return 查询到返回数组下标，未查询到返回-1
     */
    public static int binarySearchBasic(int[] array, int target) {
        int i = 0;
        int j = array.length - 1;

        // 问题1: 为什么是 i<=j 意味着区间内有未比较的元素, 而不是 i<j ?
        // i==j 意味着 i,j 它们指向的元素也会参与比较; i<j 只意味着 m 指向的元素参与比较
        while (i <= j) {

            // int mid = (i + j) / 2; // 获取中间值,自动取整并转换为int类型
            // 问题2: (i + j) / 2 有没有问题?
            // 存在大数的溢出问题,如果 i,j 很大的话, (i+j)/2 可能会溢出
            int mid = (i + j) >>> 1;

            if (target == array[mid]) {
                return mid;
            }

            if (target < array[mid]) {
                j = mid - 1;
            }

            if (array[mid] < target) {
                i = mid + 1;
            }
        }

        return -1;
    }

    /**
     * 二分查找修改版
     *
     * @param array  待查询数组
     * @param target 目标值
     * @return 查询到返回数组下标，未查询到返回-1
     */
    public static int binarySearchAlternative(int[] array, int target) {
        int i = 0;
        int j = array.length; // 边界条件修改

        while (i < j) {
            int mid = (i + j) >>> 1;

            if (target == array[mid]) {
                return mid;
            } else if (target < array[mid]) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return -1;
    }
}
