package com.jerry.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 可获得的最大点数
 * https://leetcode-cn.com/problems/maximum-points-you-can-obtain-from-cards/
 */
public class MaxScore {

    public static void main(String[] args) {
        int nums[] = {11,49,100,20,86,29,72};
        MaxScore maxScore = new MaxScore();
        System.out.println(maxScore.maxScore(nums, 4));
    }

        public int maxScore(int[] cardPoints, int k){
            Map<Integer, Integer> window = new HashMap<>();
            Map<Integer, Integer> needs = new HashMap<>();
            int max = 0;
            int left = -1, right = 0;

            while (left < k){
                int value = 0;
                if(left > -1){
                    value = cardPoints[left];
                    needs.put(left, needs.getOrDefault(left -1 , 0) + value);
                    window.put(left, needs.getOrDefault(left - 1, 0) + value);
                }

                int index = 0;
                right = cardPoints.length;
                while ((k - left - 1) > index){

                    window.put(left, window.getOrDefault(left, 0) + cardPoints[right-1]);
                    right--;
                    index++;
                }
                max = Math.max(window.getOrDefault(left, 0), max);
                left++;
            }
            return max;
        }
}

