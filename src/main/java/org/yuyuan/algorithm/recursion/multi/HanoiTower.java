package org.yuyuan.algorithm.recursion.multi;

import java.util.LinkedList;

public class HanoiTower {
    private static LinkedList<Integer> towerA = new LinkedList<>();
    private static LinkedList<Integer> towerB = new LinkedList<>();
    private static LinkedList<Integer> towerC = new LinkedList<>();

    private static void init(int n) {
        for (int i = n; i >=1 ; i--) {
            towerA.addLast(i);
        }
    }

    public static void main(String[] args) {
        init(3);
        System.out.println(towerA);
    }
}
