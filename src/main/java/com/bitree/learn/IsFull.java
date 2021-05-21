package com.bitree.learn;

public class IsFull {
    /** 是否为满二叉树 **/
    /** 如果左孩子为空，右孩子不为空违反完全二叉树
     *  如果遍历到第一个不全的结点，则剩下的结点必须是叶子结点
     * **/
    static class Info {
        int h;
        int nodes;

        public Info(int h, int nodes) {
            this.h = h;
            this.nodes = nodes;
        }
    }
    public static boolean isFull(Node root) {
        if (root == null) {
            return true;
        }
        Info info = process(root);
        return info.h << 1 - 1 == info.nodes;
    }
    public static Info process(Node root) {
        if (root == null) {
            return new Info(0,0);
        }
        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);
        return new Info(Math.max(leftInfo.h,rightInfo.h) + 1,leftInfo.nodes + rightInfo.nodes + 1);
    }
    public static boolean testForIsFull(Node root) {
        if (root == null) {
            return true;
        }
        int h = h(root);
        int n = n(root);
        return h << 1 - 1 == n;
    }
    public static int n(Node root) {
        if (root == null) {
            return 0;
        }
        return n(root.left) + n(root.right) + 1;
    }
    public static int h(Node root) {
        if (root == null) {
            return 0;
        }
        return Math.max(h(root.left),h(root.right)) + 1;
    }
    // for test
    public static Node generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
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
        int maxLevel = 5;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            if (testForIsFull(head) != isFull(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");

    }
}
