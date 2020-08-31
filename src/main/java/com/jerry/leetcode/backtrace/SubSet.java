package com.jerry.leetcode.backtrace;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * 求子集 【1， 2， 3】 求子集 如 {【】，【1】，【1,2】，【1,3】【1,2,3】，【2】，【2，3】，【3】}
 * 套用 回溯框架
 * 画出树形节点
 *          []
 * [1]      [2]     [3]
 * [1,2]    [2]     [3]
 * [1,2,3]  [2,3]
 */

public class SubSet {
    public static void main(String[] args) {
        SubSet subSet = new SubSet();

        int[] nums = {1,2,3};
        List<List<Integer>> rs = subSet.subsets(nums);
        System.out.println("");
    }

    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums){
        LinkedList traceList = new LinkedList();
        backtrace(nums, 0, traceList);
        return result;
    }

    public void backtrace(int[] nums, int start, LinkedList<Integer> track){
        result.add(new LinkedList<>(track));
        for(int i = start; i < nums.length; i++){
            //做选择
            track.add(nums[i]);
            //回溯
            backtrace(nums, i + 1, track);
            //撤回
            track.removeLast();
        }
    }
}
