package algorithm.leetcode.medium.l;

import java.util.*;

public class LongestEqualSubarray {

    // 1 <= nums.length <= 10^5
    // 1 <= nums[i] <= nums.length
    // 0 <= k <= nums.length
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int ans = 1;
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            LinkedList<Integer> list = map.getOrDefault(nums.get(i), new LinkedList<>());
            list.addLast(i);
            if (list.size() == 1) {
                map.put(nums.get(i), list);
            } else {
                while (!list.isEmpty()) {
                    Integer firstIndex = list.peekFirst();
                    int needCut = i - firstIndex + 1 - list.size();
                    if (k >= needCut) {
                        ans = Math.max(ans, list.size());
                        break;
                    } else {
                        list.pollFirst();
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestEqualSubarray longestEqualSubarray = new LongestEqualSubarray();
        int[] arr2 = new int[]{1,1,2,2,1,1};
        int[] arr = new int[]{1,3,2,3,1,3};
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }
        for (int i : arr2) {
            list2.add(i);
        }
        System.out.println(4 == longestEqualSubarray.longestEqualSubarray(list2, 2));
        System.out.println(3 == longestEqualSubarray.longestEqualSubarray(list, 3));
    }
}
