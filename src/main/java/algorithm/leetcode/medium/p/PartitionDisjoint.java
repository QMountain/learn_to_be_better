package algorithm.leetcode.medium.p;

public class PartitionDisjoint {

    // O(n)
    public int partitionDisjoint(int[] nums) {
        int length = nums.length;
        int leftMax = nums[0];
        int knownMax = nums[0];
        int minIndex = 0;
        for (int i = 1; i < length; i++) {
            knownMax = Math.max(knownMax,nums[i]);
            if (nums[i] < leftMax) {
                minIndex = i;
                leftMax = knownMax;
            }
        }
        return minIndex+1;
    }

    // O(3n)
    public int partitionDisjoint2(int[] nums) {
        int length = nums.length;
        int[] prefixMax = new int[length];
        prefixMax[0] = nums[0];
        for (int i = 1; i < length; i++) {
            prefixMax[i] = Math.max(prefixMax[i-1],nums[i]);
        }
        int[] suffixMin = new int[length];
        suffixMin[length-1] = nums[length-1];
        for (int i = length-2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i+1],nums[i]);
        }
        for (int i = 0; i < length - 1; i++) {
            if (prefixMax[i] <= suffixMin[i+1]) {
                return i+1;
            }
        }
        return length-1;
    }

    public static void main(String[] args) {
        PartitionDisjoint partitionDisjoint = new PartitionDisjoint();
        System.out.println(11 == partitionDisjoint.partitionDisjoint(new int[]{29,33,6,4,42,0,10,22,62,16,46,75,100,67,70,74,87,69,73,88}));
        System.out.println(4 == partitionDisjoint.partitionDisjoint(new int[]{1,1,1,0,6,12}));
        System.out.println(3 == partitionDisjoint.partitionDisjoint(new int[]{5,0,3,8,6}));
    }
}
