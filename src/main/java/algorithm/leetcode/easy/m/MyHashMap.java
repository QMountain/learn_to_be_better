package algorithm.leetcode.easy.m;

public class MyHashMap {

    static class Node {
        int key;
        int val;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node[] arr;
    int count;

    public MyHashMap() {
        count = 0;
    }

    public void put(int key, int value) {
        if (arr == null) {
            arr = new Node[16];
        } else if (count >= arr.length) {
            resize();
        }
        int hash = key % arr.length;
        if (arr[hash] == null) {
            arr[hash] = new Node(key, value);
            count++;
            return;
        }
        Node node = arr[hash];
        while (true) {
            if (node.key == key) {
                node.val = value;
                return;
            }
            if (node.next != null) {
                node = node.next;
            } else {
                node.next = new Node(key, value);
                count++;
                return;
            }
        }
    }

    public int get(int key) {
        if (arr == null) {
            return -1;
        }
        int hash = key % arr.length;
        Node node = arr[hash];
        while (node != null) {
            if (node.key == key) {
                return node.val;
            }
            node = node.next;
        }
        return -1;
    }

    public void remove(int key) {
        if (arr == null) {
            return;
        }
        int hash = key % arr.length;
        if (arr[hash] == null) {
            return;
        }
        if (arr[hash].key == key) {
            arr[hash] = arr[hash].next;
            return;
        }
        Node node = arr[hash];
        while (node.next != null) {
            if (node.next.key == key) {
                node.next = node.next.next;
                return;
            }
            node = node.next;
        }
    }

    public void resize() {
        int newCap = arr.length << 1;
        Node[] copyArr = new Node[newCap];
        for (Node node : arr) {
            while (node != null) {
                int hash = node.key % newCap;
                if (copyArr[hash] == null) {
                    copyArr[hash] = new Node(node.key, node.val);
                } else {
                    Node newNode = new Node(node.key, node.val);
                    newNode.next = copyArr[hash];
                    copyArr[hash] = newNode;
                }
                node = node.next;
            }
        }
        arr = copyArr;
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.remove(27);
        myHashMap.put(65, 65);
        myHashMap.remove(19);
        myHashMap.remove(0);
        System.out.println(myHashMap.get(18));
        myHashMap.remove(3);
        myHashMap.put(42, 0);
        System.out.println(myHashMap.get(19));
        myHashMap.remove(42);
        myHashMap.put(17, 90);
        myHashMap.put(31, 76);
        myHashMap.put(48, 71);
        myHashMap.put(5, 50);
        myHashMap.put(7, 68);
        myHashMap.put(73, 74);
        myHashMap.put(85, 18);
        myHashMap.put(74, 95);
        myHashMap.put(84, 82);
        myHashMap.put(59, 29);
        myHashMap.put(71, 71);
        myHashMap.remove(42);
        myHashMap.put(51, 40);
        myHashMap.put(33, 76);
        System.out.println(myHashMap.get(17));

        myHashMap.get(2);
    }
}
