package javase;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @ClassName LearnBlockingQueue
 * @Description
 * @Author qsf
 * Date   2022-02-18  13:32
 */
public class LearnBlockingQueue {

    public static void main(String[] args) {
        ArrayBlockingQueue<String> stringArrayBlockingQueue = new ArrayBlockingQueue<>(16);

        int a = 1;
        int b = 2;
        a = b = 3;
        System.out.println(a);
        System.out.println(b);
    }
}
