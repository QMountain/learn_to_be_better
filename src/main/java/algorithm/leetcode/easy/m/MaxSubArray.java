package algorithm.leetcode.easy.m;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int ans = nums[0];
        int[] prefix = new int[length];
        prefix[0] = nums[0];
        for (int i = 1; i < length; i++) {
            prefix[i] = prefix[i-1]+nums[i];
            ans = Math.max(ans,nums[i]);
        }
        int[] min = new int[length];
        min[0] = prefix[0];
        for (int i = 1; i < length; i++) {
            min[i] = Math.min(prefix[i-1],prefix[i]);
            ans = Math.max(ans,prefix[i]);
        }
        int[] max = new int[length];
        max[length-1] = prefix[length-1];
        for (int i = length-2; i >= 0; i--) {
            max[i] = Math.max(prefix[i],max[i+1]);
        }
        for (int i = 0; i < length-1; i++) {
            int diff = max[i+1]-min[i];
            ans = Math.max(ans,diff);
        }
        return ans;
    }

    public int maxSubArray2(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        return getMax(nums,0,length-1);
    }

    public int getMax(int[] nums, int startIndex, int endIndex) {
        int max = nums[startIndex];
        while (nums[startIndex] <= 0 && startIndex <= endIndex) {
            max = Math.max(max,nums[startIndex]);
            startIndex++;
            if (startIndex > endIndex) {
                startIndex--;
                break;
            }
        }
        while (nums[endIndex] <= 0 && startIndex <= endIndex) {
            max = Math.max(max,nums[endIndex]);
            endIndex--;
            if (endIndex < 0 || startIndex > endIndex) {
                endIndex++;
                break;
            }
        }
        max = Math.max(max,nums[endIndex]);
        if (startIndex == endIndex) {
            return max;
        }
        int ns = startIndex+1;
        int sum = nums[startIndex];
        while (ns <= endIndex) {
            if (nums[ns] <= 0) {
                sum += nums[ns];
                ns++;
            } else {
                break;
            }
        }
        if (ns == endIndex) {
            sum -= nums[startIndex];
            sum += nums[endIndex];
            if (sum > 0) {
                return Math.max(sum+nums[startIndex],max);
            } else {
                return Math.max(nums[startIndex],max);
            }
        }
        if (sum > 0) {
            nums[ns] += sum;
            return Math.max(getMax(nums,ns,endIndex),max);
        }
        int nm = getMax(nums, ns, endIndex);
        return Math.max(max,Math.max(nm,nums[startIndex]));
    }

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(6 == maxSubArray.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(-1 == maxSubArray.maxSubArray(new int[]{-2,-1}));
        System.out.println(5 == maxSubArray.maxSubArray(new int[]{3,2,-3,-1,1,-3,1,-1}));
        System.out.println(2 == maxSubArray.maxSubArray(new int[]{-3,1,-2,2}));

        System.out.println(1 == maxSubArray.maxSubArray(new int[]{-2,1}));

        System.out.println(1 == maxSubArray.maxSubArray(new int[]{1}));
        System.out.println(23 == maxSubArray.maxSubArray(new int[]{5,4,-1,7,8}));
    }
}
