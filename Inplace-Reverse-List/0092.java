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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {    return head;    }
        ListNode sentinel = new ListNode(0, head);

        ListNode prev = getIth(sentinel, left - 1);
        ListNode tail = getIth(prev, right - left + 1);

        ListNode nextHead = tail.next;
        tail.next = null;
        ListNode newTail = prev.next;
        prev.next = reverse(prev.next);
        newTail.next = nextHead;
        return sentinel.next;
    }

    private static ListNode getIth(ListNode prev, int k) {
        for (int i = 0; i < k; i++) {
            prev = prev.next;
        }
        return prev;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {    return head;    }

        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;        
    }
}