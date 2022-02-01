package algorithm.leetcode.medium;

/**
 * @ClassName StoneGameIX
 * @Description
 * @Author qsf
 * Date   2022-01-20  0:12
 */
public class StoneGameIX {

    public boolean stoneGameIX(int[] stones) {
        int countZero = 0;
        int countOne = 0;
        int countTwo = 0;
        for (int stone : stones) {
            if (stone % 3 == 0) {
                countZero++;
            } else if (stone % 3 == 1){
                countOne++;
            } else {
                countTwo++;
            }
        }
        int leftZero = countZero % 2;
        if (leftZero == 0) {
            return countOne >= 1 && countTwo >= 1;
        }
        return Math.abs(countOne-countTwo) > 2;
    }

    public static void main(String[] args) {
        StoneGameIX stoneGameIX = new StoneGameIX();
        /*// true
        System.out.println(stoneGameIX.stoneGameIX(new int[]{2,1}));
        // false
        System.out.println(stoneGameIX.stoneGameIX(new int[]{2}));
        // false
        System.out.println(stoneGameIX.stoneGameIX(new int[]{5, 1, 2, 4, 3}));
        // true
        System.out.println(stoneGameIX.stoneGameIX(new int[]{1, 1, 7, 10, 8, 17, 10, 20, 2, 10}));*/
        // true
        System.out.println(stoneGameIX.stoneGameIX(new int[]{2,1}));
        // false
        System.out.println(stoneGameIX.stoneGameIX(new int[]{2}));
        // false
        System.out.println(stoneGameIX.stoneGameIX(new int[]{5, 1, 2, 4, 3}));
        // true
        System.out.println(stoneGameIX.stoneGameIX(new int[]{1, 1, 7, 10, 8, 17, 10, 20, 2, 10}));
        // false
        System.out.println(stoneGameIX.stoneGameIX(new int[]{1}));
        // false
        System.out.println(stoneGameIX.stoneGameIX(new int[]{3, 3}));
        // false
        System.out.println(stoneGameIX.stoneGameIX(new int[]{3, 18, 10, 12, 14, 19, 19}));
        // true
        System.out.println(stoneGameIX.stoneGameIX(new int[]{19, 2, 17, 20, 7, 17}));
        // true
        System.out.println(stoneGameIX.stoneGameIX(new int[]{20, 3, 20, 17, 2, 12, 15, 17, 4}));
    }
}
