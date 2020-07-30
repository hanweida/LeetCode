package com.jerry.leetcode.search;

//275. H指数 II

public class HIndex {
    public static void main(String[] args) {
        int[] nums = {0,1,3,5,6};
        System.out.println(hIndex(nums));
    }

    public static int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length  - 1;
        int length = citations.length;
        if(length == 0 || citations[length-1] == 0){
            return 0;
        }
        while (left < right){
            int mid = left + (right - left) / 2;
            if(citations[mid] < length - mid){
                left = mid +1;
            } else {
                right = mid;
            }
        }
        return length - left;
    }
}
