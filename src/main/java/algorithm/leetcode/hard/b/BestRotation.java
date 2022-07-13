package algorithm.leetcode.hard.b;

public class BestRotation {

    public int bestRotation(int[] nums) {
        int length = nums.length;
        int maxScore = 0;
        int maxK = 0;
        for (int i = 0; i < length; i++) {
            int score = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] <= length-i+j) {
                    score++;
                }
            }
            for (int j = i; j < length; j++) {
                if (nums[j] <= j-i) {
                    score++;
                }
            }
            if (score > maxScore) {
                maxScore = score;
                maxK = i;
            }
        }
        return maxK;
        /*int n = nums.length;
        int[] diffs = new int[n];
        for (int i = 0; i < n; i++) {
            int low = (i + 1) % n;
            int high = (i - nums[i] + n + 1) % n;
            diffs[low]++;
            diffs[high]--;
            if (low >= high) {
                diffs[0]++;
            }
        }
        int bestIndex = 0;
        int maxScore = 0;
        int score = 0;
        for (int i = 0; i < n; i++) {
            score += diffs[i];
            if (score > maxScore) {
                bestIndex = i;
                maxScore = score;
            }
        }
        return bestIndex;*/

    }

    public static void main(String[] args) {
        BestRotation bestRotation = new BestRotation();
        System.out.println(3 == bestRotation.bestRotation(new int[]{2,3,1,4,0}));
        System.out.println(0 == bestRotation.bestRotation(new int[]{1,3,0,2,4}));
    }
}
