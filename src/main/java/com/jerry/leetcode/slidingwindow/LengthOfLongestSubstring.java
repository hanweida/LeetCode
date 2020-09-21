package com.jerry.leetcode.slidingwindow;

import java.util.HashMap;

//最长不含重复字符的子字符串
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbbdaf";
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring(s));
        System.out.println();
    }

    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;

        HashMap<Character, Integer> window = new HashMap<>();

        char[] sArray = s.toCharArray();
        int max = 0;
        while (right < sArray.length){
            char c = sArray[right];
            window.put(c, (int)window.getOrDefault(c, 0) + 1);
            right++;

            while ((int)window.get(c) > 1){
                char leftChar = sArray[left];
                window.put(leftChar, (int)window.getOrDefault(leftChar, 0) - 1);
                left ++;
            }

            max = Math.max(right - left, max);
        }

        return max;
    }
}
