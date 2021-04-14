package com.xor.learn;

public class XOR {
    /**
     * 得到二进制
     * @param value
     * @return
     */
    public static String getBytes(int value) {
        String byteStr = "";
        for (int i = 31; i >= 0 ; i--) {
            byteStr += ((value & 1 << i) == 0) ? '0' : '1';
        }
        return byteStr;
    }
    public static int getRightOne(int value) {
        return value & (~value + 1);
    }
    public static void main(String[] args) {
        String bytes = getBytes(5346);
        String b = getBytes(5346 & (~5346 + 1));
        System.out.println(bytes+ ":" + bytes.length());
        System.out.println(Integer.toBinaryString(5346 & (~5346 + 1)));
        System.out.println(b);
    }
}
