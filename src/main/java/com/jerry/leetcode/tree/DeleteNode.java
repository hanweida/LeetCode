package com.jerry.leetcode.tree;

public class DeleteNode {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(2);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(7);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode3.right =  treeNode6;


        DeleteNode deleteNode = new DeleteNode();
        deleteNode.deleteNode(treeNode1, 3);
        System.out.println();
    }

    /**
     * 450. 删除二叉搜索树中的节点
     * https://leetcode-cn.com/problems/delete-node-in-a-bst/
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        //root == null
        if(root == null){ return null;}
        if(root.val == key){
            //左右子树为null, 则直接删除
            if(root.left == null && root.right == null){
                root = null;
            } else if(root.left == null){
                root = root.right;
            } else if(root.right == null){
                root = root.left;
            } else if(root.left != null && root.right != null){
                // 左右都有值, 找右子树种，最小的
                TreeNode min = getMin(root.right);
                root.val = min.val;
                root.right = deleteNode(root.right, min.val);
            }

        } else if(root.val > key){
            root = deleteNode(root.left, key);
        } else if(root.val < key){
            root = deleteNode(root.right, key);
        }
        return root;
    }

    TreeNode getMin(TreeNode treeNode){
        while (treeNode.left != null){
            treeNode = treeNode.left;
        }
        return treeNode;
    }

   static class TreeNode {
        int val;
        com.jerry.leetcode.tree.DeleteNode.TreeNode left;
        com.jerry.leetcode.tree.DeleteNode.TreeNode right;
        TreeNode(int x) { val = x; }
    }
}


