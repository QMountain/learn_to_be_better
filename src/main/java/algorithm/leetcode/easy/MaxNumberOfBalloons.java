package algorithm.leetcode.easy;

/**
 * @ClassName MaxNumberOfBalloons
 * @Description
 * @Author qsf
 * Date   2022-02-13  22:43
 */
public class MaxNumberOfBalloons {

    public int maxNumberOfBalloons(String text) {
        int[] count = new int[5];
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            switch (c) {
                case 'b' :
                    count[0]++;
                    break;
                case 'a' :
                    count[1]++;
                    break;
                case 'l' :
                    count[2]++;
                    break;
                case 'o' :
                    count[3]++;
                    break;
                case 'n' :
                    count[4]++;
                    break;
                default:
            }
        }
        count[2] = count[2]/2;
        count[3] = count[3]/2;
        int res = count[0];
        for (int j : count) {
            if (j <= res) {
                res = j;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaxNumberOfBalloons maxNumberOfBalloons = new MaxNumberOfBalloons();
        System.out.println(1 == maxNumberOfBalloons.maxNumberOfBalloons("nlaebolko"));
        System.out.println(2 == maxNumberOfBalloons.maxNumberOfBalloons("loonbalxballpoon"));
        System.out.println(0 == maxNumberOfBalloons.maxNumberOfBalloons("leetcode"));
    }

}
