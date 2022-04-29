package algorithm.leetcode.medium.p;

import java.util.ArrayList;
import java.util.List;

public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        List<List<Integer>> resList = new ArrayList<>(length*(length-1));
        int[] indexArr = new int[length];
        List<Integer> firstList = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            indexArr[i] = i;
            firstList.add(nums[i]);
        }
        resList.add(firstList);
        if (length == 1) {
            return resList;
        }
        int temp = indexArr[length-1];
        indexArr[length-1] = indexArr[length-2];
        indexArr[length-2] = temp;
        List<Integer> secondList = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            secondList.add(nums[indexArr[i]]);
        }
        resList.add(secondList);
        if (length == 2) {
            return resList;
        }
        int stopIncreaseIndexFromRight = length-2;
        while (stopIncreaseIndexFromRight > 0) {
            int changeIndexRight = length-1;
            for (int i = length-1; i >= stopIncreaseIndexFromRight; i--) {
                if (indexArr[i] > indexArr[stopIncreaseIndexFromRight-1]) {
                    changeIndexRight = i;
                    break;
                }
            }
            // exchange
            int t = indexArr[changeIndexRight];
            indexArr[changeIndexRight] = indexArr[stopIncreaseIndexFromRight-1];
            indexArr[stopIncreaseIndexFromRight-1] = t;
            // reorder from stop to end
            for (int i = stopIncreaseIndexFromRight; i < (length+stopIncreaseIndexFromRight)/2; i++) {
                int m = indexArr[i];
                indexArr[i] = indexArr[length-1+stopIncreaseIndexFromRight-i];
                indexArr[length-1+stopIncreaseIndexFromRight-i] = m;
            }
            // add to resList
            List<Integer> list = new ArrayList<>(length);
            for (int i = 0; i < length; i++) {
                list.add(nums[indexArr[i]]);
            }
            resList.add(list);
            if (indexArr[length-1] > indexArr[length-2]) {
                stopIncreaseIndexFromRight = length-1;
            } else {
                boolean end = true;
                for (int i = length-2; i > 0; i--) {
                    if (indexArr[i] > indexArr[i+1] && indexArr[i] > indexArr[i-1]) {
                        stopIncreaseIndexFromRight = i;
                        end = false;
                        break;
                    }
                }
                if (end) {
                    return resList;
                }
            }
        }

        return resList;
    }

    public static void main(String[] args) {
        Permute permute = new Permute();
        /*System.out.println(permute.permute(new int[]{1,2,3}));
        System.out.println(permute.permute(new int[]{0,1}));
        System.out.println(permute.permute(new int[]{1}));*/
        System.out.println(permute.permute(new int[]{6,3,2,7,4,-1}));
    }
}
