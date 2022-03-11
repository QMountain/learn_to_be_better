package algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;
        int[] indexArr = new int[length];
        for (int num : nums) {
            indexArr[num-1] = num;
        }
        List<Integer> list = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            if (indexArr[i] == 0) {
                list.add(i+1);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        FindDisappearedNumbers findDisappearedNumbers = new FindDisappearedNumbers();
        System.out.println(findDisappearedNumbers.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
        System.out.println(findDisappearedNumbers.findDisappearedNumbers(new int[]{1,1}));

    }
}
