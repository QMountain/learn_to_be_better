package algorithm.leetcode.medium.r;

import java.util.HashMap;
import java.util.Map;

public class RepairCars {

    public long repairCars(int[] ranks, int cars) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int minRank = ranks[0];
        int countMinRank = 0;
        for (int rank : ranks) {
            map.put(rank, map.getOrDefault(rank, 0) + 1);
            if (rank > minRank) {
                continue;
            }
            if (rank == minRank) {
                countMinRank++;
            } else {
                minRank = rank;
                countMinRank = 1;
            }
        }
        int carsPerson = cars/ countMinRank;
        if (cars % countMinRank != 0) {
            carsPerson++;
        }
        long minMinutes = 1L;
        long maxMinutes = (long) carsPerson * carsPerson * minRank;
        while (minMinutes < maxMinutes) {
            long mid = maxMinutes / 2 + (minMinutes / 2);
            if (minMinutes % 2 != 0 && maxMinutes % 2 != 0) {
                mid++;
            }
            int countCars = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                Integer personCount = entry.getValue();
                Integer rank = entry.getKey();
                countCars += personCount * (int)Math.sqrt((double) mid / rank);
            }
            if (countCars >= cars) {
                maxMinutes = mid;
            } else {
                if (minMinutes + 1 == maxMinutes) {
                    return maxMinutes;
                }
                minMinutes = mid;
            }
        }
        return maxMinutes;
    }

    public long repairCars2(int[] ranks, int cars) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long product = 1;
        long minRank = ranks[0];
        for (int rank : ranks) {
            map.put(rank, map.getOrDefault(rank, 0) + 1);
            product *= rank;
            minRank = Math.min(minRank, rank);
        }
        long fz = (long) cars * cars * product;
        double sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer rank = entry.getKey();
            sum += Math.sqrt((double) product / rank * entry.getValue());
        }
        double v = fz / (sum * sum);
        long minMinutes = (long) v;
        long maxMinutes = minRank * cars * cars;
        while (minMinutes < maxMinutes) {
            long minutes = minMinutes / 2 + (maxMinutes / 2);
            if (minMinutes % 2 != 0 && maxMinutes % 2 != 0) {
                minutes++;
            }
            int count = 0;
            for (int rank : ranks) {
                count += (int)Math.sqrt((double) minutes / rank);
            }
            if (count >= cars) {
                maxMinutes = minutes;
            } else {
                if (minutes > minMinutes) {
                    minMinutes = minutes;
                } else {
                    return maxMinutes;
                }
            }
        }
        return maxMinutes;
    }

    public static void main(String[] args) {
        RepairCars repairCars = new RepairCars();
        System.out.println(repairCars.repairCars(new int[]{1}, 100_0000));
        System.out.println(repairCars.repairCars(new int[]{5,1,8}, 6));
        System.out.println(repairCars.repairCars(new int[]{4,2,3,1}, 10));
    }
}
