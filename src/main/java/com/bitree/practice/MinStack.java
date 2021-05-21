package com.bitree.practice;

import java.util.Queue;
import java.util.Stack;

class MinStack {
    Stack<Integer> stack ;
    Stack<Integer> minstack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack();
        minstack = new Stack();
    }

    public void push(int x) {
        stack.push(x);
        if(minstack.isEmpty()) {
            minstack.push(x);
        } else {

            if ((x < minstack.peek())) {
                minstack.push(x);
            } else {
                minstack.push(minstack.peek());
            }
        }
    }
    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        stack.pop();
        minstack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minstack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.min();
        minStack.pop();
        minStack.top();
        minStack.min();
        Queue queue;

    }
}

