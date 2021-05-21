package com.bitree.learn;

import com.bitree.practice.Solution;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.LinkedList;
import java.util.Queue;

/** 是否为完全二叉树 **/
public class IsComplete {
    /** 是否为满二叉树 **/
    /** 如果左孩子为空，右孩子不为空违反完全二叉树
     *  如果遍历到第一个不全的结点，则剩下的结点必须是叶子结点
     * **/
    public static boolean isCBT1(Node head) {
        if (head == null) {
            return true;
        }
        LinkedList<Node> queue = new LinkedList<>();
        // 是否遇到过左右两个孩子不双全的节点
        boolean leaf = false;
        Node l = null;
        Node r = null;
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if (
                // 如果遇到了不双全的节点之后，又发现当前节点不是叶节点
                    (leaf && (l != null || r != null))
                            ||
                            (l == null && r != null)

            ) {
                return false;
            }
            if (l != null) {
                queue.add(l);
            }
            if (r != null) {
                queue.add(r);
            }
            if (l == null || r == null) {
                leaf = true;
            }
        }
        return true;
    }
    // 队列版
    public static boolean isCT(Node root) {
        if (root == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        boolean leaf = false;
        queue.add(root);
        while (!queue.isEmpty()) {
            Node pop = queue.poll();
            if (  (leaf && (pop.left != null || pop.right != null))
                    ||
                    (pop.left == null && pop.right != null)) {
                return false;
            }
            if (pop.left !=  null) {
                queue.add(pop.left);
            }
            if (pop.right != null) {
                queue.add(pop.right);
            }

            if (pop.left == null || pop.right == null) {
                leaf = true;
            }
        }
        return true;
    }
    // 递归版
    static class Info {
        boolean isfull;
        boolean isct;
        int h;

        public Info(boolean isfull, boolean isct, int h) {
            this.isfull = isfull;
            this.isct = isct;
            this.h = h;
        }
    }
    /**
     * 讨论以x为头的树是否为完全二叉树
     * 1） 左子树 与 右子树都满 左高 == 右高
     * 2） 左树为完全二叉树，右树为满树，左比右高1
     * 3） 左右都满 左 比 右高1
     * 4） 左满，右树为完全  左高 == 右高
     */

    public static boolean isCT2(Node root) {
     return process(root).isct;
    }
    public static Info process(Node x) {
        if (x == null) {
            return new Info(true,true,0);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int h = Math.max(leftInfo.h, rightInfo.h) + 1;
        boolean isFull = leftInfo.isfull
                &&
                rightInfo.isfull
                && leftInfo.h == rightInfo.h;
        // 第一种情况的判断与isFull相同
        boolean isCBT = false;
        if (isFull) {
            isCBT = true;
        } else { // 以x为头整棵树，不满
            if (leftInfo.isct && rightInfo.isct) {
                if (leftInfo.isct
                        && rightInfo.isfull
                        && leftInfo.h == rightInfo.h + 1) {
                    isCBT = true;
                }
                if (leftInfo.isfull
                        &&
                        rightInfo.isfull
                        && leftInfo.h == rightInfo.h + 1) {
                    isCBT = true;
                }
                if (leftInfo.isfull
                        && rightInfo.isct && leftInfo.h == rightInfo.h) {
                    isCBT = true;
                }


            }
        }
        return new Info(isFull,isCBT,h);

    }
    // for test
    public static Node generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        Node head = new Node((int) (Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }
    public static void main(String[] args) {
        int testTime = 100000;
        for (int i = 0; i < testTime; i++) {
            Node node  = generate(1,20,20);
            if (isCBT1(node) != isCT(node)) {
                System.out.println("oops!");
            }
        }
    }
}
