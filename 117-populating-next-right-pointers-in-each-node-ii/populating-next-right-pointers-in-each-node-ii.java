/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Node curr = root; // Current node on the upper level
        
        while (curr != null) {
            Node dummyHead = new Node(0); // Dummy head to start the next level's list
            Node tail = dummyHead;       // Tail pointer to build the next level's list
            
            // Traverse the current level using the established 'next' pointers
            while (curr != null) {
                if (curr.left != null) {
                    tail.next = curr.left;
                    tail = tail.next;
                }
                if (curr.right != null) {
                    tail.next = curr.right;
                    tail = tail.next;
                }
                curr = curr.next; // Move to the next node on the current level
            }
            
            // Move down to the next level
            curr = dummyHead.next;
        }
        
        return root;
    }
}