package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.HashMap;
import java.util.Scanner;

// 内存冷热标记
public class MemoryHotAndColdTags {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        HashMap<Integer, Integer> cnts = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            cnts.put(num, cnts.getOrDefault(num, 0) + 1);
        }

        int threshold = sc.nextInt();

        cnts.keySet().removeIf(num -> cnts.get(num) < threshold);

        System.out.println(cnts.size());

        cnts.entrySet().stream()
                .sorted(
                        (a, b) ->
                                a.getValue() - b.getValue() != 0
                                        ? b.getValue() - a.getValue()
                                        : a.getKey() - b.getKey())
                .forEach(a -> System.out.println(a.getKey()));
    }
}
