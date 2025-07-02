package algorithm.leetcode.easy.f;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

// 哈希表算个数，就是在算长度，O(N)
public class FindLHS {

    public int findLHS(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int max = 0;
        int pre = map.firstEntry().getValue();
        int last = map.pollFirstEntry().getKey();
        while (!map.isEmpty()) {
            Map.Entry<Integer, Integer> entry = map.pollFirstEntry();
            Integer key = entry.getKey();
            if (key - last == 1) {
                max = Math.max(max, pre + entry.getValue());
            }
            last = key;
            pre = entry.getValue();
        }
        return max;
    }

    public static void main(String[] args) {
        FindLHS findLHS = new FindLHS();
        System.out.println(0 == findLHS.findLHS(new int[]{1, 1, 1, 1}));
    }

    // NlogN
    public int findLHS2(int[] nums) {
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
