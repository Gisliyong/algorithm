package com.bitree.learn;

import java.util.*;

/**
 * 返回a,b的最低公共祖先
 */

public class lowestAncestor {

    // 方法1 借助容器hashmap


    // 方法二 递归

    /**
     * 以x为头的树，a,b最初汇聚在哪
     * 没有汇聚返回null，汇聚了返回汇聚结点
     * 如果树上有a,有b则汇聚，否则不会汇聚
     * 1 汇聚点与x无关
     * 1）在左树已经汇聚了
     * 2）在右树汇聚了
     * 3） a,b不全
     * 2 与x有关
     * 1）左树发现了一个，右树发现了一个在x汇聚
     * 2） x 本身为a 左树右树发现了b
     * 3) x 本身为b 左树右树发现a
     */
    static class Info  {
        boolean findA;
        boolean findB;
        Node ans;

        public Info(boolean findA, boolean findB, Node ans) {
            this.findA = findA;
            this.findB = findB;
            this.ans = ans;
        }
    }
    public static Node lowestAncestor2(Node root,Node a,Node b) {
        return process(root,a,b).ans;
    }
    public static Info process(Node x,Node a,Node b) {
        if (x == null) {
            return new Info(false,false,null);
        }
        Info leftInfo = process(x.left,a,b);
        Info rightInfo = process(x.right,a,b);
        boolean findA = (x == a) || leftInfo.findA || rightInfo.findA;
        boolean finB = (x == b) || leftInfo.findB || rightInfo.findB;
        Node ans = null;
        if (leftInfo.ans != null) {
            ans = leftInfo.ans;
        } else if (rightInfo.ans != null) {
            ans = rightInfo.ans;
        } else {
            if (findA && finB) {
                ans = x;
            }
        }
        return new Info(findA,finB,ans);
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
            Node a = randomPic(node);
            Node b = randomPic(node);
            Node ans1 = fortestLowest(node,a,b);
            Node ans2 = lowestAncestor2(node,a,b);
            if (ans1 != ans2) {
                System.out.println("oops!");
            }
        }
        System.out.println("finsh!");
    }
    public static Node randomPic(Node root) {
        if (root == null) {
            return null;
        }
        Map<Node,Node> map = new HashMap<>();
        buildParent(root,null,map);
        List<Node> nodes = new ArrayList<>();
        for(Node node : map.keySet()) {
            nodes.add(node);
        }
        int indx = (int) (Math.random() * nodes.size());
        return nodes.get(indx);

    }
    public static void buildParent(Node root,Node parent,Map<Node,Node> map) {
        if (root == null) {
            return ;
        }
        map.put(root,parent);
        buildParent(root.left,root,map);
        buildParent(root.right,root,map);
    }
    public static Node fortestLowest(Node root, Node a, Node b) {
        if (root == null) {
            return null;
        }
        Map<Node,Node> map = new HashMap<>();
        buildParent(root,null,map);
        Set<Node> set = new HashSet();
        // 拿到b的所有父节点
        // 注意千万别操作a,b引用类型操作后值会发生改变
        Node cur = b;
        set.add(cur);
        while (map.get(cur) != null) {
            set.add(map.get(cur));
            cur = map.get(cur);
        }
        cur = a;
        while (!set.contains(cur)) {
           cur = map.get(cur);
        }
        return cur;
    }
}
