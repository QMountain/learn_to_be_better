package algorithm.leetcode.medium.f;

public class FindUnsortedSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int length = nums.length;
        int unsortedStart = -1;
        for (int i = 1; i < length; i++) {
            if (nums[i] < nums[i-1]) {
                unsortedStart = i-1;
                break;
            }
        }
        if (unsortedStart == -1) {
            return 0;
        }
        int unsortedEnd = 0;
        for (int i = length-2; i >= 0; i--) {
            if (nums[i] > nums[i+1]) {
                unsortedEnd = i+1;
                break;
            }
        }
        int unsortedMin = nums[unsortedStart];
        int unsortedMax = nums[unsortedStart];
        for (int i = unsortedStart; i <= unsortedEnd; i++) {
            if (nums[i] < unsortedMin) {
                unsortedMin = nums[i];
            }
            if (nums[i] > unsortedMax) {
                unsortedMax = nums[i];
            }
        }
        if (unsortedStart > 0) {
            while (unsortedMin < nums[unsortedStart-1]) {
                if (--unsortedStart == 0) {
                    break;
                }
            }
        }
        if (unsortedEnd < length-1) {
            while (unsortedMax > nums[unsortedEnd+1]) {
                if (++unsortedEnd == length-1) {
                    break;
                }
            }
        }
        return unsortedEnd-unsortedStart+1;
    }

    public static void main(String[] args) {
        FindUnsortedSubarray findUnsortedSubarray = new FindUnsortedSubarray();
        System.out.println(findUnsortedSubarray.findUnsortedSubarray(new int[]{1,3,2,2,2}));
        System.out.println(findUnsortedSubarray.findUnsortedSubarray(new int[]{1}));
        System.out.println(findUnsortedSubarray.findUnsortedSubarray(new int[]{1,2,3,4}));
        System.out.println(findUnsortedSubarray.findUnsortedSubarray(new int[]{2,6,4,8,10,9,15}));
    }
}
