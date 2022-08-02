package algorithm.leetcode.medium.m;

public class MyCircularQueue {

    int[] arr;
    int headIndex;

    int tailIndex;

    int length;

    public MyCircularQueue(int k) {
        length = k;
        arr = new int[k];
        headIndex = 0;
        tailIndex = -1;
    }

    public boolean enQueue(int value) {
        if (tailIndex == -1) {
            arr[headIndex] = value;
            tailIndex = headIndex;
            return true;
        }
        if (headIndex <= tailIndex) {
            if (tailIndex + 1 < length) {
                arr[++tailIndex] = value;
                return true;
            }
            int preIndex = tailIndex+1-length;
            if (preIndex >= headIndex) {
                return false;
            }
            arr[preIndex] = value;
            tailIndex = 0;
            return true;
        } else {
            if (tailIndex+1 == headIndex) {
                return false;
            }
        }
        arr[++tailIndex] = value;
        return true;
    }

    public boolean deQueue() {
        if (tailIndex == -1) {
            return false;
        }
        if (headIndex == tailIndex) {
            tailIndex = -1;
            return true;
        }
        if (headIndex < tailIndex) {
            headIndex++;
            return true;
        }
        if (headIndex + 1 < length) {
            headIndex++;
            return true;
        }
        headIndex = 0;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return arr[headIndex];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[tailIndex];
    }

    public boolean isEmpty() {
        return tailIndex == -1;
    }

    public boolean isFull() {
        if (headIndex == 0) {
            return tailIndex == length-1;
        }
        return tailIndex+1 == headIndex;
    }

    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(2);
        System.out.println(queue.enQueue(1));
        System.out.println(queue.enQueue(2));
        System.out.println(queue.deQueue());
        System.out.println(queue.enQueue(3));
        System.out.println(queue.deQueue());
        System.out.println(queue.enQueue(3));
        System.out.println(queue.deQueue());
        System.out.println(queue.Front());
        /*MyCircularQueue myCircularQueue = new MyCircularQueue(8);
        System.out.println(myCircularQueue.enQueue(3));
        System.out.println(myCircularQueue.enQueue(9));
        System.out.println(myCircularQueue.enQueue(5));
        System.out.println(myCircularQueue.enQueue(0));
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.isEmpty());
        System.out.println(myCircularQueue.isEmpty());
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.deQueue());*/

        /*MyCircularQueue myCircularQueue = new MyCircularQueue(6);
        System.out.println(myCircularQueue.enQueue(6));
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.enQueue(5));
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.Front());
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.deQueue());*/

        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        System.out.println(myCircularQueue.enQueue(1));
        System.out.println(myCircularQueue.enQueue(2));
        System.out.println(myCircularQueue.enQueue(3));
        System.out.println(myCircularQueue.enQueue(4));
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.isFull());
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.enQueue(4));
        System.out.println(myCircularQueue.Rear());
    }
}
