package com.jerry.leetcode.dynamic;


import java.util.Arrays;
import java.util.HashMap;

/**
 * 动态规划
 */
public class Palindromic {

    public static void main(String[] args) {
        //最长回文子串
        //System.out.println(longestPalindrome("ac"));
        //斐波那契

        //int[] arry =  {1,2,3,1};
        //System.out.println(rob(arry));

        int[] arry = {1,3};
        System.out.println(findLengthOfLCIS(arry));
    }

    /**
     * 最长回文子串
     * 通过 动态规划方法求解
     * 动态规划问题 主要通过 历史问题 来解决当前问题
     * 通过空间换时间
     */
    public static String longestPalindrome(String s) {
        int length = s.length();

        int begin = 0;
        int maxlength = 1;

        boolean[][] arry = new boolean[length][length];

        if(length <= 1){
            return s;
        }

        char[] chars = s.toCharArray();

        for(int j = 1; j < length; j++){
            for(int i =0; i < j; i ++){
                if(chars[j] != chars[i]){
                    arry[i][j] = false;
                }
                else if(chars[j] == chars[i]){
                    if(j - i < 3){
                        arry[i][j] = true;
                    } else {
                        arry[i][j] = arry[i+1][j-1];
                    }
                }

                if(arry[i][j] && j -i + 1 > maxlength){
                    begin = i;
                    maxlength = j -i + 1;
                }
            }
        }

        return s.substring(begin, maxlength + begin);
    }

    //斐波那契
    public int fib(int N) {

        if(N < 2){
            if(N == 0){
                return 0;
            }
            if(N == 1){
                return 1;
            }
        }
        int[] dp = new int[N+1];

        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i < N + 1 ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[N];
    }

    /**
     * 爬楼梯 70题
     * https://leetcode-cn.com/problems/climbing-stairs/
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        //经过计算 f(2)=2 f(3)=3 f(4)=4= f(2) + f(3); f(5)=f(4) + f(3)
        //得出规律 f(n)=f(n-1) + f(n-2)

        if(n < 4){
            return n;
        }
        int[] dp = new int[n+1];
        dp[2]=2;
        dp[3]=3;
        for(int i = 4; i < n+1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    /**
     * 零钱兑换 322
     * https://leetcode-cn.com/problems/coin-change/
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);

        for(int i = 1; i<amount+1; i++){
            for(int coin : coins){
                if(i - coin > 0){
                    dp[i] = Math.min(dp[i], 1 + dp[i-coin]);
                }
                if(i - coin == 0){
                    dp[i] =1;
                }
            }
        }

        if(dp[amount] == amount + 1){
            dp[amount] = -1;
        }
        return dp[amount];
    }

    /**
     * 198. 打家劫舍
     * https://leetcode-cn.com/problems/house-robber/
     */
    public static int rob(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length+1];

        if(length == 0){
            return 0;
        }
        if(length == 1){
            dp[0] = 0;
            dp[1] = nums[0];
            return nums[0];
        }
        if(length == 2){
            dp[0] = 0;
            dp[1] = nums[0];
            dp[2] = Math.max(nums[0], nums[1]);
            return dp[2];
        }
        dp[0] = 0;
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0], nums[1]);
        for(int i = 3; i<= length; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }
        return dp[length];
    }

    /**
     * https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/
     * 673. 最长递增子序列的个数
     */
    public static int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i-1]){
                dp[i] = dp[i-1] + 1;
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
