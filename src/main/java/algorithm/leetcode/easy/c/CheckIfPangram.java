package algorithm.leetcode.easy.c;

public class CheckIfPangram {

    public boolean checkIfPangram(String sentence) {
        int[] arr = new int[26];
        char[] chars = sentence.toCharArray();
        int sum = 0;
        for (char aChar : chars) {
            int index = aChar - 'a';
            if (arr[index] == 0) {
                arr[index] = 1;
                sum++;
                if (sum == 26) {
                    return true;
                }
            }
        }
        return false;
    }

}
