package algorithm.leetcode.medium.c;

import java.util.ArrayList;
import java.util.List;

public class Combine {

    int n;

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ansList = new ArrayList<>();
        for (int i = 1; i <= 2<<n; i++) {
            if (Integer.toBinaryString(i).length() > n) {
                break;
            }
            int count = Integer.bitCount(i);
            if (count == k) {
                StringBuilder s = new StringBuilder(Integer.toBinaryString(i));
                int length = s.length();
                if (length < n) {
                    for (int j = 0; j < n - length; j++) {
                        s.insert(0, "0");
                    }
                }
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    if (s.charAt(j) == '1') {
                        list.add(j+1);
                    }
                }
                ansList.add(list);
            }
        }
        return ansList;
    }

    public List<List<Integer>> combine2(int n, int k) {
        this.n = n;
        List<List<Integer>> ansList = new ArrayList<>();
        for (int j = 1; j <= n - k+1; j++) {
            List<Integer> list = new ArrayList<>();
            list.add(j);
            ansList.add(list);
        }
        for (int i = 0; i < k-1; i++) {
            ansList = add(ansList);
        }
        return ansList;
    }

    public List<List<Integer>> add(List<List<Integer>> list) {
        List<List<Integer>> ansList = new ArrayList<>();
        for (List<Integer> nums : list) {
            Integer last = nums.get(nums.size() - 1);
            for (int i = last+1; i <= n; i++) {
                List<Integer> nl = new ArrayList<>(nums);
                nl.add(i);
                ansList.add(nl);
            }
        }
        return ansList;
    }

    public static void main(String[] args) {
        Combine combine = new Combine();
        System.out.println(combine.combine(1, 1));
        System.out.println(combine.combine(4, 2));
    }
}
