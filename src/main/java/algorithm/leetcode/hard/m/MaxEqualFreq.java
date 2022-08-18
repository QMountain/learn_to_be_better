package algorithm.leetcode.hard.m;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MaxEqualFreq {

    public int maxEqualFreq(int[] nums) {
        Map<Integer,Integer> elementCountMap = new HashMap<>();
        for (int num : nums) {
            elementCountMap.put(num,elementCountMap.getOrDefault(num,0)+1);
        }
        int length = nums.length;
        if (check(elementCountMap)) {
            return length;
        }
        for (int i = length-1; i > 0; i--) {
            Integer oldV = elementCountMap.get(nums[i]);
            if (oldV == 1) {
                elementCountMap.remove(nums[i]);
            } else {
                elementCountMap.put(nums[i], oldV -1);
            }
            if (check(elementCountMap)) {
                return i;
            }
        }
        return 1;
    }

    public boolean check(Map<Integer,Integer> map) {
        ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        int size = entries.size();
        if (size == 1) {
            return true;
        }
        Integer value1 = entries.get(0).getValue();
        Integer value2 = entries.get(1).getValue();
        if (size == 2 && (value1 == 1 || value2 == 1)) {
            return true;
        }
        if (value1 == 1) {
            boolean allEqual = true;
            for (int i = 2; i < size; i++) {
                if (!Objects.equals(entries.get(i).getValue(), value2)) {
                    allEqual = false;
                    break;
                }
            }
            if (allEqual) {
                return true;
            }
        }
        if (value2 == 1) {
            boolean allEqual = true;
            for (int i = 2; i < size; i++) {
                if (!Objects.equals(entries.get(i).getValue(), value1)) {
                    allEqual = false;
                    break;
                }
            }
            if (allEqual) {
                return true;
            }
        }
        if (Objects.equals(value1, value2)) {
            for (int i = 2; i < size; i++) {
                Integer currValue = entries.get(i).getValue();
                if (!Objects.equals(currValue, value1)) {
                    if (currValue == value1 + 1 || currValue == 1) {
                        for (int j = i+1; j < size; j++) {
                            if (!Objects.equals(entries.get(j).getValue(), value1)) {
                                return false;
                            }
                        }
                        return true;
                    } else {
                        return false;
                    }
                }
            }
            return value1 == 1;
        } else if (value1 + 1 == value2) {
            for (int i = 2; i < size; i++) {
                if (!Objects.equals(entries.get(i).getValue(), value1)) {
                    return false;
                }
            }
            return true;
        } else if (value1 == value2 + 1) {
            for (int i = 2; i < size; i++) {
                if (!Objects.equals(entries.get(i).getValue(), value2)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MaxEqualFreq maxEqualFreq = new MaxEqualFreq();
        System.out.println(maxEqualFreq.maxEqualFreq(new int[]{1,1,1,2,2,2}));
        System.out.println(maxEqualFreq.maxEqualFreq(new int[]{1,1,2,3,3,4,4,5,30,31,38,48,99,13,57,29,59,85,36,95,94,19,55,36,17,49,11,61,23,89,49,36,5,86,39,26,28,12,45,34,45,19,34,92,47,74,75,97,19,14,33,98,46,66,98,3,93,95,30,24,77,20,64,32,45,91,41,28,95,7,36,2,92,42,90,96,53,57,26,70,15,54,51,28,46,82,66,68,89,43,90,36,44,51,40,29,98,16,34,90,11,100,2}));
        System.out.println(maxEqualFreq.maxEqualFreq(new int[]{1,2,3,4,5,6,7,8,9}));
        System.out.println(maxEqualFreq.maxEqualFreq(new int[]{1,2}));
        System.out.println(maxEqualFreq.maxEqualFreq(new int[]{10,2,8,9,3,8,1,5,2,3,7,6}));
        System.out.println(maxEqualFreq.maxEqualFreq(new int[]{1,1,1,2,2,2,3,3,3,4,4,4,5}));
        System.out.println(maxEqualFreq.maxEqualFreq(new int[]{2,2,1,1,5,3,3,5}));
    }
}
