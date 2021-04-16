package com.queue;

public class CustomQueue {
    private int[] data;
    private int head;
    private int root;
    private int limit;
    private int size;
    public CustomQueue(int size) {
        data = new int[size];
        root = 0;
        limit = size;
        head = 0;
        root = 0;
    }
    public void push(int value) {
        if (size == limit) {
            System.out.println("full!");
        }
        size++;
        data[root]  = value;
        root = nextIndex(root);
    }
    public int pop() {
        if (size == 0) {
            System.out.println("empty!");
            return -1;
        }
        size--;
        int value = data[head];
        System.out.println(value);
        head = nextIndex(head);
        return value;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int nextIndex(int i) {
        return (i + 1 > limit - 1) ? 0 : i + 1;
    }
    public static void main(String[] args) {
        System.out.println();
    }
}
