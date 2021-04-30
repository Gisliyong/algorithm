package com.stack.learn;

import com.queue.learn.ArrayQueue;

/**
 * 数组实现栈
 **/
public class ArrayStack {
    int top = -1;
    int[] data = new int[128];
    public  void push(int value){
        if (top == 127) {
            System.out.println("manle");
            return;
        }
        top++;
        data[top] = value;

    }
    public  int pop() {
        if (top == -1) {
            return -1;
        }
        int value;
        value = data[top];
        top--;
        return value;
    }
    public  boolean isEmpty() {
        return top == -1;
    }
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack();
        for (int i = 0; i < 128; i++) {
            arrayStack.push(i);
        }
        arrayStack.push(9);
    }
}
