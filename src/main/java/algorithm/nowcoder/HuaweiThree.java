package algorithm.nowcoder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HuaweiThree {

    public static int findBound(int m, int n, int[][] arr) {
        Set<Set<String>> coreSet = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 5) {
                    Set<String> bounds = new HashSet<>(8);
                    int coreMinX = 0;
                    int coreMaxX = 0;
                    int coreMinY = 0;
                    int coreMaxY = 0;
                    if (i >= 2) {
                        coreMinX = i-2;
                    }
                    if (i <= m-3) {
                        coreMaxX = i+2;
                    } else {
                        coreMaxX = m-1;
                    }
                    if (j >= 2) {
                        coreMinY = j-2;
                    }
                    if (j <= n-3) {
                        coreMaxY = j+2;
                    } else {
                        coreMaxY = n-1;
                    }
                    for (int k = coreMinX; k <= coreMaxX; k++) {
                        for (int l = coreMinY; l <= coreMaxY; l++) {
                            bounds.add(k+","+l);
                        }
                    }
                    coreSet.add(bounds);
                }
            }
        }
        List<Set<String>> coreList = new ArrayList<>(coreSet);
        int size = coreList.size();
        boolean hasDup = true;
        while (hasDup) {
            boolean has = false;
            for (int i = 0; i < size-1; i++) {
                for (int j = i+1; j < size; j++) {
                    Set<String> setI = coreList.get(i);
                    Set<String> setJ = coreList.get(j);
                    boolean jci = false;
                    for (String s : setI) {
                        if (setJ.contains(s)) {
                            has = true;
                            jci = true;
                            break;
                        }
                    }
                    if (!jci) {
                        for (String s : setJ) {
                            if (setI.contains(s)) {
                                has = true;
                                break;
                            }
                        }
                    }
                    if (has) {
                        setI.addAll(setJ);
                        setJ.addAll(setI);
                        break;
                    }
                }
                if (has) {
                    break;
                }
            }
            hasDup = !has;
        }
        Set<Integer> cut = new HashSet<>();
        for (int i = 0; i < size-1; i++) {
            if (!cut.contains(i)) {
                for (int j = i+1; j < size; j++) {
                    if (j != i && !cut.contains(j)) {
                        Set<String> setI = coreList.get(i);
                        Set<String> setJ = coreList.get(j);
                        if (setI.size() == setJ.size() && setI.containsAll(setJ)) {
                            cut.add(j);
                        }
                    }
                }
            }
        }
        return coreList.size()-cut.size();
    }

    public static void main(String[] args) {
        /*System.out.println(HuaweiThree.findBound(6, 6, new int[][]{{1, 1, 1, 1, 1, 1},
                {1, 5, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 5, 1},
                {1, 1, 1, 1, 1, 1,}}));*/
        System.out.println(HuaweiThree.findBound(6, 6, new int[][]{{1, 1, 1, 1, 1, 1},
                {1, 5, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 5,}}));
    }
}
