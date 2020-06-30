package com.jerry.leetcode;

/**
 * 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 */
public class CombineArray {
    /**
     * 解题思路：使用双指针合并
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums_copy = new int[nums1.length];
        System.arraycopy(nums1, 0, nums_copy, 0, nums1.length);
        int index_1 = 0;
        int index_2 = 0;

        int index = 0;

        while (index_1 < m && index_2 < n){
            nums1[index++] = nums_copy[index_1] < nums2[index_2] ? nums_copy[index_1++] : nums2[index_2++];
        }
        if(index_1 < m){
            System.arraycopy(nums_copy, index_1, nums1, index, m - index_1);
        }

        if(index_2 < n){
            System.arraycopy(nums2, index_2, nums1, index, n  - index_2);
        }
    }
}
