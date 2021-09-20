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
    public ListNode rotateRight(ListNode head, int k) {
        int size = size(head);
        if (size == 0) {    return head;    }
        k %= size;

        if (k == 0) {   return head;    }

        ListNode prev = getIth(head, size - k - 1);
        ListNode tail = prev;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = head;
        ListNode newHead = prev.next;
        prev.next = null;
        return newHead;
    }

    private static int size(ListNode head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }
        return size;
    }

    private static ListNode getIth(ListNode head, int k) {
        for (int i = 0; i < k; i++) {
            head = head.next;
        }
        return head;
    }
}