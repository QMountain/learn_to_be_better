package algorithm.leetcode.easy.r;

/**
 * @ClassName RemoveDuplicates
 * @Description
 * @Author qsf
 * Date   2022-02-19  15:48
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int i = 0;
        int j = 1;
        while (i < nums.length-1) {
            if (nums[i] == nums[nums.length-1]) {
                return i+1;
            }
            while (j < nums.length) {
                if (nums[i] < nums[j]) {
                    if (j < nums.length-1) {
                        if (nums[j] == nums[j+1]) {
                            j++;
                            continue;
                        }
                    }
                    nums[i+1] = nums[j];
                    break;
                }
                j++;
            }
            i++;
            j++;
        }

        return nums.length;
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        System.out.println(2 == removeDuplicates.removeDuplicates(new int[]{1,1,2}));
        System.out.println(5 == removeDuplicates.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
        System.out.println(2 == removeDuplicates.removeDuplicates(new int[]{1,2}));
    }
}
