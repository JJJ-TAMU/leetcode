/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode meet = findMeetPoint(head);
        return meet == null ? null : getEntrance(head, meet);
    }

    private static ListNode findMeetPoint(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }

    private static ListNode getEntrance(ListNode head, ListNode fast) {
        while (head != fast) {
            head = head.next;
            fast = fast.next;
        }
        return fast;
    }
}