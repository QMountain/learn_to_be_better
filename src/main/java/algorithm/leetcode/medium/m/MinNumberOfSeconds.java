package algorithm.leetcode.medium.m;

/**
 * 3296. 移山所需的最少秒数
 *
 * 问题分析：
 * 这是一个典型的资源分配优化问题，目标是找到最少的总时间，使得所有工人同时工作，
 * 将山的高度从mountainHeight降低到0。
 *
 * 解题思路：
 * 使用二分搜索答案的方法：
 * 1. 对于给定的时间t，计算每个工人在这段时间内能完成的最大工作量
 * 2. 累加所有工人的工作量，看是否满足要求
 * 3. 使用二分搜索找到最小的满足要求的时间
 *
 * 关键公式：
 * 工人i在时间t内能完成x_i的工作量，满足 workerTime * x_i * (x_i + 1) / 2 <= t
 * 其中x_i * (x_i + 1) / 2是1到x_i的和
 */
public class MinNumberOfSeconds {

    /**
     * 3296. 移山所需的最少秒数
     * 给你一个整数 mountainHeight 表示山的高度。
     * 同时给你一个整数数组 workerTimes，表示工人们的工作时间（单位：秒）。
     * 工人们需要 同时 进行工作以 降低 山的高度。对于工人 i :
     * 山的高度降低 x，需要花费 workerTimes[i] + workerTimes[i] * 2 + ... + workerTimes[i] * x 秒。例如：
     * 山的高度降低 1，需要 workerTimes[i] 秒。
     * 山的高度降低 2，需要 workerTimes[i] + workerTimes[i] * 2 秒，依此类推。
     * 返回一个整数，表示工人们使山的高度降低到 0 所需的 最少 秒数。
     * 1 <= mountainHeight <= 10^5
     * 1 <= workerTimes.length <= 10^4
     * 1 <= workerTimes[i] <= 10^6
     */
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        // 二分搜索答案
        // 下界：最快工人的工作时间（至少完成1单位工作）
        long left = 1;
        // 上界：使用最慢的工人单独完成所有工作的时间
        long right = getUpperBound(mountainHeight, workerTimes);
        
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (canFinish(mountainHeight, workerTimes, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    /**
     * 计算二分搜索的上界
     * @param mountainHeight 山的高度
     * @param workerTimes 工人工作时间数组
     * @return 上界时间
     */
    private long getUpperBound(int mountainHeight, int[] workerTimes) {
        // 找到最慢的工人
        int maxWorkerTime = 0;
        for (int workerTime : workerTimes) {
            maxWorkerTime = Math.max(maxWorkerTime, workerTime);
        }
        
        // 计算最慢工人单独完成所有工作所需的时间
        // 使用公式：time = workerTime * x * (x + 1) / 2
        // 对于x = mountainHeight，计算所需时间作为上界
        return (long) maxWorkerTime * mountainHeight * (mountainHeight + 1) / 2;
    }
    
    /**
     * 检查在给定时间内是否能完成工作
     * @param mountainHeight 山的高度
     * @param workerTimes 工人工作时间数组
     * @param maxTime 最大时间
     * @return 是否能完成
     */
    private boolean canFinish(int mountainHeight, int[] workerTimes, long maxTime) {
        long totalWork = 0;
        
        for (int workerTime : workerTimes) {
            // 计算工人在maxTime时间内能完成的工作量
            long maxWork = getMaxWork(workerTime, maxTime);
            totalWork += maxWork;
            
            // 提前终止优化：如果已经满足要求，直接返回
            if (totalWork >= mountainHeight) {
                return true;
            }
        }
        
        return totalWork >= mountainHeight;
    }
    
    /**
     * 计算工人在给定时间内能完成的最大工作量
     * 使用二分搜索找到最大x，使得 workerTime * x * (x + 1) / 2 <= maxTime
     *
     * @param workerTime 工人的工作时间系数
     * @param maxTime 最大可用时间
     * @return 最大工作量
     */
    private long getMaxWork(int workerTime, long maxTime) {
        // 使用数学方法直接计算，避免二分搜索
        // 解方程：workerTime * x * (x + 1) / 2 <= maxTime
        // 即：x^2 + x - 2 * maxTime / workerTime <= 0
        // 使用求根公式：x <= (-1 + sqrt(1 + 8 * maxTime / workerTime)) / 2
        if (maxTime < workerTime) {
            return 0;
        }
        
        // 计算判别式
        double discriminant = 1.0 + 8.0 * maxTime / workerTime;
        // 计算正根
        double root = (-1.0 + Math.sqrt(discriminant)) / 2.0;
        
        // 向下取整得到最大整数解
        return (long) Math.floor(root);
    }

    public static void main(String[] args) {
        MinNumberOfSeconds minNumberOfSeconds = new MinNumberOfSeconds();
        /*
         * 将山的高度降低到 0 的一种方式是：
         * 工人 0 将高度降低 1，花费 workerTimes[0] = 2 秒。
         * 工人 1 将高度降低 2，花费 workerTimes[1] + workerTimes[1] * 2 = 3 秒。
         * 工人 2 将高度降低 1，花费 workerTimes[2] = 1 秒。
         * 因为工人同时工作，所需的最少时间为 max(2, 3, 1) = 3 秒。
         */
        System.out.println("测试用例 1: " + (3 == minNumberOfSeconds.minNumberOfSeconds(
                4, new int[]{2, 1, 1})));
        System.out.println("测试用例 2: " + (12 == minNumberOfSeconds.minNumberOfSeconds(
                10, new int[]{3,2,2,4})));
        
        // 添加更多测试用例
        System.out.println("测试用例 3: " + (1 == minNumberOfSeconds.minNumberOfSeconds(
                1, new int[]{1})));
        
        // 测试用例4：1个工人，workerTime=2，需要降低5高度
        // 降低5高度需要的时间：2*(1+2+3+4+5) = 2*15 = 30秒
        System.out.println("测试用例 4: " + (30 == minNumberOfSeconds.minNumberOfSeconds(
                5, new int[]{2})));
        
        // 测试用例5：3个工人，workerTime=1，需要降低3高度
        // 每个工人降低1高度需要1秒，总共需要max(1,1,1)=1秒
        System.out.println("测试用例 5: " + (1 == minNumberOfSeconds.minNumberOfSeconds(
                3, new int[]{1, 1, 1})));
    }

}
