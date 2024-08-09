package algorithm.leetcode.medium.s;

import java.util.*;

public class SumDistance {

    int divider = 100_000_0007;

    // 2 <= nums.length <= 10^5
    // 0 <= d <= 10^9     意味着肯定不能一次次模拟
    public int sumDistance(int[] nums, String s, int d) {
        int length = nums.length;
        int[][] sortArr = new int[length][2];
        for (int i = 0; i < length; i++) {
            sortArr[i][0] = nums[i];
            sortArr[i][1] = s.charAt(i) == 'L' ? -1 : 1;
        }
        Arrays.sort(sortArr, Comparator.comparingInt(a -> a[0]));
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            if (sortArr[i][1] == 1) {
                stack.add(i);
            }
        }
        for (int i = length-1; i >= 0; i--) {
            if (sortArr[i][1] == 1) {
                nums[i] = sortArr[i][0] + d;
            } else {
                while (!stack.isEmpty() && stack.peek() > i) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    nums[i] = sortArr[i][0] + d;
                } else {
                    int time = (sortArr[i][0] - sortArr[stack.peek()][0]) >> 1;
                    if (time > d) {
                        nums[i] = sortArr[i][0] - d;
                    } else {
                        int position = (sortArr[i][0] + sortArr[stack.peek()][0]) >> 1;
                        nums[i] = position + d - time;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < length / 2; i++) {
            int x = nums[i];
            int y = nums[length-1-i];
            int bs = length - 1 - (i * 2);
            ans += (y - x) * bs % divider;
        }
        return ans;
    }

    public void move(int[] nums, int[] arr, int d, int left, int right) {
        for (int i = left; i < right; i++) {
            if (arr[i] == -1) {
                nums[left++] -= d;
            } else {
                int distance = nums[i+1] - nums[i];
                if (arr[i+1] == -1) {
                    if (distance >= d * 2) {
                        nums[left] += d;
                        nums[left+1] -= d;
                        left += 2;
                    } else {
                        if (distance % 2 == 0) {
                            nums[left] += distance / 2;
                            nums[left+1] -= distance / 2;
                            nums[left] -= d - (distance / 2);
                        }
                        nums[left] += d;
                        nums[left+1] -= d;
                        left += 2;
                    }
                }

                break;
            }
        }
        for (int i = right; i >= left; i--) {
            if (arr[i] == 1) {
                nums[right--] += d;
            } else {
                break;
            }
        }
        if (left >= right) {
            return;
        }
        int minDistance = nums[right] - nums[left];
        for (int i = left; i < right; i++) {
            if (arr[i] == 1 && arr[i+1] == -1) {
                int distance = nums[i+1] - nums[i];
                minDistance = Math.min(distance, minDistance);
            }
        }
        int minMove = (minDistance + 1) / 2;
        for (int i = left; i < right; i++) {
            int dist = nums[i+1] - nums[i];
            if (arr[i] == arr[i+1]) {
                nums[i] += minMove * arr[i];
            } else {
                if (dist == minMove * 2) {
                    nums[i] += minMove * arr[i];
                    nums[i+1] += minMove * arr[i+1];
                    arr[i] = -arr[i];
                    arr[i+1] = -arr[i+1];
                } else if (dist < minMove * 2) {
                    nums[i] += (minMove - 1) * arr[i];
                    nums[i+1] += (minMove - 1) * arr[i+1];
                    arr[i] = -arr[i];
                    arr[i+1] = -arr[i+1];
                } else {
                    nums[i] += minMove * arr[i];
                    nums[i+1] += minMove * arr[i+1];
                }
                i++;
            }
        }
        d -= minMove;
        if (d > 0) {
            move(nums, arr, d, left, right);
        }
    }

    public static void main(String[] args) {
        SumDistance sumDistance = new SumDistance();
        System.out.println(1086 == sumDistance.sumDistance(
                new int[]{12,31,24,49,37,-61,3,43},
                "LRRRLRLL", 8));
        System.out.println(8 == sumDistance.sumDistance(new int[]{-2,0,2}, "RLL", 3));
        System.out.println(5 == sumDistance.sumDistance(new int[]{1,0}, "RL", 2));

        System.out.println(1440 == sumDistance.sumDistance(
                new int[]{-59,39,-11,53,48,-54,27,17},
                "RRLLLLRL", 7));
        System.out.println(2106 == sumDistance.sumDistance(
                new int[]{1,-67,68,-26,-13,-40,-56,62,21},
                "LLLRLLRRR", 4));

        System.out.println(146 == sumDistance.sumDistance(new int[]{-10,-13,10,14,11}, "LRLLR", 2));

    }
}
