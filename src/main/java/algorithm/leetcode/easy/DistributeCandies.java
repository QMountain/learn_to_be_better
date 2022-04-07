package algorithm.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {

    public int distributeCandies(int[] candyType) {
        int length = candyType.length;
        Set<Integer> set = new HashSet<>(length);
        for (int i = 0; i < length && set.size() < length/2; i++) {
            set.add(candyType[i]);
        }
        return set.size();
    }

}
