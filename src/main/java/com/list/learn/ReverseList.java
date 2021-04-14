package com.list.learn;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class ReverseList {
    public static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    public static Node logOfReverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        List<Node> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int len = list.size();
        for (int i = len - 1; i > 0; i--) {
            list.get(i).next = list.get(i - 1);
        }
        list.get(0).next = null;
        return list.get(len -1);
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
    public static boolean isEaual(Node current, Node other) {
        if (current == null && other ==  null) {
            return true;
        }
        while (current != null ) {
            if (other == null || current.value != other.value) {
                return false;
            }
            current = current.next;
            other = other.next;
        }
        return true;
    }
    public static void pirntList(Node head) {
        while (head != null) {
            System.out.print("  " + head.value);
            head = head.next;
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        int maxValue = 100;
        int maxSize = 10;
        int testTime = 5;
        for (int i = 0; i < testTime; i++) {
            Node head = generator(maxValue,maxSize);

            Node one = reverse(head);

            Node two = logOfReverse(one);
            pirntList(head);
            pirntList(one);
            pirntList(two);
            if (!isEaual(head, two)) {
                System.out.println("eroor!");
            }
            System.out.println("");
        }
        System.out.println("finsh!");
    }
}
