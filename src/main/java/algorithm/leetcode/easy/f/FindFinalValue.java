package algorithm.leetcode.easy.f;

import java.util.HashSet;
import java.util.Set;

public class FindFinalValue {

    /**
     * 2154. 将找到的值乘以 2
     * 给你一个整数数组 nums ，另给你一个整数 original ，这是需要在 nums 中搜索的第一个数字。
     * 接下来，你需要按下述步骤操作：
     * 1 如果在 nums 中找到 original ，将 original 乘以 2 ，
     *      得到新 original（即，令 original = 2 * original）。
     * 2 否则，停止这一过程。
     * 3 只要能在数组中找到新 original ，就对新 original 继续 重复 这一过程。
     * 返回 original 的 最终 值。
     * 1 <= nums.length <= 1000
     * 1 <= nums[i], original <= 1000
     */
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        while (set.contains(original)) {
            original *= 2;
        }

        return original;
    }

    public static void main(String[] args) {
        FindFinalValue findFinalValue = new FindFinalValue();
        System.out.println(24 == findFinalValue.findFinalValue(
                new int[]{5, 3, 6, 1, 12}, 3));
    }

    public int findFinalValue2(int[] nums, int original) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            set.add(num);
        }
        while (true) {
            if (set.contains(original)) {
                original *= 2;
            } else {
                break;
            }
        }
        return original;
    }

}
