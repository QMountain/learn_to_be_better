package algorithm.leetcode.medium.c;

import java.util.*;

public class CanPartitionKSubsets {
    int average;
    Set<String> set;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        set = new HashSet<>();
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        this.average = sum / k;
        int length = nums.length;
        List<Integer> list = new ArrayList<>(length);
        for (int num : nums) {
            if (num > average) {
                return false;
            }
            list.add(num);
        }
        return canPartition(list,average,k-1);
    }

    public boolean canPartition(List<Integer> list, int left, int k) {
        if (k == 0) {
            int sum = 0;
            for (Integer i : list) {
                sum += i;
            }
            return sum == left;
        }
        if (left == 0) {
            if (set.contains(list+","+average+","+k)) {
                return false;
            }
            return canPartition(list,average,k-1);
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) <= left) {
                List<Integer> nl = new ArrayList<>(list);
                nl.remove(i);
                if (!set.contains(nl+","+(left-list.get(i))+","+k)) {
                    if (canPartition(nl,left-list.get(i),k)) {
                        return true;
                    }
                }
            }
        }
        set.add(list +","+left+","+k);
        return false;
    }

    public static void main(String[] args) {
        CanPartitionKSubsets canPartitionKSubsets = new CanPartitionKSubsets();
        System.out.println(canPartitionKSubsets.canPartitionKSubsets(new int[]{2, 2, 2, 2, 3, 4, 5}, 4));
        System.out.println(canPartitionKSubsets.canPartitionKSubsets(new int[]{4,4,6,2,3,8,10,2,10,7}, 4));
        System.out.println(canPartitionKSubsets.canPartitionKSubsets(new int[]{1,1,1,1,2,2,2,2}, 2));
        System.out.println(canPartitionKSubsets.canPartitionKSubsets(new int[]{5309,7138,779,8949,8568,2250,1794,6539,4948,7189,4270,9866,5867,2112,9176,3162}, 2));

        System.out.println(canPartitionKSubsets.canPartitionKSubsets(new int[]{1, 2, 3, 4}, 3));
        System.out.println(canPartitionKSubsets.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
    }
}
