package algorithm.leetcode.medium.c;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        return combine(k,n,1);
    }

    public List<List<Integer>> combine(int k, int n, int from) {
        List<List<Integer>> ansList = new ArrayList<>();
        if (k == 1) {
            if (from <= n && n <= 9) {
                List<Integer> list = new ArrayList<>();
                list.add(n);
                ansList.add(list);
                return ansList;
            }
            return null;
        }
        for (int i = from; i <= 9 && i <= n; i++) {
            List<List<Integer>> combine = combine(k - 1, n - i, i+1);
            if (combine != null) {
                if (!combine.isEmpty()) {
                    for (List<Integer> list : combine) {
                        list.add(0,i);
                    }
                    ansList.addAll(combine);
                }
            }
        }
        return ansList;
    }

    public static void main(String[] args) {
        CombinationSum3 combinationSum3 = new CombinationSum3();
        System.out.println(combinationSum3.combinationSum3(3, 15));
        System.out.println(combinationSum3.combinationSum3(4, 1));
        System.out.println(combinationSum3.combinationSum3(3, 9));
        System.out.println(combinationSum3.combinationSum3(3, 7));
    }
}
