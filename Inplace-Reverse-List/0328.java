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
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode();
        ListNode evenHead = new ListNode();

        ListNode oddCopy = oddHead;
        ListNode evenCopy = evenHead;

        while (head != null) {
            oddCopy.next = head;
            oddCopy = head;
            head = head.next;
            if (head != null) {
                evenCopy.next = head;
                evenCopy = head;
                head = head.next;
            }
            oddCopy.next = null;
            evenCopy.next = null;
        }
        oddCopy.next = evenHead.next;
        return oddHead.next;
    }
}