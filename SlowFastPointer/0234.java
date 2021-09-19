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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {    return true;    }
        
        // Step 1: find middle of the list
        ListNode middle = findMiddle(head);

        // Step 2: reverse the second part
        ListNode second = reverse(middle.next);
        middle.next = null;

        // Step 3: check if it is palindrome        
        return similar(head, second);
    }

    // Returns the middle of the list
    private static ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head;
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

    // Checks if two are similar
    private static boolean similar(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {     return false;   }
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }
}