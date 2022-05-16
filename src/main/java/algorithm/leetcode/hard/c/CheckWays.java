package algorithm.leetcode.hard.c;

import java.util.*;

/**
 * @ClassName CheckWays
 * @Description
 * @Author qsf
 * Date   2022-02-16  16:56
 */
public class CheckWays {

    public int checkWays(int[][] pairs) {
        int count = 0;

        HashMap<Integer, Integer> numberCountMap = new HashMap<>(pairs.length*2);
        Set<int[]> pairSet = new HashSet<>(pairs.length);
        for (int[] pair : pairs) {
            pairSet.add(pair);
            for (int i : pair) {
                numberCountMap.put(i,numberCountMap.getOrDefault(i,0) + 1);
            }
        }

        HashMap<Integer, Integer> possibleRootMap = new HashMap<>(pairs.length/2);
        numberCountMap.forEach((number,currentCount) -> {
            List<Integer> keys = new ArrayList<>(possibleRootMap.keySet());
            int currentMaxCount = keys.isEmpty() ? 0 : possibleRootMap.get(keys.get(0));
            if (currentCount > currentMaxCount) {
                possibleRootMap.clear();
                possibleRootMap.put(number,currentCount);
            } else if (currentCount == currentMaxCount) {
                possibleRootMap.put(number,currentCount);
            }
        });

        for (Map.Entry<Integer, Integer> entry : possibleRootMap.entrySet()) {
            Set<int[]> copyPairSet = new HashSet<>(pairSet);
            int ways = getWays(entry.getKey(), copyPairSet);
            if (ways >= 2) {
                return 2;
            }
            count += ways;
            if (count >= 2) {
                return 2;
            }
        }

        return count;
    }

    public int getWays(int root, Set<int[]> copyPairSet) {
        Set<int[]> originalSet = new HashSet<>(copyPairSet);
        copyPairSet.removeIf(ints -> ints[0] == root || ints[1] == root);
        if (copyPairSet.isEmpty()) {
            return 1;
        }
        boolean allLeftCanReach = true;
        for (int[] ints : copyPairSet) {
            int x = ints[0];
            int y = ints[1];
            boolean canReachX = false;
            boolean canReachY = false;
            for (int[] originalPair : originalSet) {
                if ((originalPair[0] == root && originalPair[1] == x) || (originalPair[1] == root && originalPair[0] == x)) {
                    canReachX = true;
                }
                if ((originalPair[0] == root && originalPair[1] == y) || (originalPair[1] == root && originalPair[0] == y)) {
                    canReachY = true;
                }
                if (canReachX && canReachY) {
                    break;
                }
            }
            if (!(canReachX && canReachY)) {
                allLeftCanReach = false;
                break;
            }
        }

        if (!allLeftCanReach) {
            return 0;
        }
        int[][] newPairs = new int[copyPairSet.size()][2];
        List<int[]> copyPairList = new ArrayList<>(copyPairSet);
        for (int i = 0; i < copyPairList.size(); i++) {
            newPairs[i] = copyPairList.get(i);
        }
        int i = checkWays(newPairs);
        return i == 0 ? 2 : i;
        /*boolean hasRepeat = false;
        Set<Integer> set = new HashSet<>(copyPairSet.size()*2);
        for (int[] ints : copyPairSet) {
            if (!set.add(ints[0])) {
                hasRepeat = true;
                break;
            }
            if (!set.add(ints[1])) {
                hasRepeat = true;
                break;
            }
        }
        if (hasRepeat) {
            int[][] newPairs = new int[copyPairSet.size()][2];
            List<int[]> copyPairList = new ArrayList<>(copyPairSet);
            for (int i = 0; i < copyPairList.size(); i++) {
                newPairs[i] = copyPairList.get(i);
            }

            return allLeftCanReach ? checkWays(newPairs) : 0;
        }
        return allLeftCanReach ? 2 : 0;*/

    }

    public static void main(String[] args) {
        CheckWays checkWays = new CheckWays();
        /*System.out.println(1 == checkWays.checkWays(new int[][]{{1, 2}, {2, 3}}));
        System.out.println(2 == checkWays.checkWays(new int[][]{{1, 2}, {2, 3},{1, 3}}));
        System.out.println(0 == checkWays.checkWays(new int[][]{{1, 2}, {2, 3},{2, 4},{1, 5}}));
        System.out.println(1 == checkWays.checkWays(new int[][]{{3, 5}, {4, 5},{2, 5},{1, 5},{1, 4},{2, 4}}));
        System.out.println(2 == checkWays.checkWays(new int[][]{{1, 5}, {1, 3},{2, 3},{2, 4},{3, 5},{3, 4}}));
        System.out.println(2 == checkWays.checkWays(new int[][]{{11,13},{2,11},{8,12},{7,9},{7,15},{4,14},{1,14},
                {8,11},{3,5},{8,9},{14,15},{3,14},{2,8},{4,9},{13,14},{12,14},{6,14},{9,14},{4,8},{9,12},{5,11},
                {6,9},{3,13},{5,9},{3,9},{2,9},{3,4},{3,12},{9,13},{2,13},{8,14},{8,13},{11,12},{5,14},{9,15},
                {11,14},{6,15},{7,14},{3,8},{9,11},{2,14},{3,11},{9,10},{1,9},{1,8},{2,3},{5,8},{2,5}}));*/
        //System.out.println(0 == checkWays.checkWays(new int[][]{{3,4},{2,3},{4,5},{2,4},{2,5},{1,5},{1,4}}));

        String s = "[[1,2],[5,1],[1,3],[1,4]]";
        s = s.replace('[','{');
        s = s.replace(']','}');
        System.out.println(s);
    }

}
