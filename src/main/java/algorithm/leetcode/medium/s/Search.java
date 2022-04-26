package algorithm.leetcode.medium.s;

public class Search {

    public int search(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Search search = new Search();
        System.out.println(search.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }
}
