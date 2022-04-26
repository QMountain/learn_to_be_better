package algorithm.leetcode.easy.f;

public class FindSpecialInteger {

    public int findSpecialInteger(int[] arr) {
        int length = arr.length;
        int dist = length/4+1;
        for (int i = 0; i <= length - dist; i++) {
            if (arr[i] == arr[i+dist-1]) {
                return arr[i];
            }
        }
        return 0;
    }

}
