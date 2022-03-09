package algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static List<Integer> fun(int n, int k) {
        List<Integer> list = new ArrayList<>();
        if (n >= k) {
            list.add(k);
            return list;
        }
        list.add(n);
        list.addAll(fun(n-1,k-n));
        return list;
    }

    public static void main(String[] args) {
        System.out.println(Test.fun(5, 8));
    }
}
