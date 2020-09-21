package com.jerry.leetcode.other;

public class AddTwoNumbers {

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode listNode = addTwoNumbers.new ListNode(1);
        ListNode listNode2 = addTwoNumbers.new ListNode(2);
        ListNode listNode3 = addTwoNumbers.new ListNode(3);

        ListNode result = listNode;

        result.next = listNode2;
        result = result.next;

        result.next = listNode3;
        result = result.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(-1);
        ListNode result = listNode;
        int i = 0;
        while (l1 != null && l2 != null){
            int l1Val = l1 == null?0:l1.val;
            int l2Val = l2 == null?0:l2.val;

            int sum = l1Val + l2Val + i;
            if(sum > 9){
                sum = sum % 10;
                i = 1;
            } else {
                i = 0;
            }
            result.next = new ListNode(sum);
            result = result.next    ;
            if(l1 != null){l1 = l1.next;}
            if(l2 != null){l2 = l2.next;}
        }

        while (l1 != null){
            int l1Val = l1 == null?0:l1.val;
            int sum = l1Val + i;
            if(sum > 9){
                sum = sum % 10;
                i = 1;
            } else {
                i = 0;
            }
            result.next = new ListNode(sum);
            result = result.next    ;
            if(l1 != null){l1 = l1.next;}
        }

        while (l2 != null){
            int l2Val = l2 == null?0:l2.val;
            int sum = l2Val + i;
            if(sum > 9){
                sum = sum % 10;
                i = 1;
            } else {
                i = 0;
            }
            result.next = new ListNode(sum);
            result = result.next    ;
            if(l2 != null){l2 = l2.next;}
        }

        if(i == 1){
            result.next = new ListNode(1);
        }
        return listNode.next;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}
