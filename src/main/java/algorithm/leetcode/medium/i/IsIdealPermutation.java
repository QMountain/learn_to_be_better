package algorithm.leetcode.medium.i;

public class IsIdealPermutation {

    public boolean isIdealPermutation(int[] nums) {
        int length = nums.length;
        int globalInversion = 0;
        int partInversion = 0;
        int lastInversionNum = 0;
        int curr = 0;
        for (int i = 0; i < length-1; i++) {
            if (nums[i] < lastInversionNum) {
                if (nums[i]+curr > i) {
                    globalInversion += nums[i] + curr - i;
                    lastInversionNum = nums[i];
                    curr = 0;
                }
            } else {
                if (nums[i] > i) {
                    globalInversion += nums[i] - i;
                    lastInversionNum = nums[i];
                    curr = 0;
                }
            }
            if (nums[i] > nums[i+1]) {
                curr++;
                partInversion++;
            }
        }
        if (nums[length-1] > length-1) {
            globalInversion += nums[length-1] - length + 1;
        }
        return globalInversion == partInversion;
    }

    public static void main(String[] args) {
        IsIdealPermutation isIdealPermutation = new IsIdealPermutation();
        System.out.println(isIdealPermutation.isIdealPermutation(new int[]{1,0,3,2}));
        System.out.println(isIdealPermutation.isIdealPermutation(new int[]{1,0,2,3}));
        System.out.println(!isIdealPermutation.isIdealPermutation(new int[]{2,1,0}));
        System.out.println(!isIdealPermutation.isIdealPermutation(new int[]{1,2,0}));
        System.out.println(isIdealPermutation.isIdealPermutation(new int[]{1,0,2}));
    }
}
