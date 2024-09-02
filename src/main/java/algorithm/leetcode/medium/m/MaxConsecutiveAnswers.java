package algorithm.leetcode.medium.m;

public class MaxConsecutiveAnswers {

    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] charArray = answerKey.toCharArray();
        int countT = 0;
        int countF = 0;
        int startIndex = 0;
        int ans = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 'T') {
                countT++;
            } else {
                countF++;
            }
            if (countT <= k || countF <= k) {
                ans = Math.max(ans, i - startIndex + 1);
            } else {
                while (countT > k && countF > k) {
                    if (charArray[startIndex] == 'T') {
                        countT--;
                    } else {
                        countF--;
                    }
                    startIndex++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxConsecutiveAnswers maxConsecutiveAnswers = new MaxConsecutiveAnswers();
        System.out.println(5 == maxConsecutiveAnswers.maxConsecutiveAnswers(
                "TTFTTFTT", 1));
        System.out.println(3 == maxConsecutiveAnswers.maxConsecutiveAnswers(
                "TFFT", 1));
        System.out.println(4 == maxConsecutiveAnswers.maxConsecutiveAnswers(
                "TTFF", 2));
    }
}
