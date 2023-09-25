package algorithm.leetcode.medium.l;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LockingTree {

    // key 父节点  value 子孙节点集合
    HashMap<Integer, HashSet<Integer>> map;

    // key 父节点  value 上锁用户
    HashMap<Integer, Integer> lockedMap;

    public LockingTree(int[] parent) {
        map = new HashMap<>();
        int length = parent.length;
        for (int i = 1; i < length; i++) {
            int key = parent[i];
            HashSet<Integer> set = map.get(key);
            if (set == null) {
                set = new HashSet<>();
            }
            set.add(i);
            if (map.containsKey(i)) {
                set.addAll(map.get(i));
            }
            map.put(key, set);
            int p = key;
            while (parent[p] != -1) {
                HashSet<Integer> hashSet = map.get(parent[p]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                }
                hashSet.add(i);
                map.put(parent[p], hashSet);
                p = parent[p];
            }
        }
        lockedMap = new HashMap<>();
    }

    public boolean lock(int num, int user) {
        if (lockedMap.containsKey(num)) {
            return false;
        }
        lockedMap.put(num, user);
        return true;
    }

    public boolean unlock(int num, int user) {
        if (!lockedMap.containsKey(num)) {
            return false;
        }
        Integer lockUser = lockedMap.get(num);
        if (lockUser != user) {
            return false;
        }
        lockedMap.remove(num);
        return true;
    }

    public boolean upgrade(int num, int user) {
        if (lockedMap.containsKey(num)) {
            return false;
        }
        HashSet<Integer> lockedChildrenSet = new HashSet<>();
        HashSet<Integer> set = map.get(num);
        if (set == null) {
            return false;
        }
        for (Integer child : set) {
            if (lockedMap.containsKey(child)) {
                lockedChildrenSet.add(child);
            }
        }
        if (lockedChildrenSet.isEmpty()) {
            return false;
        }
        for (Map.Entry<Integer, Integer> entry : lockedMap.entrySet()) {
            HashSet<Integer> children = map.get(entry.getKey());
            if (children != null && children.contains(num)) {
                return false;
            }
        }
        lockedMap.put(num, user);
        for (Integer integer : lockedChildrenSet) {
            lockedMap.remove(integer);
        }
        return true;
    }

    public static void main(String[] args) {
        LockingTree lockingTree1 = new LockingTree(new int[]{-1,0,3,1,0});
        System.out.println(lockingTree1.upgrade(4, 5));
        System.out.println(lockingTree1.upgrade(3, 8));
        System.out.println(lockingTree1.unlock(0, 7));
        System.out.println(lockingTree1.lock(2, 7));
        System.out.println(lockingTree1.upgrade(4, 6));

        LockingTree lockingTree = new LockingTree(new int[]{-1, 0, 0, 1, 1, 2, 2});
        System.out.println(lockingTree.lock(2, 2));
        System.out.println(lockingTree.unlock(2, 3));
        System.out.println(lockingTree.unlock(2, 2));
        System.out.println(lockingTree.lock(4, 5));
        System.out.println(lockingTree.upgrade(0, 1));
        System.out.println(lockingTree.lock(0, 1));
    }
}
