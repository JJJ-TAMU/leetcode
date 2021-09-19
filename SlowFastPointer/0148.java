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
    public ListNode sortList(ListNode head) {
        return iterative(head);
    }

    private static ListNode recursive(ListNode head) {
        if (head == null || head.next == null) {    return head;    }
        ListNode middle = findMiddle(head);
        ListNode second = recursive(middle.next);
        middle.next = null;
        head = recursive(head);
        return merge(head, second);
    }

    // Returns the middle node of the list given head
    private static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Merge the two lists
    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode();
        ListNode copy = sentinel;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                copy.next = l1;
                l1 = l1.next;
            } else {
                copy.next = l2;
                l2 = l2.next;
            }
            copy = copy.next;
        }
        copy.next = (l1 == null ? l2 : l1);
        return sentinel.next;
    }

    private static ListNode iterative(ListNode head) {
        int length = size(head);
        ListNode sentinel = new ListNode(0, head);
        ListNode copy = sentinel;
        for (int size = 1; size < length; size += size) {
            for (int lo = 0, hi = lo + size; hi < length; lo = hi + size, hi = lo + size) {
                ListNode first = copy.next;
                // get first-tail and second-tail
                ListNode[] coor = getTails(first, size);
                ListNode second = coor[0].next;
                coor[0].next = null;
                ListNode third = coor[1].next;
                coor[1].next = null;
                copy.next = merge(first, second);
                copy = coor[0].val <= coor[1].val ? coor[1] : coor[0];
                copy.next = third;
            }
        }
        return sentinel.next;
    }

    private static ListNode[] getTails(ListNode node, int size) {
        ListNode[] next = new ListNode[2];
        for (int i = 0; i < size - 1; i++) {
            node = node.next;
        }
        next[0] = node;
        for (int i = 0; i < size; i++) {
            if (node.next == null) {
                break;
            }
            node = node.next;
        }
        next[1] = node;
        return next;
    }

    private static int size(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
}