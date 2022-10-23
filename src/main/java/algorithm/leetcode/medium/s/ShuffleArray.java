package algorithm.leetcode.medium.s;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

/**
 * 题号 384 打乱数组
 *
 */
public class ShuffleArray {

    int[] nums;
    int length;
    LinkedList<Integer> elementList;
    Random random;

    public ShuffleArray(int[] nums) {
        this.nums = nums;
        this.length = nums.length;
        this.elementList = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            elementList.add(nums[i]);
        }
        this.random = new Random();
    }

    public int[] reset() {
        for (int i = 0; i < length; i++) {
            nums[i] = elementList.get(i);
        }
        return nums;
    }

    public int[] shuffle() {
        LinkedList<Integer> list = new LinkedList<>(elementList);
        int putIndex = 0;
        while (list.size() > 0) {
            int i = random.nextInt(list.size());
            nums[putIndex++] = list.get(i);
            list.remove(i);
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = {-6, 10, 184};
        ShuffleArray shuffleArray = new ShuffleArray(arr);
        for (int i = 0; i < 100; i++) {
            System.out.println(Arrays.toString(shuffleArray.shuffle()));
            System.out.println(Arrays.toString(shuffleArray.reset()).equals(Arrays.toString(arr)));
        }
    }
}
