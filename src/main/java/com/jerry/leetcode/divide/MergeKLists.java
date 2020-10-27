package com.jerry.leetcode.divide;

import java.util.List;

/**
 * 合并K个升序链表
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 *
 * 分值算法
 */
public class MergeKLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKListsRange(lists, 0, lists.length-1);
    }

    public ListNode mergeKListsRange(ListNode[] lists, int left, int right) {

        if(left > right){
            return null;
        }

        if(left == right){
            return lists[left];
        }
        int mid = (left + right) >> 1;
        return merge(mergeKListsRange(lists, left, mid), mergeKListsRange(lists, mid + 1, right));
    }

    //合并两个有序链表
    public ListNode merge(ListNode list1, ListNode list2) {
        if(list1 == null || list2 == null){
            return list1 != null ? list1:list2;
        }

        ListNode temp = new ListNode(0);
        ListNode tail = temp;
        ListNode pre = list1;
        ListNode p = list2;
        while (pre != null && p!=null){
            if(pre.val < p.val){
                tail.next = pre;
                pre = pre.next;
            } else {
                tail.next = p;
                p = p.next;
            }
            tail = tail.next;
        }

        tail.next = (p != null? p: pre);

        return temp.next;
    }
}
