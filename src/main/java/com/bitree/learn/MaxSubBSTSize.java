package com.bitree.learn;

import com.bitree.practice.Code05_MaxSubBSTSize;

import java.util.ArrayList;
import java.util.List;

import static com.bitree.practice.Code05_MaxSubBSTSize.maxSubBSTSize1;

public class MaxSubBSTSize {
    static class Info {
        int maxSubSize;
        int max;
        int min;
        int size;

        public Info(int maxSubSize, int max, int min, int size) {
            this.maxSubSize = maxSubSize;
            this.max = max;
            this.min = min;
            this.size = size;
        }
    }
    public static int maxSbuSize1 (Node head) {
        if (head == null) {
            return 0;
        }
        int h =getBSFSize(head);
        if (h != 0) {
            return h;
        }
        return Math.max(maxSbuSize1(head.left),maxSbuSize1(head.right));
    }
   public static int getBSFSize(Node x) {
        if (x == null) {
            return 0;
        }
        List<Node> list = new ArrayList<>();
        in(x,list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).value < list.get(i - 1).value) {
                return 0;
            }
        }
        return list.size();
    }
    public static void in(Node head, List<Node> list) {
        if (head == null) {
            return;
        }
        in(head.left,list);
        list.add(head);
        in(head.right,list);
    }
    public static int maxSubSize(Node head) {
        if (head == null) {
            return 0;
        }
        return process(head).maxSubSize;
    }
    public static MaxSubBSTSize.Info process(Node x) {
        if (x == null) {
            return null;
        }
        MaxSubBSTSize.Info leftInfo = process(x.left);
        MaxSubBSTSize.Info rightInfo = process(x.right);
        int max = x.value;
        int min  = x.value;
        int allSize = 1;
        if (leftInfo != null) {
            max = Math.max(max,leftInfo.max);
            min  = Math.min(min,leftInfo.min);
            allSize += leftInfo.size;
        }
        if (rightInfo != null) {
            min  = Math.min(min,rightInfo.min);
            max = Math.max(max,rightInfo.max);
            allSize += rightInfo.size;
        }
        int p1 = -1;
        if (leftInfo != null) {
            p1 = leftInfo.maxSubSize;
        }
        int p2 = -1;
        if (rightInfo != null) {
            p2 = rightInfo.maxSubSize;
        }
        int p3 = -1;
        boolean leftBST = leftInfo == null ? true : (leftInfo.maxSubSize == leftInfo.size);
        boolean rightBST = rightInfo == null ? true : (rightInfo.maxSubSize == rightInfo.size);
        if (leftBST && rightBST) {
            boolean isBST1 = leftInfo == null ? true : leftInfo.max < x.value;
            boolean isBST2 = rightInfo == null ? true: rightInfo.min > x.value;
            if (isBST1 && isBST2) {
                int leftSize = leftInfo == null ? 0 : leftInfo.size;
                int rightSize = rightInfo == null ? 0 : rightInfo.size;
                p3 = leftSize + rightSize + 1;
            }
        }
        return new Info(Math.max(p1, Math.max(p2, p3)), max, min , allSize);
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
        int maxLevel = 4;
        int maxValue = 100;
        int testTimes = 1000000;
//        for (int i = 0; i < testTimes; i++) {
//            Node head = generateRandomBST(maxLevel, maxValue);
        Node head = new Node(20);
        head.left = null;
        head.right = new Node(33);
            if (maxSbuSize1(head) != maxSubSize(head)) {
                System.out.println("Oops!");
//            }
        }
        System.out.println("finish!");
    }
}
