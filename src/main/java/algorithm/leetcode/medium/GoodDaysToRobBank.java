package algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class GoodDaysToRobBank {

    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int length = security.length;
        if (length < time*2) {
            return new ArrayList<>();
        }
        
        List<Integer> resList = new ArrayList<>(length-time*2);
        if (time == 0) {
            for (int i = 0; i < security.length; i++) {
                resList.add(i);
            }
            return resList;
        }
        for (int i = time; i < length - time;) {
            if (resList.size() > 0 && resList.get(resList.size() - 1) == i-1) {
                if (security[i-1] == security[i] && security[i+time-1] <= security[i+time]) {
                    resList.add(i);
                }
            } else {
                // check left not increase
                boolean leftDecrease = true;
                for (int j = i-time; j < i; j++) {
                    if (security[j] < security[j + 1]) {
                        leftDecrease = false;
                        break;
                    }
                }
                // check right not decrease
                boolean rightIncrease = true;
                for (int j = i; j < i + time; j++) {
                    if (security[j] > security[j + 1]) {
                        rightIncrease = false;
                        break;
                    }
                }
                if (leftDecrease && rightIncrease) {
                    resList.add(i);
                }
            }

            if (resList.size() > 0 && resList.get(resList.size()-1) == i && security[i+1] > security[i]) {
                i += time;
            } else {
                i++;
            }

        }
        
        return resList;
    }

    public static void main(String[] args) {
        GoodDaysToRobBank goodDaysToRobBank = new GoodDaysToRobBank();
        System.out.println(goodDaysToRobBank.goodDaysToRobBank(new int[]{5, 3, 3, 3, 5, 6, 2}, 2));
        System.out.println(goodDaysToRobBank.goodDaysToRobBank(new int[]{1,1,1,1,1}, 0));
        System.out.println(goodDaysToRobBank.goodDaysToRobBank(new int[]{1,2,3,4,5,6}, 2));
        System.out.println(goodDaysToRobBank.goodDaysToRobBank(new int[]{1}, 5));
        System.out.println(goodDaysToRobBank.goodDaysToRobBank(new int[]{1,2,5,4,1,0,2,4,5,3,1,2,4,3,2,4,8}, 2));
    }
}
