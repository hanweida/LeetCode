package com.jerry.leetcode.doublepoint;

public class GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slowNode = head , fastNode = head;

        for(int i = 0; i < k; i++){
            fastNode = fastNode.next;
        }

        while (fastNode.next != null){
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }



 public class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

}
