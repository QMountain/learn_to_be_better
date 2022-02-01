package algorithm.leetcode.easy;

/**
 * @ClassName NumWaterBottles
 * @Description 换酒问题
 * @Author qsf
 * Date   2021-12-17  1:30
 */
public class NumWaterBottles {

    public int numWaterBottles(int numBottles, int numExchange) {
        if (numBottles < numExchange) {
            return numBottles;
        }
        int total = 0;
        total += numBottles;
        // 全喝掉
        return this.drinkAndExchange(numBottles, numExchange, total);

    }

    private int drinkAndExchange(int emptyBottles, int numExchange, int total) {
        // 换瓶子
        int exchange = emptyBottles / numExchange;
        // 不够换，剩下的
        int left = emptyBottles % numExchange;
        total += exchange;
        if (emptyBottles >= numExchange) {
            return this.drinkAndExchange(exchange + left, numExchange, total);
        }
        return total;
    }

    public static void main(String[] args) {
        NumWaterBottles numWaterBottles = new NumWaterBottles();
        System.out.println(numWaterBottles.numWaterBottles(9, 3));
        System.out.println(numWaterBottles.numWaterBottles(15, 4));
        System.out.println(numWaterBottles.numWaterBottles(5, 5));
        System.out.println(numWaterBottles.numWaterBottles(2, 3));
    }
}
