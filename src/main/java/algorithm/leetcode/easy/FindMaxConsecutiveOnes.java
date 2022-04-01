package algorithm.leetcode.easy;

public class FindMaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int length = nums.length;
        int max = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                if (i == length-1) {
                    max = Math.max(max,1);
                    continue;
                }
                for (int j = i+1; j < length; j++) {
                    if (nums[i] * nums[j] == 0) {
                        max = Math.max(max,j-i);
                        i = j;
                        break;
                    }
                    if (j == length-1) {
                        max = Math.max(max,j-i+1);
                        i = j;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        FindMaxConsecutiveOnes findMaxConsecutiveOnes = new FindMaxConsecutiveOnes();
        System.out.println(findMaxConsecutiveOnes.findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
        System.out.println(findMaxConsecutiveOnes.findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1}));
    }
}
