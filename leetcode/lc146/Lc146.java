package leetcode.lc146;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author anztim
 */
public class Lc146 {
    public static void main(String[] args) {

    }
}

class LRUCache {

    static class Node {
        int key;
        int val;
        Node prev;
        Node next;
        Node(Node prev, int key, int val, Node next) {
            this.prev = prev;
            this.key = key;
            this.val = val;
            this.next = next;
        }
        public void set(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    Map<Integer, Node> map;
    int cap;
    int len;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        cap = capacity;
        len = 0;
        head = new Node(null, -1, -1, null);
        tail = new Node(null, -1, -1, null);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        int val = -1;
        if (map.containsKey(key)) {
            Node node = map.get(key);
            val = node.val;
            moveToHead(node);
        }
        print();
        return val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            moveToHead(node);
            return;
        }
        Node node;
        if (len >= cap) {
            node = tail.prev;
            map.remove(node.key);
            node.set(key, value);
            moveToHead(node);
        } else {
            node = new Node(head, key, value, head.next);
            head.next.prev = node;
            head.next = node;
            len++;
        }
        map.put(key, node);
//        print();
    }

    private void moveToHead(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    private void print(){
        Node p = head.next;
        while (p != tail){
            System.out.print(p.val+" ");
            p = p.next;
        }
        System.out.println();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LRUCache)) return false;
        LRUCache lruCache = (LRUCache) o;
        return cap == lruCache.cap && len == lruCache.len && Objects.equals(map, lruCache.map) && Objects.equals(head, lruCache.head) && Objects.equals(tail, lruCache.tail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(map, cap, len, head, tail);
    }
}