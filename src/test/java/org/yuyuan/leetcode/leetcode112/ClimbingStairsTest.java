package org.yuyuan.leetcode.leetcode112;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClimbingStairsTest {

    // 斐波那契数列：f(1)=1, f(2)=2, f(n)=f(n-1)+f(n-2)
    private static final int[] EXPECTED = {0, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89};

    @Test
    @DisplayName("测试暴力递归解法")
    void climbStairs() {
        Solution solution = new Solution();
        for (int n = 1; n < EXPECTED.length; n++) {
            assertEquals(EXPECTED[n], solution.climbStairs(n), "n=" + n);
        }
    }

    @Test
    @DisplayName("测试自底向上迭代解法")
    void climbStairsIterative() {
        Solution solution = new Solution();
        for (int n = 1; n < EXPECTED.length; n++) {
            assertEquals(EXPECTED[n], solution.climbStairs1(n), "n=" + n);
        }
    }
}
