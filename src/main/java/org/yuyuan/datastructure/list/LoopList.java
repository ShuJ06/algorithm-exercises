package org.yuyuan.datastructure.list;

public class LoopList {
    public static class Node {
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    // 在链表中寻找第一个入环节点，找不到返回null
    public Node getLoopNode(Node head) {
        // 长度3以内的排除
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }

        // 定义慢快指针
        Node slow_p = head.next;
        Node fast_p = head.next.next;

        while (slow_p != fast_p) {
            // 确保快指针不会空指针
            if (fast_p.next == null || fast_p.next.next == null) {
                return null;
            }
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;
        }

        // 当快慢指针相遇时，快指针指向头结点，然后步进1
        fast_p = head;
        while (slow_p != fast_p) {
            slow_p = slow_p.next;
            fast_p = fast_p.next;
        }

        return slow_p;
    }
}
