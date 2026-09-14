/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode slow = head;
        ListNode fast = head;

        // Move fast n steps
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // If we have to remove the first node
        if (fast == null) {
            return head.next;
        }

        // Move both
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove node
        slow.next = slow.next.next;

        return head;
    }
}