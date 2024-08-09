package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

// 连续字母长度
public class ContinuousLetterLength {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        System.out.println(getResult(s, k));
    }

    public static int getResult(String s, int k) {
        if (k <= 0) return -1;

        s += "0";

        HashMap<Character, Integer> count = new HashMap<>();

        char b = s.charAt(0);
        int len = 1;

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);

            if (b == c) {
                len++;
            } else {
                if (!count.containsKey(b) || count.get(b) < len) {
                    count.put(b, len);
                }
                len = 1;
                b = c;
            }
        }

        Integer[] arr = count.values().toArray(new Integer[0]);

        if (k > arr.length) return -1;
        else {
            Arrays.sort(arr, (x, y) -> y - x);
            return arr[k - 1];
        }
    }
}
