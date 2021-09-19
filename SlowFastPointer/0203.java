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
    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(0, head);
        ListNode copy = sentinel;

        while (copy.next != null) {
            if (copy.next.val == val) {
                copy.next = copy.next.next;
            } else {
                copy = copy.next;
            }
        }
        return sentinel.next;        
    }
}