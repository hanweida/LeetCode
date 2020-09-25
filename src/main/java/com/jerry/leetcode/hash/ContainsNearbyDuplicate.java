package com.jerry.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 存在重复元素 II
 * https://leetcode-cn.com/problems/contains-duplicate-ii/submissions/
 * 时间复杂度(O(n))
 * 
 */
public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for(int i= 0; i < nums.length ; i++ ){
            if(hashMap.containsKey(nums[i])){
                int index = hashMap.get(nums[i]);
                if(Math.abs(i - index) <= k){
                    return true;
                }
                hashMap.put(nums[i], i);
            }else{
                hashMap.put(nums[i], i);
            }
        }
        return false;
    }
}
