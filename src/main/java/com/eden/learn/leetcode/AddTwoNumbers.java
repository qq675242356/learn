package com.eden.learn.leetcode;

import java.util.List;

public class AddTwoNumbers {

    public static void main(String[] args) {

        ListNode first = ListNode.of(2, 4, 3);
        ListNode second = ListNode.of(5, 6, 4);
        second.print(second);
        ListNode listNode = addTwoNumbers(first, second);
        listNode.print(listNode);

    }


    //todo 实现
    //@https://leetcode-cn.com/problems/add-two-numbers/solution/hua-jie-suan-fa-2-liang-shu-xiang-jia-by-guanpengc/
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return null;
    }
}

class ListNode {


    int var;

    ListNode next;

    public ListNode(int i) {
        this.var = i;
    }

    public static ListNode of(int... x) {
        if (x == null) {
            return null;
        }
        ListNode head = null;
        ListNode next = null;
        for (int i = 0; i < x.length; i++) {
            if (i == 0) {
                head = new ListNode(x[i]);
                next = head;
            } else {
                next.next = new ListNode(x[i]);
                next = next.next;
            }

        }
        return head;
    }

    public void print(ListNode head) {
        while (head != null){
            System.out.print(head.var);
            head = head.next;
        }
        System.out.println("");
    }
}
