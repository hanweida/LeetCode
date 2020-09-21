package com.jerry.leetcode.doublepoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};

        ThreeSum threeSum = new ThreeSum();
        threeSum.threeSum(nums);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for(int k = 0; k < nums.length - 2; k++){
            if(nums[k] > 0){break;}
            if(k > 0 && nums[k] == nums[k-1]){continue;}

            int i = k + 1;
            int j = nums.length - 1;

            while (i < j){
                int sum = nums[k] + nums[i] + nums[j];
                if(sum < 0){while (i < j && nums[i]==nums[++i]);}
                else if(sum > 0){while (i < j && nums[j]==nums[--j]);}
                else {
                    result.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while (i < j && nums[i]==nums[++i]);
                    while (i < j && nums[j]==nums[++j]);
                }
            }
        }
        return result;
    }
}
