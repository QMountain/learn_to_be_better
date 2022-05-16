package algorithm.leetcode.medium.f;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicates {

    public List<Integer> findDuplicates2(int[] nums) {
        int length = nums.length;
        Set<Integer> set = new HashSet<>();
        while (true) {
            boolean changed = false;
            for (int i = 0; i < length; i++) {
                if (nums[i] > 0 && nums[i] != i+1) {
                    if (nums[nums[i]-1] > 0 && nums[nums[i]-1] != nums[i]) {
                        int temp = nums[i];
                        nums[i] = nums[nums[i]-1];
                        nums[temp-1] = -temp;
                        changed = true;
                    } else {
                        set.add(nums[i]);
                    }
                }
            }
            if (!changed) {
                break;
            }
        }

        return new ArrayList<>(set);
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public List<Integer> findDuplicates3(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (nums[i] - 1 != i) {
                ans.add(nums[i]);
            }
        }
        return ans;
    }

    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            int x = Math.abs(nums[i]);
            if (nums[x - 1] > 0) {
                nums[x - 1] = -nums[x - 1];
            } else {
                ans.add(x);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        FindDuplicates findDuplicates = new FindDuplicates();
        System.out.println(findDuplicates.findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
        System.out.println(findDuplicates.findDuplicates(new int[]{1}));
        System.out.println(findDuplicates.findDuplicates(new int[]{1,1,2}));
    }
}
