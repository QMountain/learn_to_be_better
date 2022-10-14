package algorithm.leetcode.medium.l;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        LinkedList<LinkedList<Integer>> totalList = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            list.add(i);
            totalList.add(list);
        }
        int max = 1;
        while (true) {
            LinkedList<LinkedList<Integer>> nt = new LinkedList<>();
            for (LinkedList<Integer> list : totalList) {
                Integer last = list.peekLast();
                for (int i = last+1; i < length && length-i+list.size() > max; i++) {
                    if (nums[i] % nums[last] == 0) {
                        LinkedList<Integer> nl = new LinkedList<>(list);
                        nl.add(i);
                        nt.add(nl);
                        max = Math.max(max,nl.size());
                    }
                }
            }
            if (nt.isEmpty()) {
                break;
            }
            totalList = nt;
        }
        for (LinkedList<Integer> list : totalList) {
            if (list.size() == max) {
                List<Integer> ansList = new ArrayList<>();
                for (Integer integer : list) {
                    ansList.add(nums[integer]);
                }
                return ansList;
            }
        }
        return new LinkedList<>();
    }

    public static void main(String[] args) {
        LargestDivisibleSubset largestDivisibleSubset = new LargestDivisibleSubset();
        System.out.println(largestDivisibleSubset.largestDivisibleSubset(new int[]{1,2,4,8}));
        System.out.println(largestDivisibleSubset.largestDivisibleSubset(new int[]{1,2,3}));
    }
}
