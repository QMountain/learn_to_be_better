package algorithm.leetcode.easy.p;

import java.util.ArrayList;
import java.util.List;

public class PrefixesDivBy5 {

    public List<Boolean> prefixesDivBy5(int[] nums) {
        int length = nums.length;
        List<Boolean> list = new ArrayList<>(length);
        int left = nums[0];
        if (left == 0) {
            list.add(Boolean.TRUE);
        } else {
            list.add(Boolean.FALSE);
        }
        for (int i = 1; i < length; i++) {
            left = left * 2 + nums[i];
            if (left % 5 == 0) {
                list.add(Boolean.TRUE);
            } else {
                list.add(Boolean.FALSE);
            }
            left = left % 5;
        }
        return list;
    }

    public static void main(String[] args) {
        PrefixesDivBy5 prefixesDivBy5 = new PrefixesDivBy5();
        System.out.println(prefixesDivBy5.prefixesDivBy5(
                new int[]{1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,
                        0,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0,1}));
    }
}
