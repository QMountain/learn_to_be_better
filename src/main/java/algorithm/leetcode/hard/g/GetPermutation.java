package algorithm.leetcode.hard.g;

import java.util.ArrayList;
import java.util.List;

public class GetPermutation {

    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        StringBuilder sb = new StringBuilder();
        while (k > 1) {
            int count = 1;
            for (int i = 2; i < list.size(); i++) {
                count *= i;
            }
            int bs = k / count;
            if (k % count == 0) {
                if (bs - 1 < list.size() && bs-1 >= 0) {
                    sb.append(list.get(bs-1));
                    list.remove(bs-1);
                    if (k > count) {
                        k -= (bs-1) * count;
                    }
                } else {
                    break;
                }
            } else {
                sb.append(list.get(bs));
                list.remove(bs);
                k -= bs * count;
            }

        }
        for (Integer integer : list) {
            sb.append(integer);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        GetPermutation getPermutation = new GetPermutation();
        System.out.println("321".equals(getPermutation.getPermutation(3, 6)));
        System.out.println(getPermutation.getPermutation(3, 4));
        System.out.println("132".equals(getPermutation.getPermutation(3, 2)));
        System.out.println(getPermutation.getPermutation(3, 1));
        System.out.println(getPermutation.getPermutation(4, 9));
        System.out.println(getPermutation.getPermutation(3, 3));
    }
}
