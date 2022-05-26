package javase;

import java.util.Arrays;

public class MyQueue {

    public static int size;
    public static int[] arr;

    public MyQueue() {
        arr = new int[10];
    }

    public static synchronized void putLeft(int e) {
        int[] nArr = new int[arr.length+1];
        System.arraycopy(arr,0,nArr,1,size);
        nArr[0] = e;
        arr = nArr;
        size++;
    }

    public synchronized void putRight(int e) {
        if (size == arr.length) {
            int[] nArr = new int[arr.length<<1];
            System.arraycopy(arr,0,nArr,0,size);
            nArr[size++] = e;
            arr = nArr;
            return;
        }
        arr[size++] = e;
    }

    public int getLeft() {
        return arr[0];
    }

    public int getRight() {
        return arr[size-1];
    }

    public void removeLeft() {
        int[] nArr = new int[arr.length];
        System.arraycopy(arr,1,nArr,0,size-1);
        arr = nArr;
        size--;
    }

    public void removeRight() {
        size--;
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.putLeft(2);
        myQueue.putLeft(1);
        myQueue.putRight(3);
        myQueue.putRight(4);
        System.out.println(Arrays.toString(myQueue.arr));
        System.out.println(myQueue.getLeft());
        myQueue.removeLeft();
        System.out.println(myQueue.getLeft());
        System.out.println(myQueue.getRight());
        myQueue.removeRight();
        System.out.println(myQueue.getRight());
    }

    public static synchronized void fun1() {
        System.out.println("fun1");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void fun2() {
        System.out.println("fun2");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
