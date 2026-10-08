class Solution {
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return max;
    }
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        max = Math.max(max, left + right);
        return 1 + Math.max(left, right);
    }
}
