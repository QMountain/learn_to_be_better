package algorithm.leetcode.medium.p;

import java.util.Arrays;

public class PartitionArray {

    public int partitionArray(int[] nums, int k) {
        int length = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < length; i++) {
            int max = nums[i]+k;
            for (int j = i; j < length; j++) {
                if (nums[j] > max) {
                    ans++;
                    i = j-1;
                    break;
                }
                if (j == length-1) {
                    ans++;
                    i = j;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        PartitionArray partitionArray = new PartitionArray();
        System.out.println(partitionArray.partitionArray(new int[]{1,2,3}, 1));
        System.out.println(partitionArray.partitionArray(new int[]{3, 6, 1, 2, 5}, 2));
    }
}
