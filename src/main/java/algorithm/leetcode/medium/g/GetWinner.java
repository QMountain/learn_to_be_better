package algorithm.leetcode.medium.g;

import java.util.LinkedList;

public class GetWinner {

    // 2 <= arr.length <= 10^5
    // 1 <= arr[i] <= 10^6
    // arr 所含的整数 各不相同 。
    // 1 <= k <= 10^9
    public int getWinner(int[] arr, int k) {
        int first = Math.max(arr[0], arr[1]);
        if (k == 1) {
            return first;
        }
        int winTimes = 1;
        LinkedList<Integer> list = new LinkedList<>();
        list.add(Math.min(arr[0], arr[1]));
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] < first) {
                winTimes++;
            } else {
                winTimes = 1;
                first = arr[i];
                list.addLast(arr[i]);
            }
            if (winTimes >= k) {
                return first;
            }
        }
        while (!list.isEmpty()) {
            Integer pollFirst = list.pollFirst();
            if (pollFirst > first) {
                winTimes = 1;
                first = pollFirst;
                list.addLast(pollFirst);
            } else {
                winTimes++;
            }
            if (winTimes >= k) {
                return first;
            }
        }
        return first;
    }

    public static void main(String[] args) {
        GetWinner getWinner = new GetWinner();
        System.out.println(25 == getWinner.getWinner(new int[]{1,25,35,42,68,70}, 1));
        System.out.println(getWinner.getWinner(new int[]{2,1,3,5,4,6,7}, 2));
    }
}
