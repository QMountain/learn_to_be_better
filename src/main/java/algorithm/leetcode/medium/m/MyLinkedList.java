package algorithm.leetcode.medium.m;

public class MyLinkedList {

    Node head;
    Node tail;

    public MyLinkedList() {
        head = null;
        tail = null;
    }

    public int get(int index) {
        Node curr = head;
        while (curr != null && index > 0) {
            curr = curr.next;
            index--;
        }
        if (index > 0 || curr == null) {
            return -1;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        if (head == null) {
            head = new Node(val);
            tail = head;
            return;
        }
        Node nHead = new Node(val);
        nHead.next = head;
        head.prev= nHead;
        head = nHead;
    }

    public void addAtTail(int val) {
        if (tail == null) {
            tail = new Node(val);
            head = tail;
            return;
        }
        Node nHead = new Node(val);
        tail.next = nHead;
        nHead.prev = tail;
        tail = nHead;
    }

    public void addAtIndex(int index, int val) {
        if (index == 0 && head != null) {
            Node node = new Node(val);
            node.next = head;
            head.prev = node;
            head = node;
            return;
        }
        Node curr = head;
        while (curr != null && index > 1) {
            curr = curr.next;
            index--;
        }
        if (curr == null && index >= 1) {
            return;
        }
        if (curr == null) {
            addAtTail(val);
            return;
        }
        if (curr.next == null) {
            Node node = new Node(val);
            curr.next = node;
            node.prev = curr;
            tail = node;
            return;
        }
        Node next = curr.next;
        Node node = new Node(val);
        curr.next = node;
        node.prev = curr;
        node.next = next;
        next.prev = node;
    }

    public void deleteAtIndex(int index) {
        if (index == 0) {
            if (head == tail) {
                head = null;
                tail = null;
                return;
            }
            head = head.next;
            head.prev = null;
            return;
        }
        Node curr = head;
        while (curr != null && index > 1) {
            curr = curr.next;
            index--;
        }
        if (index > 1 || curr == null) {
            return;
        }
        if (curr.next == null) {
            return;
        }
        if (curr.next.next == null) {
            curr.next = null;
            tail = curr;
            return;
        }
        Node nn = curr.next.next;
        curr.next = nn;
        nn.prev = curr;
    }

    class Node {
        int val;
        Node prev;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtIndex(1,0);
        myLinkedList.get(0);


        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(1);

        myLinkedList.deleteAtIndex(2);
        myLinkedList.addAtHead(6);
        myLinkedList.addAtTail(4);

        myLinkedList.addAtHead(4);
        myLinkedList.addAtIndex(5,0);
        myLinkedList.addAtHead(6);
    }
}
