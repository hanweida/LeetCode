package com.jerry.leetcode.doublepoint;

import java.util.Arrays;

/**
 * 最接近的三数之和
 * https://leetcode-cn.com/problems/3sum-closest/
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int[] num = {1,1,-1,-1,3};
        threeSumClosest.threeSumClosest(num, -1);
    }                   

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int sumclosest = nums[0] + nums[1] + nums[2];
        int minDiff = Math.abs(target - sumclosest);
        for(int i = 0; i < nums.length - 2 ; i++){
            int left = i + 1;
            int right = nums.length - 1;
            int currentTarget = target - nums[i];

            while (left < right){

                int diff = currentTarget - nums[left] - nums[right];

                if(diff == 0){
                    return target;
                }

                if(Math.abs(diff) < Math.abs(minDiff)){
                    minDiff = Math.abs(diff);
                    sumclosest = nums[i] + nums[left] + nums[right];
                }

                if(diff > 0){
                    //优化 重复过滤
                    do {
                        left++;
                    } while (left < right && nums[left] == nums[left - 1]);
                } else {
                    do {
                        right--;
                    } while (left < right && nums[right] == nums[right + 1]);
                }
                
            }
        }
        return sumclosest;
    }
}
