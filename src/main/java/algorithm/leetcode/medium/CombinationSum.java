package algorithm.leetcode.medium;

import java.util.*;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resList = new ArrayList<>();
        Set<Integer> set = new TreeSet<>();
        for (int candidate : candidates) {
            if (candidate == target) {
                resList.add(Collections.singletonList(candidate));
            } else {
                if (candidate < target) {
                    set.add(candidate);
                }
            }
        }
        List<Integer> candidateList = new ArrayList<>(set);
        Integer minCandidate = candidateList.get(0);
        int maxCandidate = target - minCandidate;
        for (int i = maxCandidate+1; i <= target; i++) {
            set.remove(i);
        }
        for (int i = minCandidate; i <= maxCandidate; i++) {
            resList.addAll(combine(set,i));
        }
        return resList;
    }

    public List<List<Integer>> combine(Set<Integer> set, int target) {
        return null;
    }
}
