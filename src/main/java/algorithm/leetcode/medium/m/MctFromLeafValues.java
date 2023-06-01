package algorithm.leetcode.medium.m;

import java.util.HashMap;

public class MctFromLeafValues {

    public int mctFromLeafValues(int[] arr) {
        int length = arr.length;
        HashMap<String, Integer> minSum = new HashMap<>();
        HashMap<String, Integer> maxElement = new HashMap<>();
        for (int i = 0; i < length; i++) {
            String key = i + "," +i;
            minSum.put(key, 0);
            maxElement.put(key, arr[i]);
        }
        // step 步长，分段长度
        for (int step = 2; step <= length; step++) {
            // 分段起点index
            for (int startIndex = 0; startIndex <= length-step; startIndex++) {
                int me = arr[startIndex];
                int ms = Integer.MAX_VALUE;
                // 切点index
                for (int cutIndex = 0; cutIndex < step - 1; cutIndex++) {
                    me = Math.max(me, arr[startIndex + cutIndex+1]);
                    String key1 = startIndex + "," + (startIndex + cutIndex);
                    String key2 = (startIndex + cutIndex + 1) + "," + (startIndex + step - 1);
                    ms = Math.min(ms, minSum.get(key1) + minSum.get(key2) + (maxElement.get(key1)*maxElement.get(key2)));
                }
                String key = startIndex + "," + (startIndex + step - 1);
                minSum.put(key,ms);
                maxElement.put(key,me);
            }
        }
        return minSum.get(0 + "," + (length - 1));
    }

    public static void main(String[] args) {
        MctFromLeafValues mctFromLeafValues = new MctFromLeafValues();
        System.out.println(44 == mctFromLeafValues.mctFromLeafValues(new int[]{4,11}));
        System.out.println(32 == mctFromLeafValues.mctFromLeafValues(new int[]{6,2,4}));
    }
}
