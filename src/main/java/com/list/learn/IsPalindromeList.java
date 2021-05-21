package com.list.learn;

import java.util.ArrayList;
import java.util.List;

public class IsPalindromeList {
    public static boolean isPalinnd(Node head) {
        boolean flag = true;
        if (head ==  null || head.next == null && head.value != head.next.value) {
            flag = false;
        }
        if (head.next.next == null && head.value != head.next.next.value) {
         flag = false;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while (fast.next!= null && fast.next.next != null) {
            slow = slow.next;
            fast= fast.next;
        }
        Node mid = slow;
        Node cur = slow;
        while (cur != null) {
           fast = cur.next;
           cur.next = slow;
           slow = cur;
           cur=fast;
        }
        fast = slow;
        cur = slow;
        slow = head;

        while (fast != mid) {
            if (fast.value != slow.value) {
                flag = false;
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }
        fast = cur.next;
        cur.next = null;
        while (fast != mid) {
            slow = fast.next;
            fast.next = cur;
            cur = fast;
            fast = slow;
        }
        fast.next = cur;
        return flag;
    }
    public static boolean testIsPalind(Node head) {
        List<Node> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int i = 0;
        int j = list.size() - 1;
        for (;i < j;i++,j--) {
            if (list.get(i).value != list.get(j).value) {
                return false;
            }
        }
        return true;
    }
    public static Node generator(int maxValue, int maxSize) {
        int len = (int) (Math.random() * maxSize);
        if (len == 0) {
            return null;
        }
        Node head = new Node((int) (Math.random() * maxValue));
        Node pre = head;
        for (int i = 1; i < len; i++) {
            pre.next = new Node((int) (Math.random() * maxValue));
            pre = pre.next;
        }
        return head;
    }
    public static void main(String[] args) {
        Node head;
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        System.out.println("=========================");
        System.out.println(isPalinnd(head));
        System.out.println(testIsPalind(head));
    }
}
