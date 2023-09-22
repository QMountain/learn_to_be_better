package algorithm.leetcode.easy.d;

public class DistMoney {

    public int distMoney(int money, int children) {
        if (money < children) {
            return -1;
        }
        if (money == children * 8) {
            return children;
        }
        int max = (money - children) / 7;
        max = Math.min(max, children-1);
        int leftMoney = money - (max * 8);
        int leftChildren = children - max;
        if (leftChildren < 1) {
            return max-1;
        }
        if (leftMoney < leftChildren) {
            return max-1;
        }
        if (leftMoney == 4 && children - max == 1) {
            return max-1;
        }
        return max;
    }

}
