package org.yuyuan.algorithm.recursion.multi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HanoiTower {
    // 三根柱子：A 为源柱、B 为辅助柱、C 为目标柱；用 LinkedList 模拟栈，柱顶在 addLast/removeLast 一端
    private final LinkedList<Integer> towerA = new LinkedList<>();
    private final LinkedList<Integer> towerB = new LinkedList<>();
    private final LinkedList<Integer> towerC = new LinkedList<>();
    // 按执行顺序记录每一步移动，便于外部校验
    private final List<String> moves = new ArrayList<>();

    /**
     * 求解汉诺塔：把源柱 A 上的 n 个盘子借助辅助柱 B 全部移动到目标柱 C。
     *
     * @param n 盘子数量（n>=1，编号 1 最小、n 最大）
     * @return 按执行顺序记录的移动步骤列表，总步数为 2^n - 1
     */
    public List<String> solve(int n) {
        towerA.clear();
        towerB.clear();
        towerC.clear();
        moves.clear();
        init(n);
        move(n, 'A', 'C', 'B');
        return new ArrayList<>(moves);
    }

    /** 初始化：将 n 个盘子按从大到小压入源柱 A（栈尾即柱顶，为最小盘 1） */
    private void init(int n) {
        for (int i = n; i >= 1; i--) {
            towerA.addLast(i);
        }
    }

    /**
     * 递归核心：将 from 柱顶部的 n 个盘子借助 aux 移动到 to。
     * 三步走：先把上面 n-1 个盘子移到 aux，再把第 n 个盘子移到 to，最后把 aux 上的 n-1 个盘子移到 to。
     */
    private void move(int n, char from, char to, char aux) {
        if (n <= 0) {
            return;
        }
        move(n - 1, from, aux, to);
        // 搬运此时 from 柱顶的那一个盘子
        int disk = towerOf(from).removeLast();
        towerOf(to).addLast(disk);
        moves.add("Move disk " + disk + " from " + from + " to " + to);
        move(n - 1, aux, to, from);
    }

    private LinkedList<Integer> towerOf(char name) {
        switch (name) {
            case 'A':
                return towerA;
            case 'B':
                return towerB;
            default:
                return towerC;
        }
    }

    /** 返回源柱 A 当前状态（自柱底到柱顶），供测试/展示使用 */
    public List<Integer> getTowerA() {
        return new ArrayList<>(towerA);
    }

    /** 返回辅助柱 B 当前状态（自柱底到柱顶），供测试/展示使用 */
    public List<Integer> getTowerB() {
        return new ArrayList<>(towerB);
    }

    /** 返回目标柱 C 当前状态（自柱底到柱顶），供测试/展示使用 */
    public List<Integer> getTowerC() {
        return new ArrayList<>(towerC);
    }

    public static void main(String[] args) {
        HanoiTower hanoi = new HanoiTower();
        for (String step : hanoi.solve(3)) {
            System.out.println(step);
        }
        System.out.println("TowerC = " + hanoi.getTowerC());
    }
}
