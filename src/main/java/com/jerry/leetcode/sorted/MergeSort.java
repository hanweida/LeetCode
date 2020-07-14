package com.jerry.leetcode.sorted;

import java.util.Arrays;

/**
 * 归并排序
 * 基本思路：借助额外空间，合并两个有序数组，得到更长的有序数组
 * 算法思想：分而治之（分治思想）。「分而治之」思想的形象理解是「曹冲称象」、MapReduce，在一定情况下可以并行化。
 *
 * 归并排序（MERGE-SORT）是利用归并的思想实现的排序方法，
 * 该算法采用经典的分治（divide-and-conquer）策略（分治法将问题分(divide)成一些小的问题然后递归求解，
 * 而治(conquer)的阶段则将分的阶段得到的各答案"修补"在一起，即分而治之)
 */
public class MergeSort {
    public static void main(String []args){
        int []arr = {7,6,8,4,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
                          
    public static void sort(int[] arr){
        int[]  temp = new int[arr.length];
        sort(arr, 0, arr.length-1, temp);
    }

    public static void sort(int[] arr, int left, int right, int[] temp){
        if(left >= right){
            return;
        }

        if(left < right){
            int mid = (left + right) / 2;
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);
            merge(arr, left, right, temp);
        }
    }

    public static void merge(int[] arr, int left, int right, int[] temp){
        int mid = (left + right) / 2;
        int start1 = left, end1 = mid;
        int start2 = mid + 1, end2 = right;
        int k = left;
        while (start1 <= end1 && start2 <= end2){
            temp[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        }
        while (start1 <= end1){
            temp[k++] = arr[start1++];
        }
        while (start2 <= end2){
            temp[k++] = arr[start2++];
        }
        for(int i = left; i < right+1 ; i++){
            arr[i] = temp[i];
        }
    }
}
