package algorithm.leetcode.easy;

import java.util.Map;
import java.util.TreeMap;

/**
 * tips: 差分数组
 */
public class MaximumPopulation {

    public int maximumPopulation2(int[][] logs) {
        Map<Integer,Integer> yearCountMap = new TreeMap<>();
        for (int[] log : logs) {
            int birth = log[0];
            int death = log[1];
            for (int i = birth; i < death; i++) {
                yearCountMap.put(i,yearCountMap.getOrDefault(i,0)+1);
            }
        }
        int year = 0;
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : yearCountMap.entrySet()) {
            Integer value = entry.getValue();
            if (value > max) {
                max = value;
                year = entry.getKey();
            }
        }
        return year;
    }

    public int maximumPopulation3(int[][] logs) {
        int minYear = logs[0][0];
        int maxYear = logs[0][1];
        for (int[] log : logs) {
            if (log[0] < minYear) {
                minYear = log[0];
            }
            if (log[1] > maxYear) {
                maxYear = log[1];
            }
        }
        int[] arr = new int[maxYear-minYear+1];
        for (int[] log : logs) {
            int birth = log[0];
            int death = log[1];
            for (int i = birth; i < death; i++) {
                arr[i-minYear]++;
            }
        }
        int maxIndex = 0;
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex+minYear;
    }

    public int maximumPopulation(int[][] logs) {
        int minYear = 1950;
        int[] arr = new int[101];
        for (int[] log : logs) {
            int birth = log[0];
            int death = log[1];
            for (int i = birth; i < death; i++) {
                arr[i-minYear]++;
            }
        }
        int maxIndex = 0;
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex+minYear;
    }

    public static void main(String[] args) {
        MaximumPopulation maximumPopulation = new MaximumPopulation();
        System.out.println(maximumPopulation.maximumPopulation(new int[][]{{1993,1999},{2000,2010}}));
    }
}
