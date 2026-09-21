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
    public ListNode partition(ListNode head, int x) {
        // Dummy heads for the two separate partitions
        ListNode beforeHead = new ListNode(0);
        ListNode afterHead = new ListNode(0);

        // Pointers to build the two lists
        ListNode before = beforeHead;
        ListNode after = afterHead;

        // Iterate through the original list
        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        // Terminate the 'after' list to avoid cycles
        after.next = null;

        // Connect the 'before' list to the 'after' list
        before.next = afterHead.next;

        return beforeHead.next;
    }
}