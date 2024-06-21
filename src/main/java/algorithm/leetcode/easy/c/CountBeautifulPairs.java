package algorithm.leetcode.easy.c;

public class CountBeautifulPairs {

    // 2 <= nums.length <= 100
    // 1 <= nums[i] <= 9999
    // nums[i] % 10 != 0
    public int countBeautifulPairs(int[] nums) {
        int length = nums.length;
        int ans = 0;
        for (int i = 0; i < length - 1; i++) {
            int num1 = nums[i];
            while (num1 >= 10) {
                num1 /= 10;
            }
            if (num1 == 1) {
                ans += length - i - 1;
            } else {
                for (int j = i + 1; j < length; j++) {
                    if (isPrime(num1, nums[j])) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    public boolean isPrime(int num1, int num2) {
        num2 %= 10;
        if (num1 == 1 || num2 == 1) {
            return true;
        }
        if (num1 == num2) {
            return false;
        }
        if (num1 == 7 || num2 == 7) {
            return true;
        }
        int sum = num1 + num2;
        num1 = Math.max(num1, num2);
        num2 = sum - num1;
        if (num2 == 1) {
            return true;
        }
        while (num2 > 1 && num1 % num2 != 0) {
            int rem = num1 % num2;
            num1 = num2;
            num2 = rem;
        }
        return num2 == 1;
    }

    public static void main(String[] args) {
        CountBeautifulPairs countBeautifulPairs = new CountBeautifulPairs();
        System.out.println(183 == countBeautifulPairs.countBeautifulPairs(
                new int[]{756,1324,2419,495,106,111,1649,1474,2001,1633,273,1804,2102,1782,705,1529,1761,1613,111,186,412}));
        System.out.println(7 == countBeautifulPairs.countBeautifulPairs(
                new int[]{31,25,72,79,74}));
    }
}
