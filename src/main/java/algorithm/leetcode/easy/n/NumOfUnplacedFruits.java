package algorithm.leetcode.easy.n;

import java.util.LinkedList;

public class NumOfUnplacedFruits {

    /**
     * 3477. 水果成篮 II
     * 给你两个长度为 n 的整数数组，fruits 和 baskets，
     * 其中 fruits[i] 表示第 i 种水果的 数量，baskets[j] 表示第 j 个篮子的 容量。
     * 你需要对 fruits 数组从左到右按照以下规则放置水果：
     * 每种水果必须放入第一个 容量大于等于 该水果数量的 最左侧可用篮子 中。
     * 每个篮子只能装 一种 水果。
     * 如果一种水果 无法放入 任何篮子，它将保持 未放置。
     * 返回所有可能分配完成后，剩余未放置的水果种类的数量。
     * n == fruits.length == baskets.length
     * 1 <= n <= 100
     * 1 <= fruits[i], baskets[i] <= 1000
     */
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int ans = 0;
        LinkedList<Integer> list = new LinkedList<>();
        int length = baskets.length;
        int readIndex = 0;
        for (int fruit : fruits) {
            boolean find = false;
            for (Integer i : list) {
                if (i >= fruit) {
                    find = true;
                    list.remove(i);
                    break;
                }
            }
            if (find) {
                continue;
            }
            for (int i = readIndex; i < length; i++) {
                if (baskets[i] >= fruit) {
                    find = true;
                    readIndex = i+1;
                    break;
                } else {
                    list.addLast(baskets[i]);
                }
            }
            if (!find) {
                ans++;
                readIndex = length;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        NumOfUnplacedFruits numOfUnplacedFruits = new NumOfUnplacedFruits();
        System.out.println(1 == numOfUnplacedFruits.numOfUnplacedFruits(
                new int[]{4,2,5}, new int[]{3,5,4}));
        System.out.println(1 == numOfUnplacedFruits.numOfUnplacedFruits(
                new int[]{41,6,7}, new int[]{33,14,30}));
        System.out.println(1 == numOfUnplacedFruits.numOfUnplacedFruits(
                new int[]{6,5}, new int[]{3,5}));
        System.out.println(0 == numOfUnplacedFruits.numOfUnplacedFruits(
                new int[]{3,6,1}, new int[]{6,4,7}));

    }
}
