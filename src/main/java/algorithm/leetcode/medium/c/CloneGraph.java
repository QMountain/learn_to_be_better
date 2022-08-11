package algorithm.leetcode.medium.c;

import java.util.*;

public class CloneGraph {

    Map<Integer,Node> map;
    Set<Integer> connectedSet;

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        map = new HashMap<>();
        connectedSet = new HashSet<>();
        addNode(node);
        connect(node);
        return map.get(node.val);
    }

    public void addNode(Node node) {
        if (!map.containsKey(node.val)) {
            map.put(node.val,new Node(node.val));
        }
        List<Node> neighbors = node.neighbors;
        for (Node neighbor : neighbors) {
            if (!map.containsKey(neighbor.val)) {
                addNode(neighbor);
            }
        }
    }

    public void connect(Node node) {
        if (!connectedSet.contains(node.val)) {
            Node currNode = map.get(node.val);
            List<Node> neighbors = node.neighbors;
            List<Node> cloneNeighbors = currNode.neighbors;
            if (cloneNeighbors == null) {
                cloneNeighbors = new ArrayList<>(neighbors.size());
            }
            for (Node neighbor : neighbors) {
                if (!cloneNeighbors.contains(map.get(neighbor.val))) {
                    cloneNeighbors.add(map.get(neighbor.val));
                    if (!connectedSet.contains(neighbor.val)) {
                        connect(neighbor);
                    }
                }
            }
            currNode.neighbors = cloneNeighbors;
            connectedSet.add(node.val);
        }
    }

    public Node cloneBySet(Node node, Set<Integer> halfSet) {
        if (halfSet.contains(node.val)) {

        } else {

        }
        Node clone = new Node(node.val);
        List<Node> neighbors = node.neighbors;

        List<Node> cloneNeighbors = clone.neighbors;
        if (cloneNeighbors == null) {
            cloneNeighbors = new ArrayList<>();
        }
        Set<Integer> set = new HashSet<>();
        for (Node cloneNeighbor : cloneNeighbors) {
            set.add(cloneNeighbor.val);
        }
        for (Node neighbor : neighbors) {
            if (!halfSet.contains(neighbor.val)) {
                Node node1 = new Node(neighbor.val);
                List<Node> n1Neighbors = new ArrayList<>();
                n1Neighbors.add(neighbor);
                node1.neighbors = n1Neighbors;
                cloneNeighbors.add(node1);
                halfSet.add(neighbor.val);
            } else {

            }
        }
        clone.neighbors = cloneNeighbors;

        return clone;
    }

    public static void main(String[] args) {
        CloneGraph cloneGraph = new CloneGraph();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        Node node3 = new Node(3);
        List<Node> n1n = new ArrayList<>();
        n1n.add(node2);
        n1n.add(node4);
        node1.neighbors = n1n;
        List<Node> n2n = new ArrayList<>();
        n2n.add(node1);
        n2n.add(node3);
        node2.neighbors = n2n;
        List<Node> n3n = new ArrayList<>();
        n3n.add(node2);
        n3n.add(node4);
        node3.neighbors = n3n;
        List<Node> n4n = new ArrayList<>();
        n4n.add(node1);
        n4n.add(node3);
        node4.neighbors = n4n;

        Node node = cloneGraph.cloneGraph(node1);
        System.out.println(node);
    }

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

}


