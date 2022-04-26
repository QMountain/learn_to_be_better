package algorithm.leetcode.medium.m;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] > o2[0]) {
                return 1;
            } else if (o1[0] < o2[0]) {
                return -1;
            }
            return 0;
        });
        List<int[]> list = Arrays.asList(intervals);
        while (true) {
            List<int[]> nList = new ArrayList<>(list.size()-1);
            int size = list.size();
            boolean combined = false;
            for (int i = 0; i < size; i++) {
                if (i == size-1) {
                    nList.add(list.get(i));
                    break;
                }
                int[] ints1 = list.get(i);
                int[] ints2 = list.get(i+1);
                if (ints1[1] >= ints2[0]) {
                    int[] nInt = new int[2];
                    nInt[0] = ints1[0];
                    nInt[1] = Math.max(ints1[1],ints2[1]);
                    nList.add(nInt);
                    i++;
                    combined = true;
                } else {
                    nList.add(ints1);
                }

            }
            list = nList;
            if (!combined) {
                break;
            }
        }

        int[][] resArr = new int[list.size()][2];
        int size = list.size();
        for (int i = 0; i < size; i++) {
            resArr[i] = list.get(i);
        }
        return resArr;
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        System.out.println(Arrays.deepToString(merge.merge(new int[][]{{1,4},{2,3}})));
        System.out.println(Arrays.deepToString(merge.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}})));
    }
}
