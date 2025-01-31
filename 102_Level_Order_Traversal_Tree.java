// 102. Binary Tree Level Order Traversal
// https://leetcode.com/problems/binary-tree-level-order-traversal/description/
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
class Solution {
    // Time: O(n) Space: O(1)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        preOrderTraversal(root, answer, 0);
        return answer;
    }
    void preOrderTraversal(TreeNode root, List<List<Integer>> answer, int height) {
        if(root == null)
            return;
        if(answer.size() == height){
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            answer.add(list);
        }
        else {
            answer.get(height).add(root.val);
        }
        preOrderTraversal(root.left, answer, height+1);
        preOrderTraversal(root.right, answer, height+1);
    }
}