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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode left = list1;
        ListNode right = list2;
        ListNode soln = new ListNode();
        ListNode current = soln;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                current.next = new ListNode(left.val);
                left = left.next;
            } else {
                current.next = new ListNode(right.val);
                right = right.next;
            }
            current = current.next;
        }
        while (left != null) {
            current.next = new ListNode(left.val);
            left = left.next;
            current = current.next;
        }
        while (right != null) {
            current.next = new ListNode(right.val);
            right = right.next;
            current = current.next;
        }
        return soln.next;
    }
}