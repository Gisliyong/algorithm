package com.stack.learn;
import java.util.Stack;

/**
 * 实现一个栈除了基本操作以外，还需要返回最小值。
 * 实现方法：
 *       准备两个栈
 **/
public class MinStack {
     Stack<Integer> mainStack;
     Stack<Integer> minStack;
    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }
    public  int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        return -1;
    }
    /**
     * 如果最小栈为空，这直接入栈
     **/
    public  void push(int value) {
        mainStack.push(value);
        if (minStack.isEmpty()) {
            minStack.push(value);
        } else {
            if (value < minStack.peek()) {
                minStack.push(value);
            } else {
                minStack.push(minStack.peek());
            }
        }
    }
    /**
     * 出栈
     **/
    public  int  pop() {
        int value = 0;
        if (!mainStack.isEmpty()) {
            value = mainStack.pop();
            minStack.pop();
        }
        return value;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(3);
        minStack.push(3);
        minStack.push(4);
        minStack.push(67);
        minStack.push(34);
        System.out.println(minStack.getMin());
        minStack.push(1);
        System.out.println(minStack.getMin());
        minStack.push(0);
        System.out.println(minStack.getMin());
    }
}
