package com.jerry.leetcode;

/**
 * 最小K求解
 * 解题思路：(类似二分法)其实就是根据两个数组，然后根据位于中位数，比较两个数组下标的值，小的一方，则删除下标以左的数，然后最后得出中位数
 * k 的值：k= k-k/2
 * 两个有序数组中下标为 k/2-1 
 *
 * 比如 A数组=[1, 2, 6, 7] B数组=[2, 3, 8, 9, 10]
 *
 * 第一轮： K的值: m + n (总个数) = k-k/2 = 5  , 比较下标为 5/2 -1 = 1 比较 A[1] B[1]，由于A[1]< B[1]， 则删除A[1]以左的数
 * 第一轮结果:  A数组=[(1, 2), 6, 7] B数组=[2, 3, 8, 9, 10]，由于 第一轮是 A小，所以A数组下标右移一位 进行第二轮
 * 第二轮: K的值: k-k/2 = (5 - 5/2) = 3 比较下标为 k/2-1 = 3/2-1 = 0, 则比较 A[2]与B[0]，由于A[2]>B[0]，则删除B[0], B数组下标右移一位B[1]，开始第三轮
 * 第三轮: K的值: k-k/2 = (3 - 3/2) = 2 比较下标为 k/2-1 = 2/2-1 = 0，则比较 A[0]（此时A[0]已经变成6了，因为左边的已经删除了）  B[1], A[0](6) > B[1](3)， 则B再右移一位
 * 第四轮: K的值: k-k/2 = (2 - 2/2) = 1 由于K=1，则比较两个有序数组，未排除的最小下标的数，也就是A[0]（6）与B[2]（8）比较，最小为6，则K个数=6
 *
 * 可以求 中位数
 *
 */
public class SmallestK {

    public static void main(String[] args) {
        int[] nums1 = {1};
        int[] nums2 = {2,3,4,5,6};
                         
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            double median = smallest(nums1, nums2, midIndex + 1);
            return median;
        } else {
            int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
            double median = (smallest(nums1, nums2, midIndex1 + 1) + smallest(nums1, nums2, midIndex2 + 1)) / 2.0;
            return median;
        }
    }

    public static int smallest(int[] num1, int[] num2, int k){
        int index1 = 0;
        int index2 = 0;
        while (true){

            //边界情况
            if(index1 == num1.length){
                return num2[index2 + k - 1];
            }

            if(index2 == num2.length){
                return num1[index1 + k - 1];
            }

            if(k == 1){
                return Math.min(num1[index1], num2[index2]);
            }

            int newIndex1 = Math.min(index1 + k/2, num1.length) - 1;
            int newIndex2 = Math.min(index2 + k/2, num2.length) - 1;

            if(num1[newIndex1] <= num2[newIndex2]){
                k = k - (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            }

            if(num1[newIndex1] > num2[newIndex2]){
                k = k - (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }

    }
}
