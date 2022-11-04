package algorithm.leetcode.hard.s;

import java.util.LinkedList;

public class ShortestSubarray {

    public int shortestSubarray(int[] nums, int k) {
        LinkedList<int[]> list = new LinkedList<>();
        for (int num : nums) {
            if (num >= k) {
                return 1;
            }
            if (list.isEmpty() || (list.peekLast()[0] <= 0 && num > 0) || list.peekLast()[0] > 0) {
                list.add(new int[]{num,1});
            } else {
                int[] pollLast = list.pollLast();
                list.addLast(new int[]{pollLast[0]+num,pollLast[1]+1});
            }
        }
        int size = list.size();
        int tryLength = 2;
        while (tryLength <= size) {
            int base = 0;
            int startIndex = 0;
            for (int i = 0; i <=size - tryLength; i++) {
                startIndex = i;
                if (list.get(i)[0] > 0) {
                    int endIndex = 0;
                    for (int j = i; j < i + tryLength ; j++) {
                        int n = list.get(j)[0];
                        base += n;
                        if (n < 0) {
                            j += list.get(j)[1]-1;
                        }
                        endIndex = j;
                        if (base >= k) {
                            return tryLength;
                        }
                    }
                    if (list.get(endIndex)[0] <= 0) {
                        base = 0;
                    } else {
                        break;
                    }
                }
            }
            for (int i = startIndex+1; i <= size - tryLength; i++) {
                if (list.get(i)[0] > 0) {
                    int endIndex = 0;
                    for (int j = i; j < i + tryLength ; j++) {
                        int n = list.get(j)[0];
                        if (n < 0) {
                            j += list.get(j)[1]-1;
                        }
                        endIndex = j;
                    }
                    if (list.get(endIndex)[0] > 0) {
                        base -= list.get(i-1)[0];
                        base += list.get(endIndex)[0];
                        if (base >= k) {
                            return tryLength;
                        }
                    }
                }
            }
            tryLength++;
        }
        return -1;
    }

    public static void main(String[] args) {
        ShortestSubarray shortestSubarray = new ShortestSubarray();
        System.out.println(3 == shortestSubarray.shortestSubarray(new int[]{-47,45,92,86,17,-22,77,62,-1,42}, 180));
        System.out.println(2 == shortestSubarray.shortestSubarray(new int[]{17,85,93,-45,-21}, 150));
        System.out.println(1 == shortestSubarray.shortestSubarray(new int[]{-11,-15,76,41,-41,68,41,12,73,-8}, 50));
        System.out.println(2 == shortestSubarray.shortestSubarray(new int[]{48,99,37,4,-31}, 140));
        System.out.println(-1 == shortestSubarray.shortestSubarray(new int[]{1,2}, 4));
        System.out.println(1 == shortestSubarray.shortestSubarray(new int[]{77,19,35,10,-14}, 19));
        System.out.println(3 == shortestSubarray.shortestSubarray(new int[]{2,-1,2}, 3));

        System.out.println(1 == shortestSubarray.shortestSubarray(new int[]{1}, 1));
    }
}
