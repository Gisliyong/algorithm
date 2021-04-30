package com.list.practice;

import com.list.learn.DoubleNode;
import com.list.learn.Node;

import java.util.ArrayList;
import java.util.List;

import static com.list.learn.ReverseList.isEaual;

public class Test {
    public static Node reverseList(Node head) {
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
    /**
     * @Description 对数器;
     **/
    public static Node logOfReverseList(Node head) {
        if (head == null) {
            return null;
        }
        List<Node> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        list.get(0).next = null;
        for (int i = 1; i < list.size(); i++) {
            list.get(i).next = list.get(i - 1);
        }
        return list.get(list.size() -1);
    }

    public static void main(String[] args) {
        int maxValue = 100;
        int maxSize = 10;
        int testTime = 5;
        for (int i = 0; i < testTime; i++) {
            Node head = generator(maxValue,maxSize);
            Node one = reverseList(head);
            Node two = logOfReverseList(one);

            if (!isEaual(head, two)) {
                System.out.println("eroor!");
            }
        }
        System.out.println("finsh!");
    }
    /**
     * 反转双链表
     **/
    public static DoubleNode reverseDoubleList(DoubleNode head) {
        if (head == null || head.next == null) {
            return head;
        }
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

}
