package algorithm.leetcode.medium;

public class OptimalDivision {

    public String optimalDivision(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0]+"";
        }
        if (length == 2) {
            return nums[0] + "/" + nums[1];
        }
        StringBuilder s = new StringBuilder(nums[0] + "/(" + nums[1]);
        for (int i = 2; i < length; i++) {
            s.append("/").append(nums[i]);
        }
        s.append(")");
        return s.toString();
    }

    public static void main(String[] args) {
        OptimalDivision optimalDivision = new OptimalDivision();
        System.out.println("1000/(100/10/2)".equals(optimalDivision.optimalDivision(new int[]{1000,100,10,2})));
    }
}
