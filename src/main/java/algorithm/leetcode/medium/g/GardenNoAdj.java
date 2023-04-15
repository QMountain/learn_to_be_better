package algorithm.leetcode.medium.g;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class GardenNoAdj {

    public int[] gardenNoAdj(int n, int[][] paths) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int[] path : paths) {
            HashSet<Integer> set = map.get(path[0]);
            if (set == null) {
                set = new HashSet<>();
            }
            set.add(path[1]);
            map.put(path[0], set);

            HashSet<Integer> set2 = map.get(path[1]);
            if (set2 == null) {
                set2 = new HashSet<>();
            }
            set2.add(path[0]);
            map.put(path[1], set2);
        }
        int[][] colorArray = new int[n][4];
        for (Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
            // i 是花园号
            Integer i = entry.getKey();
            // j 是 i号花园 花色列表
            for (int j = 0; j < n; j++) {
                // 第一个可用花色，找到即上色
                if (colorArray[i-1][j] == 0) {
                    colorArray[i-1][j] = 1;
                    // 其他关联花园不可用当前花色
                    HashSet<Integer> set = map.get(i);
                    for (Integer index : set) {
                       colorArray[index-1][j] = -1;
                    }
                    break;
                }
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < colorArray.length; i++) {
            if (!map.containsKey(i+1)) {
                ans[i] = 1;
                continue;
            }
            int[] ca = colorArray[i];
            for (int j = 0; j < 4; j++) {
                if (ca[j] == 1) {
                    ans[i] = j+1;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        GardenNoAdj gardenNoAdj = new GardenNoAdj();
        System.out.println(Arrays.toString(gardenNoAdj.gardenNoAdj(10000, new int[][]{})));
        System.out.println(Arrays.toString(gardenNoAdj.gardenNoAdj(4, new int[][]{{1,2},{2,3},{3,4},{4,1},{1,3},{2,4}})));
        System.out.println(Arrays.toString(gardenNoAdj.gardenNoAdj(4, new int[][]{{1,2},{3,4}})));
        System.out.println(Arrays.toString(gardenNoAdj.gardenNoAdj(3, new int[][]{{1,2},{2,3},{3,1}})));
    }
}
