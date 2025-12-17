package algorithm.leetcode.easy.f;

public class FindErrorNums {

    /**
     * 错误的集合
     * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，
     * 导致集合里面某一个数字复制成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
     * 给定一个数组 nums 代表了该集合发生错误后的结果。
     * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
     */
    public int[] findErrorNums(int[] nums) {
        int length = nums.length;
        int sum = (1 + length) * length / 2;
        int[] arr = new int[length];
        int twice = 0;
        for (int num : nums) {
            if (arr[num - 1] != 0) {
                twice = arr[num - 1];
            } else {
                sum -= num;
            }
            arr[num - 1] = num;
        }
        return new int[]{twice, sum};
    }

}
