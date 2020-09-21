package com.jerry.leetcode.doublepoint;

/**
 * 环形链表，判断有环，并且 输出环起始点
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class DetectCycle {
    public static void main(String[] args) {
        
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slowNode = head;
        ListNode fastNode = head;

        //判断有环
       while (true){
           if(fastNode == null || fastNode.next == null){
               return null;
           }
           slowNode = slowNode.next;
           fastNode = fastNode.next.next;
           if(slowNode == fastNode){
               break;
           }
       }

       slowNode = head;
       while (slowNode != fastNode){
           slowNode = slowNode.next;
           fastNode = fastNode.next;
       }
        return slowNode;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}

