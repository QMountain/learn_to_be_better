package algorithm.leetcode.medium.m;

public class MinimumSubarrayLength {

    // 1 <= nums.length <= 2 * 10^5
    // 0 <= nums[i] <= 10^9
    // 0 <= k <= 10^9
    public int minimumSubarrayLength(int[] nums, int k) {
        int[] arr = new int[32];
        int length = nums.length;
        int ans = -1;
        int readIndex = -1;
        for (int i = 0; i < length; i++) {
            if (nums[i] >= k) {
                return 1;
            }
            for (int j = readIndex+1; j < length; j++) {
                readIndex = j;
                addToArr(arr, nums[j]);
                if (bigger(arr, k)) {
                    if (ans == -1) {
                        ans = j - i + 1;
                    } else {
                        ans = Math.min(ans, j - i + 1);
                    }
                    minus(arr, nums[i]);
                    while (bigger(arr, k) && readIndex > i + 1) {
                        minus(arr, nums[readIndex--]);
                    }
                    break;
                }
            }
        }
        return ans;
    }

    public void addToArr(int[] arr, int num) {
        int writeIndex = 31;
        while (num > 0) {
            arr[writeIndex--] += num % 2;
            num /= 2;
        }
    }

    public void minus(int[] arr, int num) {
        int writeIndex = 31;
        while (num > 0) {
            arr[writeIndex--] -= num % 2;
            num /= 2;
        }
    }

    public boolean bigger(int[] arr, int k) {
        int cal = 0;
        for (int i = 31; i >= 0; i--) {
            if (arr[i] > 0) {
                cal |= 1 << (31 - i);
            }
        }
        return cal >= k;
    }

    public static void main(String[] args) {
        MinimumSubarrayLength minimumSubarrayLength = new MinimumSubarrayLength();
        System.out.println(Integer.toBinaryString(536870912));
        System.out.println(1 == minimumSubarrayLength.minimumSubarrayLength(
                new int[]{536870912, 268435456, 134217728, 67108864, 33554432,
                        16777216, 8388608, 4194304, 2097152, 1048576, 524288,
                        262144, 131072, 65536, 32768, 16384, 8192, 4096, 2048,
                        1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1, 0, 0}, 1000000000));
        System.out.println(1 == minimumSubarrayLength.minimumSubarrayLength(
                new int[]{1,2,3}, 2));
        System.out.println(4 == minimumSubarrayLength.minimumSubarrayLength(
                new int[]{67,24,1,32,22}, 110));
        System.out.println(4 == minimumSubarrayLength.minimumSubarrayLength(
                new int[]{32, 1, 25, 11, 2}, 59));
    }
}
