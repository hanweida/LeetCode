package com.jerry.leetcode.backtrace;

import java.util.LinkedList;
import java.util.List;

//求组合
//输入两个数组 n、k， 算法输出 [1.....n] 中k个数字的所有组合
//如 【4，2】
//{【1,2】/ 【1,3】【1,4】【2,3】【2,4】【3,4】}
public class Combine {

    public static void main(String[] args) {
        Combine subSet = new Combine();

        int[] nums = {1,2,3};
        List<List<Integer>> rs = subSet.combine(nums);
        System.out.println("");
    }

    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> combine(int[] nums){
        LinkedList traceList = new LinkedList();
        backtrace(4, 2, 1, traceList);
        return result;
    }

    public void backtrace(int n, int k, int start, LinkedList<Integer> track){
        //因为k代表层数，所以如果k=2时，代表两层，则结束条件 k==0时，代表 遍历两层
        if(k == 0){
            result.add(new LinkedList<>(track));
            return;
        }

        //start 代表每层起始值 当第二层时，起始就为 2，所以是 【1,2】；再次循环第二层，起始为3【1,3】，再次循环第二层，则为【1,4】
        //i 为 选择【所以如 用 1 选择时】
        for(int i = start; i <= n; i++){
            //做选择
            track.add(i);
            //回溯
            //回溯时，通过k 值来判定是 第几次；通过 start 来设定每层的起始值
            backtrace(n, k-1, i+1, track);
            //撤回
            track.removeLast();
        }
    }
}
