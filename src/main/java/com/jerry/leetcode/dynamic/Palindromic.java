package com.jerry.leetcode.dynamic;


/**
 * 动态规划
 */
public class Palindromic {

    public static void main(String[] args) {
        //最长回文子串
        //System.out.println(longestPalindrome("ac"));

        //斐波那契
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
    
}
