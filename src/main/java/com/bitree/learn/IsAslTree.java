package com.bitree.learn;
/** 搜索二叉树 **/
public class IsAslTree {
    static class Info {
        boolean isAsl;
        int min;
        int max;

        public Info(boolean isAsl, int min, int max) {
            this.isAsl = isAsl;
            this.min = min;
            this.max = max;
        }
    }
    public boolean isAsl(Node root) {
        return process(root).isAsl;
    }
    public static Info process(Node x) {
        /** 此时如果不知道怎么设置则返回空,交给上游处理**/
        if (x == null) {
            return null;
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int max = x.value;
        int min = x.value;
        boolean isBST = true;
        if (leftInfo != null) {
            max = Math.max(max,leftInfo.max);
            min  = Math.min(min,leftInfo.min);
        }
        if (rightInfo != null) {
            min  = Math.min(min,rightInfo.min);
            max = Math.max(max,rightInfo.max);
        }

        if (leftInfo != null&& !leftInfo.isAsl) {
            isBST = false;
        }
        if (rightInfo != null&& !rightInfo.isAsl) {
            isBST = false;
        }
        if (leftInfo != null && leftInfo.max >= x.value) {
            isBST = false;
        }
        if (rightInfo != null && rightInfo.max <= x.value) {
            isBST = false;
        }
        return new Info(isBST,min,max);
    }
    public static void main(String[] args) {

    }
}
