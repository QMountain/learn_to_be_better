package algorithm.leetcode.medium.m;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumTotal {

    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> lastRowDP = triangle.get(0);
        int size = triangle.size();
        for (int i = 1; i < size; i++) {
            List<Integer> list = triangle.get(i);
            int size1 = list.size();
            List<Integer> currRowDP = new ArrayList<>();
            for (int j = 0; j < size1; j++) {
                int min = Integer.MAX_VALUE;
                if (j < lastRowDP.size()) {
                    min = lastRowDP.get(j);
                }
                if (j > 0) {
                    min = Math.min(min,lastRowDP.get(j-1));
                }
                currRowDP.add(min+list.get(j));
            }
            lastRowDP = currRowDP;
        }
        int fs = lastRowDP.size();
        int min = lastRowDP.get(0);
        for (int i = 1; i < fs; i++) {
            min = Math.min(min,lastRowDP.get(i));
        }
        return min;
    }

    public static void main(String[] args) {
        MinimumTotal minimumTotal = new MinimumTotal();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = Collections.singletonList(2);
        list.add(list1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        list.add(list2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        list.add(list3);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        list.add(list4);
        System.out.println(minimumTotal.minimumTotal(list));
    }
}
