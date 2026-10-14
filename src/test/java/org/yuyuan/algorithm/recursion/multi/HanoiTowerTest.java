package org.yuyuan.algorithm.recursion.multi;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HanoiTowerTest {

    @Test
    @DisplayName("测试单盘：直接 A 到 C，共 1 步")
    void oneDisk() {
        HanoiTower hanoi = new HanoiTower();
        List<String> moves = hanoi.solve(1);
        assertEquals(List.of("Move disk 1 from A to C"), moves);
        assertEquals(List.of(1), hanoi.getTowerC());
        assertTrue(hanoi.getTowerA().isEmpty());
        assertTrue(hanoi.getTowerB().isEmpty());
    }

    @Test
    @DisplayName("测试两步移动序列与最终柱态")
    void twoDisks() {
        HanoiTower hanoi = new HanoiTower();
        List<String> moves = hanoi.solve(2);
        assertEquals(List.of(
                "Move disk 1 from A to B",
                "Move disk 2 from A to C",
                "Move disk 1 from B to C"), moves);
        // 目标柱自底到顶应为 [2, 1]
        assertEquals(List.of(2, 1), hanoi.getTowerC());
    }

    @Test
    @DisplayName("测试 n 盘总步数为 2^n - 1 且全部落到目标柱")
    void threeDisks() {
        HanoiTower hanoi = new HanoiTower();
        List<String> moves = hanoi.solve(3);
        assertEquals((1 << 3) - 1, moves.size()); // 7 步
        assertEquals(List.of(3, 2, 1), hanoi.getTowerC());
        assertTrue(hanoi.getTowerA().isEmpty());
        assertTrue(hanoi.getTowerB().isEmpty());
    }
}
