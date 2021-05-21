package com.list.learn;

import java.util.function.BinaryOperator;

public class SmallerEqualBigger {

    /**
     * 将链表调整为左（小） 中（等） 右（大）
     * 申请6个变量 左头左尾 中头中尾 右头右尾
     * 最后将三个链表串起来
     */
    public static Node partition(Node head, int value) {
        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node bH = null;
        Node bT = null;
        while (head != null) {
            if (head.value < value) {
                if (sH == null) {
                    sH = new Node(head.value);
                    sT = sH;
                } else {
                    sT.next = new Node(head.value);
                    sT = sT.next;
                }
            } else if (head.value == value){
                if (eH == null) {
                    eH = new Node(head.value);
                    eT = eH;
                } else {
                    eT.next = new Node(head.value);
                    eT = eT.next;
                }
            } else {
                if (bH == null) {

                    bH = new Node(head.value);
                    bT = bH;
                } else {
                    bT.next = new Node(head.value);
                    bT = bT.next;
                }
            }
            head = head.next;
        }
        // 小于区域的尾巴，连等于区域的头，等于区域的尾巴连大于区域的头
        if (sT != null) { // 如果有小于区域
            sT.next = eH;
            eT = eT == null ? sT : eT; // 下一步，谁去连大于区域的头，谁就变成eT
        }
        // 下一步，一定是需要用eT 去接 大于区域的头
        // 有等于区域，eT -> 等于区域的尾结点
        // 无等于区域，eT -> 小于区域的尾结点
        // eT 尽量不为空的尾巴节点
        if (eT != null) { // 如果小于区域和等于区域，不是都没有
            eT.next = bH;
        }
        return sH != null ? sH : (eH != null ? eH : bH);
    }
    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);

        // head1 = listPartition1(head1, 4);
        head1 = partition(head1, 5);
        System.out.println("");
    }
}
