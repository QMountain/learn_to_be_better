package algorithm.leetcode.medium.s;

import java.util.*;

public class SubsetsWithDup {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<String> set = new HashSet<>();
        List<List<Integer>> last = new ArrayList<>();
        last.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> curr = new ArrayList<>(last);
            for (List<Integer> list : last) {
                List<Integer> list2 = new ArrayList<>(list);
                list2.add(num);
                if (set.add(list2.toString())) {
                    curr.add(list2);
                }
            }
            last = curr;
        }
        return last;
    }

    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        Arrays.sort(nums);
        Set<String> set = new HashSet<>();
        List<List<Integer>> ansList = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < 2 << length-1; i++) {
            List<Integer> list = new ArrayList<>();
            StringBuilder s = new StringBuilder(Integer.toBinaryString(i));
            if (s.length() < length) {
                int sl = s.length();
                for (int j = 0; j < length - sl; j++) {
                    s.insert(0, "0");
                }
            }
            for (int j = 0; j < length; j++) {
                if (s.charAt(j) == '1') {
                    list.add(nums[j]);
                }
            }
            if (!set.contains(list.toString())) {
                ansList.add(list);
                set.add(list.toString());
            }
        }
        return ansList;
    }

    public static void main(String[] args) {
        SubsetsWithDup subsetsWithDup = new SubsetsWithDup();
        System.out.println(subsetsWithDup.subsetsWithDup(new int[]{0}));
        System.out.println(subsetsWithDup.subsetsWithDup(new int[]{1,2,2}));
    }
}
