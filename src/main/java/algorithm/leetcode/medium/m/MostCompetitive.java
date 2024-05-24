package algorithm.leetcode.medium.m;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MostCompetitive {

    public int[] mostCompetitive(int[] nums, int k) {
        int length = nums.length;
        if (length == k) {
            return nums;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->{
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        int[] ans = new int[k];
        int writeAnsIndex = 0;
        int readNumIndex = 0;
        int lastUseIndex = -1;
        while (writeAnsIndex < ans.length) {
            while (readNumIndex <= nums.length - k) {
                queue.add(new int[]{nums[readNumIndex], readNumIndex});
                readNumIndex++;
            }
            while (queue.peek()[1] <= lastUseIndex) {
                queue.poll();
            }
            int[] poll = queue.poll();
            ans[writeAnsIndex++] = poll[0];
            lastUseIndex = poll[1];
            k--;
        }
        return ans;
    }

    public static void main(String[] args) {
        MostCompetitive mostCompetitive = new MostCompetitive();
        System.out.println(Arrays.toString(mostCompetitive.mostCompetitive(
                new int[]{2,4,3,3,5,4,9,6}, 4)));
        System.out.println(Arrays.toString(mostCompetitive.mostCompetitive(
                new int[]{1,1,1,1,1,1,1,1,0,0}, 5)));
        System.out.println(Arrays.toString(mostCompetitive.mostCompetitive(
                new int[]{84,10,71,23,66,61,62,64,34,41,80,25,91,43,4,75,65,13,37,41,46,90,55,8,85,61,95,71}, 24)));


        System.out.println(Arrays.toString(mostCompetitive.mostCompetitive(
                new int[]{3, 5, 2, 6}, 2)));
    }
}
