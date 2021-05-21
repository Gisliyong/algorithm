package com.list.learn;

/**
 * 给定两个可能无环的链表，实现如果相交返回第一个相交的结点，不相交返回null
 */

public class FindFirstIntersectNode {

    /**
     * 第一步
     * 判断一个链表是否存在环，如果存在返回第一个入环结点
     * 思路一：容器，利用hashset如果能走到null则无环
     * 思路二：
     * 准备快慢指针slow fast 从头开始走
     * 如果fast为空了，则肯定无环
     * 如果有环则肯定会相遇，当相遇的时候。fast指针回到头，他们一定会在第一个入环节点相遇
     */
    public static Node getLoopNode(Node head) {
        if (head == null  || head.next == null || head.next.next == null) {
            return null;
        }
        Node slow;
        Node fast;
        slow = head;
        fast = head.next.next;
        while (slow != fast) {
            if (fast == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     *  情况一：如果两个链表都无环
     *  分别遍历两个链表，如果结尾不等一定不相交。
     *  如果相交，长链表先走(自己长度 - 短链表长度),然后同时走第一个相等结点就是答案。
     */
    public static Node noLoop(Node head1, Node head2) {
        Node cur1;
        Node cur2;
        int n = 0;
        cur1 = head1;
        cur2 = head2;
        while (cur1.next != null) {
            cur1 = cur1.next;
            n++;
        }
        while (cur2.next != null) {
            cur2 = cur2.next;
            n--;
        }
        if (cur1 != cur2) return null;
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
    /**
     *  情况二：一个有环一个无环
     *  不可能相交
     */
    /**
     *  情况三：都有环
     *  1） 相互独立
     *  2） 两条链表入环结点相同
     *  3） 两条链表入环结点不同 （顺着指针向下走，回到自己都没找到第二个入环则不相交，否则返回任意一个结点即可）
     */
    // 两个有环链表，返回第一个相交节点，如果不想交返回null
    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }
    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }
    public static void main(String[] args) {

    }
}
