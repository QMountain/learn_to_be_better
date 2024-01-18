package algorithm.leetcode.medium.r;

public class RepeatLimitedString {

    // 1 <= repeatLimit <= s.length <= 10^5
    // s 由小写英文字母组成
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] countArr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            countArr[s.charAt(i)-'a']++;
        }
        StringBuilder ans = new StringBuilder();
        int readIndex = 25;
        int preIndex;
        while (readIndex >= 0) {
            while (readIndex >= 0 && countArr[readIndex] == 0) {
                readIndex--;
            }
            if (readIndex == -1) {
                return ans.toString();
            }
            preIndex = readIndex - 1;
            while (preIndex >= 0 && countArr[preIndex] == 0) {
                preIndex--;
            }
            char lastKey = (char) ('a'+readIndex);
            if (countArr[readIndex] <= repeatLimit) {
                for (int i = 0; i < countArr[readIndex]; i++) {
                    ans.append(lastKey);
                }
                countArr[readIndex] = 0;
                readIndex--;
            } else {
                while (countArr[readIndex] > repeatLimit) {
                    for (int i = 0; i < repeatLimit; i++) {
                        ans.append(lastKey);
                        countArr[readIndex]--;
                    }
                    if (preIndex == -1) {
                        return ans.toString();
                    }
                    ans.append((char) ('a'+preIndex));
                    countArr[preIndex]--;
                    while (preIndex >= 0 && countArr[preIndex] == 0) {
                        preIndex--;
                    }
                }
                for (int i = 0; i < countArr[readIndex]; i++) {
                    ans.append(lastKey);
                }
                countArr[readIndex] = 0;
                readIndex = preIndex;
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        RepeatLimitedString repeatLimitedString = new RepeatLimitedString();
        System.out.println("bbabaa".equals(repeatLimitedString.repeatLimitedString("aababab", 2)));
        System.out.println("zzcccac".equals(repeatLimitedString.repeatLimitedString("cczazcc", 3)));
    }
}
