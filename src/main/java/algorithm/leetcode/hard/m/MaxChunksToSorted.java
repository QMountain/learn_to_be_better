package algorithm.leetcode.hard.m;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxChunksToSorted {

    public int maxChunksToSorted(int[] arr) {
        int length = arr.length;
        int[] sorted = new int[length];
        System.arraycopy(arr,0,sorted,0,length);
        Arrays.sort(sorted);
        int ans = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] != sorted[i]) {
                Map<Integer,Integer> oldMap = new HashMap<>();
                oldMap.put(arr[i],1);
                Map<Integer,Integer> sortedMap = new HashMap<>();
                sortedMap.put(sorted[i],1);
                for (int j = i+1; j < length; j++) {
                    oldMap.put(arr[j],oldMap.getOrDefault(arr[j],0)+1);
                    sortedMap.put(sorted[j],sortedMap.getOrDefault(sorted[j],0)+1);
                    if (oldMap.size() == sortedMap.size()) {
                        boolean allEqual = true;
                        for (Integer key : oldMap.keySet()) {
                            if (!oldMap.get(key).equals(sortedMap.getOrDefault(key,0))) {
                                allEqual = false;
                                break;
                            }
                        }
                        if (allEqual) {
                            i = j;
                            ans++;
                        }
                    }
                }
            } else {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxChunksToSorted maxChunksToSorted = new MaxChunksToSorted();
        System.out.println(maxChunksToSorted.maxChunksToSorted(new int[]{0,0,1,1,1}));
        System.out.println(4 == maxChunksToSorted.maxChunksToSorted(new int[]{2,1,3,4,4}));
        System.out.println(1 == maxChunksToSorted.maxChunksToSorted(new int[]{5,4,3,2,1}));
    }
}
