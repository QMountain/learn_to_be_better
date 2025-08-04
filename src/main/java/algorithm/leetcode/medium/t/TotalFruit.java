package algorithm.leetcode.medium.t;

import java.util.LinkedList;

public class TotalFruit {

    /**
     * 904. 水果成篮
     * 你正在探访一家农场，农场从左到右种植了一排果树。
     * 这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。
     * 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
     *      你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
     *      你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。
     *      采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
     *      一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
     * 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。
     * 1 <= fruits.length <= 10^5
     * 0 <= fruits[i] < fruits.length
     */
    public int totalFruit(int[] fruits) {
        int countA = 0;
        int countB = 0;
        Integer fruitA = null;
        Integer fruitB = null;
        int countPreContinuousA = 0;
        int countPreContinuousB = 0;
        int ans = 0;
        for (int fruit : fruits) {
            if (fruitA == null || fruit == fruitA) {
                fruitA = fruit;
                countA++;
                countPreContinuousA++;
                countPreContinuousB = 0;
            } else if (fruitB == null || fruit == fruitB) {
                fruitB = fruit;
                countB++;
                countPreContinuousA = 0;
                countPreContinuousB++;
            } else {
                if (countPreContinuousA > 0) {
                    fruitB = fruit;
                    countB = 1;
                    countPreContinuousB = 1;

                    countA = countPreContinuousA;
                    countPreContinuousA = 0;
                } else {
                    fruitA = fruit;
                    countA = 1;
                    countPreContinuousA = 1;

                    countB = countPreContinuousB;
                    countPreContinuousB = 0;
                }
            }
            ans = Math.max(ans, countA + countB);
        }
        return ans;
    }


    int ans;
    LinkedList<Integer> firstIndexList;
    LinkedList<Integer> secondIndexList;

    public int totalFruit2(int[] fruits) {
        int firstNum = -1;
        int secondNum = -1;
        this.firstIndexList = new LinkedList<>();
        this.secondIndexList = new LinkedList<>();
        int length = fruits.length;
        this.ans = 0;
        for (int i = 0; i < length; i++) {
            int fruit = fruits[i];
            if (firstNum == -1 || fruit == firstNum) {
                firstNum = fruit;
                firstIndexList.add(i);
                updateAns();
            } else if (secondNum == -1 || secondNum == fruit) {
                secondNum = fruit;
                secondIndexList.add(i);
                updateAns();
            } else {
                if (firstIndexList.peekLast() < secondIndexList.peekLast()) {
                    while (!secondIndexList.isEmpty() && secondIndexList.peekFirst() < firstIndexList.peekLast()) {
                        secondIndexList.pollFirst();
                    }
                    firstNum = secondNum;
                    firstIndexList = secondIndexList;
                } else {
                    while (!firstIndexList.isEmpty() && firstIndexList.peekFirst() < secondIndexList.peekLast()) {
                        firstIndexList.pollFirst();
                    }
                }
                secondNum = fruit;
                secondIndexList = new LinkedList<>();
                secondIndexList.add(i);
                updateAns();

            }
        }
        return ans;
    }

    public void updateAns() {
        Integer firstStart = firstIndexList.peekFirst();
        Integer firstEnd = firstIndexList.peekLast();
        Integer secondStart = secondIndexList.peekFirst();
        Integer secondEnd = secondIndexList.peekLast();
        int start = firstStart;
        if (secondStart != null) {
            start = Math.min(start,secondStart);
        }
        int end = firstEnd;
        if (secondEnd != null) {
            end = Math.max(end,secondEnd);
        }
        ans = Math.max(ans,end-start+1);
    }

    public static void main(String[] args) {
        TotalFruit totalFruit = new TotalFruit();
        System.out.println(3 == totalFruit.totalFruit(new int[]{0,1,0,2}));
        System.out.println(5 == totalFruit.totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
        System.out.println(4 == totalFruit.totalFruit(new int[]{1,2,3,2,2}));
        System.out.println(3 == totalFruit.totalFruit(new int[]{0,1,2,2}));
        System.out.println(3 == totalFruit.totalFruit(new int[]{1,2,1}));
    }
}
