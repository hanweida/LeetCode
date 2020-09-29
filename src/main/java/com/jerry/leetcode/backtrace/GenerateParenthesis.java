package com.jerry.leetcode.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/solution/gua-hao-sheng-cheng-by-leetcode-solution/
 */
public class GenerateParenthesis {
        List<String> resultlist = new ArrayList<String>();
        public List<String> generateParenthesis(int n) {
            if(n == 0){
                return resultlist;
            }

            backtrace(n, 0, 0, new StringBuilder());
            return resultlist;
        }

        public void backtrace(int n, int left, int right , StringBuilder stringBuilder){
            if(stringBuilder.length() == n *2){
                resultlist.add(new String(stringBuilder.toString()));
                return;
            }

            if(left < n){
                stringBuilder.append("(");
                backtrace(n, left + 1, right, stringBuilder);
                stringBuilder.deleteCharAt(stringBuilder.length()-1);

            }
            if(right < left){
                stringBuilder.append(")");
                backtrace(n, left, right + 1, stringBuilder);
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
            }
        }
}
