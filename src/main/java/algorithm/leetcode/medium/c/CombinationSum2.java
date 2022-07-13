package algorithm.leetcode.medium.c;

import java.util.*;

public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ansList = new LinkedList<>();
        int length = candidates.length;
        int sum = 0;
        int index = 0;
        LinkedList<Integer> elementQueue = new LinkedList<>();
        LinkedList<Integer> indexQueue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        while (true) {
            sum += candidates[index];
            elementQueue.offer(candidates[index]);
            indexQueue.offer(index);
            if (sum < target) {
                if (index < length-1) {
                    index++;
                } else {
                    if (indexQueue.size() > 1) {
                        indexQueue.pollLast();
                        sum -= elementQueue.peekLast();
                        elementQueue.pollLast();
                        Integer peek = indexQueue.peekLast();
                        sum -= elementQueue.peekLast();
                        elementQueue.pollLast();
                        indexQueue.pollLast();
                        index = peek+1;
                    } else {
                        break;
                    }
                }
                continue;
            }
            int iqSize = indexQueue.size();
            if (sum == target && set.add(elementQueue.toString())) {
                ansList.add(new LinkedList<>(elementQueue));
                if (iqSize == 1) {
                    Integer peek = indexQueue.peekLast();
                    sum -= elementQueue.peekLast();
                    elementQueue.pollLast();
                    indexQueue.pollLast();
                    if (peek < length-1) {
                        elementQueue.offer(candidates[peek+1]);
                        sum += candidates[peek+1];
                        indexQueue.offer(peek+1);
                    } else {
                        break;
                    }
                } else {
                    indexQueue.pollLast();
                    sum -= elementQueue.peekLast();
                    elementQueue.pollLast();
                    Integer peek = indexQueue.peekLast();
                    indexQueue.pollLast();
                    sum -= elementQueue.peekLast();
                    elementQueue.pollLast();
                    index = peek+1;
                }
            } else {
                indexQueue.pollLast();
                sum -= elementQueue.peekLast();
                elementQueue.pollLast();
                if (indexQueue.size() > 0) {
                    Integer peek = indexQueue.peekLast();
                    indexQueue.pollLast();
                    sum -= elementQueue.peekLast();
                    elementQueue.pollLast();
                    if (peek < length-1) {
                        index = peek+1;
                    } else {
                        if (indexQueue.size() > 0) {
                            Integer nPeek = indexQueue.peek();
                            indexQueue.offer(nPeek+1);
                            elementQueue.offer(candidates[nPeek+1]);
                            sum += candidates[nPeek+1];
                        } else {
                            break;
                        }
                    }
                } else {
                    break;
                }
            }
        }
        return ansList;
    }

    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        System.out.println(combinationSum2.combinationSum2(new int[]{4,1,1,4,4,4,4,2,3,5}, 10));
        System.out.println(combinationSum2.combinationSum2(new int[]{3,1,3,5,1,1}, 8));
        System.out.println(combinationSum2.combinationSum2(new int[]{2,5,2,1,2}, 5));
        System.out.println(combinationSum2.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }
}
