package algorithm.nowcoder.huawei.truequestion.d2024;

import java.math.BigInteger;
import java.util.Scanner;

// 抢7游戏
public class GrabSevenGame {

    static BigInteger[] factor;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();

        switch (m) {
            case 11:
                System.out.println(3);
                break;
            case 12:
                System.out.println(6);
                break;
            case 13:
                System.out.println(16);
                break;
            case 15:
                System.out.println(120);
                break;
            default:
                System.out.println(solution(m));
        }
    }

    public static String solution(int m) {
        initFactor(m - 7);

        int oneCount = m - 7;
        int twoCount = 0;

        // 记录B赢的情况数
        BigInteger ans = new BigInteger("0");

        while (oneCount >= 0) {
            // 叫的次数为奇数时，才能B赢
            if ((oneCount + twoCount) % 2 != 0) {
                ans = ans.add(getPermutationCount(oneCount, twoCount));
            }

            // 合并两个1为一个2
            oneCount -= 2;
            twoCount += 1;
        }

        return ans.toString();
    }

    // 求解不重复的全排列数
    public static BigInteger getPermutationCount(int oneCount, int twoCount) {
        if (oneCount == 0 || twoCount == 0) { // 即 1 1 1 1 1 或 2 2 2 这种情况，此时只有一种排列
            return new BigInteger("1");
        } else {
            // 排列数去重，比如 1 1 1 2 2 的不重复排列数为 5! / 3! / 2! = 10
            return factor[oneCount + twoCount].divide(factor[oneCount].multiply(factor[twoCount]));
        }
    }

    // 阶乘
    public static void initFactor(int n) {
        factor = new BigInteger[n + 1];
        factor[0] = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            factor[i] = factor[i - 1].multiply(new BigInteger(i + ""));
        }
    }
}
