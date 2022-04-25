package algorithm.leetcode.easy.f;

import java.util.Arrays;

// 哈希表算个数，就是在算长度，O(N)
public class FindLHS {

    // NlogN
    public int findLHS(int[] nums) {
        int length = nums.length;
        int[] arr = new int[length];
        System.arraycopy(nums,0,arr,0,length);
        Arrays.sort(arr);
        int max = 0;
        for (int i = 0; i < length-1; i++) {
            for (int j = i+1; j < length; j++) {
                if (arr[j] == arr[i]+1 && (j == length-1 || arr[j+1] > arr[j])) {
                    max = Math.max(max,j-i+1);
                }
            }
        }
        return max;
    }

}
