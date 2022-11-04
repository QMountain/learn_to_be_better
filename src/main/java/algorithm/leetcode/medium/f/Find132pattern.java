package algorithm.leetcode.medium.f;

import java.util.*;

public class Find132pattern {

    public boolean find132pattern(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return false;
        }
        List<int[]> list = new ArrayList<>(length);
        int minIndex = 0;
        int maxIndex = -1;
        for (int i = 1; i < length; i++) {
            if (nums[i] > nums[minIndex]) {
                if (maxIndex == -1 || nums[i] > nums[maxIndex]) {
                    for (int[] ints : list) {
                        if (nums[i] > ints[0] && nums[i] < ints[1]) {
                            return true;
                        }
                    }
                    maxIndex = i;
                } else if (nums[i] < nums[maxIndex]) {
                    return true;
                }
            } else if (nums[i] < nums[minIndex]) {
                if (maxIndex != -1) {
                    int[] curr = new int[]{nums[minIndex],nums[maxIndex]};
                    int index = Collections.binarySearch(list, curr, (a, b) -> {
                        int min = Math.min(a[0],b[0]);
                        int max = Math.max(a[1],b[1]);
                        if (max - min > a[1] - a[0] + b[1] - b[0]) {
                            return a[0] - b[0];
                        }
                        return 0;
                    });
                    if (index == -1) {
                        list.add(0,curr);
                    } else {
                        int[] ints = list.get(index);
                        int min = Math.min(ints[0],curr[0]);
                        int max = Math.max(ints[1],curr[1]);
                        if (max - min <= ints[1] - ints[0] + curr[1] - curr[0]) {
                            ints[0] = min;
                            ints[1] = max;
                        } else {
                            list.add(index+1,curr);
                        }
                    }
                }
                minIndex = i;
                maxIndex = -1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Find132pattern find132pattern = new Find132pattern();
        System.out.println(find132pattern.find132pattern(new int[]{2,4,1,3}));
        System.out.println(find132pattern.find132pattern(new int[]{1,0,1,-4,-3}));
        System.out.println(find132pattern.find132pattern(new int[]{-1,3,2,0}));
        System.out.println(find132pattern.find132pattern(new int[]{3,1,4,2}));
        System.out.println(find132pattern.find132pattern(new int[]{1,2,3,4}));
    }
}
