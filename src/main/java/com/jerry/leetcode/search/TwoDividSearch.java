package com.jerry.leetcode.search;

/**
 * 二分查找法
 */
public class TwoDividSearch {
    public static void main(String[] args) {
//        int[] nums = {1,2,5};
//        int   target = 5;
//        System.out.println(search(nums, target, 0, nums.length - 1));
//        System.out.println(searchB(nums, target, 0, nums.length - 1));


        int[] nums = {5,7,7,8,9,10};
        int target = 8;
        System.out.println(searchD(nums, target, 0, nums.length - 1));
    }

    public static int search(int[] nums, int target) {
           return searchA(nums, target, 0, nums.length - 1);
    }

    public static int searchA(int[] nums, int target, int left, int right){
        int mid = (left + right) / 2;
        if(left >= right  && nums[mid] != target){
            return -1;
        }
        if(nums[mid] == target){
            return mid;
        } else if(nums[mid] > target){
            return searchA(nums,  target ,left, mid);
        } else {
            return searchA(nums,  target , mid + 1, right);
        }
    }

    public static int searchB(int[] nums, int target, int left, int right){
        while (left < right){
            int mid = left + (right - left + 1) / 2;
            if(nums[mid] > target){
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        if(nums[left] == target){
            return left;
        } else {
            return -1;
        }
    }

    /**
     * 原理就是排除法，将不符合的排除，最后剩下的，就是符合的
     * @param nums
     * @param target
     * @param left
     * @param right
     * @return
     */
    public static int searchC(int[] nums, int target, int left, int right){
        while (left < right){
            //边界问题，如果  right - left + 1 话，会造成死循环，上转
            int mid = left + (right - left) / 2;
            if(target > nums[mid]){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        //当跳出时，
        if(nums[left] == target){
            return left;
        } else {
            return -1;
        }
    };

    /**
     * 还是排除法
     * 上整型，当 left = mid 时，用  int mid = left + (right - left + 1) / 2; 上整形解法
     * @param nums
     * @param target
     * @param left
     * @param right
     * @return
     */
    public static int searchD(int[] nums, int target, int left, int right){
        while (left < right){
            int mid = left + (right - left + 1) / 2;
            if(target < nums[mid]){
                right = mid - 1;
            } else {
                left = mid ;
            }
        }
        //当跳出时，
        if(nums[left] == target){
            return left;
        } else {
            return -1;
        }
    };
}
