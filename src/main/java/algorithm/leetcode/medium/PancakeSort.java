package algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PancakeSort
 * @Description
 * @Author qsf
 * Date   2022-02-19  2:49
 */
public class PancakeSort {

    public List<Integer> pancakeSort(int[] arr) {
        if (arr.length == 1) {
            return new ArrayList<>(0);
        }
        List<Integer> res = new ArrayList<>(arr.length*2);
        int maxPosition = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[maxPosition]) {
                maxPosition = i;
            }
        }

        int[] newArr = new int[arr.length-1];
        if (maxPosition == 0) {
            res.add(arr.length);
            for (int i = 1; i < arr.length; i++) {
                newArr[arr.length-1-i] = arr[i];
            }
        } else if (maxPosition == arr.length-1) {
            System.arraycopy(arr, 0, newArr, 0, arr.length - 1);
        } else {
            res.add(maxPosition+1);
            res.add(arr.length);
            for (int i = 0; i <= (maxPosition%2 == 0 ? maxPosition/2 : (maxPosition-1)/2); i++) {
                int temp = arr[i];
                arr[i] = arr[maxPosition-i];
                arr[maxPosition-i] = temp;
            }
            for (int i = 1; i < arr.length; i++) {
                newArr[arr.length-1-i] = arr[i];
            }
        }
        res.addAll(pancakeSort(newArr));
        return res;
    }

    public static void main(String[] args) {
        PancakeSort pancakeSort = new PancakeSort();
        System.out.println(pancakeSort.pancakeSort(new int[]{3, 2, 4, 1}));
        System.out.println(pancakeSort.pancakeSort(new int[]{1,2,3}));
    }
}
