package algorithm.leetcode.medium.l;

import java.util.*;

public class LRUCache {

    public List<Integer> keyList;
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
