package com.list.practice;

import com.list.learn.Node;

import java.util.ArrayList;
import java.util.List;

public class FimdMid {
    // 输入链表头节点，奇数长度返回中点，偶数长度返回上中点
    public static Node find1(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null || head.next.next == null) {
            return head;
        }
        Node fast;
        Node slow;
        fast = slow = head;
        while (fast.next != null && fast.next .next!= null) {
                fast = fast.next.next;
                slow = slow.next;
        }
        return slow;
    }
    public static Node find2 (Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node slow = head.next;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static Node testFind1(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null || head.next.next == null) {
            return head;
        }
        List<Node> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        return (list.size() % 2 == 0) ? list.get(list.size()/ 2 - 1):list.get(list.size() / 2);
    }
    public static Node testFind2(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        List<Node> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        return  list.get(list.size() / 2);
    }
    public static Node find3(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node slow = head;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static Node testFind3(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            return  null;
        }
        List<Node> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
       return  (list.size() % 2 == 0) ? list.get(list.size()/ 2 - 2):list.get(list.size() / 2 -1);
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
    public static Node find4(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        if (head.next.next == null) {
            return head;
        }
        Node slow = head;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        int testTime = 10000;
        for (int i = 0; i < testTime; i++) {
            Node head = generator(100,10);
            Node ans1  = find3(head);
            Node ans2 = testFind3(head);
            if (ans1 != null && ans2 != null && ans1.value != ans2.value) {
                System.out.println("error!");
            };
        }
    }
}
