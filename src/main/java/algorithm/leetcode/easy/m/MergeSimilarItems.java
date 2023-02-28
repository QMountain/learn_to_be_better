package algorithm.leetcode.easy.m;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MergeSimilarItems {

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] ints : items1) {
            map.put(ints[0],map.getOrDefault(ints[0],0)+ints[1]);
        }
        for (int[] ints : items2) {
            map.put(ints[0],map.getOrDefault(ints[0],0)+ints[1]);
        }
        List<List<Integer>> ansList = new ArrayList<>(map.size());
        map.forEach((k,v) -> {
            List<Integer> list = new ArrayList<>();
            list.add(k);
            list.add(v);
            ansList.add(list);
        });
        return ansList;
    }

    public static void main(String[] args) {
        MergeSimilarItems mergeSimilarItems = new MergeSimilarItems();
        System.out.println(mergeSimilarItems.mergeSimilarItems(
                new int[][]{{1, 1}, {4, 5}, {3, 8}}, new int[][]{{3, 1}, {1, 5}}));
    }
}
