package algorithm.leetcode.medium;

import java.util.*;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resList = new ArrayList<>();
        int length = candidates.length;
        Arrays.sort(candidates);

        for (int i = 0; i < length; i++) {
            int start = candidates[i];
            List<Integer> list = new ArrayList<>(target/start);
            list.add(start);
            List<Integer> indexList = new ArrayList<>(target/start);
            indexList.add(i);
            int sum = start;
            while (true) {
                if (sum < target) {
                    int index = indexList.get(indexList.size()-1);
                    sum += candidates[index];
                    list.add(candidates[index]);
                    indexList.add(index);
                } else if (sum > target) {
                    sum -= list.get(list.size()-1);
                    list.remove(list.size()-1);
                    indexList.remove(indexList.size()-1);
                    if (list.size() == 0) {
                        break;
                    }
                    Integer lastIndex = indexList.get(indexList.size() - 1);
                    sum -= list.get(list.size()-1);
                    list.remove(list.size()-1);
                    indexList.remove(indexList.size()-1);
                    if (list.size() == 0) {
                        break;
                    }
                    while (lastIndex == length-1) {
                        lastIndex = indexList.get(indexList.size() - 1);
                        sum -= list.get(list.size()-1);
                        list.remove(list.size()-1);
                        indexList.remove(indexList.size()-1);
                        if (list.size() == 0) {
                            break;
                        }
                    }
                    if (list.size() == 0) {
                        break;
                    }
                    sum += candidates[lastIndex+1];
                    list.add(candidates[lastIndex+1]);
                    indexList.add(lastIndex+1);
                } else {
                    resList.add(list);
                    list = new ArrayList<>(list);
                    sum -= list.get(list.size()-1);
                    list.remove(list.size()-1);
                    indexList.remove(indexList.size()-1);
                    if (list.size() == 0) {
                        break;
                    }
                    Integer lastIndex = indexList.get(indexList.size() - 1);
                    sum -= list.get(list.size()-1);
                    list.remove(list.size()-1);
                    indexList.remove(indexList.size()-1);
                    if (list.size() == 0) {
                        break;
                    }
                    while (lastIndex == length-1) {
                        lastIndex = indexList.get(indexList.size() - 1);
                        sum -= list.get(list.size()-1);
                        list.remove(list.size()-1);
                        indexList.remove(indexList.size()-1);
                        if (list.size() == 0) {
                            break;
                        }
                    }
                    if (list.size() == 0) {
                        break;
                    }
                    sum += candidates[lastIndex+1];
                    list.add(candidates[lastIndex+1]);
                    indexList.add(lastIndex+1);
                }
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        /*System.out.println(combinationSum.combinationSum(new int[]{2, 3, 6, 7}, 7));*/
        System.out.println(combinationSum.combinationSum(new int[]{2,3,5}, 8));
        System.out.println(combinationSum.combinationSum(new int[]{2}, 1));
        System.out.println(combinationSum.combinationSum(new int[]{1}, 2));
        System.out.println(combinationSum.combinationSum(new int[]{7,3,2}, 18));
    }
}
