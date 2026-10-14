package org.yuyuan.leetcode.leetcode70;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PathSumTest {

    /**
     * 构造示例树：
     *        5
     *       / \
     *      4   8
     *     /   / \
     *   11  13   4
     *   / \        \
     *  7   2        1
     * 根到叶路径 5-4-11-2 之和为 22；5-8-4-1 之和为 18。
     */
    private TreeNode buildTree() {
        TreeNode seven = new TreeNode(7);
        TreeNode two = new TreeNode(2);
        TreeNode eleven = new TreeNode(11, seven, two);
        TreeNode fourLeft = new TreeNode(4, eleven, null);
        TreeNode thirteen = new TreeNode(13);
        TreeNode one = new TreeNode(1);
        TreeNode fourRight = new TreeNode(4, null, one);
        TreeNode eight = new TreeNode(8, thirteen, fourRight);
        return new TreeNode(5, fourLeft, eight);
    }

    @Test
    @DisplayName("测试存在的根到叶路径")
    void existingPath() {
        Solution solution = new Solution();
        assertTrue(solution.hasPathSum(buildTree(), 22));
        assertTrue(solution.hasPathSum(buildTree(), 18));
    }

    @Test
    @DisplayName("测试不存在的路径")
    void missingPath() {
        Solution solution = new Solution();
        assertFalse(solution.hasPathSum(buildTree(), 20));
    }

    @Test
    @DisplayName("测试空树与单节点")
    void edgeCases() {
        Solution solution = new Solution();
        assertFalse(solution.hasPathSum(null, 0));
        assertTrue(solution.hasPathSum(new TreeNode(5), 5));
        assertFalse(solution.hasPathSum(new TreeNode(5), 4));
    }

    @Test
    @DisplayName("测试单侧子树需走到真正的叶子")
    void mustReachLeaf() {
        // 根 1 只有左子节点 2，目标 1 不构成根到叶路径
        TreeNode root = new TreeNode(1, new TreeNode(2), null);
        Solution solution = new Solution();
        assertFalse(solution.hasPathSum(root, 1));
        assertTrue(solution.hasPathSum(root, 3));
    }
}
