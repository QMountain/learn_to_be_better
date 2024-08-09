package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringJoiner;

// 数组去重和排序
public class ArrayDeduplicationAndSorting {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(",");
        System.out.println(getResult(arr));
    }

    public static String getResult(String[] arr) {
        HashMap<String, Integer> count = new HashMap<>();
        HashMap<String, Integer> first = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            count.put(s, count.getOrDefault(s, 0) + 1);
            first.putIfAbsent(s, i);
        }

        StringJoiner sj = new StringJoiner(",");

        first.keySet().stream()
                .sorted(
                        (a, b) -> {
                            int countA = count.get(a);
                            int countB = count.get(b);

                            if (countA != countB) {
                                return countB - countA;
                            } else {
                                int firstA = first.get(a);
                                int firstB = first.get(b);
                                return firstA - firstB;
                            }
                        })
                .forEach(s -> sj.add(s));

        return sj.toString();
    }
}
