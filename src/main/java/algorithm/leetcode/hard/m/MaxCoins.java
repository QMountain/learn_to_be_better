package algorithm.leetcode.hard.m;

public class MaxCoins {

    public int maxCoins(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        if (length == 2) {
            return nums[0]*nums[1]+Math.max(nums[0],nums[1]);
        }
        for (int i = 1; i < length-1; i++) {
            if (nums[i] == 0 || (nums[i] < nums[i-1] && nums[i] < nums[i+1])) {
                int all = nums[i-1] * nums[i];
                if (i < length-1) {
                    all *= nums[i+1];
                }
                int[] arr = new int[length-1];
                System.arraycopy(nums,0,arr,0,i);
                System.arraycopy(nums,i+1,arr,i,length-i-1);
                all += maxCoins(arr);
                return all;
            }
        }
        int maxIndex = 1;
        int maxSum = nums[0] * nums[1] * nums[2];
        for (int i = 2; i < length - 1; i++) {
            int sum = nums[i - 1] * nums[i] * nums[i + 1];
            if (sum >= maxSum) {
                maxSum = sum;
                maxIndex = i;
            }
        }
        int all = nums[maxIndex-1] * nums[maxIndex] * nums[maxIndex+1];
        int[] arr = new int[length-1];
        System.arraycopy(nums,0,arr,0,maxIndex);
        System.arraycopy(nums,maxIndex+1,arr,maxIndex,length-maxIndex-1);
        all += maxCoins(arr);
        return all;

    }

    public static void main(String[] args) {
        MaxCoins maxCoins = new MaxCoins();
        System.out.println(maxCoins.maxCoins(new int[]{35,16,83,87,84,59,48,41}));
        System.out.println(maxCoins.maxCoins(new int[]{9, 76, 64, 21}));
        System.out.println(maxCoins.maxCoins(new int[]{9, 76, 64, 21,97,60,5}));
        System.out.println(maxCoins.maxCoins(new int[]{3, 1, 5, 8}));

        System.out.println(maxCoins.maxCoins(new int[]{9, 76, 64, 21,97}));


    }
}
