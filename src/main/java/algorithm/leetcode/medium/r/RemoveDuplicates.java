package algorithm.leetcode.medium.r;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int currEle = nums[0];
        int countCurr = 1;
        int writeIndex = 1;
        for (int i = 1; i < length; i++) {
            if (nums[i] == currEle) {
                if (++countCurr <= 2) {
                    nums[writeIndex++] = currEle;
                }
            } else {
                nums[writeIndex++] = nums[i];
                currEle = nums[i];
                countCurr = 1;
            }
        }

        return writeIndex;
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        System.out.println(7 == removeDuplicates.removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
        System.out.println(5 == removeDuplicates.removeDuplicates(new int[]{1,1,1,2,2,3}));
    }
}
