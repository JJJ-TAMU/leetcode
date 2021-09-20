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
    public ListNode swapPairs(ListNode head) {
        ListNode sentinel = new ListNode(0, head);
        ListNode copy = sentinel;

        while (pairExists(copy)) {
            copy = reversePair(copy);
        }
        return sentinel.next;
    }

    private static boolean pairExists(ListNode prev) {
        return prev.next != null && prev.next.next != null;
    }

    private static ListNode reversePair(ListNode prev) {
        ListNode first = prev.next;
        ListNode second = first.next;
        ListNode third = second.next;

        prev.next = second;
        second.next = first;
        first.next = third;
        return first;
    }
}