package algorithm.leetcode.easy;

public class MinMoves {

    public int minMoves(int[] nums) {
        boolean allEquals = true;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] != nums[i+1]) {
                allEquals = false;
            }
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        if (allEquals) {
            return 0;
        }
        int res = 0;
        int p = nums.length-2;
        while (p >= 0) {
            int distance = nums[nums.length-1] - nums[p];
            if (distance == 0) {
                p--;
                continue;
            }
            int willChange = nums.length-1-p-1;
            if (willChange > 0) {
                int count = nums.length-1-p;
                int newMax = count*nums[nums.length-1]-(count-1)*nums[p];
                int totalMoveCount = newMax - nums[p];
                for (int i = 0; i <= p; i++) {
                    nums[i] += totalMoveCount;
                }
                for (int i = p+1; i < nums.length; i++) {
                    nums[i] = newMax;
                }
                res += totalMoveCount;
            } else {
                for (int i = 0; i <= p; i++) {
                    nums[i] += distance;
                }
                res += distance;
            }
            p--;
        }
        return res;
    }

    public static void main(String[] args) {
        MinMoves minMoves = new MinMoves();
        /*System.out.println(3 == minMoves.minMoves(new int[]{1,2,3}));
        System.out.println(0 == minMoves.minMoves(new int[]{1,1,1}));
        System.out.println(300 == minMoves.minMoves(new int[]{-100,0,100}));*/
        System.out.println(7 == minMoves.minMoves(new int[]{5,6,8,8,5}));
    }
}
