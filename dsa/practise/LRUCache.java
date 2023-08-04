package dsa.practise;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    HashMap<Integer, ListNode> map;
    int capacity = 0;
    ListNode head = null, tail = null;

    static class ListNode {

        int val;
        ListNode next;
        ListNode prev;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) { // o(1)
        if(map.containsKey(key)){
            ListNode node = map.get(key);
            if(node.next!=null){
                // delete node in dll
                deleteNode(node);
                // insert node to last
                insertAtEnd(node);
            }
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            ListNode node = map.get(key);
            node.val = value;
            if(node.next!=null){
                // delete node in dll
                deleteNode(node);
                // insert node to last
                insertAtEnd(node);
            }
            map.put(key, node);
        } else {
            ListNode newNode = new ListNode(value);
            if(map.size() < capacity){
                map.put(key, newNode);
                // insert node to last
                insertAtEnd(newNode );
             } else {
                // deleting from map
                for(Map.Entry<Integer, ListNode> entry : map.entrySet()){
                    if(entry.getValue() == head){
                        map.remove(entry.getKey());
                        break;
                    }
                }
                deleteNode(head);
                insertAtEnd(newNode);
                map.put(key,newNode);
            }

        }
    }

    public void deleteNode(ListNode node){
        if (node.prev == null && node.next == null) {
            // empty list
            head = null;
            tail = null;
            return;
        }
        if(node == head){
            head = head.next;
            head.prev = null;
        } else if (node == tail){
            tail = node.prev;
            tail.next = null;
        } else {
            node.prev.next = node.next;
            if (node.next != null)
                node.next.prev = node.prev;
        }
    }

    public void insertAtEnd(ListNode node){
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.prev = tail;
        tail = node;
    }

    public static void main(String[] args) {
        LRUCache lc = new LRUCache(2);
        lc.put(1,1);
        lc.put(2,2);
        System.out.println(lc.get(1));
        lc.put(3,3);
        System.out.println(lc.get(2));
    }


}
