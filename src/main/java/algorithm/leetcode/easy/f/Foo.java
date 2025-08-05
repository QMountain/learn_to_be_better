package algorithm.leetcode.easy.f;

public class Foo {

    private volatile int flag;

    public Foo() {
        flag = 0;
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        flag = 1;
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while (flag != 1) {

        }
        printSecond.run();
        flag = 2;
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while (flag != 2) {

        }
        printThird.run();
        flag = 0;
    }

}
