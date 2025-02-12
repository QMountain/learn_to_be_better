package algorithm.leetcode.medium.m;

import java.util.Map;
import java.util.TreeMap;

public class MinimumSize {

    public int minimumSize(int[] nums, int maxOperations) {
        int max = nums[0];
        int sum = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        int length = nums.length;
        int finalLength = length + maxOperations;
        int bestAve = (sum / finalLength) + (sum % finalLength == 0 ? 0 : 1);
        int left = bestAve;
        int right = max;
        while (left < right) {
            int mid = (left + right) >> 1;
            int count = 0;
            for (int num : nums) {
                if (num > bestAve) {
                    int times = (num / mid) - (num % mid == 0 ? 1 : 0);
                    count += times;
                }
            }
            if (count <= maxOperations) {
                right = mid;
            } else {
                if (left + 1 == right) {
                    return right;
                } else {
                    left = mid;
                }
            }
        }
        return left;
    }

    public int minimumSize2(int[] nums, int maxOperations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int sum = 0;
        for (int num : nums) {
            sum += num;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int length = nums.length;
        while (true) {
            int finalLength = length + maxOperations;
            int bestAve = (sum / finalLength) + (sum % finalLength == 0 ? 0 : 1);
            if (map.firstKey() < bestAve) {
                Map.Entry<Integer, Integer> entry = map.pollFirstEntry();
                sum -= entry.getKey() * entry.getValue();
                length -= entry.getValue();
            } else {
                int left = bestAve;
                int right = map.lastKey();
                while (left < right) {
                    int mid = (left + right) >> 1;
                    int count = 0;
                    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                        if (entry.getKey() > bestAve) {
                            int times = (entry.getKey() / mid) - (entry.getKey() % mid == 0 ? 1 : 0);
                            count += times * entry.getValue();
                        }
                    }
                    if (count <= maxOperations) {
                        right = mid;
                    } else {
                        if (left + 1 == right) {
                            return right;
                        } else {
                            left = mid;
                        }
                    }
                }

                return left;
            }
        }
    }

    public static void main(String[] args) {
        MinimumSize minimumSize = new MinimumSize();
        System.out.println(531 == minimumSize.minimumSize(new int[]{4,412,354,607,587,28,136,327,929,905,671,811,572,152,556,96,205,188,505,14,602,591,802,662,543,781,878,812,539,981,587,716,531,354,92,165,352,522,983,966,378,911,873,606,392,927,426,726,892,939,96,419,769,387,178,895,41,291,437,513,37,569,945,102,460}, 33));
        System.out.println(129 == minimumSize.minimumSize(new int[]{431,922,158,60,192,14,788,146,788,775,772,792,68,143,376,375,877,516,595,82,56,704,160,403,713,504,67,332,26}, 80));
        System.out.println(7 == minimumSize.minimumSize(new int[]{7, 17}, 2));
        System.out.println(3 == minimumSize.minimumSize(new int[]{9}, 2));
    }
}
