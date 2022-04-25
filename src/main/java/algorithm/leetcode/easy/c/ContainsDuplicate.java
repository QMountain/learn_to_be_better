package algorithm.leetcode.easy.c;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            boolean add = set.add(num);
            if (!add) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        System.out.println(containsDuplicate.containsDuplicate(new int[]{1,2,3,1}));
        System.out.println(containsDuplicate.containsDuplicate(new int[]{1,2,3,4}));
        System.out.println(containsDuplicate.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }
}
