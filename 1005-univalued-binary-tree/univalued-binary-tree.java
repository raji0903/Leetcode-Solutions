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
    public boolean isUnivalTree(TreeNode root) {
        // Base case: an empty tree is vacuously univalued
        if (root == null) {
            return true;
        }
        
        // Check left child: if it exists, its value must match the root's value
        if (root.left != null && root.left.val != root.val) {
            return false;
        }
        
        // Check right child: if it exists, its value must match the root's value
        if (root.right != null && root.right.val != root.val) {
            return false;
        }
        
        // Recursively check the left and right subtrees
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}