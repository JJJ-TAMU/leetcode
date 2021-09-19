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
    public void reorderList(ListNode head) {
        // Step 1: find middle of the list
        if (head == null || head.next == null) {    return;     }
        // Step 2: split list into two parts
        ListNode middle = findMiddle(head);
        ListNode first = head;
        ListNode second = middle.next;
        middle.next = null;
        // Step 3: reverse the second part
        second = reverse(second);
        // Step 4: merge the two parts
        merge(first, second);      
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

    // Reverse the list and returns the new head
    private static ListNode reverse(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    // Mergers the two lists 
    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode();
        ListNode copy = sentinel;
        while (l1 != null && l2 != null) {
            copy.next = l1;
            l1 = l1.next;
            copy.next.next = l2;
            l2 = l2.next;
            copy = copy.next.next;
        }
        if (l1 != null) copy.next = l1;
        else copy.next = l2;
        return sentinel.next;
    }
}