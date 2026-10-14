package org.yuyuan.algorithm.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class KmpTest {

    @Test
    @DisplayName("测试 next 数组构造")
    void nextArray() {
        // 单字符无需回退
        assertArrayEquals(new int[]{-1}, Kmp.getNextArray("a".toCharArray()));
        // "abcabab" 采用 next[0]=-1 约定，各位置回退下标为其最长相等真前后缀长度
        assertArrayEquals(new int[]{-1, 0, 0, 0, 1, 2, 1}, Kmp.getNextArray("abcabab".toCharArray()));
    }

    @Test
    @DisplayName("测试模式串存在于主串")
    void found() {
        assertEquals(6, Kmp.getIndexOf("hello world", "world"));
        assertEquals(1, Kmp.getIndexOf("abcabc", "bca"));
        assertEquals(0, Kmp.getIndexOf("aaaa", "aa"));
        assertEquals(8, Kmp.getIndexOf("ababcaababcabab", "abcabab"));
    }

    @Test
    @DisplayName("测试模式串不存在返回 -1")
    void notFound() {
        assertEquals(-1, Kmp.getIndexOf("abcdef", "xyz"));
        assertEquals(-1, Kmp.getIndexOf("ABABABABABABABABABABABAC", "ABABABC"));
    }

    @Test
    @DisplayName("测试非法参数返回 -1")
    void invalidParams() {
        assertEquals(-1, Kmp.getIndexOf(null, "x"));
        assertEquals(-1, Kmp.getIndexOf("abc", null));
        assertEquals(-1, Kmp.getIndexOf("abc", ""));
        // 主串长度小于模式串
        assertEquals(-1, Kmp.getIndexOf("ab", "abc"));
    }
}
