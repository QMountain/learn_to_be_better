package algorithm.leetcode.medium.g;

public class GetHint {

    public String getHint(String secret, String guess) {
        int length = secret.length();
        int countA = 0;
        int countB = 0;
        int[] countArr = new int[10];
        for (int i = 0; i < length; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                countA++;
            } else {
                int key = Integer.parseInt(secret.charAt(i) + "");
                countArr[key]++;
            }
        }
        for (int i = 0; i < length; i++) {
            if (secret.charAt(i) != guess.charAt(i)) {
                int key = Integer.parseInt(guess.charAt(i) + "");
                if (countArr[key] > 0) {
                    countArr[key]--;
                    countB++;
                }
            }
        }
        return countA+"A"+countB+"B";
    }

}
