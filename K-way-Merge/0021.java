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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode();
        ListNode copy = sentinel;
        while (l1 != null && l2 != null) {
            if (less(l1, l2)) { copy.next = l1; l1 = l1.next;  }
            else              { copy.next = l2; l2 = l2.next;   }
            copy = copy.next;
        }
        if (l1 != null) {   copy.next = l1; }
        else {  copy.next = l2; }
        return sentinel.next;
    }

    private static boolean less(ListNode l1, ListNode l2) {
        return l1.val <= l2.val;
    }
}