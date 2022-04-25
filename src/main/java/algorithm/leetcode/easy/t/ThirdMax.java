package algorithm.leetcode.easy.t;

public class ThirdMax {

    public int thirdMax(int[] nums) {
        int change = 0;
        Integer first = null;
        Integer second = null;
        Integer third = null;
        for (int num : nums) {
            if (first == null) {
                first = num;
                change++;
                continue;
            }
            if (num > first) {
                third = second;
                second = first;
                first = num;
                change++;
                continue;
            }
            if (num == first) {
                continue;
            }
            if (second == null) {
                second = num;
                change++;
                continue;
            }
            if (num > second && num < first) {
                third = second;
                second = num;
                change++;
                continue;
            }
            if (num == second) {
                continue;
            }
            if (third == null) {
                third = num;
                change++;
                continue;
            }
            if (num > third && num < second) {
                third = num;
                change++;
            }
        }
        return change >= 3 ? third : first;
    }

    public static void main(String[] args) {
        ThirdMax thirdMax = new ThirdMax();
        System.out.println(thirdMax.thirdMax(new int[]{5, 2, 2}));
        System.out.println(thirdMax.thirdMax(new int[]{1, 2, -2147483648}));
        System.out.println(thirdMax.thirdMax(new int[]{1, 1, 2}));
        System.out.println(thirdMax.thirdMax(new int[]{2, 2, 3, 1}));
        System.out.println(thirdMax.thirdMax(new int[]{3, 2, 1}));
    }
}
