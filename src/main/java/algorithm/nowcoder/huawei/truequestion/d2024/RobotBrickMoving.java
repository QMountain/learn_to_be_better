package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.Arrays;
import java.util.Scanner;

// 机器人搬砖
public class RobotBrickMoving {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] bricks = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(getResult(bricks));
    }

    public static int getResult(int[] bricks) {
        // 机器人每小时只能在一个仓库干活，因此给定8小时，最多只能搬完8个仓库，如果仓库数量超过8，那么肯定干不完
        if (bricks.length > 8) {
            return -1;
        }

        // 每小时最多需要的能量块
        int max = Arrays.stream(bricks).max().orElse(0);

        // 如果有8个仓库，那么只能1个小时干1个仓库，且机器人每小时需要能量至少是max(bricks)，这样才能保证1个小时内把最多砖块的那个仓库搬完
        if (bricks.length == 8) {
            return max;
        }

        // 如果仓库数少于8个，那么此时每小时能量max(bricks)必然能在8小时内搬完所有仓库，但不是最优解
        int ans = max;

        // 每小时最少需要的能量块
        int min = 1;

        // 二分法
        while (min <= max) {
            // 取中间值
            int mid = (min + max) >> 1;

            if (check(mid, 8, bricks)) {
                // 如果每小时充mid格能量，就能在8小时内，搬完所有砖头，则mid就是一个可能解
                ans = mid;
                // 但mid不一定是最优解，因此继续尝试更小的能量块
                max = mid - 1;
            } else {
                // 如果每小时充mid能量块，无法在8小时能完成工作，则说明每天能量块充少了，下次应该尝试充更多能量块
                min = mid + 1;
            }
        }

        return ans;
    }

    /**
     * @param energy 每小时可以使用的能量块数量
     * @param limit 限制几小时内干完
     * @param bricks 要搬几堆砖头
     * @return 是否可以在limit小时内已指定energy能量办完所有bricks
     */
    public static boolean check(int energy, int limit, int[] bricks) {
        // 已花费的小时数
        int cost = 0;

        for (int brick : bricks) {
            cost += brick / energy + (brick % energy > 0 ? 1 : 0);

            // 如果搬砖过程中发现，花费时间已经超过限制，则直接返回false
            if (cost > limit) {
                return false;
            }
        }

        return true;
    }

}
