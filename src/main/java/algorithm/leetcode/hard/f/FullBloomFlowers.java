package algorithm.leetcode.hard.f;

import java.util.*;

public class FullBloomFlowers {

    LinkedList<int[]> flowerList;
    TreeMap<Integer, Integer> peopleMap;

    // 1 <= flowers.length <= 5 * 10^4
    // 1 <= people.length <= 5 * 10^4
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        peopleMap = new TreeMap<>();
        for (int person : people) {
            peopleMap.put(person, 0);
        }
        ArrayList<Integer> timeList = new ArrayList<>(peopleMap.keySet());
        for (int[] flower : flowers) {
            if (timeList.size() == 1) {
                Integer key = timeList.get(0);
                if (flower[0] <= key && key <= flower[1]) {
                    peopleMap.put(key, peopleMap.getOrDefault(key, 0)+1);
                }
                continue;
            }
            int left = 0;
            int right = timeList.size()-1;
            Integer minTime = timeList.get(left);
            if (flower[1] < minTime) {
                continue;
            }
            if (flower[1] == minTime) {
                peopleMap.put(minTime, peopleMap.getOrDefault(minTime, 0)+1);
                continue;
            }
            Integer maxTime = timeList.get(right);
            if (flower[0] > maxTime) {
                continue;
            }
            if (flower[0] == maxTime) {
                peopleMap.put(maxTime, peopleMap.getOrDefault(maxTime, 0)+1);
                continue;
            }
            if (flower[0] == flower[1]) {
                if (peopleMap.containsKey(flower[0])) {
                    peopleMap.put(flower[0], peopleMap.getOrDefault(flower[0], 1)+1);
                }
                continue;
            }
            while (left < right) {
                int mid = (left + right) / 2;
                Integer time = timeList.get(mid);
                if (flower[0] <= time && time <= flower[1]) {
                    left = mid;
                    break;
                } else if (flower[1] < time) {
                    right = mid;
                } else {
                    if (left == mid) {
                        if (flower[0] <= timeList.get(right) && timeList.get(right) <= flower[1]) {
                            left = right;
                        } else {
                            left = -1;
                        }
                        break;
                    } else {
                        left = mid;
                    }
                }
            }
            if (left == -1) {
                continue;
            }
            Integer time = timeList.get(left);
            peopleMap.put(time, peopleMap.getOrDefault(time, 0)+1);
            int preKey = time;
            while (preKey > peopleMap.firstKey()) {
                preKey = peopleMap.lowerKey(preKey);
                if (flower[0] <= preKey && preKey <= flower[1]) {
                    peopleMap.put(preKey, peopleMap.getOrDefault(preKey, 0)+1);
                } else {
                    break;
                }
            }
            int nextKey = time;
            while (nextKey < peopleMap.lastKey()) {
                nextKey = peopleMap.higherKey(nextKey);
                if (flower[0] <= nextKey && nextKey <= flower[1]) {
                    peopleMap.put(nextKey, peopleMap.getOrDefault(nextKey, 0)+1);
                } else {
                    break;
                }
            }
        }
        int length = people.length;
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            ans[i] = peopleMap.get(people[i]);
        }
        return ans;
    }

    public void addToList(int[] flower) {
        if (flower[1] < peopleMap.firstKey()) {
            return;
        }
        if (flower[0] > peopleMap.lastKey()) {
            return;
        }
        if (flower[0] < peopleMap.firstKey()) {
            flower[0] = peopleMap.firstKey();
        }
        if (flower[1] > peopleMap.lastKey()) {
            flower[1] = peopleMap.lastKey();
        }
        if (flowerList.isEmpty()) {
            flowerList.add(new int[]{flower[0], flower[1], 1});
            return;
        }
        if (flower[0] > flowerList.peekLast()[1]) {
            flowerList.addLast(new int[]{flower[0], flower[1], 1});
            return;
        }
        if (flower[1] < flowerList.peekFirst()[0]) {
            flowerList.add(0, new int[]{flower[0], flower[1], 1});
            return;
        }
        int overlapIndex = 0;
        if (flowerList.size() > 1) {
            overlapIndex = binarySearch(flower[0]);
        }
        handleWithIndex(flower, overlapIndex);
    }

    public void handleWithIndex(int[] flower, int insertIndex) {
        if (insertIndex == flowerList.size()) {
            flowerList.addLast(new int[]{flower[0], flower[1], 1});
            return;
        }
        int[] segment = flowerList.get(insertIndex);
        // 完全在目标区间左侧
        if (flower[1] < segment[0]) {
            flowerList.add(insertIndex, new int[]{flower[0], flower[1], 1});
            return;
        }
        // 左侧部分溢出
        if (flower[0] < segment[0]) {
            flowerList.add(insertIndex++, new int[]{flower[0], segment[0]-1, 1});
            handleWithIndex(new int[]{segment[0], flower[1]}, insertIndex);
            return;
        }
        // 到此 flower[0] >= segment[0] && flower[0] <= segment[1]
        if (flower[0] > segment[0]) {
            flowerList.add(insertIndex++, new int[]{segment[0], flower[0]-1, segment[2]});
            segment[0] = flower[0];
        }
        // 到此 flower[0] == segment[0]
        if (segment[0] == segment[1]) {
            segment[2]++;
            if (flower[0] < flower[1]) {
                handleWithIndex(new int[]{flower[0]+1, flower[1]}, insertIndex+1);
            }
            return;
        }
        // 到此 segment[0] < segment[1]
        if (flower[1] == segment[1]) {
            segment[2]++;
            return;
        }
        if (flower[1] < segment[1]) {
            int segmentOldEnd = segment[1];
            segment[1] = flower[1];
            segment[2]++;
            flowerList.add(insertIndex+1,
                    new int[]{flower[1]+1, segmentOldEnd, segment[2]-1});
            return;
        }
        segment[2]++;
        if (insertIndex+1 == flowerList.size()) {
            flowerList.addLast(new int[]{segment[1]+1, flower[1], 1});
            return;
        }
        handleWithIndex(new int[]{segment[1]+1, flower[1]}, insertIndex+1);
    }

    public int binarySearchLeftBound(int target, ArrayList<Integer> keyList) {
        if (target < keyList.get(0)) {
            return 0;
        }
        int left = 0;
        int right = keyList.size() - 1;
        if (target > keyList.get(right)) {
            return -1;
        }
        while (left < right) {
            int mid = (left + right) / 2;
            Integer key = keyList.get(mid);
            if (target == key) {
                return mid;
            }
            if (target < key) {
                right = mid;
            } else {
                if (left == mid) {
                    return right;
                }
                left = mid;
            }
        }
        return left;
    }

    public int binarySearchRightBound(int target, ArrayList<Integer> keyList) {
        if (target < keyList.get(0)) {
            return -1;
        }
        int left = 0;
        int right = keyList.size() - 1;
        if (target > keyList.get(right)) {
            return right;
        }
        while (left < right) {
            int mid = (left + right) / 2;
            Integer key = keyList.get(mid);
            if (target == key) {
                return mid;
            }
            if (target < key) {
                right = mid;
            } else {
                if (left == mid) {
                    if (target > keyList.get(right)) {
                        return right;
                    }
                    return left;
                }
                left = mid;
            }
        }
        return left;
    }

    public int binarySearch(int target) {
        int left = 0;
        int right = flowerList.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int[] segment = flowerList.get(mid);
            int start = segment[0];
            int end = segment[1];
            if (start <= target && target <= end) {
                return mid;
            }
            if (target > end) {
                if (left == mid) {
                    return right;
                } else {
                    left = mid;
                }
            } else {
                right = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        FullBloomFlowers fullBloomFlowers = new FullBloomFlowers();
        System.out.println(Arrays.toString(fullBloomFlowers.fullBloomFlowers(
                new int[][]{{27,46},{48,48},{47,49},{14,48},{24,38},{43,43},{7,15},
                        {23,25},{18,42},{9,34},{32,33},{10,37},{41,44},{10,27},{6,10},
                        {49,50},{15,47},{48,49},{25,43},{27,28},{35,47},{5,13},{5,17},
                        {39,39},{3,3},{40,40},{8,39},{39,47},{33,46},{9,37},{3,29},
                        {45,47},{19,46},{18,50},{28,31},{6,38},{1,35},{38,40},
                        {37,50},{3,25},{6,10},{45,47},{29,34},{35,47},{36,45},
                        {25,34},{24,36},{18,32},{14,47},{36,40},{49,49},{45,45},
                        {4,20},{34,38},{14,46},{2,17},{47,48},{50,50},{42,47},{9,31},
                        {47,48},{42,48},{21,23},{38,38}}
                , new int[]{33,43,7,2,24,1,26,7,11,12,40,42,6,6,17,20,22,
                        13,18,31,28,46,50,47,12,26,16,45,21,2,32,30,43,12,49,49,
                        19,14,22,31,31,35,20})));
        System.out.println(Arrays.toString(fullBloomFlowers.fullBloomFlowers(
                new int[][]{{19,37},{19,38},{19,35}}, new int[]{6,7,21,1,13,37,5,37,46,43})));

        System.out.println(Arrays.toString(fullBloomFlowers.fullBloomFlowers(
                new int[][]{{11,11},{24,46},{3,25},{44,46}},
                new int[]{1,8,26,7,43,26,1})).equals("[0, 1, 1, 1, 1, 1, 0]"));
        System.out.println(Arrays.toString(fullBloomFlowers.fullBloomFlowers(
                new int[][]{{1,6},{3,7},{9,12},{4,13}},
                new int[]{2,3,7,11})).equals("[1, 2, 2, 2]"));
        System.out.println(Arrays.toString(fullBloomFlowers.fullBloomFlowers(
                new int[][]{{1, 10}, {3, 3}}, new int[]{3, 3, 2})).equals("[2, 2, 1]"));

        System.out.println(Arrays.toString(fullBloomFlowers.fullBloomFlowers(
                new int[][]{{29,46},{8,32},{16,36},{49,49},{42,43}}, new int[]{31})));

        System.out.println(Arrays.toString(fullBloomFlowers.fullBloomFlowers(
                new int[][]{{2,8},{31,37}}, new int[]{33,47,45,12})).equals("[1, 0, 0, 0]"));



    }
}
