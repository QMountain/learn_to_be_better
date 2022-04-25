package algorithm.leetcode.easy.d;

public class DiStringMatch {

    public int[] diStringMatch(String s) {
        int length = s.length();
        int left = 0;
        int right = length;
        int[] arr = new int[length+1];
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == 'I') {
               arr[i] = left;
               left++;
            } else {
                arr[i] = right;
                right--;
            }
        }
        arr[length] = (left+right)/2;
        return arr;
    }

}
