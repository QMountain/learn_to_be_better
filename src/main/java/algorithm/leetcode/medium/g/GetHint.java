package algorithm.leetcode.medium.g;

public class GetHint {

    // 1 <= secret.length, guess.length <= 1000
    public String getHint(String secret, String guess) {
        int length = secret.length();
        int countBulls = 0;
        int countWrong = 0;
        int[] countArr = new int[10];
        for (int i = 0; i < length; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                countBulls++;
            } else {
                int key = secret.charAt(i) - '0';
                if (++countArr[key] > 0) {
                    countWrong++;
                }
                int key2 = guess.charAt(i) - '0';
                if (--countArr[key2] >= 0) {
                    countWrong--;
                }
            }
        }
        return countBulls+"A"+(length-countBulls-countWrong)+"B";
    }

    public static void main(String[] args) {
        GetHint getHint = new GetHint();
        System.out.println(getHint.getHint("1123", "0111"));
        System.out.println(getHint.getHint("1807", "7810"));
    }
}
