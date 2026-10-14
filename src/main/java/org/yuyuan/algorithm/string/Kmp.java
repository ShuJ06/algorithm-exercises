package org.yuyuan.algorithm.string;

public class Kmp {
    /**
     * 使用 KMP 算法查找模式串 b 在主串 a 中首次出现的位置。
     *
     * @param a 主串（被搜索的字符串）
     * @param b 模式串（要查找的字符串）
     * @return 模式串首次匹配时的起始下标；若不存在（或参数非法）则返回 -1
     */
    public static int getIndexOf(String a, String b) {
        // 参数校验：主串/模式串为空、模式串为空串、或主串长度小于模式串长度时无解
        if (a == null || b == null || b.isEmpty() || a.length() < b.length()) {
            return -1;
        }

        // 将字符串转为字符数组，便于按下标逐个比较
        char[] str1 = a.toCharArray();
        char[] str2 = b.toCharArray();
        int index_a = 0;   // 主串指针，只前进不回溯
        int index_b = 0;   // 模式串指针，失配时依据 next 数组回退
        // 预先构建模式串的 next 数组，记录各位置失配时模式串指针应回退到的下标
        int[] next = getNextArray(str2);

        // 主串与模式串指针均未越界时持续匹配
        while (index_a < str1.length && index_b < str2.length) {
            if (str1[index_a] == str2[index_b]) {
                // 当前字符匹配成功，两个指针同时右移
                index_a++;
                index_b++;
            } else if (next[index_b] == -1) {
                // 已回退到模式串起点仍失配，说明此处无法匹配，主串指针右移
                index_a++;
            } else {
                // 失配但仍有可回退位置，模式串指针按 next 跳转到下一个候选位置
                index_b = next[index_b];
            }
        }

        // 模式串指针走完全程表示匹配成功，返回起始下标；否则返回 -1
        return index_b == str2.length ? index_a - index_b : -1;
    }

    /**
     * 构建模式串的 next 数组（采用 next[0] = -1 的回退约定）。
     * next[i] 表示：当 str[i] 失配时，模式串指针应回退到的下标，
     * 其值等于子串 str[0..i-1] 的最长「相等真前缀与真后缀」长度。
     */
    public static int[] getNextArray(char[] str) {
        // 模式串只有一个字符时，无需回退，直接返回 [-1]
        if (str.length == 1) {
            return new int[]{-1};
        }

        int[] next_array = new int[str.length];
        next_array[0] = -1;
        next_array[1] = 0;

        int cn = 0; // 当前已匹配的相等真前缀长度，即下一个待比较的前缀字符下标
        int i = 2;
        while (i < str.length) {
            // i 位置的信息使用i-1位置的信息进行更新
            if (str[i - 1] == str[cn]) {
                // L64: L66 更为简洁的表达: next_array[i++] = ++cn;
                next_array[i] = cn + 1;
                i++;
                cn++;
            } else if (cn > 0) {
                // 不相等，模式串指针按 next 回退到更短的相等前后缀候选位置
                cn = next_array[cn];
            } else {
                next_array[i++] = 0;
            }
        }

        return next_array;
    }

}
