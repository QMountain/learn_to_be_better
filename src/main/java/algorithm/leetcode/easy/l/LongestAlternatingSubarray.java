package algorithm.leetcode.easy.l;

public class LongestAlternatingSubarray {

    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int length = nums.length;
        int ans = 0;
        int startIndex = -1;
        for (int i = 0; i < length; i++) {
            if (nums[i] % 2 == 0) {
                if (nums[i] <= threshold) {
                    if (startIndex == -1) {
                        startIndex = i;
                        ans = Math.max(ans, 1);
                    } else {
                        if ((i - startIndex) % 2 == 0) {
                            ans = Math.max(ans, i - startIndex + 1);
                        } else {
                            ans = Math.max(ans, i - startIndex);
                            startIndex = i;
                        }
                    }
                } else {
                    if (startIndex != -1) {
                        ans = Math.max(ans, i - startIndex);
                        startIndex = -1;
                    }
                }
            } else {
                if (startIndex != -1 && nums[i] <= threshold) {
                    if ((i - startIndex) % 2 == 1) {
                        ans = Math.max(ans, i - startIndex + 1);
                    } else {
                        startIndex = -1;
                    }
                } else {
                    startIndex = -1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestAlternatingSubarray longestAlternatingSubarray = new LongestAlternatingSubarray();
        System.out.println(1 == longestAlternatingSubarray.longestAlternatingSubarray(
                new int[]{4,4,7,2}, 6));
        System.out.println(2 == longestAlternatingSubarray.longestAlternatingSubarray(
                new int[]{4,3,1}, 4));
        System.out.println(3 == longestAlternatingSubarray.longestAlternatingSubarray(
                new int[]{2,3,4,5}, 4));
        System.out.println(1 == longestAlternatingSubarray.longestAlternatingSubarray(
                new int[]{1,2}, 2));
        System.out.println(3 == longestAlternatingSubarray.longestAlternatingSubarray(
                new int[]{3,2,5,4}, 5));
    }
}
