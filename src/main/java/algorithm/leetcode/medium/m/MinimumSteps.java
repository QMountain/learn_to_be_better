package algorithm.leetcode.medium.m;

public class MinimumSteps {

    public long minimumSteps(String s) {
        char[] charArray = s.toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        int continuousOne = 0;
        long ans = 0L;
        while (left < right) {
            if (charArray[left] == '0') {
                left++;
            } else if (charArray[right] == '1') {
                right--;
            } else {
                for (int i = left+1; i <= right; i++) {
                    if (charArray[i] == '0') {
                        ans += i - left + continuousOne;
                        charArray[i] = '1';
                        charArray[left-continuousOne] = '0';
                        continuousOne += i - left - 1;
                        left = i;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MinimumSteps minimumSteps = new MinimumSteps();
        System.out.println(18 == minimumSteps.minimumSteps("001010100011101"));
        System.out.println(0 == minimumSteps.minimumSteps("0111"));
        System.out.println(2 == minimumSteps.minimumSteps("100"));
        System.out.println(1 == minimumSteps.minimumSteps("101"));
    }
}
