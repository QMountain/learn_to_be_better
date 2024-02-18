package algorithm.leetcode.easy.s;

import java.util.*;

public class SingleNumber {

    // 时间 O(n)  但是还遍历了一次map，准确说是 O(n+k),其中k为map的size
    // 空间 O(n)
    public int singleNumber1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }

    // 1 <= nums.length <= 3 * 10^4
    // -3 * 10^4 <= nums[i] <= 3 * 10^4
    // 除了某个元素只出现一次以外，其余每个元素均出现两次
    // 时间 O(n)
    // 空间 O(n)
    public int singleNumber4(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int total = 0;
        int setSum = 0;
        for (int num : nums) {
            total += num;
            if (set.add(num)) {
                setSum += num;
            }
        }
        return total - setSum;
    }

    // 时间 O(n^2)
    // 空间 O(1)
    public int singleNumber2(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            boolean currIsSingle = true;
            for (int j = i+1; j < length; j++) {
                if (nums[i] == nums[j]) {
                    currIsSingle = false;
                    break;
                }
            }
            if (currIsSingle) {
                return nums[i];
            }
        }
        return 0;
    }

    // 时间 O(nLogN)
    // 空间 O(1)
    public int singleNumber3(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length-1; i++) {
            if (nums[i-1] != nums[i] && nums[i] != nums[i+1]) {
                return nums[i];
            }
        }
        return 0;
    }

    // 时间 O(n)  空间 O(1)
    public int singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }

    // 异或运算有以下三个性质：
    // 任何数和 0 做异或运算，结果仍然是原来的数，即 a ^ 0 = a
    // 任何数和其自身做异或运算，结果是 0，即 a ^ a = 0
    // 异或运算满足交换律和结合律，即 a ^ b ^ a =
    //                          b ^ a ^ a =
    //                          b ^ (a ^ a) =
    //                          b ^ 0 = b

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        System.out.println(1 == singleNumber.singleNumber(new int[]{2,2,1}));
        System.out.println(4 == singleNumber.singleNumber(new int[]{4,1,2,1,2}));
    }
}
