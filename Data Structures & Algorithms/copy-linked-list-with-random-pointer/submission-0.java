
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node r = new Node(0);
        Node current = head;
        while (current != null) {
            Node copy = new Node(current.val);
            map.put(current, copy);
            current = current.next;
        }
        current = head;
        Node res = r;
        while (current != null) {
            Node next = current.next;
            Node random = current.random;

            Node copy = map.get(current);
            copy.next = map.get(next);
            copy.random = map.get(random);
            res.next = copy;
            res = res.next;
            current = current.next;
        }
        return r.next;
    }
}

