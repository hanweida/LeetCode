package com.jerry.leetcode.doublepoint;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right){
            int value = numbers[left] +numbers[right];
            if(value > target){
                right--;
            } else if(value < target){
                left--;
            } else {
                return new int[]{left, right};
            }

        }
        return new int[]{-1, -1};
    }
}
