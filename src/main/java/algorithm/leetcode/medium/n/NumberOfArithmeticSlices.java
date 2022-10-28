package algorithm.leetcode.medium.n;

import java.util.LinkedList;
import java.util.List;

public class NumberOfArithmeticSlices {

    public int numberOfArithmeticSlices(int[] nums) {
        int length = nums.length;
        int start = 0;
        List<Integer> list = new LinkedList<>();
        while (start < length-2) {
            int count = 2;
            for (int i = start+1; i < length-1; i++) {
                if (nums[i] - nums[i-1] == nums[i+1] - nums[i]) {
                    count++;
                } else {
                    break;
                }
            }
            if (count >= 3) {
                list.add(count);
            }
            start += count-1;
        }
        int ans = 0;
        for (Integer count : list) {
            ans += (count-1)*(count-2)/2;
        }
        return ans;
    }

    public static void main(String[] args) {
        NumberOfArithmeticSlices numberOfArithmeticSlices = new NumberOfArithmeticSlices();
        System.out.println(3 == numberOfArithmeticSlices.numberOfArithmeticSlices(new int[]{1,2,3,4}));
        System.out.println(0 == numberOfArithmeticSlices.numberOfArithmeticSlices(new int[]{1}));
    }
}
