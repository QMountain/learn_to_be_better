package algorithm.leetcode.medium.m;

import java.util.*;

/**
 * 给定 m 个数组，每个数组都已经按照升序排好序了。
 * 现在你需要从两个不同的数组中选择两个整数（每个数组选一个）并且计算它们的距离。
 * 两个整数 a 和 b 之间的距离定义为它们差的绝对值 |a-b| 。
 */
public class MaxDistance {

    // m == arrays.length
    // 2 <= m <= 10^5
    // 1 <= arrays[i].length <= 500
    // -10^4 <= arrays[i][j] <= 10^4
    // arrays[i] 以 升序 排序。
    // 所有数组中最多有 10^5 个整数。
    public int maxDistance(List<List<Integer>> arrays) {
        int leftMinVal = 0;
        Integer leftSecVal = null;
        int rightMaxVal = 0;
        Integer rightSecVal = null;
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> array = arrays.get(i);
            if (array.get(0) <= arrays.get(leftMinVal).get(0)) {
                leftSecVal = leftMinVal;
                leftMinVal = i;
            } else if (leftSecVal == null || array.get(0) < arrays.get(leftSecVal).get(0)) {
                leftSecVal = i;
            }

            Integer currArrayMax = array.get(array.size() - 1);
            List<Integer> oldMaxList = arrays.get(rightMaxVal);
            if (currArrayMax >= oldMaxList.get(oldMaxList.size()-1)) {
                rightSecVal = rightMaxVal;
                rightMaxVal = i;
            } else if (rightSecVal == null) {
                rightSecVal = i;
            } else {
                List<Integer> list1 = arrays.get(rightSecVal);
                if (currArrayMax > list1.get(list1.size()-1)) {
                    rightSecVal = i;
                }
            }
        }
        List<Integer> rightList = arrays.get(rightMaxVal);
        Integer rightMax = rightList.get(rightList.size() - 1);
        Integer leftMin = arrays.get(leftMinVal).get(0);
        if (leftMinVal != rightMaxVal) {
            return rightMax - leftMin;
        }
        List<Integer> rightSecList = arrays.get(rightSecVal);
        int m1 = rightSecList.get(rightSecList.size() - 1) - leftMin;
        int m2 = rightMax - arrays.get(leftSecVal).get(0);
        return Math.max(m1, m2);
    }


    // n == position.length
    // 2 <= n <= 10^5
    // 1 <= position[i] <= 10^9
    // 所有 position 中的整数 互不相同 。
    // 2 <= m <= position.length
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int length = position.length;
        int totalSpan = position[length-1] - position[0];
        int spanCount = m - 1;
        int bestAveSpan = totalSpan / spanCount;
        int left = 0;
        int right = bestAveSpan;
        while (left < right) {
            int mid = (left + right) >> 1;
            int count = 1;
            int last = 0;
            for (int i = 1; i < length; i++) {
                if (position[i] - position[last] >= mid) {
                    count++;
                    last = i;
                    if (count >= m) {
                        break;
                    }
                }
            }
            if (count >= m) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        int count = 1;
        int last = 0;
        for (int i = 1; i < length; i++) {
            if (position[i] - position[last] >= right) {
                count++;
                last = i;
                if (count >= m) {
                    break;
                }
            }
        }
        return count >= m ? right : right - 1;
    }

    public static void main(String[] args) {
        MaxDistance maxDistance = new MaxDistance();
        System.out.println(maxDistance.maxDistance(List.of(List.of(1, 2, 3, 98, 99, 100), List.of(49, 50))));

        System.out.println(5 == maxDistance.maxDistance(new int[]{79,74,57,22}, 4));
        System.out.println(3 == maxDistance.maxDistance(new int[]{5,4,3,2,1,1000000000}, 2));
        System.out.println(3 == maxDistance.maxDistance(new int[]{1,20,305,4199,7999}, 4));
        System.out.println(3 == maxDistance.maxDistance(new int[]{1,2,3,4,7}, 3));
    }
}
