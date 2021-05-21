package com.bitree.learn;
/** 任意两个结点都有距离，从一个结点走到另一个结点，沿途的节点数量就是距离，返回最大距离。 **/
public class MaxDistance {
    static class Info {
        int h;
        int maxDistance;
        public Info(int h, int maxDistance) {
            this.h = h;
            this.maxDistance = maxDistance;
        }
    }
    public static int maxDistance(Node root) {
        return process(root).maxDistance;
    }
    public static Info process(Node x) {
        if (x == null) {
            return new Info(0,0);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int maxDis = Math.max((leftInfo.h + rightInfo.h + 1),Math.max(leftInfo.maxDistance,rightInfo.maxDistance));
        return new Info(Math.max(leftInfo.h,rightInfo.h),maxDis);
    }
    public static void main(String[] args) {

    }
}
