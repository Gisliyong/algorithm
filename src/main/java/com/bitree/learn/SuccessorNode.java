package com.bitree.learn;

import com.sun.java.swing.plaf.windows.WindowsDesktopIconUI;

import java.util.ArrayList;
import java.util.List;

public class SuccessorNode {
    /** 找到一个结点中序遍历的后继结点 **/
    static class Node {
        Node left;
        Node right;
        Node parent;
        int value;
        public Node(Node left, Node right, Node parent, int value) {
            this.left = left;
            this.right = right;
            this.parent = parent;
            this.value = value;
        }
    }

    public static Node generate(Node pre, int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        Node root = new Node(null,null,pre,(int) (Math.random() * maxValue));
        root.left = generate(root,level + 1, maxLevel, maxValue);
        root.right = generate(root,level + 1, maxLevel, maxValue);
        return root;
    }
    /**
     * x 有右树  则是右树上最左孩子
     * x 沿着parent往上走，直到某个结点是父亲的左孩子。
     */

    public static Node getNode(Node cur) {
        if (cur == null) {
            return cur;
        }
        // 第一种情况，当前结点存在右孩子,后继结点一定是右孩子
        if (cur.right != null) {
            // 有右子树
            Node node = cur.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        Node parent = cur.parent;
        while (parent != null && parent.left != cur) {
            cur =  parent;
            parent = parent.parent;
        }
        return parent;
    }
    // for test
    public static Node testGetNod(Node root,Node x) {
        if (x == null) {
            return x;
        }
        List<Node> nodes = new ArrayList<>();
        in(root,nodes);
        int index = nodes.indexOf(x);
        if (index + 1 < nodes.size()) {
            return nodes.get(index + 1);
        }
        return null;
    }
    public static void  in(Node root, List<Node> list) {
        if (root == null) {
            return;
        }
        in(root.left, list);
        list.add(root);
        in(root.right,list);
    }
    public static void main(String[] args) {
        int testTime = 100000;
        for (int i = 0; i < testTime; i++) {
            Node tree = generate(null,1,34,100);
            List<Node> nodes = new ArrayList<>();
            in(tree,nodes);
            int index = (int) (Math.random() * nodes.size());
            Node x = (index == 0) ? null:nodes.get(index);
            Node ans1= getNode(x);
            Node ans2 = testGetNod(tree,x);
            if (ans1 != ans2){
                System.out.println("oops");
            }
        }
    }
}
