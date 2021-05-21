package com.bitree.learn;
/** 判断二叉树是否为平衡树 **/
public class IsBalanceTree {
    static class Info{
        public boolean isBalanced;
        public int height;
        public Info(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
    public static boolean isBalance(Node root) {
        return process(root).isBalanced;
    }
    public static Info process(Node x) {
        if (x == null) {
            return new Info(true,0);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int h = Math.max(leftInfo.height,rightInfo.height);
        boolean isBalance = true;
        if (!leftInfo.isBalanced) {
            isBalance = false;
        }
        if (!rightInfo.isBalanced) {
            isBalance = false;
        }
        if ( Math.abs(leftInfo.height - rightInfo.height) > 1) {
            isBalance = false;
        }
        return new Info(isBalance,h);
    }

    public static void main(String[] args) {

    }
}
