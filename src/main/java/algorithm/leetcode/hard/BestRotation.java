package algorithm.leetcode.hard;

public class BestRotation {

    public int bestRotation(int[] nums) {
        /*int length = nums.length;
        Map<Integer,Integer> scoreIndexMap = new TreeMap<>();
        for (int i = 0; i < length; i++) {
            int[] newNums = new int[length];
            System.arraycopy(nums,i,newNums,0,length-i);
            System.arraycopy(nums,0,newNums,length-i,i);
            int score = 0;
            for (int j = 0; j < length; j++) {
                if (newNums[j] <= j) {
                    score++;
                }
            }
            if (scoreIndexMap.containsKey(score)) {
                scoreIndexMap.put(score,Math.min(scoreIndexMap.get(score),i));
            } else {
                scoreIndexMap.put(score,i);
            }
        }
        Set<Integer> set = scoreIndexMap.keySet();
        List<Integer> list = new ArrayList<>(set);
        Integer maxScore = list.get(list.size()-1);
        return scoreIndexMap.get(maxScore);*/
        int n = nums.length;
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
        return bestIndex;

    }

    public static void main(String[] args) {
        BestRotation bestRotation = new BestRotation();
        System.out.println(3 == bestRotation.bestRotation(new int[]{2,3,1,4,0}));
        System.out.println(0 == bestRotation.bestRotation(new int[]{1,3,0,2,4}));
    }
}
