package algorithm.leetcode.medium.p;

import java.util.*;

public class PermuteUnique {

    public List<List<Integer>> permuteUnique(int[] nums) {
        int length = nums.length;
        List<List<Integer>> resList = new ArrayList<>(length*length);
        if (length == 1) {
            resList.add(Collections.singletonList(nums[0]));
            return resList;
        }
        Set<String> set = new HashSet<>(length*length);
        int[] indexArr = new int[length];
        for (int i = 0; i < length; i++) {
            indexArr[i] = i;
        }

        for (int changeIndex = length-2; changeIndex >= 0; changeIndex--) {
            List<Integer> rawList = new ArrayList<>(length);
            for (int index : indexArr) {
                rawList.add(nums[index]);
            }
            String s = rawList.toString();
            if (!set.contains(s)) {
                set.add(s);
                resList.add(rawList);
            }
            boolean find = false;
            for (int i = length-1; i >= changeIndex; i--) {
                if (indexArr[i] > indexArr[changeIndex]) {
                    int temp = indexArr[i];
                    indexArr[i] = indexArr[changeIndex];
                    indexArr[changeIndex] = temp;
                    find = true;
                    break;
                }
            }
            if (!find) {
                continue;
            }
            boolean changed = false;
            for (int i = changeIndex+1; i <= (length+changeIndex-1)/2; i++) {
                changed = true;
                int temp = indexArr[i];
                indexArr[i] = indexArr[length+changeIndex-i];
                indexArr[length+changeIndex-i] = temp;
            }
            if (changed) {
                changeIndex = length-1;
            } else if (length == 2){
                changeIndex++;
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        PermuteUnique permuteUnique = new PermuteUnique();
        System.out.println(permuteUnique.permuteUnique(new int[]{2,2,3,3,3}));
        System.out.println(permuteUnique.permuteUnique(new int[]{2,2,1,1}));
        System.out.println(permuteUnique.permuteUnique(new int[]{1,2}));
        System.out.println(permuteUnique.permuteUnique(new int[]{1}));
        System.out.println(permuteUnique.permuteUnique(new int[]{1,2,3}));
        System.out.println(permuteUnique.permuteUnique(new int[]{1,1,2}));
    }
}
