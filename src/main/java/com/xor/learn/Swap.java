package com.xor.learn;
/**
 * 不用额外空间交换两个数
 **/
public class Swap {
    /**
     * 需要注意此交换需要a与b不指向同一个地址
     * 如果两个位置相同，则结果变成0
     **/
    public static void swap(int a,int b) {
        System.out.println("a:" + a + " " + "b:" + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a:" + a + " " + "b:" + b);
    }
    public static void main(String[] args) {
        swap(2,6);
    }
}
