package com.bitree.learn;

import java.util.ArrayList;
import java.util.List;

public class EncodeNaryTreeToBinaryTree {
    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public static com.bitree.learn.Node en (Node root) {
        com.bitree.learn.Node head   = new com.bitree.learn.Node(root.val);
        com.bitree.learn.Node cur = head;
        for (Node e : root.children) {
            if (cur.left == null) {
                cur.left = new com.bitree.learn.Node(e.val);
                cur = cur.left;
            } else {
                cur.right = new com.bitree.learn.Node(e.val);
                cur = cur.right;
            }
            en(e);
        }
        return head;
    }
    public static Node decode(com.bitree.learn.Node node) {
        List<Node> list = new ArrayList<>();
        Node root = new Node(node.value);
        com.bitree.learn.Node cur = node.left;
        while (cur != null) {
            Node subNode = new Node(cur.value);
            list.add(subNode);
            decode(cur);
            cur = cur.right;
        }
        root.children = list;
        return root;
    }
    public static void main(String[] args) {

    }
}
