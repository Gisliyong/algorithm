package com.list.learn;
/**
 * 双链表
 **/
public class DoubleNode {
    int value;
    DoubleNode pre;
    DoubleNode next;
    public DoubleNode(int value) {
        this.value = value;
        this.pre = null;
        this.next = null;
    }
}
