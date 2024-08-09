package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringJoiner;

// 找朋友
public class FindFriends {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println(getResult(arr));
    }

    public static String getResult(int[] arr) {
        LinkedList<int[]> stack = new LinkedList<>();

        int len = arr.length;
        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            int ele = arr[i];

            while (true) {
                if (stack.size() == 0) {
                    stack.add(new int[] {ele, i});
                    break;
                }

                int[] peek = stack.getLast();
                int peekEle = peek[0];
                int peekIndex = peek[1];

                if (ele > peekEle) {
                    res[peekIndex] = i;
                    stack.removeLast();
                } else {
                    stack.add(new int[] {ele, i});
                    break;
                }
            }
        }

        StringJoiner sj = new StringJoiner(" ");
        for (int v : res) {
            sj.add(v + "");
        }

        return sj.toString();
    }
}
