/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node currNode = queue.poll();
                currentLevel.add(currNode.val);

                // Add all children of the current node to the queue
                if (currNode.children != null) {
                    for (Node child : currNode.children) {
                        if (child != null) {
                            queue.offer(child);
                        }
                    }
                }
            }
            result.add(currentLevel);
        }

        return result;
    }
}