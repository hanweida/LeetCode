package com.jerry.leetcode.search;

/**
 * 二分查找相关题目
 */
public class Solution2 {
    //https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
    // 33. 搜索旋转排序数组
    //假设按照升序排序的数组在预先未知的某个点上进行了旋转。
    public static void main(String[] args) {
        int[] nums = {6,7,8,9,0,1,2,4,5};
        int result = searchRange(nums, 6);
        System.out.println(result);
        
    }

    /**
     * 废了好大的劲。。。 一上午
     *
     * 解题思路就是：最终通过比对 mid与 target 相同，返回结果
     * 由于螺旋后， 出现 两组 有序数列，通过不断比较 left - mid 之间是否有序
     * 如果left-mid 是有序的，
     *      那么如果 target 在 这个有序区间 判断有值的话，就缩小区间值
     *      如果 target 在这个有序区间没有值的话，则找 另一个区间
     * 如果left-mid 是无序的， 那说明 mid - right 是有序的，所以通过 比较 target 是否在 mid-right 区间就可以判断
     *
     * 所以最终是通过 查找 在有序的区间内 查找是否有 target， 再进一步缩小空间，直至找到 mid=tartet
     *
     * 思路：一个是要 确定目标，比如 一定要通过在 有序的范围区间内，判断是否存在值；
     * 通俗讲 就是，
     *      我要看 left - mid 之间是不是有序的
     *          如果是有序的，我就在这里找 有没有 target；有的话我就这里找（left-mid），没有的话，我就在 (mid-right)找就完事了
 *          那当 left-mid 之间 不是有序时，那我就知道 mid-right 肯定是有序的
     *          那就在 mid-right里找，找到的话 就缩小区间 （mid-right）里继续查找
     *          找不到的话，就在(left-mid) 里查找
     *
     * 所以一定要在 有序区间里判断，是否含有 target， 因为无序是判断不出来的；
     * 同时要注意边界问题：比如 target 是第一个元素，或者是 最后一个元素时，边界怎么判断的
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }
            //有序
            if(nums[left] <= nums[mid]){
                if(nums[left] <= target && nums[mid] >= target){
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else {
                //无序
                if(target > nums[mid] && target <= nums[right]){
                    left = mid;
                } else {
                    right = mid;
                }
                
            }
        }
        return -1;
    }
}
