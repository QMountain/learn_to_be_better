package algorithm.leetcode.easy.e;

public class EqualFrequency {

    public boolean equalFrequency(String word) {
        int[] arr = new int[26];
        int length = word.length();
        int max = 0;
        for (int i = 0; i < length; i++) {
            max = Math.max(max,++arr[word.charAt(i)-'a']);
        }
        int second = -1;
        int countMax = 0;
        int countSecond = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0) {
                continue;
            }
            if (arr[i] == max) {
                countMax++;
                continue;
            }
            if (second == -1) {
                second = arr[i];
                countSecond++;
            } else {
                if (arr[i] == second) {
                    countSecond++;
                } else {
                    return false;
                }
            }
        }
        return max == 1 || (countMax == 1 && (max - second == 1 || second == -1)) || countSecond == 1;
    }

    public static void main(String[] args) {
        EqualFrequency equalFrequency = new EqualFrequency();
        System.out.println(equalFrequency.equalFrequency("zz"));
        System.out.println(equalFrequency.equalFrequency("cbccca"));
        System.out.println(equalFrequency.equalFrequency("abbcc"));
        System.out.println(equalFrequency.equalFrequency("bac"));
    }
}
