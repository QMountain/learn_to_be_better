package algorithm.leetcode.medium.t;

import java.util.*;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int length = nums.length;
        Arrays.sort(nums);
        Map<Integer, Set<String>> sumIndexMap = new TreeMap<>();
        for (int i = 0; i < length - 1; i++) {
            for (int j = i+1; j < length; j++) {
                int sum = nums[i]+nums[j];
                Set<String> set = sumIndexMap.getOrDefault(sum, new HashSet<>());
                set.add(i+","+j);
                sumIndexMap.put(sum,set);
            }
        }
        int closest = nums[0]+nums[1]+nums[2];
        for (Map.Entry<Integer, Set<String>> entry : sumIndexMap.entrySet()) {
            Integer key = entry.getKey();
            Set<String> value = entry.getValue();
            for (int i = 0; i < length; i++) {
                boolean has = false;
                for (String s : value) {
                    if (!s.contains(i+"")) {
                        has = true;
                        break;
                    }
                }
                if (has) {
                    int sum = key + nums[i];
                    if (Math.abs(sum-target) < Math.abs(closest-target)) {
                        closest = sum;
                    }
                    if (sum == target) {
                        return target;
                    } else if (sum > target) {
                        break;
                    }
                }
            }
        }
        return closest;
    }

    // worst n*n*n
    /*public int threeSumClosest(int[] nums, int target) {
        int length = nums.length;
        int closest = nums[0]+nums[1]+nums[2];
        for (int i = 0; i < length-2; i++) {
            for (int j = i+1; j < length-1; j++) {
                for (int k = j+1; k < length; k++) {
                    int sum = nums[i]+nums[j]+nums[k];
                    if (Math.abs(sum-target) < Math.abs(closest-target)) {
                        closest = sum;
                    }
                }
            }
        }
        return closest;
    }*/

    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        /*System.out.println(2 == threeSumClosest.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(0 == threeSumClosest.threeSumClosest(new int[]{0,0,0}, 1));
        System.out.println(2 == threeSumClosest.threeSumClosest(new int[]{1,1,1,0}, -100));*/
        System.out.println(3 == threeSumClosest.threeSumClosest(new int[]{1,1,1,0}, 100));
    }
}
