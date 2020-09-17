package com.jerry.leetcode.slidingwindow;

import java.util.HashMap;

/**
 * 最小覆盖子串
 * https://leetcode-cn.com/problems/minimum-window-substring/
 *
 * s: abcdn
 * t: bd
 *
 * 滑动窗口原理步骤
 * 1. 【获得答案集】left和right 指针，从 0 起步，right 指针不断向右滑动，直到 窗口完全 包含 子串[abcd]
 * 2. 【优化 答案集】 left 开始向右滑动，直到下一个元素不在 窗口解内[bcd]（也就是说如果left再滑动，cd 显然不是t的子串答案）
 * 3. 重复直接，要到 最小 解
 * 
 */
public class MinWindow {
    public static void main(String[] args) {
        String S = "a";
        String T = "aa";

        MinWindow minWindow = new MinWindow();
        System.out.println(minWindow.minWindow(S, T));
        System.out.println();
    }

    public String minWindow(String s, String t) {
        int right = 0, left = 0;
        int match = 0;
        int start = 0;
        int min = Integer.MAX_VALUE;

        //窗口
        HashMap window = new HashMap();

        HashMap needs = new HashMap();
        char[] tArray = t.toCharArray();
        char[] sArray = s.toCharArray();


        for(int i = 0 ; i< tArray.length; i++){
            needs.put(tArray[i], ((int)needs.getOrDefault(tArray[i], 0)) +1);
        }

        while (right < s.length()){
            if(needs.containsKey(sArray[right])){
                //往窗口里放元素
                window.put(sArray[right], ((int)window.getOrDefault(sArray[right], 0)) + 1);
                if((int)window.get(sArray[right]) == (int)needs.get(sArray[right])){
                   match++;
                }
            }
            //增大窗口
            right++;

            //符合条件，left 指针移动
            while (match == needs.size()){
                //判断最小长度
                if(right - left < min){
                    //记录最小子串起始位置
                    start = left;
                    min = right - left;
                }

                //包含则进行 匹配处理
                if(needs.containsKey(sArray[left])){
                    window.put(sArray[left], (int)window.getOrDefault(sArray[left], 0) -1);
                    if((int)window.get(sArray[left]) < (int)needs.get(sArray[left])){
                        match--;
                    }
                }
                //缩小窗口
                left++;
            }
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(start, start+ min);
    }
}
