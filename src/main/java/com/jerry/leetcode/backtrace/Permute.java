package com.jerry.leetcode.backtrace;

import java.util.LinkedList;
import java.util.List;

public class Permute {
    public static void main(String[] args) {
        Permute permute = new Permute();
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> rs = permute.permute(nums);
        System.out.println(rs);
    }


    public List<List<Integer>> permute(int[] nums) {
        LinkedList traceList = new LinkedList();
        backtrace(nums, traceList);
        return result;
    }

    List<List<Integer>> result = new LinkedList<>();

    //选择条件 i
    //路径： trace
    //选择列表；nums 中，不存在 trace的元素
    //结束条件：nums 中的元素 全在 trace中
    public void backtrace(int[] nums, LinkedList<Integer> traceList){
        //结束条件；
        if(nums.length == traceList.size()){
            result.add(new LinkedList<Integer>(traceList));
            return;
        }

        //for 选择: 选择列表
        for(int i = 0; i < nums.length ; i++){
            //去除 trace中已有的 num【如 trace{2,3} ，当num ==2时，过滤】
            if(traceList.contains(nums[i])){
                continue;
            }
            //将选择加到trace列表
            traceList.add(nums[i]);
            //递归遍历 回溯
            backtrace(nums, traceList);
            //撤销选择：回退前一节点
            traceList.removeLast();
        }
    }
}
