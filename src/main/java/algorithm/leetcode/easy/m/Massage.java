package algorithm.leetcode.easy.m;

public class Massage {

    public int massage(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int preNotSelected = 0;
        int preSelected = nums[0];
        int temp;
        for (int i = 1; i < length; i++) {
            temp = preNotSelected;
            preNotSelected = Math.max(preNotSelected, preSelected);
            preSelected = temp + nums[i];
        }
        return Math.max(preNotSelected, preSelected);
    }

    public static void main(String[] args) {
        Massage massage = new Massage();
        System.out.println(12 == massage.massage(new int[]{2,7,9,3,1}));
        System.out.println(4 == massage.massage(new int[]{1,2,3,1}));
    }
}
