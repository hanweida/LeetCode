package com.jerry.leetcode.backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 字母大小写全排列
 * https://leetcode-cn.com/problems/letter-case-permutation/
 */
public class LetterCasePermutation {
    public static void main(String[] args) {
        LetterCasePermutation letterCasePermutation = new LetterCasePermutation();
        letterCasePermutation.letterCasePermutation("a1b2");
        System.out.println(letterCasePermutation.result);
    }

    List<String> result = new ArrayList<>();
    public List<String> letterCasePermutation(String S) {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> str = new LinkedList<>();
        char[] arry = S.toCharArray();
        backtrace(arry, 0, stringBuilder);
        return result;
    }

    public void backtrace(char[] s, int start ,StringBuilder stringBuilder){
        //结束条件
//        result.add(new LinkedList<String>(str));
        if(s.length == stringBuilder.length()){
            result.add(new String(stringBuilder.toString()));
            return;
        }
        //选择
        for(int i = start; i < s.length; i++){
        //添加
            stringBuilder.append(s[i]);
            //回溯
            backtrace(s, i + 1, stringBuilder);
            //撤回
            stringBuilder = stringBuilder.deleteCharAt(stringBuilder.length()-1);
//
            if(Character.isLetter(s[i])){
                if(Character.isLowerCase(s[i])){
                    stringBuilder.append(Character.toUpperCase(s[i]));
                    //回溯
                    backtrace(s, i + 1, stringBuilder);
                    //撤回
                    stringBuilder = stringBuilder.deleteCharAt(stringBuilder.length()-1);
                }
                if(Character.isUpperCase(s[i])){
                    stringBuilder.append(Character.toLowerCase(s[i]));
                    //回溯
                    backtrace(s, i + 1, stringBuilder);
                    //撤回
                    stringBuilder = stringBuilder.deleteCharAt(stringBuilder.length()-1);
                }
            }

        }
    }
}
