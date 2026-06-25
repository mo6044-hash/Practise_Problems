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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode res = new ListNode(0);
        ListNode c = res;
        while (l1 != null || l2 != null) {
            int num1 = 0;
            int num2 = 0;
            if (l1 != null) num1 = l1.val;
            if (l2 != null) num2 = l2.val;

            int sum = carry + num1 + num2;
            ListNode current = new ListNode(sum % 10);
            carry = sum / 10;

            c.next = current;
            c = c.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry != 0) c.next = new ListNode(carry);
        return res.next;
    }
}
