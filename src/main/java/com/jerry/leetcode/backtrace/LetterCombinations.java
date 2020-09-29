package com.jerry.leetcode.backtrace;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinations {
    List<String> result = new LinkedList<String>();

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) {
            return result;
        }
        Map<Character, String> map = new HashMap<Character, String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtrace(map, digits, 0, new StringBuilder());
        return result;
    }

    public void backtrace(Map map, String digits, int index, StringBuilder stringBuilder){
        //添加
        if(digits.length() == index){
            result.add(new String(stringBuilder.toString()));
        } else{
            String c = (String)map.get(digits.charAt(index));

            //做选择
            for(int i = 0; i < c.length(); i++){
                stringBuilder.append(c.charAt(i));
                backtrace(map, digits, index + 1, stringBuilder);
                stringBuilder=stringBuilder.deleteCharAt(stringBuilder.length()-1);
            }
        }

    }
}
