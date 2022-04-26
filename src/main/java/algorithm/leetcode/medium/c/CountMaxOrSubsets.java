package algorithm.leetcode.medium.c;

public class CountMaxOrSubsets {

    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0, cnt = 0;
        for (int i = 0; i < 1 << nums.length; i++) {
            int orVal = 0;
            for (int j = 0; j < nums.length; j++) {
                if (((i >> j) & 1) == 1) {
                    orVal |= nums[j];
                }
            }
            if (orVal > maxOr) {
                maxOr = orVal;
                cnt = 1;
            } else if (orVal == maxOr) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        CountMaxOrSubsets countMaxOrSubsets = new CountMaxOrSubsets();
        //System.out.println(2 == countMaxOrSubsets.countMaxOrSubsets(new int[]{3,1}));
        System.out.println(7 == countMaxOrSubsets.countMaxOrSubsets(new int[]{2,2,2}));
    }

}
