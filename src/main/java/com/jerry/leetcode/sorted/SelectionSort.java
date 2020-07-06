package com.jerry.leetcode.sorted;

/**
 * 选择排序
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
        nums = sortArray(nums);
        for(int i: nums){
            System.out.println(i);
        }
    }

    public static int[] sortArray(int[] nums) {
        for(int i = 0; i < nums.length -1 ; i++){
            int index = i;
            for(int j = i + 1; j < nums.length; j++){
                if(nums[index] > nums[j]){
                    index = j;
                }
            }
            swap(nums, index, i);
        }
        return nums;
    }

    public static int[] swap(int[] nums, int index, int i){
        int temp = nums[index];
        nums[index] = nums[i];
        nums[i] = temp;
        return nums;
    }
}
