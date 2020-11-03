package com.jerry.leetcode.sorted;

/**
 * 堆排序（两步、 建堆和排序）
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arry = {0, 4, 1, 2, 5};
        sort(arry, 4);
        System.out.println();
    }

    //第一步，构建堆
    private static void buildHeap(int[] a, int n){
        // n/2 到 1 是非叶子节点，需要堆化
        // n/2 到 n 是 叶子节点，不需要堆化
        for(int i = n/2; i >= 1; i--){
            heapify(a, n, i);
        }
    }

    private static void heapify(int[] a, int n, int i){
        while (true){
            int maxPox = i;
            if(i * 2 <= n && a[i] < a[i*2]){maxPox = i*2;}
            if(i * 2 + 1 <=n && a[maxPox] < a[i*2+1]){maxPox = i*2+1;}
            if(maxPox == i){break;}
            swap(a, maxPox, i);
            i = maxPox;
        }
    }

    private static void swap(int[]a, int maxPox, int i){
        int temp = a[maxPox];
        a[maxPox] = a[i];
        a[i] = temp;
    }

    //第二步，构建堆+排序
    public static void sort(int[] a, int n){
        buildHeap(a, n);
        int k = n;
        while (k > 1){
            swap(a, 1, k);
            k--;
            heapify(a, k, 1);
        }
    }
}
