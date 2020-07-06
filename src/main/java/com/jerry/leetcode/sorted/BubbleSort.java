package com.jerry.leetcode.sorted;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
        nums = sortArray(nums);
        for(int i: nums){
            System.out.println(i);
        }
    }

    public static int[] sortArray(int[] nums) {
        int length = nums.length;
        for(int i = 0; i < length -1 ; i++){
            for(int j = 0; j < length-i-1; j++){
                if(nums[j] > nums[j+1]){
                    swap(nums, j, j+1);
                }
            }
        }
        return nums;
    }

    public static int[] swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
        return nums;
    }
}
