package algorithm.leetcode.easy.m;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsDifference {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = arr[1] - arr[0];
        int length = arr.length;
        for (int i = 2; i < length; i++) {
            int diff = arr[i] - arr[i-1];
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 1; i < length; i++) {
            if (arr[i] - arr[i-1] == minDiff) {
                List<Integer> list1 = new ArrayList<>(2);
                list1.add(arr[i-1]);
                list1.add(arr[i]);
                list.add(list1);
            }
        }
        return list;
    }

}
