package algorithm.leetcode.medium.s;

import java.util.Arrays;

public class SortColors {

    /**
     * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，
     * 原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
     */
    public void sortColors(int[] nums) {
        int length = nums.length;
        int writeZeroIndex = 0;
        int writeTwoIndex = length - 1;
        for (int i = 0; i < length && i <= writeTwoIndex; i++) {
            if (nums[i] == 2) {
                while (nums[writeTwoIndex] == 2) {
                    if (writeTwoIndex - 1 < writeZeroIndex) {
                        return;
                    }
                    writeTwoIndex--;
                }
                if (writeTwoIndex <= i) {
                    break;
                }
                nums[i] = nums[writeTwoIndex];
                nums[writeTwoIndex--] = 2;
                i--;
            } else if (nums[i] == 0) {
                while (nums[writeZeroIndex] == 0) {
                    if (writeZeroIndex + 1 > writeTwoIndex) {
                        return;
                    }
                    writeZeroIndex++;
                    i++;
                }
                if (writeZeroIndex < i) {
                    nums[i] = nums[writeZeroIndex];
                    nums[writeZeroIndex++] = 0;
                }
                i--;
            }
        }
    }

    public void sortColors2(int[] nums) {
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
        sortColors.sortColors(new int[]{2});
        sortColors.sortColors(new int[]{0});
        // [0,0,1,1,2,2]
        int[] arr = {2, 0, 2, 1, 1, 0};
        sortColors.sortColors(arr);
        System.out.println(Arrays.toString(arr));

        // [0,1,2]
        int[] arr2 = new int[]{2, 0, 1};
        sortColors.sortColors(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
