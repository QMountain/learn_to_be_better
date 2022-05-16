package algorithm.leetcode.medium.s;

public class SortColors {

    public void sortColors(int[] nums) {
        int length = nums.length;
        int countZero = 0;
        int countOne = 0;
        int countTwo = 0;
        for (int num : nums) {
            if (num == 0) {
                countZero++;
            } else if (num == 1) {
                countOne++;
            } else {
                countTwo++;
            }
        }
        for (int i = 0; i < countZero; i++) {
            nums[i] = 0;
        }
        for (int i = 0; i < countOne; i++) {
            nums[countZero+i] = 1;
        }
        for (int i = 0; i < countTwo; i++) {
            nums[countZero+countOne+i] = 2;
        }
    }

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        sortColors.sortColors(new int[]{2,0,2,1,1,0});
    }
}
