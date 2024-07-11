package algorithm.leetcode.hard.i;

public class IncremovableSubarrayCount {

    public long incremovableSubarrayCount(int[] nums) {
        int length = nums.length;
        int left = -1;
        for (int i = 0; i < length-1; i++) {
            if (nums[i] >= nums[i+1]) {
                left = i;
                break;
            }
        }
        if (left == -1) {
            return (1 + length) * length >> 1;
        }
        // 至此，length > 1
        // 一个不留 1种
        // 只留第一个 1种
        // 只留最后一个 1种
        long ans = left + 2;
        while (left >= 0 && nums[left] >= nums[length-1]) {
            left--;
        }
        ans += left + 2;
        int lastEnd = left;
        // i 是 尾部保留长度
        for (int i = 2; i < length; i++) {
            if (nums[length-i] < nums[length-i+1]) {
                if (lastEnd < 0) {
                    ans++;
                    continue;
                }
                for (int j = lastEnd; j >= 0; j--) {
                    lastEnd = j;
                    if (nums[j] < nums[length-i]) {
                        break;
                    }
                }
                ans++;
                if (lastEnd > 0 || nums[lastEnd] < nums[length - i]) {
                    ans += lastEnd + 1;
                }
            } else {
                break;
            }
        }
        return ans;
    }

}
