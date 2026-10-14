package org.yuyuan.algorithm.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ManacherTest {

    @Test
    @DisplayName("测试奇数长度回文")
    void oddLengthPalindrome() {
        // "aba"、"abcba" 均为回文，长度分别为 3、5
        assertEquals(3, Manacher.getLcpsLength("aba"));
        assertEquals(5, Manacher.getLcpsLength("abcba"));
        assertEquals(3, Manacher.getLcpsLength("babad")); // "bab" 或 "aba"
    }

    @Test
    @DisplayName("测试偶数长度回文")
    void evenLengthPalindrome() {
        // "aa"、"abba" 为偶数回文，长度分别为 2、4
        assertEquals(2, Manacher.getLcpsLength("aa"));
        assertEquals(4, Manacher.getLcpsLength("abba"));
        assertEquals(2, Manacher.getLcpsLength("cbbd")); // "bb"
    }

    @Test
    @DisplayName("测试无重复回文（最长仅为单字符）")
    void noRepeatPalindrome() {
        assertEquals(1, Manacher.getLcpsLength("abcd"));
    }

    @Test
    @DisplayName("测试单字符")
    void singleChar() {
        assertEquals(1, Manacher.getLcpsLength("a"));
    }

    @Test
    @DisplayName("测试空串与 null")
    void emptyOrNull() {
        assertEquals(0, Manacher.getLcpsLength(""));
        assertEquals(0, Manacher.getLcpsLength(null));
    }

    @Test
    @DisplayName("测试全相同字符")
    void allSameChars() {
        assertEquals(5, Manacher.getLcpsLength("aaaaa"));
    }
}
