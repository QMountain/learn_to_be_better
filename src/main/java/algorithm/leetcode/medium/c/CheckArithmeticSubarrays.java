package algorithm.leetcode.medium.c;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CheckArithmeticSubarrays {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int ll = l.length;
        List<Boolean> ansList = new ArrayList<>(ll);
        for (int i = 0; i < ll; i++) {
            int min = nums[l[i]];
            int max = nums[l[i]];
            HashSet<Integer> set = new HashSet<>();
            for (int j = l[i]; j <= r[i]; j++) {
                set.add(nums[j]);
                if (nums[j] < min) {
                    min = nums[j];
                }
                if (nums[j] > max) {
                    max = nums[j];
                }
            }
            if (set.size() == 1) {
                ansList.add(true);
            } else {
                if (set.size() < r[i] - l[i] + 1) {
                    ansList.add(false);
                } else {
                    if ((max - min) % (set.size()-1) != 0) {
                        ansList.add(false);
                    } else {
                        int diff = (max - min) / (set.size()-1);
                        boolean find = true;
                        for (int j = min + diff; j <= max-diff; j+=diff) {
                            if (!set.contains(j)) {
                                find = false;
                                break;
                            }
                        }
                        ansList.add(find);
                    }
                }
            }
        }
        return ansList;
    }

    public static void main(String[] args) {
        CheckArithmeticSubarrays checkArithmeticSubarrays = new CheckArithmeticSubarrays();
        System.out.println(checkArithmeticSubarrays.checkArithmeticSubarrays(
                new int[]{1,-2,-6,-4,-8,-10,9,2,1,-3,-9,-12,-6,-10,1,4,2,3,6},
                new int[]{1,0,14,9}, new int[]{5,3,17,12}));
        System.out.println(checkArithmeticSubarrays.checkArithmeticSubarrays(
                new int[]{-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10},
                new int[]{0,1,6,4,8,7}, new int[]{4,4,9,7,9,10}));
        System.out.println(checkArithmeticSubarrays.checkArithmeticSubarrays(new int[]{4, 6, 5, 9, 3, 7},
                new int[]{0, 0, 2}, new int[]{2,3,5}));
    }
}
