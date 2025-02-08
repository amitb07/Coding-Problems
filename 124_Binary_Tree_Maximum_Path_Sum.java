// 124. Binary Tree Maximum Path Sum
// https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// Approach:
// Use a helper function calc to calculate the maximum path sum for each subtree.
// For every node:
// Compute the maximum contribution from its left and right children (ignoring negative sums).
// Update a global variable max to store the maximum path sum, including the node and its subtrees.
// Return the maximum path sum where the current node is part of the path.
// TimeComplexity: O(n) each node is traversed only once
// Space complexity: O(height of the tree)  Recursive calls take up space in the call stack
class Solution {
    int answer = Integer.MIN_VALUE;
    public int maxPathSumUtil(TreeNode root) {
        if(root==null) return 0;

        int left = Math.max(0, maxPathSumUtil(root.left));
        int right = Math.max(0, maxPathSumUtil(root.right));
        answer = Math.max(answer, Math.max(root.val+left+right, Math.max(root.val, root.val+Math.max(left, right))));
        return root.val+Math.max(left, right);
    }
    public int maxPathSum(TreeNode root) {
        maxPathSumUtil(root);
        return answer;
    }

}