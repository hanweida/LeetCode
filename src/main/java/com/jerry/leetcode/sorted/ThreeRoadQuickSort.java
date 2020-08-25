package com.jerry.leetcode.sorted;

/**
 * 三路快排
 * 如果 相同部分元素非常多，那么我们的三路快速排序算法
 * 效果就会越明显，这也正是他的优点所在
 *
 * 原理就是 只排序 < v 和 > v 的元素， 不排序 =v
 */
public class ThreeRoadQuickSort {
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    static String a ;
    public static void main(String[] args) {
        threadLocal.set(a);

        ThreadLocal<String> threadLocal2 = new ThreadLocal<>();
        threadLocal2.remove();
        //threadLocal.set();
        int[] arry = {6 ,1, 6, 2, 7 ,9, 3, 6, 4, 5 ,10 ,8, 6};
        quickSort(arry, 0, arry.length - 1);
        System.out.println("dd");
    }

    public static void quickSort(int[] nums, int left, int right){
        //先找出随机数，交换，避免 有序数组, 先省略，直接用 二路排序原理
        if(left >= right){
            return;
        }

        int point = nums[left];
        int i = left + 1;
        int lt = left;
        int rt = right;

        while (i < rt){
            if(point > nums[i]){
                swap(nums, i, lt);
                i++;
                lt++;
            } else if(point == nums[i]){
                i++;
            } else {
                swap(nums, i, rt -1);
                rt --;
            }
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
