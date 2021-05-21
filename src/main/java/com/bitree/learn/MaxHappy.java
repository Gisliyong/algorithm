package com.bitree.learn;

import java.util.List;

/**
 * 多叉树
 * int value
 * List<Node> sublings
 */

public class MaxHappy {
    static class Employee {
        int val;
        List<Employee> nexts;

        public Employee(int value) {
            this.val = value;
        }
    }
    /**
     * 整棵树为一个公司：
     * 每个结点有自己的快乐值
     * 1）可以选任何结点发请帖
     * 2）但是不能发直接上下级
     * 3）快乐值最大
     *
     * 以x为头的最大快乐值
     * 1） x 来 x的快乐值 + x 孩子不来的最大快乐值
     * 2） x 不来 0 + x 孩子来最大的快乐与孩子不来时的最大值
     *
     */
    public static int maxHappy(Employee head) {
        Info allInfo = process(head);
        return Math.max(allInfo.no,allInfo.yes);
    }


    public static Info process(Employee x) {
        if (x == null) {
            return new Info(0,0);
        }
        int no = 0;
        int yes = x.val;
        for (Employee e: x.nexts) {
            Info eInfo = process(e);
            yes += eInfo.no;
            no += Math.max(eInfo.yes,eInfo.no);
        }
        return new Info(no,yes);
    }
    static class Info {
        public int no;
        public int yes;
        public Info(int no, int yes) {
            this.no = no;
            this.yes = yes;
        }
    }

    public static int testForMaxHappy(Employee employee, boolean boosCome) {
        if (employee == null) {
            return 0;
        }
        if (boosCome) {
            int ans = 0;
            for (Employee e : employee.nexts) {
                ans += testForMaxHappy(e,false);
            }
            return ans;
        } else {
            int ans = employee.val;
            int op1 = 0;
            int op2 = 0;
            for (Employee e : employee.nexts) {
                 op1 += testForMaxHappy(e,true);
                 op2 += testForMaxHappy(e,false);
            }
            return Math.max(op1,op2);
        }
    }
    public static int testprocess(Employee employee) {
        return Math.max(testForMaxHappy(employee,true),testForMaxHappy(employee,false));
    }
    public static Employee genarateBoss(int maxLevel, int maxNexts, int maxHappy) {
        if (Math.random() < 0.02) {
            return null;
        }
        Employee boss = new Employee((int) (Math.random() * (maxHappy + 1)));
        genarateNexts(boss, 1, maxLevel, maxNexts, maxHappy);
        return boss;
    }

    // for test
    public static void genarateNexts(Employee e, int level, int maxLevel, int maxNexts, int maxHappy) {
        if (level > maxLevel || e.nexts ==  null) {
            return;
        }
        int nextsSize = (int) (Math.random() * (maxNexts + 1));
        for (int i = 0; i < nextsSize; i++) {
            Employee next = new Employee((int) (Math.random() * (maxHappy + 1)));
            e.nexts.add(next);
            genarateNexts(next, level + 1, maxLevel, maxNexts, maxHappy);
        }
    }

    public static void main(String[] args) {
        int maxLevel = 4;
        int maxNexts = 7;
        int maxHappy = 100;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            Employee boss = genarateBoss(maxLevel, maxNexts, maxHappy);
            if (testprocess(boss) != maxHappy(boss)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");

    }
}
