package com.list.learn;
/**
 * 双链表
 **/
public class DoubleNode {
    public int value;
    public DoubleNode pre;
    public DoubleNode next;
    public DoubleNode(int value) {
        this.value = value;
        this.pre = null;
        this.next = null;
    }


}
