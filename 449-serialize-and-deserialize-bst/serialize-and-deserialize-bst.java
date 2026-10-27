/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string using Preorder traversal.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        // Append value followed by a comma delimiter
        sb.append(node.val).append(",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    // Decodes your encoded data to tree using Queue and BST bounds.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode deserializeHelper(Queue<String> queue, int lower, int upper) {
        if (queue.isEmpty()) return null;
        
        // Peek at the next value to check if it fits the valid BST range
        String valStr = queue.peek();
        int val = Integer.parseInt(valStr);
        
        if (val < lower || val > upper) return null;
        
        // Valid node found; poll it from the queue
        queue.poll();
        TreeNode node = new TreeNode(val);
        node.left = deserializeHelper(queue, lower, val);
        node.right = deserializeHelper(queue, val, upper);
        
        return node;
    }
}
// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;