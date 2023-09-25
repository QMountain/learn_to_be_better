package algorithm.leetcode.hard.l;

import java.util.HashMap;

public class LFUCache {

    static class Node {

        Integer key;
        int value;
        Node preDataNode;
        Node nextDataNode;
        Node dataListHead;
        Node dataListTail;

        Integer count;
        Node preOrderNode;
        Node nextOrderNode;

    }

    int capacity;
    HashMap<Integer, Node> kvMap;
    Node orderHead;
    Node orderTail;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.kvMap = new HashMap<>();
        this.orderHead = new Node();
        this.orderTail = new Node();
        orderHead.nextOrderNode = orderTail;
        orderTail.preOrderNode = orderHead;
    }

    public int get(int key) {
        if (!kvMap.containsKey(key)) {
            return -1;
        }
        // 数据节点
        Node node = kvMap.get(key);
        // 节点使用次数+1
        node.count += 1;
        // 把自身放入到 count + 1 队列的最前面
        // 当前使用次数列表的头节点，是个排序节点
        Node currDataListHead = node.dataListHead;
        // 当前排序节点的上一级节点
        Node preDataListHead = currDataListHead.preOrderNode;
        // 如果这个上一级排序节点是排序头节点，说明就使用次数而言，已是新的最高次数
        if (preDataListHead.count == null || preDataListHead.count > node.count) {
            Node newDataListHead = createNewDataList(node);
            newDataListHeadAddToOderList(currDataListHead, newDataListHead);
        } else {
            dataNodeAddToDataList(node, preDataListHead);
        }
        if (currDataListHead.nextDataNode.key == null) {
            Node nextOrderNode = currDataListHead.nextOrderNode;
            preDataListHead.nextOrderNode = nextOrderNode;
            nextOrderNode.preOrderNode = preDataListHead;
        }
        return kvMap.get(key).value;
    }

    public void put(int key, int value) {
        // 如果key已存在，则变更其值
        if (kvMap.containsKey(key)) {
            // 1. 变更值
            Node node = kvMap.get(key);
            node.value = value;
            // 2. 更新位置
            get(key);
            return;
        }
        // 如果键不存在，需要插入键值对
        // 如果缓存达到容量capacity，删除最不经常使用的Node
        if (kvMap.size() == capacity) {
            // 删掉最少且最久未使用的
            // 如果整个列表为空，删掉整个空的数据列表
            removeLeastLongestNode();
        }
        // 插入新的数据
        Node node = new Node();
        node.key = key;
        node.value = value;
        node.count = 1;

        if (orderTail.preOrderNode.count == null
                || orderTail.preOrderNode.count > 1) {
            Node newDataListHead = createNewDataList(node);
            newDataListHeadAddToOderList(orderTail, newDataListHead);
        } else {
            // 插入到已有的最后一个列表，最后一个列表，一定是使用了一次的
            dataNodeAddToDataList(node, orderTail.preOrderNode);
        }
        kvMap.put(key, node);
    }

    public void removeLeastLongestNode() {
        Node tail = orderTail.preOrderNode.dataListTail;
        Node delNode = tail.preDataNode;
        Node preNode = delNode.preDataNode;
        preNode.nextDataNode = tail;
        tail.preDataNode = preNode;
        kvMap.remove(delNode.key);
        // 如果整个列表为空，删掉整个空的数据列表
        if (preNode.key == null) {
            Node preOrderNode = preNode.preOrderNode;
            Node nextOrderNode = preNode.nextOrderNode;
            preOrderNode.nextOrderNode = nextOrderNode;
            nextOrderNode.preOrderNode = preOrderNode;
        }
    }

    public void dataNodeAddToDataList(Node dataNode, Node dataListHead) {
        Node nextDataNode = dataListHead.nextDataNode;
        dataListHead.nextDataNode = dataNode;
        dataNode.preDataNode = dataListHead;
        dataNode.nextDataNode = nextDataNode;
        nextDataNode.preDataNode = dataNode;

        dataNode.dataListHead = dataListHead;
        dataNode.dataListTail = nextDataNode.dataListTail;
    }

    public Node createNewDataList(Node node) {
        Node newDataListHead = new Node();
        newDataListHead.count = node.count;
        Node newDataListTail = new Node();
        node.dataListHead = newDataListHead;
        node.dataListTail = newDataListTail;
        newDataListHead.dataListTail = newDataListTail;

        newDataListHead.nextDataNode = node;
        node.preDataNode = newDataListHead;
        node.nextDataNode = newDataListTail;
        newDataListTail.preDataNode = node;
        return newDataListHead;
    }

    public void newDataListHeadAddToOderList(Node oldDataListHead, Node newDataListHead) {
        Node preOrderNode = oldDataListHead.preOrderNode;
        preOrderNode.nextOrderNode = newDataListHead;
        newDataListHead.preOrderNode = preOrderNode;
        newDataListHead.nextOrderNode = oldDataListHead;
        oldDataListHead.preOrderNode = newDataListHead;
    }

    public static void main(String[] args) {
        /*LFUCache lfuCache = new LFUCache(1);
        System.out.println("null");
        lfuCache.put(2,1);
        System.out.println("null");
        System.out.println(lfuCache.get(2));
        lfuCache.put(3,2);
        System.out.println("null");
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(3));*/

        LFUCache lfuCache = new LFUCache(2);
        System.out.println("null");
        lfuCache.put(1,1);
        System.out.println("null");
        lfuCache.put(2,2);
        System.out.println("null");
        System.out.println(lfuCache.get(1));
        lfuCache.put(3,3);
        System.out.println("null");
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(3));
        lfuCache.put(4,4);
        System.out.println("null");
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(4));
    }
}
