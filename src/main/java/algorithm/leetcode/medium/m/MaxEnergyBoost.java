package algorithm.leetcode.medium.m;

public class MaxEnergyBoost {

    // n == energyDrinkA.length == energyDrinkB.length
    // 3 <= n <= 10^5
    // 1 <= energyDrinkA[i], energyDrinkB[i] <= 10^5
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int length = energyDrinkA.length;
        long m1 = energyDrinkA[0];
        long m2 = energyDrinkB[0];
        long n1 = energyDrinkA[1] + m1;
        long n2 = energyDrinkB[1] + m2;
        for (int i = 2; i < length; i++) {
            long next1 = Math.max(m2, n1) + energyDrinkA[i];
            long next2 = Math.max(m1, n2) + energyDrinkB[i];
            m1 = n1;
            m2 = n2;
            n1 = next1;
            n2 = next2;
        }
        return Math.max(n1, n2);
    }

    public static void main(String[] args) {
        MaxEnergyBoost maxEnergyBoost = new MaxEnergyBoost();
        System.out.println(7 == maxEnergyBoost.maxEnergyBoost(
                new int[]{4,1,1}, new int[]{1,1,3}));
        System.out.println(5 == maxEnergyBoost.maxEnergyBoost(
                new int[]{1,3,1}, new int[]{3,1,1}));
    }
}
