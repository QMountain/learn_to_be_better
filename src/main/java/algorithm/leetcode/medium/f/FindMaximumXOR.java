package algorithm.leetcode.medium.f;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindMaximumXOR {

    public int findMaximumXOR(int[] nums) {
        Map<Integer,Set<Integer>> map = new HashMap<>();
        int maxLength = 0;
        for (int num : nums) {
            int l = Integer.toBinaryString(num).length();
            maxLength = Math.max(maxLength,l);
            if (map.containsKey(l)) {
                map.get(l).add(num);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(num);
                map.put(l,set);
            }
        }
        Set<Integer> highestSet = map.get(maxLength);
        int ans = 0;
        for (Integer highest : highestSet) {
            String s = Integer.toBinaryString(highest);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    int nl = s.length()-i;
                    Set<Integer> set = map.get(nl);
                    break;
                }
            }
        }
        return ans;
    }

    public int findMaximumXOR1(int[] nums) {
        int length = nums.length;
        Set<Integer> set = new HashSet<>();
        set.add(nums[0]);
        int maxLength = Integer.toBinaryString(nums[0]).length();
        for (int i = 1; i < length; i++) {
            int l = Integer.toBinaryString(nums[i]).length();
            if (l > maxLength) {
                maxLength = l;
                set.clear();
                set.add(nums[i]);
            } else if (l == maxLength) {
                set.add(nums[i]);
            }
        }
        int max = 0;
        for (Integer num1 : set) {
            for (int num2 : nums) {
                int curr = num1 ^ num2;
                max = Math.max(max, curr);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        FindMaximumXOR findMaximumXOR = new FindMaximumXOR();
        System.out.println(3 == findMaximumXOR.findMaximumXOR(new int[]{4,6,7}));
        System.out.println(127 == findMaximumXOR.findMaximumXOR(new int[]{14,70,53,83,49,91,36,80,92,51,66,70}));
        System.out.println(28 == findMaximumXOR.findMaximumXOR(new int[]{3,10,5,25,2,8}));
    }
}
