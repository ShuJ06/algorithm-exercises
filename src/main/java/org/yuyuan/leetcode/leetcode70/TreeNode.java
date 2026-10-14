package org.yuyuan.leetcode.leetcode70;


// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    /**
     * 判断二叉树中是否存在「根到叶子」的路径，使路径上节点值之和等于 targetSum。
     *
     * @param root      树的根节点
     * @param targetSum 目标和
     * @return 存在这样的根-叶路径则返回 true，否则 false
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // 空树不存在任何路径
        if (root == null) {
            return false;
        }
        // 到达叶子节点：剩余目标恰好等于叶子自身取值即命中
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        // 否则扣除当前节点值，递归检查左右子树是否存在和为剩余值的路径
        int remaining = targetSum - root.val;
        return hasPathSum(root.left, remaining) || hasPathSum(root.right, remaining);
    }
}