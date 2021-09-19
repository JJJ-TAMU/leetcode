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
        // There is possibility that head is the nth node, we use sentinel
        ListNode sentinel = new ListNode(0, head);

        ListNode fast = getkthNode(sentinel, n);
        ListNode slow = sentinel;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return sentinel.next;
    }

    private static ListNode getkthNode(ListNode sentinel, int k) {
        for (int i = 0; i < k; i++) {
            sentinel = sentinel.next;
        }
        return sentinel;
    }
}