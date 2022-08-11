package algorithm.leetcode.medium.c;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {

    Map<Integer,Node> originIndexNodeMap;
    Map<Integer,Node> copyIndexNodeMap;

    Map<Node,Integer> originNodeIndexMap;


    public Node copyRandomList(Node head) {
        originIndexNodeMap = new HashMap<>();
        copyIndexNodeMap = new HashMap<>();
        originNodeIndexMap = new HashMap<>();
        int index = 0;
        Node node = head;
        while (node != null) {
            originIndexNodeMap.put(index,node);
            originNodeIndexMap.put(node,index);
            copyIndexNodeMap.put(index++,new Node(node.val));
            node = node.next;
        }
        int size = originNodeIndexMap.size();
        for (int i = 0; i < size - 1; i++) {
            copyIndexNodeMap.get(i).next = copyIndexNodeMap.get(i+1);
        }
        int randomIndex = 0;
        Node random = head;
        while (random != null) {
            if (random.random != null) {
                Node random1 = random.random;
                Integer originIndex = originNodeIndexMap.get(random1);
                copyIndexNodeMap.get(randomIndex).random = copyIndexNodeMap.get(originIndex);
            }
            randomIndex++;
            random = random.next;
        }
        return copyIndexNodeMap.get(0);
    }

    public static void main(String[] args) {
        CopyRandomList copyRandomList = new CopyRandomList();
        Node node7 = new Node(7);
        Node node13 = new Node(13);
        Node node11 = new Node(11);
        Node node10 = new Node(10);
        Node node1 = new Node(1);
        node7.next = node13;
        node13.next= node11;
        node11.next = node10;
        node10.next = node1;
        node13.random = node7;
        node11.random = node1;
        node10.random = node11;
        node1.random = node7;
        Node node = copyRandomList.copyRandomList(node7);
        System.out.println(node);
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
