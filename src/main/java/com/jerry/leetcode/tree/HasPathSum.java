package com.jerry.leetcode.tree;

/**
 * 路径总和 一： 简单
 * https://leetcode-cn.com/problems/path-sum/
 */
public class HasPathSum {

    /**
     * 递归方法
     * 时间复杂度 O(n)
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {

        if(root == null){
            return false;
        }

        if(root.left == null && root.right == null){
            return (sum - root.val) == 0;
        }


        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);

    }
}
