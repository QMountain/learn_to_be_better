package algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyHashSet {

    private final Node[] arr;

    public MyHashSet() {
        arr = new Node[1024];
    }

    public void add(int key) {
        int index = key % 1024;
        if (arr[index] == null) {
            List<Integer> list = new ArrayList<>();
            list.add(key);
            Node node = new Node();
            node.list = list;
            arr[index] = node;
            return;
        }
        List<Integer> list = arr[index].list;
        for (Integer i : list) {
            if (Objects.equals(i,key)) {
                return;
            }
        }
        list.add(key);
    }

    public void remove(int key) {
        int index = key % 1024;
        if (arr[index] == null) {
            return;
        }
        List<Integer> list = arr[index].list;
        int p = -1;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i).equals(key)) {
                p = i;
                break;
            }
        }
        if (p != -1) {
            list.remove(p);
        }
    }

    public boolean contains(int key) {
        int index = key % 1024;
        if (arr[index] == null) {
            return false;
        }
        List<Integer> list = arr[index].list;
        for (Integer i : list) {
            if (i.equals(key)) {
                return true;
            }
        }
        return false;
    }

    static class Node {
        List<Integer> list;

        public Node() {
            list = new ArrayList<>(16);
        }
    }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(9);
        myHashSet.remove(19);
        myHashSet.add(14);
        myHashSet.remove(19);
        myHashSet.remove(9);
        myHashSet.add(0);
        myHashSet.add(3);
        myHashSet.add(4);
        myHashSet.add(0);
        myHashSet.remove(9);
    }
}
