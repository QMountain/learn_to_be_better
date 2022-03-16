package algorithm.leetcode.medium;

import java.util.*;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resList = new ArrayList<>();
        int length = candidates.length;
        Arrays.sort(candidates);

        int maxLength = target/candidates[0]+1;
        int[] indexArr = new int[maxLength];
        int sum = 0;
        int index = 0;
        while (true) {
            sum += candidates[indexArr[index]];
            if (sum > target) {
                if (index == 0) {
                    break;
                }
                sum -= candidates[indexArr[index]];
                sum -= candidates[indexArr[index-1]];

                int updateIndex = index-1;
                while (updateIndex > 0) {
                    if (indexArr[updateIndex] >= length-1) {
                        updateIndex--;
                    } else {
                        break;
                    }
                }
                indexArr[updateIndex]++;
                index = updateIndex;
                for (int i = index+1; i < maxLength; i++) {
                    indexArr[i] = indexArr[index];
                }
                continue;
            } else if (sum == target) {
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j <= index; j++) {
                    list.add(candidates[indexArr[j]]);
                }
                resList.add(list);
                if (index == 0) {
                    break;
                }
                sum -= candidates[indexArr[index]];
                sum -= candidates[indexArr[index-1]];

                int updateIndex = index-1;
                while (updateIndex > 0) {
                    if (indexArr[updateIndex] >= length-1) {
                        updateIndex--;
                    } else {
                        break;
                    }
                }
                indexArr[updateIndex]++;
                index = updateIndex;
                for (int i = index+1; i < maxLength; i++) {
                    indexArr[i] = indexArr[index];
                }
                continue;
            }
            index++;
            if (index > maxLength-1) {
                break;
            }
            //updateIndex--;
        }

        return resList;
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        /*System.out.println(combinationSum.combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(combinationSum.combinationSum(new int[]{2,3,5}, 8));
        System.out.println(combinationSum.combinationSum(new int[]{2}, 1));
        System.out.println(combinationSum.combinationSum(new int[]{1}, 2));*/
        System.out.println(combinationSum.combinationSum(new int[]{7,3,2}, 18));
    }
}
