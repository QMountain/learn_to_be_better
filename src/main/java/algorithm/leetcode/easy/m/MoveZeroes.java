package algorithm.leetcode.easy.m;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0 && i != index) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index++;
            }
            if (nums[i] != 0 && i == index) {
                index++;
            }
        }
    }

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(new int[]{0,1,0,3,12});
        moveZeroes.moveZeroes(new int[]{2,1});
    }
}
