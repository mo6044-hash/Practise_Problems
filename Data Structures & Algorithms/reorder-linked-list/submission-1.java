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
        if (head.next == null) return;
        ListNode fast = head;
        ListNode slow = head;
        ListNode slower = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slower = slow;
            slow = slow.next;
        }
        slower.next = null;


        //then reverse second half
        ListNode prev = null;
        ListNode current = slow;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        ListNode f = head;
        ListNode res = new ListNode(0);
        ListNode rh = res;
        while (f != null) {
            rh.next = f;
            f = f.next;
            rh = rh.next;
            rh.next = prev;
            prev = prev.next;
            rh = rh.next;
        }
        if (prev != null) {
            rh.next = prev;
        }

    }
}
