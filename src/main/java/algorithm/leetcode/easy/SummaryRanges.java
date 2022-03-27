package algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        int length = nums.length;
        List<String> list = new ArrayList<>(length);
        if (length == 0) {
            return list;
        }
        for (int i = 0; i < length; i++) {
            int right = i;
            for (int j = i+1; j < length; j++) {
                if (nums[j] != nums[j-1] + 1) {
                    right = j-1;
                    break;
                }
                if (j == length-1 && nums[j] == nums[j-1]+1) {
                    right = j;
                }
            }
            if (i == right) {
                list.add(nums[i]+"");
            } else {
                list.add(nums[i]+"->"+nums[right]);
                i = right;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        SummaryRanges summaryRanges = new SummaryRanges();
        System.out.println(summaryRanges.summaryRanges(new int[]{0,2,3,4,6,8,9}));
        System.out.println(summaryRanges.summaryRanges(new int[]{0,1,2,4,5,7}));
    }
}
