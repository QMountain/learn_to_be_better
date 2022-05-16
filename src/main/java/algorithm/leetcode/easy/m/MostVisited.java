package algorithm.leetcode.easy.m;

import java.util.ArrayList;
import java.util.List;

public class MostVisited {

    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> list = new ArrayList<>();
        int length = rounds.length;
        if (rounds[0] == rounds[length-1]) {
            list.add(rounds[0]);
            return list;
        }
        if (rounds[0] < rounds[length-1]) {
            for (int i = rounds[0]; i <= rounds[length - 1]; i++) {
                list.add(i);
            }
            return list;
        }
        for (int i = 1; i <= rounds[length-1]; i++) {
            list.add(i);
        }
        for (int i = rounds[0]; i <= n; i++) {
            list.add(i);
        }
        return list;
    }

}
