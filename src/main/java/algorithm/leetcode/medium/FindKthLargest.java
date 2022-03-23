package algorithm.leetcode.medium;

public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        int index = 0;
        while (index < k) {
            for (int i = index+1; i < length; i++) {
                if (nums[i] > nums[index]) {
                    int temp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = temp;
                }
            }
            if (index == k-1) {
                return nums[index];
            }
            index++;
        }
        return 0;
    }

    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();
        System.out.println(5 == findKthLargest.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(4 == findKthLargest.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}
