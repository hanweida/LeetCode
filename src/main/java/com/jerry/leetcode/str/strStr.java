package com.jerry.leetcode.str;

/**
 * 实现 strStr() 函数
 * https://leetcode-cn.com/problems/implement-strstr/
 */
public class strStr {
    public int strStr(String haystack, String needle) {
        char[] hayArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();

        int i = 0, j = 0;
        int match = 0;
        if(needle.equals("")){
            return 0;
        }
        if(needle.length() > haystack.length()){
            return -1;
        }
        while (i < hayArray.length){
            if(hayArray[i] == needleArray[j]){
                int temp = i;
                while (j < needleArray.length && temp< hayArray.length){
                    if(hayArray[temp] == needleArray[j]){
                        match++;
                        j++;
                        temp++;
                    } else {
                        break;
                    }
                    if(match == needleArray.length){
                        return i;
                    }
                }
                match = 0;
                j = 0;
            }
            i++;
        }
        return -1;
    }

    public int strStr2(String haystack, String needle) {
        char[] hayArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();

        int i = 0, j = 0;
        int match = 0;
        if(needle.equals("")){
            return 0;
        }
        if(needle.length() > haystack.length()){
            return -1;
        }
        while (i < hayArray.length){
            if(hayArray[i] == needleArray[j]){
                match++;
                j++;
                if(match == needleArray.length){
                    return i;
                }
            } else if(match > 0){
                j = 0;
                match = 0;
            } else if(match == 0){
                i++;
            }
        }
        return -1;
    }
}
