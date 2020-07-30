package com.jerry.leetcode.search;

/**
 *
 * 300
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
 *
 * 最长上升子序列
 */
public class Solution3 {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 0;
        for(int num : nums){
            int i = 0, j = res;
            while (i < j){
                int mid = i + (j - i) / 2;
                if(dp[mid] < num){
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
            dp[i] = num;
            if(res == j) res++;
        }
        return res;
    }

}
