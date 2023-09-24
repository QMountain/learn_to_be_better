package algorithm.leetcode.medium.l;

import java.util.HashMap;

public class LRUCache {

    /*public List<Integer> keyList;
    public Map<Integer,Integer> kvMap;
    public int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        keyList = new ArrayList<>(capacity);
        kvMap = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (kvMap.containsKey(key)) {
            keyList.remove(Integer.valueOf(key));
            keyList.add(0,key);
            return kvMap.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (kvMap.containsKey(key)) {
            keyList.remove(Integer.valueOf(key));
            keyList.add(0,key);
            kvMap.put(key,value);
            return;
        }
        int size = keyList.size();
        if (size == capacity) {
            Integer lastKey = keyList.get(size - 1);
            keyList.remove(size-1);
            kvMap.remove(lastKey);
        }
        keyList.add(0,key);
        kvMap.put(key,value);
    }*/

    int capacity;
    HashMap<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = null;
        tail = null;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        // 是head就不需要处理了
        if (node != head) {
            Node preNode = node.preNode;
            Node nextNode = node.nextNode;
            preNode.nextNode = nextNode;
            if (nextNode != null) {
                nextNode.preNode = preNode;
            } else {
                tail = preNode;
            }
            head.preNode = node;
            node.nextNode = head;
            head = node;
        }
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            get(key);
            head.value = value;
            return;
        }
        Node node = new Node();
        node.key = key;
        node.value = value;
        map.put(key, node);
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        node.nextNode = head;
        head.preNode = node;
        head = node;
        if (map.size() > capacity) {
            int tk = tail.key;
            map.remove(tk);
            Node preNode = tail.preNode;
            preNode.nextNode = null;
            tail = preNode;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2,1);
        lruCache.put(1,1);
        lruCache.put(2,3);
        lruCache.put(4,1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }

}

class Node {

    Node preNode;
    Node nextNode;
    int key;
    int value;

}
