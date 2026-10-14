package org.yuyuan.datastructure.list;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

class LoopListTest {

    private LoopList.Node node(int val, LoopList.Node next) {
        return new LoopList.Node(val, next);
    }

    @Test
    @DisplayName("测试含环链表返回入环节点")
    void withLoop() {
        // 1 -> 2 -> 3 -> 4 -> 5 ->(回到)3，入环节点为 3
        LoopList.Node n5 = node(5, null);
        LoopList.Node n4 = node(4, n5);
        LoopList.Node n3 = node(3, n4);
        LoopList.Node n2 = node(2, n3);
        LoopList.Node n1 = node(1, n2);
        n5.next = n3;

        LoopList loopList = new LoopList();
        assertSame(n3, loopList.getLoopNode(n1));
    }

    @Test
    @DisplayName("测试无环链表返回 null")
    void withoutLoop() {
        LoopList.Node n5 = node(5, null);
        LoopList.Node n4 = node(4, n5);
        LoopList.Node n3 = node(3, n4);
        LoopList.Node n2 = node(2, n3);
        LoopList.Node n1 = node(1, n2);

        LoopList loopList = new LoopList();
        assertNull(loopList.getLoopNode(n1));
    }

    @Test
    @DisplayName("测试长度不足或空链表返回 null")
    void tooShort() {
        LoopList loopList = new LoopList();
        assertNull(loopList.getLoopNode(null));
        // 长度 1
        assertNull(loopList.getLoopNode(node(1, null)));
        // 长度 2
        assertNull(loopList.getLoopNode(node(1, node(2, null))));
    }
}
