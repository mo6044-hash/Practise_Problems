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
        PriorityQueue<ListNode> smallest = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) smallest.offer(lists[i]);
        }

        while (!smallest.isEmpty()) {
            ListNode top = smallest.poll();
            if (top.next != null) {
                smallest.offer(top.next);
            }
            current.next = top;
            current = current.next;
        }
        return dummy.next;

    }
}
