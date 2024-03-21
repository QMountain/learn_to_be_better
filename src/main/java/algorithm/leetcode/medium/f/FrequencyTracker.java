package algorithm.leetcode.medium.f;

import java.util.HashMap;
import java.util.Map;

public class FrequencyTracker {

    Map<Integer, Integer> numMap;
    Map<Integer, Integer> frequencyMap;

    public FrequencyTracker() {
        numMap = new HashMap<>();
        frequencyMap = new HashMap<>();
    }

    public void add(int number) {
        Integer oldShowTimes = numMap.getOrDefault(number, 0);
        int newShowTimes = oldShowTimes + 1;
        numMap.put(number, newShowTimes);
        Integer oldNumCount = frequencyMap.getOrDefault(oldShowTimes, 0);
        if (oldNumCount > 0) {
            frequencyMap.put(oldShowTimes, oldNumCount - 1);
        }
        frequencyMap.put(newShowTimes, frequencyMap.getOrDefault(newShowTimes, 0) + 1);
    }

    public void deleteOne(int number) {
        if (numMap.getOrDefault(number, 0) > 0) {
            Integer oldShowTimes = numMap.get(number);
            int newShowTimes = oldShowTimes - 1;
            numMap.put(number, oldShowTimes - 1);

            Integer oldNumCount = frequencyMap.get(oldShowTimes);
            frequencyMap.put(oldShowTimes, oldNumCount - 1);
            frequencyMap.put(newShowTimes, frequencyMap.getOrDefault(newShowTimes, 0) + 1);
        }
    }

    public boolean hasFrequency(int frequency) {
        return frequencyMap.getOrDefault(frequency, 0) > 0;
    }

    public static void main(String[] args) {
        FrequencyTracker frequencyTracker3 = new FrequencyTracker();
        System.out.println(frequencyTracker3.hasFrequency(2));
        frequencyTracker3.add(3);
        System.out.println(frequencyTracker3.hasFrequency(1));

        FrequencyTracker frequencyTracker = new FrequencyTracker();
        frequencyTracker.add(3);
        frequencyTracker.add(3);
        System.out.println(frequencyTracker.hasFrequency(2));

        FrequencyTracker frequencyTracker2 = new FrequencyTracker();
        frequencyTracker2.add(1);
        frequencyTracker2.deleteOne(1);
        System.out.println(frequencyTracker2.hasFrequency(1));
    }
}
