package algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        int length = nums.length;
        List<List<Integer>> resList = new ArrayList<>(length*length);
        resList.add(new ArrayList<>());
        for (int i = 0; i <= length; i++) {
            int index = 0;
            for (int j = 0; j < i; j++) {

            }
        }
        return resList;
    }

}
