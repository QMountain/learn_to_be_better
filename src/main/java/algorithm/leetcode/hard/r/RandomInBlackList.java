package algorithm.leetcode.hard.r;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomInBlackList {

    Random random;
    Set<Integer> set;
    int n;

    public RandomInBlackList(int n, int[] blacklist) {
        int length = blacklist.length;
        set = new HashSet<>(length);
        for (int i : blacklist) {
            set.add(i);
        }
        this.n = n;
        random = new Random();
    }

    public int pick() {
        int nextInt = random.nextInt(n);

        return 0;
    }

    public static void main(String[] args) {
        RandomInBlackList randomInBlackList = new RandomInBlackList(7, new int[]{2, 3, 5});
        System.out.println(randomInBlackList.pick());
        System.out.println(randomInBlackList.pick());
        System.out.println(randomInBlackList.pick());
        System.out.println(randomInBlackList.pick());
    }
}
