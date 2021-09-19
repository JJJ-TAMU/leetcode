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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode copy = head;

        while (copy != null) {
            ListNode next = copy.next;

            while (next != null && next.val == copy.val) {
                next = next.next;
            }
            copy.next = next;
            copy = next;
        }
        return head;
    }
}