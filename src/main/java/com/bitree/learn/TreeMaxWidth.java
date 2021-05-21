package com.bitree.learn;

import java.util.LinkedList;
import java.util.Queue;

/** 求二叉树最大宽度数量 **/
public class TreeMaxWidth {
    public static int getLevelnum(Node head) {
        Node curEnd = head;
        Node nextEnd = null;
        int max = 0;
        int curLevelNodes = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            Node pop = queue.poll();
            curLevelNodes++;
            if (pop.left != null) {
                queue.add(pop.left);
                nextEnd = pop.left;
            }
            if (pop.right != null) {
                queue.add(pop.right);
                nextEnd = pop.right;
            }
            if (pop == curEnd) {
                curLevelNodes = 0;
                max = Math.max(max,curLevelNodes);
                curEnd = nextEnd;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println("");
    }
}
