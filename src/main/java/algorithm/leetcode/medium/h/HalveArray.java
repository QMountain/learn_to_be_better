package algorithm.leetcode.medium.h;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HalveArray {

    public int halveArray(int[] nums) {
        PriorityQueue<Double> queue = new PriorityQueue<>(Comparator.reverseOrder());
        double sum = 0;
        for (int num : nums) {
            sum += num;
            queue.add(Double.parseDouble(num+""));
        }
        double cutSum = 0D;
        int times = 0;
        while (cutSum * 2 < sum) {
            Double poll = queue.poll();
            double v = poll / 2;
            queue.add(v);
            cutSum += v;
            times++;
        }
        return times;
    }

    public static void main(String[] args) {
        HalveArray halveArray = new HalveArray();
        System.out.println(3 == halveArray.halveArray(new int[]{3,8,20}));
        System.out.println(3 == halveArray.halveArray(new int[]{5,19,8,1}));
    }
}
