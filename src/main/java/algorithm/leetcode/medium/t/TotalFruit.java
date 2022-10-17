package algorithm.leetcode.medium.t;

import java.util.LinkedList;

public class TotalFruit {

    int ans;
    LinkedList<Integer> firstIndexList;
    LinkedList<Integer> secondIndexList;

    public int totalFruit(int[] fruits) {
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
