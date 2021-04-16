package com.list.learn;

import java.util.ArrayList;
import java.util.List;

public class RemoveGivenValue {
    public static Node removeValue(Node root, int value) {
        while (root != null) {
            if (root.value != value) {
                break;
            }
            root = root.next;
        }
        Node pre = root;
        Node cur = root;
        while (cur != null) {
            if (cur.value == value) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return root;
    }
   public static boolean testRemove(Node root, int value) {
       List<Integer> list = new ArrayList<>();
       Node head = root;
       while (head != null) {
           list.add(head.value);
           head = head.next;
       }
       if (list.contains(value)) return false;
       else {
           return true;
       }
   }
    public static Node generator(int maxValue, int maxSize) {
        int len = (int) (Math.random() * maxSize) ;
        Node root = new Node((int) (Math.random() * maxValue));
        Node tail = root;
        for (int i = 0; i < len; i++) {
            tail.next = new Node((int) (Math.random() * maxValue));
            tail = tail.next;
        }
        return root;
    }
    public static void printList(Node root) {
        while (root != null) {
            System.out.print(root.value + " ");
            root = root .next;
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        System.out.println("I wanna go! right now!");
        int maxSize = 10;
        int maxValue = 1000000;
        int testTime = 10000000;
        for (int i = 0; i < testTime; i++) {
            Node head = generator(maxValue, maxSize);
            int value = (int) (Math.random() * maxValue);
            Node node = removeValue(head, value);
            if (!testRemove(node,value)) {
                System.out.println("error!");
                System.out.println("value is : " + value);
                printList(head);
            }
        }
        System.out.println("finsh!");
    }
}
