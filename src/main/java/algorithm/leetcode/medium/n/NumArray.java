package algorithm.leetcode.medium.n;

public class NumArray {

    int[] nums;
    int totalSum;
    int[] prefix;
    int validPreIndex;
    int[] suffix;
    int validSufIndex;

    public NumArray(int[] nums) {
        this.nums = nums;
        int length = nums.length;
        prefix = new int[length];
        prefix[0] = nums[0];
        for (int i = 1; i < length; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }
        totalSum = prefix[length-1];
        validPreIndex = length-1;
        suffix = new int[length];
        suffix[length-1] = nums[length-1];
        for (int i = length-2; i >= 0; i--) {
            suffix[i] = suffix[i+1] + nums[i];
        }
        validSufIndex = 0;
    }

    public void update(int index, int val) {
        if (validPreIndex >= index) {
            prefix[index] -= nums[index];
            prefix[index] += val;
            validPreIndex = index;
        }
        if (validSufIndex <= index) {
            suffix[index] -= nums[index];
            suffix[index] += val;
            validSufIndex = index;
        }
        totalSum -= nums[index];
        totalSum += val;
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        if (right <= validPreIndex) {
            if (left == 0) {
                return prefix[right];
            }
            return prefix[right] - prefix[left-1];
        }
        if (left >= validSufIndex) {
            if (right == nums.length-1) {
                return suffix[left];
            }
            return suffix[left] - suffix[right+1];
        }
        if (left > validPreIndex) {
            for (int i = validPreIndex+1; i <= left; i++) {
                prefix[i] = prefix[i-1] + nums[i];
                validPreIndex = i;
            }
        }
        if (right < validSufIndex) {
            for (int i = validSufIndex-1; i >= right; i--) {
                suffix[i] = suffix[i+1] + nums[i];
                validSufIndex = i;
            }
        }
        int cutLeft = 0;
        if (left > 0) {
            cutLeft = prefix[left-1];
        }
        int cutRight = 0;
        if (right < nums.length-1) {
            cutRight = suffix[right+1];
        }
        return totalSum - cutLeft - cutRight;
    }

    /*private final int[] sum; // sum[i] 表示第 i 个块的元素和
    private final int size; // 块的大小
    private final int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        size = (int) Math.sqrt(n);
        sum = new int[(n + size - 1) / size]; // n/size 向上取整
        for (int i = 0; i < n; i++) {
            sum[i / size] += nums[i];
        }
    }

    public void update(int index, int val) {
        sum[index / size] += val - nums[index];
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        int b1 = left / size, i1 = left % size, b2 = right / size, i2 = right % size;
        if (b1 == b2) { // 区间 [left, right] 在同一块中
            int sum = 0;
            for (int j = i1; j <= i2; j++) {
                sum += nums[b1 * size + j];
            }
            return sum;
        }
        int sum1 = 0;
        for (int j = i1; j < size; j++) {
            sum1 += nums[b1 * size + j];
        }
        int sum2 = 0;
        for (int j = 0; j <= i2; j++) {
            sum2 += nums[b2 * size + j];
        }
        int sum3 = 0;
        for (int j = b1 + 1; j < b2; j++) {
            sum3 += sum[j];
        }
        return sum1 + sum2 + sum3;
    }*/

    public static void main(String[] args) {
        NumArray numArray2 = new NumArray(new int[]{0,9,5,7,3});
        System.out.println(numArray2.sumRange(4, 4));
        System.out.println(numArray2.sumRange(2, 4));
        System.out.println(numArray2.sumRange(3, 3));
        numArray2.update(4,5);
        numArray2.update(1,7);
        numArray2.update(0,8);
        System.out.println(numArray2.sumRange(1, 2));
        numArray2.update(1,9);
        System.out.println(numArray2.sumRange(4, 4));
        numArray2.update(3,4);

        NumArray numArray = new NumArray(new int[]{1, 3, 5});
        System.out.println(numArray.sumRange(0, 2));
        numArray.update(1,2);
        System.out.println(numArray.sumRange(0, 2));
    }
}
