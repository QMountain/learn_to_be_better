package algorithm.leetcode.easy.m;

import java.util.ArrayList;

public class MyHashSet2 {

    static class Node {
        int key;
        ArrayList<Node> list;
        public Node(int key) {
            this.key = key;
            this.list = new ArrayList<>();
        }
    }

    Node[] nodeArr;
    int arrLength;
    int elementCount;

    public MyHashSet2() {
        arrLength = 0;
        elementCount = 0;
    }

    public void add(int key) {
        if (arrLength == 0) {
            arrLength = 16;
            nodeArr = new Node[16];
        }
        if (elementCount == arrLength) {
            arrLength <<= 1;
            Node[] copyArr = new Node[arrLength];
            for (Node node : nodeArr) {
                if (node != null) {
                    for (Node each : node.list) {
                        int index = each.key % arrLength;
                        if (copyArr[index] == null) {
                            copyArr[index] = new Node(index);
                        }
                        copyArr[index].list.add(new Node(each.key));
                    }
                }
            }
            nodeArr = copyArr;
        }
        int index = key % arrLength;
        if (nodeArr[index] == null) {
            nodeArr[index] = new Node(index);
        }
        boolean has = false;
        for (Node node : nodeArr[index].list) {
            if (node.key == key) {
                has = true;
                break;
            }
        }
        if (!has) {
            nodeArr[index].list.add(new Node(key));
            elementCount++;
        }
    }

    public void remove(int key) {
        if (arrLength == 0) {
            return;
        }
        int index = key % arrLength;
        if (nodeArr[index] == null) {
            return;
        }
        ArrayList<Node> list = nodeArr[index].list;
        int removeIndex = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).key == key) {
                removeIndex = i;
            }
        }
        if (removeIndex != -1) {
            list.remove(removeIndex);
        }
    }

    public boolean contains(int key) {
        if (arrLength == 0) {
            return false;
        }
        int index = key % arrLength;
        if (nodeArr[index] == null) {
            nodeArr[index] = new Node(index);
        }
        boolean has = false;
        for (Node node : nodeArr[index].list) {
            if (node.key == key) {
                has = true;
                break;
            }
        }
        return has;
    }

    public static void main(String[] args) {
        MyHashSet2 myHashSet2 = new MyHashSet2();
        myHashSet2.add(1);
        myHashSet2.add(2);
        myHashSet2.contains(3);
        myHashSet2.contains(2);
        myHashSet2.add(2);
        myHashSet2.contains(2);
        myHashSet2.remove(2);
        myHashSet2.contains(2);
    }
}
