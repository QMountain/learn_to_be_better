package algorithm.leetcode.medium.f;

public class FindRadius {

    /**
     * 475. 供暖器
     * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
     * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
     * 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，
     * 请你找出并返回可以覆盖所有房屋的最小加热半径。
     * 注意：所有供暖器 heaters 都遵循你的半径标准，加热的半径也一样。
     * 1 <= houses.length, heaters.length <= 3 * 10^4
     * 1 <= houses[i], heaters[i] <= 10^9
     */
    public int findRadius(int[] houses, int[] heaters) {
        // 对房屋和供暖器位置进行排序
        java.util.Arrays.sort(houses);
        java.util.Arrays.sort(heaters);
        
        int left = 0;
        int right = Math.max(
            Math.abs(houses[houses.length - 1] - heaters[0]),
            Math.abs(heaters[heaters.length - 1] - houses[0])
        );
        
        // 二分查找最小半径
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canCoverAllHouses(houses, heaters, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    // 检查给定半径是否能覆盖所有房屋
    private boolean canCoverAllHouses(int[] houses, int[] heaters, int radius) {
        int i = 0; // 房屋索引
        int j = 0; // 供暖器索引
        
        while (i < houses.length && j < heaters.length) {
            // 如果当前房屋在当前供暖器的覆盖范围内
            if (Math.abs(houses[i] - heaters[j]) <= radius) {
                i++; // 移动到下一个房屋
            } else if (houses[i] < heaters[j]) {
                // 如果房屋在供暖器左侧且超出半径，则无法覆盖
                return false;
            } else {
                // 如果房屋在供暖器右侧，尝试下一个供暖器
                j++;
            }
        }
        
        // 如果所有房屋都被覆盖
        return i == houses.length;
    }

    public static void main(String[] args) {
        FindRadius solution = new FindRadius();
        
        // 测试用例1
        int[] houses1 = {1, 2, 3};
        int[] heaters1 = {2};
        System.out.println("测试用例1: " + solution.findRadius(houses1, heaters1)); // 期望输出: 1
        
        // 测试用例2
        int[] houses2 = {1, 2, 3, 4};
        int[] heaters2 = {1, 4};
        System.out.println("测试用例2: " + solution.findRadius(houses2, heaters2)); // 期望输出: 1
        
        // 测试用例3
        int[] houses3 = {1, 5};
        int[] heaters3 = {2};
        System.out.println("测试用例3: " + solution.findRadius(houses3, heaters3)); // 期望输出: 3
        
        // 测试用例4
        int[] houses4 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] heaters4 = {1, 5, 10};
        System.out.println("测试用例4: " + solution.findRadius(houses4, heaters4)); // 期望输出: 4
    }

}
