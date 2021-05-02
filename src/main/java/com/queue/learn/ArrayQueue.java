package com.queue.learn;


/**
 * 数组实现队列
 **/
public class ArrayQueue {
    private int size;
    private int limit;
    private int[] data;
    private int begin;
    private int end;
    public ArrayQueue(int limit) {
        data = new int[limit];
        this.limit = limit;
        this.begin = 0;
        this.end = 0;
        this.size = 0;
    }
    public  void push(int value) {
        // 队列满了
        if (this.size == limit) {
            System.out.println("队列满了！");
            return;
        }
        data[begin] = value;
        this.size++;
        begin = nextIndex(begin);
    }
    public  int pop(){
        // 队列为空，不能在取
        if(this.size == 0) {
            System.out.println("队列为空！");
            return -1;
        }
        int value = data[end];
        this.size--;
        end = nextIndex(end);
        return value;
    }
    public  boolean isEmpty() {
        return this.size == 0;
    }
    public int nextIndex(int index) {
        return (index == limit - 1) ? (index + 1) % limit : index + 1;
    }
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.push(3);
        arrayQueue.push(3);
        arrayQueue.push(3);
        arrayQueue.push(3);
        arrayQueue.pop();
        arrayQueue.pop();
        arrayQueue.pop();
        arrayQueue.push(2);
        arrayQueue.push(2);
        arrayQueue.push(2);
        arrayQueue.push(2);
        System.out.println();
    }
}
