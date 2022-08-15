package algorithm.leetcode.medium.m;

public class MyCircularDeque {

    int[] arr;
    int length;
    int currSize;
    int firstIndex;
    int lastIndex;

    public MyCircularDeque(int k) {
        arr = new int[k];
        length = k;
        currSize = 0;
        firstIndex = -1;
        lastIndex = -1;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        if (firstIndex == -1) {
            arr[++firstIndex] = value;
            lastIndex = 0;
        } else if (firstIndex == 0) {
            arr[length-1] = value;
            firstIndex = length - 1;
        } else {
            arr[--firstIndex] = value;
        }
        currSize++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        if (lastIndex == -1) {
            arr[++lastIndex] = value;
            firstIndex = 0;
        } else if (lastIndex == length-1) {
            arr[0] = value;
            lastIndex = 0;
        } else {
            arr[++lastIndex] = value;
        }
        currSize++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        if (firstIndex == lastIndex) {
            firstIndex = -1;
            lastIndex = -1;
        } else {
            if (firstIndex < length-1) {
                firstIndex++;
            } else {
                firstIndex = 0;
            }
        }
        currSize--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        if (firstIndex == lastIndex) {
            firstIndex = -1;
            lastIndex = -1;
        } else {
            if (lastIndex > 0) {
                lastIndex--;
            } else {
                lastIndex = length-1;
            }
        }
        currSize--;
        return true;
    }

    public int getFront() {
        if (firstIndex == -1) {
            return -1;
        }
        return arr[firstIndex];
    }

    public int getRear() {
        if (lastIndex == -1) {
            return -1;
        }
        return arr[lastIndex];
    }

    public boolean isEmpty() {
        return currSize == 0;
    }

    public boolean isFull() {
        return currSize == length;
    }

    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);
        System.out.println(myCircularDeque.insertLast(1));
        System.out.println(myCircularDeque.insertLast(2));
        System.out.println(myCircularDeque.insertFront(3));
        System.out.println(myCircularDeque.insertFront(4));
        System.out.println(myCircularDeque.getRear());
        System.out.println(myCircularDeque.isFull());
        System.out.println(myCircularDeque.deleteLast());
        System.out.println(myCircularDeque.insertFront(4));
        System.out.println(myCircularDeque.getFront());
    }
}
