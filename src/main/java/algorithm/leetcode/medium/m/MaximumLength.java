package algorithm.leetcode.medium.m;

import java.util.PriorityQueue;

public class MaximumLength {

    // 题号 2981 找出出现至少三次的最长特殊子字符串 I
    // 3 <= s.length <= 50
    public int maximumLength2(String s) {
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

    // 题号 2982. 找出出现至少三次的最长特殊子字符串 II
    // 3 <= s.length <= 5 * 10^5
    public int maximumLength(String s) {
        int ans = -1;
        int[][] arr = new int[26][3];
        int lastIndex = 0;
        for (int i = 1; i < s.length(); i++) {
            char lastChar = s.charAt(lastIndex);
            char currChar = s.charAt(i);
            if (currChar != lastChar) {
                int len = i - lastIndex;
                if (len >= arr[lastChar - 'a'][0]) {
                    arr[lastChar - 'a'][2] = arr[lastChar - 'a'][1];
                    arr[lastChar - 'a'][1] = arr[lastChar - 'a'][0];
                    arr[lastChar - 'a'][0] = len;
                } else if (len >= arr[lastChar - 'a'][1]) {
                    arr[lastChar - 'a'][2] = arr[lastChar - 'a'][1];
                    arr[lastChar - 'a'][1] = len;
                } else if (len >= arr[lastChar - 'a'][2]) {
                    arr[lastChar - 'a'][2] = len;
                }
                lastIndex = i;
            }
            if (i == s.length() - 1) {
                int index = currChar - 'a';
                int len;
                if (currChar != lastChar) {
                    len = 1;
                } else {
                   len = s.length() - lastIndex;
                }
                if (len >= arr[index][0]) {
                    arr[index][2] = arr[index][1];
                    arr[index][1] = arr[index][0];
                    arr[index][0] = len;
                } else if (len >= arr[index][1]) {
                    arr[index][2] = arr[index][1];
                    arr[index][1] = len;
                } else if (len >= arr[index][2]) {
                    arr[index][2] = len;
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i][0] > 2) {
                ans = Math.max(ans, arr[i][0] - 2);
            }
            if (arr[i][0] + arr[i][1] >= 3 && arr[i][1] > 0) {
                ans = Math.max(ans, Math.min(arr[i][0]-1, arr[i][1]));
            }
            if (arr[i][2] > 0) {
                ans = Math.max(ans, arr[i][2]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumLength maximumLength = new MaximumLength();
        System.out.println(-1 == maximumLength.maximumLength("jicja"));
        System.out.println(1 == maximumLength.maximumLength("abcaba"));
        System.out.println(-1 == maximumLength.maximumLength("abcdef"));
        System.out.println(2 == maximumLength.maximumLength("aaaa"));
    }
}
