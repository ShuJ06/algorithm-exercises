package org.yuyuan.algorithm.string;

public class Manacher {
    /**
     * Manacher（马拉车）算法：求字符串 s 的最长回文子串长度。
     * 时间复杂度 O(n)，通过「回文半径数组 + 最右回文边界」的对称性，
     * 让每个字符的扩展总体呈线性，避免了中心扩散法 O(n^2) 的重复比较。
     *
     * @param s 输入字符串
     * @return 最长回文子串的长度；s 为 null 或空串时返回 0
     */
    public static int getLcpsLength(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = manacherString(s); // "121" --> "#1#2#1#"
        int[] pArr = new int[str.length]; // 回文半径数组，pArr[i] 为以 i 为中心的回文半径

        int C = -1; // 当前能 reach 最右回文边界的中心位置
        int R = -1; // 右回文边界再右一个位置，最右的有效区域是R-1位置
        int max = Integer.MIN_VALUE; // 扩出来的最大回文半径

        // 对每个位置求回文半径
        for (int i = 0; i != str.length; i++) {
            // 1) 确定 i 处回文半径的起始值，尽量利用已知回文的对称性少做扩展
            //    若 i 在最右边界内(R>i)，它关于中心 C 的对称点为 2*C-i，
            //    可直接借用对称点的半径；但该回文可能被 C 的边界截断，故取 R-i 为上界，二者取小；
            //    若 i 越过了 R，则没有可借用的信息，从最小半径 1 开始
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;

            // 2) 从起始半径继续向两侧尝试扩展
            //    比较 i 左右对称位置(i+pArr[i] 与 i-pArr[i])的字符是否相等，相等则半径 +1；
            //    一旦两侧任一越界，或字符不等，说明回文到头，停止扩展
            while (i + pArr[i] < str.length && i - pArr[i] > -1
                    && str[i + pArr[i]] == str[i - pArr[i]]) {
                pArr[i]++;
            }

            // 3) 若以 i 为中心的回文右边界超过了当前最右边界 R，则更新 C、R
            //    让后续位置尽可能多地落在新的已知回文内，从而享受对称性加速
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }

            // 4) 用当前半径刷新全局最大回文半径
            max = Math.max(max, pArr[i]);
        }

        // 半径把插入的占位符 '#' 也计入，实际原串最长回文长度 = max - 1
        return max - 1;
    }

    private static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[2 * str.length() + 1];
        int index = 0;

        for (int i = 0; i != res.length; i++) {
            // 与运算(&)是逐位比较，1的二进制是 ...0001，只有最低位为1
            // 奇数最低位必为1，偶数最低位必为0，所以 & 1 就是"取最低位"
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }

        return res;
    }
}
