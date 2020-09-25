package com.jerry.leetcode.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 存在重复元素
 * https://leetcode-cn.com/problems/contains-duplicate/
 */
public class ContainsDuplicate {
    /**
     * 时间复杂度 O(n)
     * 空间复杂度O(n)
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hashSet = new HashSet();
        for(int i = 0; i < nums.length; i++){
            if(!hashSet.add(nums[i])){
                return true;
            }
        }
        return false;
    }

}
