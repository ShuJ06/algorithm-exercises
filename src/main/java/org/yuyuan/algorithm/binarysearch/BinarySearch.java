package org.yuyuan.algorithm.binarysearch;

public class BinarySearch {

    /**
     * 二分查找基础版
     *
     * @param array  待查询数组
     * @param target 目标数组
     * @return 查询到返回数组下标，未查询到返回-1
     */
    public static int binarySearchBasic(int[] array, int target) {
        int i = 0;
        int j = array.length - 1;

        while (i <= j) {
            int mid = (i + j) / 2; // 获取中间值,自动取整并转换为int类型

            if (target == array[mid]) {
                return mid;
            }

            if (target < array[mid]) {
                j = mid - 1;
            }

            if (target > array[mid]) {
                i = mid + 1;
            }
        }

        return -1;
    }
}
