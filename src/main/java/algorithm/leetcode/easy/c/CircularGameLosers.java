package algorithm.leetcode.easy.c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CircularGameLosers {

    public int[] circularGameLosers(int n, int k) {
        int[] arr = new int[n];
        arr[0] = 1;
        int index = 0;
        int bs = 1;
        while (true) {
            int currStep = bs * k;
            index = (index + currStep) % n;
            if (arr[index] == 1) {
                arr[index]++;
                break;
            }
            if (arr[index] == 0) {
                arr[index]++;
            }
            bs++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                list.add(i+1);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        CircularGameLosers circularGameLosers = new CircularGameLosers();
        System.out.println(Arrays.toString(circularGameLosers.circularGameLosers(4, 4)));
        System.out.println(Arrays.toString(circularGameLosers.circularGameLosers(5, 2)));
    }
}
