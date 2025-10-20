package algorithm.leetcode.easy.f;

public class FinalValueAfterOperations {

    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for (String operation : operations) {
            if (operation.charAt(0) == '+' || operation.charAt(1) == '+') {
                ans++;
            } else {
                ans--;
            }
        }
        return ans;
    }

}
