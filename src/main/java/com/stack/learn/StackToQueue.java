package com.stack.learn;

import java.util.Stack;

public class StackToQueue {
    Stack<Integer> mainStack;
    Stack<Integer> helpStack;
    public StackToQueue() {
        mainStack = new Stack<>();
        helpStack = new Stack<>();
    }
    public void push(int value) {
        mainStack.push(value);
    }
    public int pop() {
        int value = 0;
        if (!helpStack.isEmpty()) {
            return helpStack.pop();
        } else if(!mainStack.isEmpty()) {
            while (!mainStack.isEmpty()) {
                helpStack.push(mainStack.pop());
            }
            return helpStack.pop();
        }
        return -1;
    }
}
