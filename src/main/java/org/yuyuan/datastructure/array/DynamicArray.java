package org.yuyuan.datastructure.array;

/**
 * 动态数组
 */
public class DynamicArray {
    private int[] array = {};
    private int size = 0;
    private int capacity = 8;

    /**
     * 向数组末尾添加元素
     *
     * @param value 待添加的元素
     */
    public void addLast(int value) {
        add(value, size);
    }

    /**
     * 向 index 位置 添加元素 value
     *
     * @param value 待添加的元素
     * @param index 待添加元素的位置
     */
    public void add(int value, int index) {
        initArray();
        checkParam(index);
        if (size == capacity) {
            expansion();
        }
        // 添加value到指定位置
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value;
        size++;
    }

    /**
     * 删除指定位置的元素
     * @param i 指定的位置
     */
    public void remove(int i) {
        checkParam(i);
        for (int j = i; j < size - 1; j++) {
            // 后移元素
            array[j] = array[j + 1];
        }
        size--;
    }

    private void initArray() {
        if (size == 0) {
            array = new int[capacity];
        }
    }

    private void expansion() {
        /**
         * 数组增长因子
         */
        int increment = 2;
        capacity *= increment;
        int[] newArray = new int[capacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    /**
     * 获取指定位置的元素
     *
     * @param index 指定的位置
     * @return 获取到的元素
     */
    public int get(int index) {
        checkParam(index);
        return array[index];
    }

    private void checkParam(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index out of bounds");
        }
    }

    /**
     * 获取数组大小
     *
     * @return 数组大小
     */
    public int size() {
        return size;
    }

}
