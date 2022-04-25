package algorithm.leetcode.easy.h;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HasGroupsSizeX {

    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : deck) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        int size = entries.size();
        for (int i = 0; i < size - 1; i++) {
            if (!Objects.equals(entries.get(i).getValue(), entries.get(i + 1).getValue())) {
                return false;
            }
        }
        return entries.get(0).getValue() >= 2;
    }

}
