package algorithm.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

public class LRUCache {

    public List<String> list;
    public int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        list = new LinkedList<>();
    }

    public int get(int key) {
        int size = list.size();
        int index = -1;
        int retValue = -1;
        for (int i = 0; i < size; i++) {
            if (list.get(i).startsWith(key+",")) {
                index = i;
                retValue = Integer.parseInt(list.get(i).replaceFirst(key + ",", ""));
            }
        }
        if (index != -1) {
            list.remove(index);
            list.add(0,key+","+retValue);
        }

        return retValue;
    }

    public void put(int key, int value) {
        int size = list.size();
        int index = -1;
        String nValue = key+","+value;
        for (int i = 0; i < size; i++) {
            if (list.get(i).startsWith(key+",")) {
                index = i;
            }
        }

        if (index != -1) {
            list.remove(index);
        } else {
            if (size == capacity) {
                list.remove(size-1);
            }
        }
        list.add(0,nValue);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        System.out.println(lruCache.get(2));
        lruCache.put(2,6);
        System.out.println(lruCache.get(1));
        lruCache.put(1,5);
        lruCache.put(1,2);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));

    }

}
