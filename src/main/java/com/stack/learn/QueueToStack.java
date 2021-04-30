package com.stack.learn;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 需要用两个队列来实现
 **/
public class QueueToStack<T> {
    public Queue<T> queue;
    public Queue<T> help;

    public QueueToStack() {
        queue = new LinkedList<>();
        help = new LinkedList<>();
    }

    public void offer(T value) {
        queue.offer(value);
    }
    public T poll() {
        T value;
        while (queue.size() > 1) {
            help.offer(queue.poll());
        }

        value = queue.poll();
        // 交换两个队列
        Queue<T> tmp = queue;
        queue = help;
        help = tmp;
        return value;
    }
    public T peek() {
        while (queue.size() > 1) {
            help.offer(queue.poll());
        }
        T ans = queue.poll();
        help.offer(ans);
        Queue<T> tmp = queue;
        queue = help;
        help = tmp;
        return ans;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
