class LRUCache {
    private int capacity;
    private int occupiedSize;
    private HashMap<Integer, Node> cache;
    private Node head;
    private Node tail;

    private class Node {
        private int key;
        private int val;
        private Node next;
        private Node prev;

        private Node(int key, int val) {
            this.val = val;
            this.key = key;
            next = null;
            prev = null;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        occupiedSize = 0;
        cache = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;

        Node reference = cache.get(key);
        if (reference.next != tail) {
            Node beforeReference = reference.prev;
            Node afterReference = reference.next;
            beforeReference.next = afterReference;
            afterReference.prev = beforeReference;

            Node beforeTail = tail.prev;
            beforeTail.next = reference;
            reference.prev = beforeTail;
            reference.next = tail;
            tail.prev = reference;
        }
        return reference.val;
    }
    
    public void put(int key, int value) {
        // if exists
        if (cache.containsKey(key)) {
            Node reference = cache.get(key);
            reference.val = value;
            Node pr = reference.prev;
            Node nxt = reference.next;
            pr.next = nxt;
            nxt.prev = pr;

            Node beforeTail = tail.prev;
            beforeTail.next = reference;
            reference.next = tail;
            reference.prev = beforeTail;
            tail.prev = reference;
        } else {
            // if doesnt exist
            // 1. if eviction not needed
            if (occupiedSize < capacity) {
                Node reference = new Node(key, value);
                Node beforeTail = tail.prev;
                beforeTail.next = reference;
                reference.next = tail;
                reference.prev = beforeTail;
                tail.prev = reference;
                occupiedSize++;
                cache.put(key, reference);
            } else {
                // eviction needed
                Node toRemove = head.next;
                Node afterRemove = toRemove.next;
                afterRemove.prev = head;
                head.next = afterRemove;
                cache.remove(toRemove.key);
                Node reference = new Node(key, value);
                cache.put(key, reference);
                Node beforeTail = tail.prev;
                beforeTail.next = reference;
                reference.prev = beforeTail;
                reference.next = tail;
                tail.prev = reference;
            }
        }
}
}