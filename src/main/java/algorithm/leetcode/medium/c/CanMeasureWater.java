package algorithm.leetcode.medium.c;

import java.util.HashSet;
import java.util.Set;

public class CanMeasureWater {

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (targetCapacity > jug1Capacity+jug2Capacity) {
            return false;
        }
        if (targetCapacity == jug1Capacity+jug2Capacity) {
            return true;
        }
        if (targetCapacity == Math.abs(jug1Capacity-jug2Capacity)) {
            return true;
        }
        Set<Integer> total = new HashSet<>();
        total.add(jug1Capacity);
        total.add(jug2Capacity);
        Set<Integer> diffSet = new HashSet<>();
        diffSet.add(Math.abs(jug1Capacity-jug2Capacity));
        while (!diffSet.isEmpty()) {
            total.addAll(diffSet);
            Set<Integer> nSet = new HashSet<>();
            for (Integer diff : diffSet) {
                nSet.add(Math.abs(jug1Capacity-diff));
                nSet.add(Math.abs(jug2Capacity-diff));
            }
            nSet.removeAll(total);
            diffSet = nSet;
        }
        Set<Integer> possible = new HashSet<>();
        for (Integer integer : total) {
            possible.add(jug1Capacity+integer);
            possible.add(jug2Capacity+integer);
            possible.add(Math.abs(jug1Capacity-integer));
            possible.add(Math.abs(jug2Capacity-integer));
        }
        return possible.contains(targetCapacity);
    }

    public static void main(String[] args) {
        CanMeasureWater canMeasureWater = new CanMeasureWater();
        System.out.println(!canMeasureWater.canMeasureWater(2, 6, 5));
        System.out.println(canMeasureWater.canMeasureWater(3, 5, 4));
    }
}
