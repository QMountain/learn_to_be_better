package algorithm.nowcoder.huawei.hard;

import java.util.Scanner;
import java.util.TreeSet;

public class HJ3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(in.nextInt());
        }
        while (!set.isEmpty()) {
            System.out.println(set.pollFirst());
        }
    }
}
