package com.jerry.leetcode.search;

/**
 * 二分查找相关题目
 */
public class Solution {
//    给定一个按照升序排列的整数数组 nums，和一个目标值 target。
//    找出给定目标值在数组中的开始位置和结束位置
//    你的算法时间复杂度必须是 O(log n) 级别
//    如果数组中不存在目标值，返回 [-1, -1]。
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int[] result = searchRange(nums, 8);
        System.out.println();
        
    }
    public static int[] searchRange(int[] nums, int target) {
        int left = searchLeftRange(nums, target);
        int right = searchRightRange(nums, target);
        int[] result = {-1, -1};
        result[0] = left;
        result[1] = right;
        return result;
    }

    public static int searchLeftRange(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (target > nums[mid]){
                left = mid + 1;
            } else {
                right = left;
            }
        }

        if(nums[left] == target){
            return left;
        }
        return -1;
    }

    public static int searchRightRange(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left + 1) / 2;
            if (target < nums[mid]){
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        if(nums[left] == target){
            return left;
        }
        return -1;
    }
    
}
