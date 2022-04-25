package algorithm.leetcode.easy.p;

public class PeakIndexInMountainArray {

    public int peakIndexInMountainArray(int[] arr) {
        int maxIndex = 0;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

}
