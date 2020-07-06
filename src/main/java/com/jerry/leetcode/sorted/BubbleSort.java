package com.jerry.leetcode.sorted;

/**
 * 冒泡排序
 * 原理就是：按大小个排队，从前往后找，一个比一个，两个相比较大的再跟后边的比，达到 最大的先站最后，
 * 然后 再从头往后找，一直比较 倒数第二个大的 站倒数第二个位置
 *
 * -1,5,3,6,0
 *
 * 第一次：-1与5比较，5大
 * 第二次：5与3比较，5大   -1,3,5,6,0
 * 第三次：5与6比较，6大   -1,3,5,6,0
 * 第四次：6与0比较，6大   -1,3,5,0,6
 *
 * 再循环一次就是  -1,3,0,5,6
 *
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
        nums = sortArray(nums);
        for(int i: nums){
            System.out.println(i);
        }
    }

    public static int[] sortArray(int[] nums) {
        int length = nums.length;
        for(int i = 0; i < length -1 ; i++){
            for(int j = 0; j < length-i-1; j++){
                if(nums[j] > nums[j+1]){
                    swap(nums, j, j+1);
                }
            }
        }
        return nums;
    }

    public static int[] swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
        return nums;
    }
}
