package algorithm.leetcode.hard;

/**
 * @ClassName NumberOfGoodSubsets
 * @Description
 * @Author qsf
 * Date   2022-02-22  15:46
 */
public class NumberOfGoodSubsets {

    public int numberOfGoodSubsets(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num != 2 && num % 2 == 0) {
                continue;
            }
            
        }
        return 0;
    }

}
