package algorithm.leetcode.easy.m;

public class MinNumberOfHours {

    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int lack = 0;
        for (int i = 0; i < energy.length; i++) {
            if (initialEnergy <= energy[i]) {
                lack += energy[i] - initialEnergy + 1;
                initialEnergy = 1;
            } else {
                initialEnergy -= energy[i];
            }
            if (initialExperience <= experience[i]) {
                lack += experience[i] - initialExperience + 1;
                initialExperience = experience[i] + 1;
            }
            initialExperience += experience[i];
        }
        return lack;
    }

    public static void main(String[] args) {
        MinNumberOfHours minNumberOfHours = new MinNumberOfHours();
        System.out.println(0 == minNumberOfHours.minNumberOfHours(2, 4,
                new int[]{1}, new int[]{3}));
        System.out.println(8 == minNumberOfHours.minNumberOfHours(5, 3, new int[]{1, 4, 3, 2}, new int[]{2, 6, 3, 1}));
    }
}
