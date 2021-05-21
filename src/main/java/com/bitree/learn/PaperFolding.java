package com.bitree.learn;

public class PaperFolding {

    /**
     * 请把一段纸条竖着放在桌子上，然后从纸条的下边向上方对折1次，压出折痕后展开。此时折痕是凹下去的，
     * 即折痕突起的方向指向纸条的背面。 如果从纸条的下边向上方连续对折2次，压出折痕后展开，此时有三条折痕，从上到下依次是下折痕、下折痕和上折痕。
     * 给定一个输入参数N，代表纸条都从下边向上方连续对折N次。 请从上到下打印所有折痕的方向。
     */
    public static  void paper(boolean down,int n) {
        if (n == 0) {
            return;
        }
        paper(true,n - 1);
        System.out.println((down) ? "凹" : "凸");
        paper(false,n - 1);
    }
    public static void main(String[] args) {
        paper(true,3);
    }
}
