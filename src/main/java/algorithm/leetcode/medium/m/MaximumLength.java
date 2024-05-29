package algorithm.leetcode.medium.m;

import java.util.PriorityQueue;

public class MaximumLength {

    // 3 <= s.length <= 50
    public int maximumLength(String s) {
        int ans = -1;
        PriorityQueue<Integer>[] arr = new PriorityQueue[26];
        int lastIndex = 0;
        for (int i = 1; i < s.length(); i++) {
            char startChar = s.charAt(lastIndex);
            char currChar = s.charAt(i);
            if (currChar != startChar || i == s.length() - 1) {
                PriorityQueue<Integer> queue = arr[startChar - 'a'];
                if (queue == null) {
                    queue = new PriorityQueue<>();
                    arr[startChar - 'a'] = queue;
                }
                int length = i - lastIndex;
                if (currChar == startChar && i == s.length() - 1) {
                    length++;
                }
                queue.add(length);
                lastIndex = i;
                if (currChar != startChar && i == s.length() - 1) {
                    PriorityQueue<Integer> queue2 = arr[currChar - 'a'];
                    if (queue2 == null) {
                        queue2 = new PriorityQueue<>();
                        arr[currChar - 'a'] = queue2;
                    }
                    queue2.add(1);
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            PriorityQueue<Integer> queue = arr[i];
            if (queue == null) {
                continue;
            }
            int len = 1;
            while (!queue.isEmpty()) {
                if (queue.peek() < len) {
                    queue.poll();
                } else {
                    int sum = 0;
                    for (Integer count : queue) {
                        sum += count - len + 1;
                    }
                    if (sum >= 3) {
                        ans = Math.max(ans, len);
                    }
                    len++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumLength maximumLength = new MaximumLength();
        System.out.println(1 == maximumLength.maximumLength("abcaba"));
        System.out.println(-1 == maximumLength.maximumLength("abcdef"));
        System.out.println(2 == maximumLength.maximumLength("aaaa"));
    }
}
