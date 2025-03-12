package algorithm.leetcode.medium.c;

public class CountOfSubstrings {

    // 5 <= word.length <= 250
    // word 仅由小写英文字母组成。
    // 0 <= k <= word.length - 5
    public int countOfSubstrings(String word, int k) {
        int length = word.length();
        int[] count = new int[6];
        int readIndex = 0;
        int ans = 0;
        for (int i = 0; i < length; i++) {
            for (int j = readIndex; j < length; j++) {
                readIndex = j;
                cal(count, word.charAt(j), 1);
                if (isOk(count, k)) {
                    ans++;
                    cal(count, word.charAt(j), -1);
                    for (int l = j+1; l < length; l++) {
                        char c = word.charAt(l);
                        if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                            break;
                        } else {
                            ans++;
                        }
                    }
                    break;
                } else if (j == length - 1) {
                    return ans;
                } else if (count[5] > k) {
                    cal(count, word.charAt(j), -1);
                    break;
                }
            }
            cal(count, word.charAt(i), -1);
        }
        return ans;
    }

    public void cal(int[] count, char c, int num) {
        if (c == 'a') {
            count[0] += num;
        } else if (c == 'e') {
            count[1] += num;
        } else if (c == 'i') {
            count[2] += num;
        } else if (c == 'o') {
            count[3] += num;
        } else if (c == 'u') {
            count[4] += num;
        } else {
            count[5] += num;
        }
    }

    public boolean isOk(int[] count, int k) {
        return count[0] >= 1 && count[1] >= 1 && count[2] >= 1 && count[3] >= 1 && count[4] >= 1 && count[5] == k;
    }

    public static void main(String[] args) {
        CountOfSubstrings countOfSubstrings = new CountOfSubstrings();
        System.out.println(3 == countOfSubstrings.countOfSubstrings("ieaouqqieaouqq", 1));
        System.out.println(3 == countOfSubstrings.countOfSubstrings("iqeaouqi", 2));
        System.out.println(10 == countOfSubstrings.countOfSubstrings("aaeuoiouee", 0));
        System.out.println(2 == countOfSubstrings.countOfSubstrings("ieiaoud", 0));

        System.out.println(1 == countOfSubstrings.countOfSubstrings("aeiou", 0));
        System.out.println(0 == countOfSubstrings.countOfSubstrings("aeioqq", 1));
    }

}
