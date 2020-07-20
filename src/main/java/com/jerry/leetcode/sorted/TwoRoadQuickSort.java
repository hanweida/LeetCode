package com.jerry.leetcode.sorted;

import java.util.Random;

/**
 * 二路快排
 *
 * 如果数组中有大量重复元素，>v部分会变得很长，导致左右两边不均衡，性能降低
 *
 * 当我们排序的是一个数值重复率非常高的序列时，
 * 此时随机化快速排序算法就不再起作用了，而将会再次退化为一个O(n^2)级别的排序算法
 *
 * 所以引用二路排序，解决大量重复元素，极端导致 O(n2)
 *
 * 原理就是  在原 left 和 right 基础上， 增加 i  和 j 指针
 * i 和 j 分别从两端，也就是 从 left 端 和 right 端 向中间移动，然后遇到 nums[i] > nums[key], num[j] < nums[key]交换
 *
 */
public class TwoRoadQuickSort {

    public static void main(String[] args) {
        int[] arry = {6 ,1, 6, 2, 7 ,9, 3, 6, 4, 5 ,10 ,8, 6};
        //int[] arry = {6 ,5, 4, 6};
        quickSort(arry, 0, arry.length - 1);
        System.out.println("dd");
    }

    public static void quickSort(int[] nums, int left, int right){
        //先找出随机数，交换，避免 有序数组, 先省略，直接用 二路排序原理
        if(left >= right){
            return;
        }

        int index = partition(nums, left, right);
        quickSort(nums, left, index -1);
        quickSort(nums, index+1, right);
    }

    public static int partition(int[] nums, int left, int right){
        int i = left + 1;
        int j = right;
        while (true){
            while (i <= right && nums[left] > nums[i]){
                i++;
            }
            while (j > left && nums[left] < nums[j]){
                j--;
            }
            if (i >= j){
                break;
            }
            swap(nums, i, j);
            i++;
            j--;
        }
        swap(nums, left, j);
        return j;
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
