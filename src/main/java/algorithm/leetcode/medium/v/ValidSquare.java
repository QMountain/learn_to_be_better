package algorithm.leetcode.medium.v;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ValidSquare {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Map<Integer,Integer> map = new HashMap<>();
        int p1p2Length = getLength(p1,p2);
        map.put(p1p2Length,map.getOrDefault(p1p2Length,0)+1);
        int p1p3Length = getLength(p1,p3);
        map.put(p1p3Length,map.getOrDefault(p1p3Length,0)+1);
        int p1p4Length = getLength(p1,p4);
        map.put(p1p4Length,map.getOrDefault(p1p4Length,0)+1);
        int p3p4Length = getLength(p3,p4);
        map.put(p3p4Length,map.getOrDefault(p3p4Length,0)+1);
        int p2p3Length = getLength(p2, p3);
        map.put(p2p3Length,map.getOrDefault(p2p3Length,0)+1);
        int p2p4Length = getLength(p2, p4);
        map.put(p2p4Length,map.getOrDefault(p2p4Length,0)+1);
        if (map.containsKey(0) || map.size() != 2) {
            return false;
        }
        ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        Map.Entry<Integer, Integer> entry1 = entries.get(0);
        Integer key1 = entry1.getKey();
        Integer value1 = entry1.getValue();
        Map.Entry<Integer, Integer> entry2 = entries.get(1);
        Integer key2 = entry2.getKey();
        Integer value2 = entry2.getValue();
        if (value1 == 2 && value2 == 4) {
            return key1 == key2 * 2;
        }
        if (value1 == 4 && value2 == 2) {
            return key2 == key1*2;
        }
        return false;
    }

    public int getLength(int[] point1, int[] point2) {
        int p1p2X = Math.abs(point1[0] - point2[0]);
        int p1p2Y = Math.abs(point1[1] - point2[1]);
        return p1p2X*p1p2X+p1p2Y*p1p2Y;
    }

    public static void main(String[] args) {
        ValidSquare validSquare = new ValidSquare();
        System.out.println(validSquare.validSquare(new int[]{0, 0},
                new int[]{0, 1},
                new int[]{1, 1},
                new int[]{1, 0}));
        System.out.println(validSquare.validSquare(new int[]{0, 0},
                new int[]{-1, 1},
                new int[]{0, 1},
                new int[]{1, 0}));
    }
}
