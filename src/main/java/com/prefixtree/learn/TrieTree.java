package com.prefixtree.learn;

import com.list.learn.Node;
import com.prefixtree.practice.Test;

import static com.prefixtree.practice.Test.generateRandomStringArray;

public class TrieTree {

    /**
     * [abc,abd,bce,abce]
     * 建立一颗多叉树（头节点空），字母相同会复用
     * 注意：abc 和 bce 也不会复用，必须前缀相同才会复用
     *
     */

    /**
     * 加强结点
     * p 有通过的结点
     * e 有以此为结尾的结点
     */

    /**
     * 应用举例：
     * 某个字符串出现了多少次
     * 某个前缀出现了多少次
     */

   static class Node1 {
        public int pass;
        public int end;
        public Node1 nexts[];
        public Node1() {
            this.pass = 0;
            this.end = 0;
            nexts = new Node1[26];
        }
    }
    static class Trie1 {
        Node1 root;
        public Trie1(){
            this.root = new Node1();
        }
        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] chs = word.toCharArray();
            Node1 node = root;
            node.pass++;
            int index = 0;
            for (int i = 0; i < chs.length; i++) { // 从左往右遍历字符
                index = chs[i] - 'a'; // 由字符，对应成走向哪条路
                if (node.nexts[index] == null) {
                    node.nexts[index] = new Node1();
                }
                node = node.nexts[index];
                node.pass++;
            }
            node.end++;

        }
        public int search(String word) {
            if (word == null) {
                return 0;
            }
            char chars[] = word.toCharArray();
            Node1 node = root;
            int path = 0;
            for (int i = 0; i < chars.length; i++) {
                path = chars[i] - 'a';
                if (node.nexts[path] == null) {
                    return 0;
                }
                node = node.nexts[path];
            }
            return node.end;
        }
        public int searchPre(String pre) {
            if (pre == null) {
                return 0;
            }
            char chars[] = pre.toCharArray();
            Node1 node = root;
            int path = 0;
            for (int i = 0; i < chars.length; i++) {
                path = chars[i] - 'a';
                if (node.nexts[path] == null) {
                    return 0;
                }
                node = node.nexts[path];
            }
            return node.pass;
        }
        public void delete(String word) {
            // 先查询是否这个单词
            if (search(word) != 0) {
                char [] chars = word.toCharArray();
                Node1 node = root;
                node.pass--;
                int path = 0;
                for (int i = 0; i < chars.length; i++) {
                    path = chars[i] - 'a';
                    if (--node.nexts[path].pass == 0) {
                        node = null;
                    }
                    node = node.nexts[path];
                }
                node.end--;
            }
        }
    }
    public static String[] getStrings(int maxLen) {
        int len = (int) (Math.random() * maxLen) * 100;
        String strs[] = new String[len];
        for (int i = 0; i < len; i++) {
            strs[i] = getString(maxLen);
        }
        return strs;
    }
    public static String getString(int maxLen) {
        int len = (int) (Math.random() * maxLen);
        char chars[] = new char[len];
        for (int i = 0; i <chars.length ; i++) {
            int v  = (int)(Math.random() * 26);
            chars[i] = (char) ('a' + v);
        }
        return String.valueOf(chars);
    }
    public static int test(String [] strs, String target) {
       int ans = 0;
       for (String str : strs ) {
           if (str.equals(target)) {
               ans++;
           }
       }
       return ans;
    }
    public static void main(String[] args) {
        int arrLen = 10000;
        int strLen = 20;
        int testTimes = 100;
        for (int i = 0; i < testTimes; i++) {
            String[] arr = generateRandomStringArray(arrLen, strLen);
            Test.Trie1 trie1 = new Test.Trie1();
            Test.Trie2 trie2 = new Test.Trie2();
            Test.Right right = new Test.Right();
            for (int j = 0; j < arr.length; j++) {
                double decide = Math.random();
                if (decide < 0.25) {
                    trie1.insert(arr[j]);
                    trie2.insert(arr[j]);
                    right.insert(arr[j]);
                } else if (decide < 0.5) {
                    trie1.delete(arr[j]);
                    trie2.delete(arr[j]);
                    right.delete(arr[j]);
                } else if (decide < 0.75) {
                    int ans1 = trie1.search(arr[j]);
                    int ans2 = trie2.search(arr[j]);
                    int ans3 = right.search(arr[j]);
                    if (ans1 != ans2 || ans2 != ans3) {
                        System.out.println(ans1 + " " + ans2 + "  " + ans3);
                        System.out.println(0);
                        System.out.printf(arr[j]);

                        System.out.println("Oops!");
                    }
                } else {
                    int ans1 = trie1.prefixNumber(arr[j]);
                    int ans2 = trie2.prefixNumber(arr[j]);
                    int ans3 = right.prefixNumber(arr[j]);
                    if (ans1 != ans2 || ans2 != ans3) {
                        System.out.println(ans1 + " " + ans2 + "  " + ans3);
                        System.out.println("there is error");
                        System.out.printf(arr[j]);
                        System.out.println("Oops!");
                    }
                }
            }
        }
        System.out.println("finish!");

    }
}
