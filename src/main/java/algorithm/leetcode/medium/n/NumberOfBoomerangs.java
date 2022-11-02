package algorithm.leetcode.medium.n;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class NumberOfBoomerangs {

    public int numberOfBoomerangs(int[][] points) {
        int length = points.length;
        List<Map<Integer,Integer>> list = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            list.add(new HashMap<>());
        }
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                int distance = calDistance(points[i],points[j]);
                Map<Integer, Integer> map1 = list.get(i);
                map1.put(distance,map1.getOrDefault(distance,0)+1);
                Map<Integer, Integer> map2 = list.get(j);
                map2.put(distance,map2.getOrDefault(distance,0)+1);
            }
        }
        AtomicInteger ans = new AtomicInteger();
        for (int i = 0; i < length; i++) {
            Map<Integer, Integer> map = list.get(i);
            map.forEach((k,v)->{
                ans.addAndGet(v * (v - 1));
            });
        }
        return ans.get();
    }

    public int calDistance(int[] p1, int[] p2) {
        int absX = Math.abs(p1[0] - p2[0]);
        int absY = Math.abs(p1[1] - p2[1]);
        return absX*absX+(absY*absY);
    }

    public static void main(String[] args) {
        NumberOfBoomerangs numberOfBoomerangs = new NumberOfBoomerangs();
        System.out.println(0 == numberOfBoomerangs.numberOfBoomerangs(new int[][]{{1,1}}));
        System.out.println(2 == numberOfBoomerangs.numberOfBoomerangs(new int[][]{{1,1},{2,2},{3,3}}));
        System.out.println(2 == numberOfBoomerangs.numberOfBoomerangs(new int[][]{{0,0},{1,0},{2,0}}));
    }
}
