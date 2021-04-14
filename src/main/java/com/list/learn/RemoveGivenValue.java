package com.list.learn;

public class RemoveGivenValue {
    public static void removeValue(Node root, int value) {
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
    }
    public static void main(String[] args) {

    }
}
