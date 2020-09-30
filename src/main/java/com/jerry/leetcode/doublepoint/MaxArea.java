package com.jerry.leetcode.doublepoint;

/**
 * 盛最多水的容器
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while(left < right){
            int minHeight = Math.min(height[left], height[right]);
            max = Math.max(max, minHeight * (right - left));
            if(height[left] > height[right]){
                right--;
            } else{
                left++;
            }
        }
        return max;
    }
}
