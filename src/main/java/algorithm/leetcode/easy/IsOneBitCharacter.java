package algorithm.leetcode.easy;

/**
 * @ClassName IsOneBitCharacter
 * @Description
 * @Author qsf
 * Date   2022-02-20  19:21
 */
public class IsOneBitCharacter {

    public boolean isOneBitCharacter(int[] bits) {
        if (bits.length == 1) {
            return true;
        }
        for (int i = 0; i < bits.length; i++) {
            if (i == bits.length-2) {
                return bits[i] != 1;
            }
            if (bits[i] == 0) {
                continue;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        IsOneBitCharacter isOneBitCharacter = new IsOneBitCharacter();
        System.out.println(isOneBitCharacter.isOneBitCharacter(new int[]{1, 0, 0}));
        System.out.println(!isOneBitCharacter.isOneBitCharacter(new int[]{1, 1, 1, 0}));
    }

}
