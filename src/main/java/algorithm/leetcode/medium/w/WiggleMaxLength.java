package algorithm.leetcode.medium.w;

import java.util.LinkedList;

public class WiggleMaxLength {

    public int wiggleMaxLength(int[] nums) {
        int length = nums.length;
        LinkedList<Integer> list = new LinkedList<>();
        list.add(nums[0]);
        boolean increase = false;
        int start = 1;
        for (int i = 1; i < length; i++) {
            if (nums[i] > list.peekLast()) {
                list.add(nums[i]);
                start = i;
                break;
            }
            if (nums[i] < list.peekLast()) {
                list.add(nums[i]);
                start = i;
                increase = true;
                break;
            }
        }
        for (int i = start+1; i < length; i++) {
            if (increase) {
                if (nums[i] > list.peekLast()) {
                    list.add(nums[i]);
                    increase = false;
                } else {
                    list.pollLast();
                    list.add(nums[i]);
                }
            } else {
                if (nums[i] < list.peekLast()) {
                    list.add(nums[i]);
                    increase = true;
                } else {
                    list.pollLast();
                    list.add(nums[i]);
                }
            }

        }
        return list.size();
    }

    public static void main(String[] args) {
        WiggleMaxLength wiggleMaxLength = new WiggleMaxLength();
        System.out.println(1 == wiggleMaxLength.wiggleMaxLength(new int[]{0,0}));
        System.out.println(2 == wiggleMaxLength.wiggleMaxLength(new int[]{1,2,3,4,5,6,7,8,9}));
        System.out.println(7 == wiggleMaxLength.wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}));
        System.out.println(6 == wiggleMaxLength.wiggleMaxLength(new int[]{1,7,4,9,2,5}));
    }
}
