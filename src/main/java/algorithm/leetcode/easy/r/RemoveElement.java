package algorithm.leetcode.easy.r;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int resetIndex = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] != val) {
                nums[resetIndex] = nums[i];
                resetIndex++;
            }
        }
        return resetIndex;
    }

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        System.out.println(2 == removeElement.removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println(5 == removeElement.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
    }
}
