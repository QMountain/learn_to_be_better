package algorithm.leetcode.medium.m;

import java.util.*;

public class MaxSumDivThree {

    // 题号 1262 可被三整除的最大和
    // 1 <= nums.length <= 4 * 10^4
    // 时间 89.09%  空间24.33%
    public int maxSumDivThree(int[] nums) {
        int zero = 0;
        int one = Integer.MIN_VALUE;
        int two = Integer.MIN_VALUE;
        for (int num : nums) {
            int currMod = num % 3;
            if (currMod == 0) {
                zero += num;
                one += num;
                two += num;
            } else {
                int oldZero = zero;
                int oldOne = one;
                int oldTwo = two;
                if (currMod == 1) {
                    zero = Math.max(oldTwo + num, oldZero);
                    one = Math.max(oldZero + num, oldOne);
                    two = Math.max(oldOne + num, oldTwo);
                } else {
                    zero = Math.max(oldOne + num, oldZero);
                    one = Math.max(oldTwo + num, oldOne);
                    two = Math.max(oldZero + num, oldTwo);
                }
            }
        }
        return zero;
    }

    // 题号 1262 可被三整除的最大和
    // 1 <= nums.length <= 4 * 10^4
    // 时间 45.62%  空间33.99%
    public int maxSumDivThree2(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 3 == 0) {
            return sum;
        }
        Arrays.sort(nums);
        TreeSet<Integer> possibleCut = new TreeSet<>();
        int lastSuccessMinCut = sum;
        for (int num : nums) {
            if (!possibleCut.isEmpty()
                    && possibleCut.last() < num
                    && (sum - num) % 3 == 0
                    && sum - num < lastSuccessMinCut) {
                return sum - num;
            }
            if (num > lastSuccessMinCut) {
                break;
            }
            List<Integer> list = new ArrayList<>(possibleCut.size()+1);
            list.add(num);
            if ((sum - num) % 3 == 0) {
                lastSuccessMinCut = num;
            }
            for (Integer i : possibleCut) {
                list.add(i + num);
                if ((sum - i - num) % 3 == 0 && sum - i - num < lastSuccessMinCut) {
                    lastSuccessMinCut = i + num;
                }
            }
            possibleCut.addAll(list);
        }
        return sum - lastSuccessMinCut;
    }

    public static void main(String[] args) {
        MaxSumDivThree maxSumDivThree = new MaxSumDivThree();
        System.out.println(49701 == maxSumDivThree.maxSumDivThree(
                new int[]{972,944,817,475,436,623,900,268,25,263,627,799,38,943,968,17,813,139,772,333,498,593,567,556,550,40,4,862,915,935,366,253,994,893,47,211,332,854,73,694,37,63,789,785,419,129,170,404,854,424,712,784,539,697,478,978,509,76,528,65,194,352,986,713,730,223,858,366,71,18,60,8,835,70,349,905,446,593,909,592,95,280,900,887,303,245,612,708,7,58,564,577,718,410,512,637,535,432,332,770}));
        System.out.println(195 == maxSumDivThree.maxSumDivThree(new int[]{2,3,36,8,32,38,3,30,13,40}));
        System.out.println(6 == maxSumDivThree.maxSumDivThree(new int[]{3,1,2}));
        System.out.println(15 == maxSumDivThree.maxSumDivThree(new int[]{2,6,2,2,7}));
        System.out.println(12 == maxSumDivThree.maxSumDivThree(new int[]{1,2,3,4,4}));
        System.out.println(0 == maxSumDivThree.maxSumDivThree(new int[]{4}));
        System.out.println(18 == maxSumDivThree.maxSumDivThree(new int[]{3,6,5,1,8}));
    }
}
