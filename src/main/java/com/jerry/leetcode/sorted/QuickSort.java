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
 * 如： 6 2 1 3 9 7
 *
 * 第一次 以基数6 为交换点， 结果 小于 6 的排到 6的左面， 大于6 的排到 6的后面 2 1 3 6 9 7
 * 第二次 以2 为基数， 1 2 3 6 9 7
 * 第三次以 1 为基数
 *
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
        //6 ,1, 2, 5 ,9, 3, 4, 7 ,10 ,8
        //6 ,1, 2, 5 ,4, 3, 9, 7 ,10 ,8
        //3,1,2,5,4,6,9,7,10,8
        //2,1,3,5,4
        //1,2,3,4,5
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
