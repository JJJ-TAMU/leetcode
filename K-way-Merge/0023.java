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
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) {   return null;    }
        for (int size = 1; size < n; size += size) {
            for (int lo = 0, hi = lo + size; hi < n; lo = hi + size, hi = lo + size) {
                lists[lo] = mergeTwoLists(lists[lo], lists[hi]);
            }
        }
        return lists[0];
    }

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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((l1, l2)->Integer.compare(l1.val, l2.val));
        ListNode sentinel = new ListNode();
        ListNode copy = sentinel;
        for (ListNode l : lists) {
            if (l != null) {    pq.offer(l);   }
        }       
        while (!pq.isEmpty()) {
            ListNode l = pq.poll();
            copy.next = l;
            copy = l;
            if (l.next != null) {   pq.offer(l.next);   }
        }
        return sentinel.next;
    }
}