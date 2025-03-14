package algorithm.leetcode.medium.b;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个下标从 0 开始的整数数组nums 。每次操作中，你可以：
 * 选择两个满足 0 <= i, j < nums.length 的不同下标 i 和 j 。
 * 选择一个非负整数 k ，满足 nums[i] 和 nums[j] 在二进制下的第 k 位（下标编号从 0 开始）是 1 。
 * 将 nums[i] 和 nums[j] 都减去 2^k 。
 * 如果一个子数组内执行上述操作若干次后，该子数组可以变成一个全为 0 的数组，那么我们称它是一个 美丽 的子数组。
 * 请你返回数组 nums 中 美丽子数组 的数目。
 * 子数组是一个数组中一段连续 非空 的元素序列。
 */
public class BeautifulSubarrays {

    /**
     * 1 <= nums.length <= 10^5
     * 0 <= nums[i] <= 10^6
     */
    public long beautifulSubarrays(int[] nums) {
        long ans = 0L;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int xor = 0;
        for (int k : nums) {
            xor ^= k;
            if (map.containsKey(xor)) {
                Integer count = map.get(xor);
                ans += count;
                map.put(xor, count + 1);
            } else {
                map.put(xor, 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        BeautifulSubarrays beautifulSubarrays = new BeautifulSubarrays();
        System.out.println(3 == beautifulSubarrays.beautifulSubarrays(new int[]{0,0}));
        System.out.println(2 == beautifulSubarrays.beautifulSubarrays(new int[]{4,3,1,2,4}));
        System.out.println(1 == beautifulSubarrays.beautifulSubarrays(new int[]{453,0,188,228,290,248,201,271,365,319,288,322,483,159,370,273,145,115,458,249,31,395,253,228,150,23,310,227,358,170,427,39,496,171,55,38,104,399,228,224,474,277,351,11,159,251,312,402,278,65,482,253,196,451,190,243,213,332,410,78,20,116,225,183,254,296,431,372,319,28,469,304,69,181,117,288,489,149,69,68,448,121,271,112,158,79,174,340,461,69,389,448,225,466,38,363,483,268,265,152,334,276,17,205,454,176,81,405,313,348,446,163,13,402,192,50,401,435,408,229,373,160,375,27,49,246,75,114,223,112,44,162,173,236,309,104,229,311,95,56,334,344,147,445,115,56,169,444,167,16,225,38,427,158,441,350,434,135,294,217,378,37,208,94,447,198,80,35,275,448,257,159,287,46,242,246,284,385,80,377,480,353,443,444,168,437,427,495,401,190}));
        System.out.println(1 == beautifulSubarrays.beautifulSubarrays(new int[]{0}));

    }
}
