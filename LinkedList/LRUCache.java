package linkedlist;

import java.util.HashMap;
import java.util.Map.Entry;

public class LRUCache {

    HashMap<Integer, LinkNode> hm = new HashMap<>();
    LinkNode head = null;
    LinkNode tail = null;
    int size;

    class LinkNode {
        int val;
        LinkNode next, prev;

        LinkNode() {
        }

        LinkNode(int val) {
            this.val = val;
            next = prev = null;
        }
    }

    public LRUCache(int capacity) {
        // head = new LinkNode();
        // tail = head;
        size = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (hm.containsKey(key)) {
            LinkNode node = hm.get(key);
            if (node.next != null) {
                deleteNode(node);
                insertNodeAtEnd(node);
            }
            return node.val;
        } else
            return -1;

    }

    public void set(int key, int value) {
        if (hm.containsKey(key)) {
            LinkNode node = hm.get(key);
            node.val = value;
            if (node.next != null) {
                deleteNode(node);
                insertNodeAtEnd(node);
            }
            hm.put(key, node);
        } else {
            LinkNode node = new LinkNode(value);
            if (hm.size() < size) {
                hm.put(key, node);
                insertNodeAtEnd(node);
            } else {
                for (Entry<Integer, LinkNode> entry : hm.entrySet()) {
                    if (entry.getValue() == head) {
                        hm.remove(entry.getKey());
                        break;
                    }
                }
                deleteNode(head);
                insertNodeAtEnd(node);
                hm.put(key, node);
            }
        }
    }

    public void deleteNode(LinkNode node) {
        if (node.next == null && node.prev == null) {
            head = null;
            tail = null;
            return;
        }
        if (node == head) {
            head = head.next;
            head.prev = null;
        } else if (node == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            node.prev.next = node.next;
            if (node.next != null)
                node.next.prev = node.prev;
        }
    }

    public void insertNodeAtEnd(LinkNode node) {
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.prev = tail;
        tail = node;
    }

    // 32 4 S 3 13 G 5 S 8 9 G 8 G 3 G 8 S 1 11 G 7 S 10 14 G 13 S 2 13 S 9 5 S 7 11
    // S 14 2 S 7 2 G 12 G 14 G 11 S 11 8 G 1 G 8 S 1 2 S 9 7 G 7 S 1 14 S 2 12 S 9
    // 5 S 1 1 G 1 G 14 G 4 S 13 11

    // The expected return value:
    // -1 9 13 9 -1 -1 -1 2 -1 -1 -1 -1 1 -1 -1
    // Your function returned the following:
    // -1 9 13 9 -1 -1 -1 2 -1 -1 -1 2 1 -1 -1
    public static void main(String[] args) {
        LRUCache lru = new LRUCache(4);
        lru.set(3, 13);
        System.out.println(lru.get(5));
        lru.set(8, 9);
        System.out.println(lru.get(8));
        System.out.println(lru.get(3));
        System.out.println(lru.get(8));
        lru.set(1, 11);
        System.out.println(lru.get(7));
        lru.set(10, 14);
        System.out.println(lru.get(13));
        lru.set(2, 13);
        lru.set(9, 5);
        lru.set(7, 11);
        lru.set(14, 2);
        lru.set(7, 2);
        System.out.println(lru.get(12));
        System.out.println(lru.get(14));
        System.out.println(lru.get(11));
        lru.set(11, 8);
        System.out.println(lru.get(1));
        System.out.println(lru.get(8));
        lru.set(1, 2);
        lru.set(9, 7);
        System.out.println(lru.get(7));
        lru.set(1, 14);
        lru.set(2, 12);
        lru.set(9, 5);
        lru.set(1, 1);
        System.out.println(lru.get(1));
        System.out.println(lru.get(14));
        System.out.println(lru.get(4));
        lru.set(13, 11);

    }
}
