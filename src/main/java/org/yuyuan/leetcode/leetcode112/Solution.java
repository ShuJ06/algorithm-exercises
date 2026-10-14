package org.yuyuan.leetcode.leetcode112;

class Solution {

    // 1. 暴力枚举
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }


        n = climbStairs(n - 1) + climbStairs(n - 2);


        return n;
    }

    // 2. 自底向上
    public int climbStairs1(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int prev2 = 1;
        int prev1 = 2;
        int current = 0;

        // 从第3个台阶开始，一直算到第n个台阶
        for (int i = 3; i <= n; i++) {
            current = prev1 + prev2; // 当前台阶 = 前一个台阶 + 前两个台阶
            prev2 = prev1;           // 更新前两个台阶的值
            prev1 = current;         // 更新前一个台阶的值
        }

        return current;
    }

}