package algorithm.leetcode.medium.s;

public class Search {

    int[] nums;
    int length;
    int target;

    // 题号81.搜索旋转排序数组II
    public boolean search(int[] nums, int target) {
        this.nums = nums;
        this.length = nums.length;
        this.target = target;
        if (length == 1) {
            return nums[0] == target;
        }
        if (target < nums[0] && target > nums[length-1]) {
            return false;
        }
        return binarySearch(0,length-1);
    }

    public boolean binarySearch(int left, int right) {
        while (left < right) {
            if (left + 1 == right) {
                if (nums[left] == target) {
                    return true;
                }
                return nums[right] == target;
            }
            int mid = (left+right)/2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > nums[mid+1]) {
                if (nums[mid] < target) {
                    return false;
                }
                if (binarySearchOrdered(left,mid)) {
                    return true;
                }
                return binarySearchOrdered(mid+1,right);
            }
            if (binarySearch(mid+1, right)) {
                return true;
            }
            return binarySearch(left,mid);
        }
        return nums[left] == target;
    }

    public boolean binarySearchOrdered(int left, int right) {
        while (left < right) {
            if (left + 1 == right) {
                if (nums[left] == target) {
                    return true;
                }
                return nums[right] == target;
            }
            int mid = (left+right)/2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return nums[left] == target;
    }

    public int search2(int[] nums, int target) {
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
        System.out.println(search.search(new int[]{2,5,6,0,0,1,2}, 3));
        System.out.println(search.search(new int[]{2,5,6,0,0,1,2}, 0));
        System.out.println(search.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }
}
