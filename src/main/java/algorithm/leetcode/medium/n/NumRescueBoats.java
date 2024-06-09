package algorithm.leetcode.medium.n;

import java.util.*;

public class NumRescueBoats {

    // 1 <= people.length <= 5 * 10^4
    // 1 <= people[i] <= limit <= 3 * 10^4
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0;
        int left = 0;
        int right = people.length-1;
        while (left <= right) {
            ans++;
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
        }
        return ans;
    }

    public static void main(String[] args) {
        NumRescueBoats numRescueBoats = new NumRescueBoats();
        System.out.println(12 == numRescueBoats.numRescueBoats(new int[]{36,74,84,92,17,68,97,6,68,85,35,26,60,45,18,48,41,57,51,32}, 100));
        System.out.println(4 == numRescueBoats.numRescueBoats(new int[]{3,5,3,4}, 5));

        System.out.println(11 == numRescueBoats.numRescueBoats(new int[]{2,49,10,7,11,41,47,2,22,6,13,12,33,18,10,26,2,6,50,10}, 50));
        System.out.println(3 == numRescueBoats.numRescueBoats(new int[]{3,2,3,2,2}, 6));
        System.out.println(1 == numRescueBoats.numRescueBoats(new int[]{2,2}, 6));
        System.out.println(3 == numRescueBoats.numRescueBoats(new int[]{3,2,2,1}, 3));
        System.out.println(1 == numRescueBoats.numRescueBoats(new int[]{1,2}, 3));
    }
}
