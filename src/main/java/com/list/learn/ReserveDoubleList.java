package com.list.learn;

import java.util.ArrayList;
import java.util.List;

public class ReserveDoubleList {
    public static DoubleNode reverList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
      }
        return pre;
    }
    public static DoubleNode logOfreverse(DoubleNode head) {
        if (head == null) {
            return null;
        }
        List<DoubleNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int len = list.size();
        list.get(0).next = null;
        DoubleNode pre = list.get(0);
        for (int i = 1; i < len ; i++) {
            DoubleNode cur = list.get(i);
            cur.pre = null;
            cur.next = pre;
            pre.pre = cur;
            pre = cur;
        }
        return list.get(len - 1);
    }
    public static DoubleNode generator(int maxvalue,int maxSize) {
        int size = (int) (Math.random() * (maxSize + 1));
        if (size == 0) {
            return null;
        }
        size--;
        DoubleNode head = new DoubleNode((int) (Math.random() * (maxvalue + 1)));
        DoubleNode pre = head;
        while (size != 0) {
            DoubleNode cur = new DoubleNode((int) (Math.random() * (maxvalue + 1)));
            pre.next = cur;
            cur.pre = pre;
            pre = cur;
            size--;
        }
        return head;
    }
    // 要求无环，有环别用这个函数
    public static boolean checkDoubleListEqual(DoubleNode head1, DoubleNode head2) {
        boolean null1 = head1 == null;
        boolean null2 = head2 == null;
        if (null1 && null2) {
            return true;
        }
        if (null1 ^ null2) {
            return false;
        }
        if (head1.pre != null || head2.pre != null) {
            return false;
        }
        DoubleNode end1 = null;
        DoubleNode end2 = null;
        while (head1 != null && head2 != null) {
            if (head1.value != head2.value) {
                return false;
            }
            end1 = head1;
            end2 = head2;
            head1 = head1.next;
            head2 = head2.next;
        }
        if (head1 != null || head2 != null) {
            return false;
        }
        while (end1 != null && end2 != null) {
            if (end1.value != end2.value) {
                return false;
            }
            end1 = end1.pre;
            end2 = end2.pre;
        }
        return end1 == null && end2 == null;
    }

    public static void main(String[] args) {
        int len = 50;
        int value = 100;
        int testTime = 100000;
        for (int i = 0; i < testTime; i++) {
            DoubleNode node2 = generator(len, value);
            DoubleNode reverse2 = reverList(node2);
            DoubleNode back2 = logOfreverse(reverse2);
            if (!checkDoubleListEqual(node2, back2)) {
                System.out.println("oops!");
                break;
            }
        }
        System.out.println("finish!");
    }
}
