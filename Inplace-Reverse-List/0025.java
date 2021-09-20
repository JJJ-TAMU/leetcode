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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2) {    return head;    }
        int size = size(head);

        int groups = size / k;

        ListNode sentinel = new ListNode(0, head);
        ListNode copy = sentinel;

        for (int i = 0; i < groups; i++) {
            copy = reverseGroup(copy, k);
        }
        return sentinel.next;
    }

    private static ListNode reverseGroup(ListNode prev, int k) {
        ListNode tail = getGroupEnd(prev, k);
        ListNode next = tail.next;
        tail.next = null;
        ListNode head = prev.next;
        prev.next = reverse(head);
        head.next = next;
        return head;
    }

    private static int size(ListNode head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }
        return size;
    }

    private static ListNode getGroupEnd(ListNode prev, int k) {
        for (int i = 0; i < k; i++) {
            prev = prev.next;
        }
        return prev;
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {    return head;    }

        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;        
    }
}