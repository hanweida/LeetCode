package com.jerry.leetcode.sorted;

import java.util.List;

/**
 * 插入排序
 * 原理就是 从前往后找， 两个相比较，前一个 如果比后一个大，则两人换位置，
 * 然后小个的 再往前找，找到 比前一个大，比后一个小的位置
 *
 * 比如 -1,5,3,4,0
 *
 * 第一次(index=0) -1 < 5, 那么两人不动位置
 * 第二次(index=1) 5 > 3, 那么 两人换位置， 3 再跟 -1 比较， -1<3<5，则插入 -1 和 5中间
 * 变成 -1 3 5 4 0
 * 第三次(index=2) 5 > 4, 那么 4再找位置， 3<4<5， 那么就插入到 3,5 中间
 */
public class InsertSort {
    public static void main(String[] args) {
        ListNode listNode0 = new ListNode(-1);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode1 = new ListNode(4);
        ListNode listNode3 = new ListNode(0);
        listNode0.next = listNode5;
        listNode5.next = listNode2;
        listNode2.next = listNode1;
        listNode1.next = listNode3;

        ListNode node = insertionSortList(listNode0);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    
    public static ListNode insertionSortList(ListNode head) {
        if(null == head){
            return null;
        }
        if(null == head.next){
            return head;
        }
        ListNode topNode = new ListNode(-1);
        topNode.next = head;


        ListNode currNode = head;
        while (null != currNode.next){
            //如 7， 1， 3， 5
            //当前和下一个比，如果大于下一个，则下一个开始计算
                //如 7 > 1, 则 1 从Top开始遍历，直到遇到 大于他的值
            //下一个从 Top 遍历，当找到 比较后，大于他的值
                //1 > top, < 7， 则1 插入 top 和7 中间
            //1， 7， 3, 5
            //7开始比较，比3大， 则3 从 top 开始找，比1大，再找 比7小，所以插入 1,7中间
            ListNode nextNode = currNode.next;
            if(nextNode.val < currNode.val){
                //temp 4
                ListNode tempNode = topNode;
                currNode.next = nextNode.next;
                while (null != tempNode){
                    if(nextNode.val > tempNode.next.val){
                        tempNode = tempNode.next;
                    } else if(nextNode.val < tempNode.next.val){
                        nextNode.next = tempNode.next;
                        tempNode.next = nextNode;
                        break;
                    }
                }
            } else {
                currNode = currNode.next;
            }
        }
        return topNode.next;
    }



    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
