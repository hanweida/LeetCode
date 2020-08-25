package com.jerry.leetcode.sorted;

/**
 * 快速排序
 * 通过二分的方式，进行跳跃性的比较交换
 * 优点：
 *      快速排序的优点是原地排序，不占用额外空间，时间复杂度是O(nlogn)。
 * 缺点：
 *      含有大量重复元素的数组排序效率是非常低的，时间复杂度会降为O(n^2)
 *      而且当有序排序时，时间复杂度也会降为O(n^2)
 * 
 *
 * 快速排序使用分治法（Divide and conquer）策略来把一个串行（list）分为两个子串行（sub-lists）。
 *
 * 快速排序又是一种分而治之思想在排序算法上的典型应用。本质上来看，快速排序应该算是在冒泡排序基础上的递归分治法。
 *
 * 对绝大多数顺序性较弱的随机数列而言，快速排序总是优于归并排序。
 *
 * 如： 【6 ,1, 2, 7 ,9, 3, 4, 5 ,10 ,8】
 *
 * 第一次 以基数6 为交换点，然后前后指针开始 从两端遍历，j 指针从 末端向前遍历，当发现 arry[j] < arry[base] 【5 < 6】时，
 *          从前往后找，i++，当发现 arry[i] > arry[base] 时，【7 > 6】；i 和 j 交换，【也就是 7和5交换位置】；
 *          继续遍历，直到i 和j的位置 重合，交换 base 与 重合的位置【6和3交换】
 * 第一次比较结果： 3 ,1, 2, 5 ,4, 6, 9, 7 ,10 ,8
 * 第二次 以交换点为中心，递归遍历 交换点左面的数组，和交换点右边的数组
 *      也就是 遍历【3 ,1, 2, 5 ,4】 和 【9, 7 ,10 ,8】
 *
 * 问题：
 * 当我们排序的是一个近乎有序的序列时，快速排序会退化到一个O(n^2)级别的排序算法，
 * 而对此的改进就是引入了随机化快速排序算法
 * 
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arry = {6 ,1, 2, 7 ,9, 3, 4, 5 ,10 ,8};
        quickSort(arry, 0, arry.length - 1);
        System.out.println();
    }

    public static void quickSort(int[] arry , int start, int end){
        if(start >= end){
            return ;
        }
        int base = start;
        int i = start;
        int j = end;



        while (true){
            if(arry[j] >= arry[base] && j > i){
                j--;
            } else if(arry[j] < arry[base]&& j > i){
                i++;
                if(arry[i] > arry[base]){
                    int temp = arry[j];
                    arry[j]=arry[i];
                    arry[i] = temp;
                }
            } else if(j <= i && arry[j] < arry[base]){
                int temp = arry[j];
                arry[j]=arry[base];
                arry[base] = temp;
                quickSort(arry, start, j - 1);
                quickSort(arry, j + 1 , end);
                return;
            }
        }

    }
}
