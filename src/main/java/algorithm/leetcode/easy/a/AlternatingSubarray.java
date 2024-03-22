package algorithm.leetcode.easy.a;

public class AlternatingSubarray {

    // 2 <= nums.length <= 100
    // 1 <= nums[i] <= 10^4
    public int alternatingSubarray(int[] nums) {
        int ans = -1;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] - nums[i+1] == -1) {
                int startIndex = i;
                for (int j = i+1; j < nums.length; j++) {
                    if (Math.abs(nums[j] - nums[j-1]) == 1) {
                        if ((j - startIndex) % 2 == 0) {
                            if (nums[j] == nums[startIndex]) {
                                ans = Math.max(ans, j - startIndex + 1);
                            } else {
                                ans = Math.max(ans, j - startIndex);
                                startIndex = --j;
                            }
                        } else {
                            if (nums[j] == nums[startIndex+1]) {
                                ans = Math.max(ans, j - startIndex + 1);
                            } else {
                                ans = Math.max(ans, j - startIndex);
                                startIndex = --j;
                            }
                        }
                    } else {
                        break;
                    }
                    i = j;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        AlternatingSubarray alternatingSubarray = new AlternatingSubarray();
        System.out.println(2 == alternatingSubarray.alternatingSubarray(new int[]{6,12,2,3,8,9,10,10,2,1}));
        System.out.println(-1 == alternatingSubarray.alternatingSubarray(new int[]{14,30,29,49,3,23,44,21,26,52}));
        System.out.println(2 == alternatingSubarray.alternatingSubarray(new int[]{4,5,6}));
        System.out.println(4 == alternatingSubarray.alternatingSubarray(new int[]{2,3,4,3,4}));
    }
}
