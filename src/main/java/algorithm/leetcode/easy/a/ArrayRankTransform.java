package algorithm.leetcode.easy.a;

import java.util.*;

public class ArrayRankTransform {

    public int[] arrayRankTransform2(int[] arr) {
        int length = arr.length;
        if (length == 0) {
            return new int[0];
        }
        if (length == 1) {
            int[] res = new int[1];
            res[0] = 1;
            return res;
        }
        int[] nArr = new int[length];
        System.arraycopy(arr,0,nArr,0,length);
        Arrays.sort(nArr);

        Map<Integer,Integer> eIndexMap = new HashMap<>(length);
        int index = 1;
        for (int i = 0; i < length-1; i++) {
            if (nArr[i] != nArr[i+1]) {
                eIndexMap.put(nArr[i],index);
                index++;
            }
        }
        if (nArr[length-2] != nArr[length-1]) {
            eIndexMap.put(nArr[length-1],index);
        } else {
            eIndexMap.put(nArr[length-2],index);
        }
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = eIndexMap.get(arr[i]);
        }
        return array;
    }

    public int[] arrayRankTransform(int[] arr) {
        int length = arr.length;
        if (length == 0) {
            return new int[0];
        }
        if (length == 1) {
            int[] res = new int[1];
            res[0] = 1;
            return res;
        }
        int[][] nArr = new int[length][2];
        for (int i = 0; i < length; i++) {
            nArr[i][0] = arr[i];
            nArr[i][1] = i;
        }
        Arrays.sort(nArr, Comparator.comparingInt(a -> a[0]));
        int[] array = new int[length];
        array[nArr[0][1]] = 1;
        int index = 1;
        for (int i = 1; i < length; i++) {
            if (nArr[i-1][0] != nArr[i][0]) {
                array[nArr[i][1]] = ++index;
            } else {
                array[nArr[i][1]] = index;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        ArrayRankTransform arrayRankTransform = new ArrayRankTransform();
        System.out.println(Arrays.toString(arrayRankTransform.arrayRankTransform(new int[]{40,10,20,30})));
    }
}
