package algorithm.leetcode.medium.l;

public class LongestMountain {

    /**
     * 845. 数组中的最长山脉
     * 把符合下列属性的数组 arr 称为 山脉数组 ：
     * arr.length >= 3
     * 存在下标 i（0 < i < arr.length - 1），满足
     * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
     * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
     * 给出一个整数数组 arr，返回最长山脉子数组的长度。如果不存在山脉子数组，返回 0 。
     */
    public int longestMountain(int[] arr) {
        int length = arr.length;
        int top = -1;
        int left = 0;

        int ans = 0;
        for (int i = 1; i < length; i++) {
            if (top != -1) {
                if (arr[i] > arr[i-1] && top == i - 1) {
                    top = i;
                } else if (arr[i] < arr[i-1]) {
                    ans = Math.max(ans, i - left + 1);
                } else if (arr[i] > arr[i-1]) {
                    top = i;
                    left = i - 1;
                } else {
                    top = -1;
                }
            } else {
                if (arr[i] > arr[i-1]) {
                    top = i;
                    left = i-1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestMountain longestMountain = new LongestMountain();
        System.out.println(0 == longestMountain.longestMountain(
                new int[]{2,2,2}));
        System.out.println(5 == longestMountain.longestMountain(
                new int[]{2,1,4,7,3,2,5}));
    }
}
