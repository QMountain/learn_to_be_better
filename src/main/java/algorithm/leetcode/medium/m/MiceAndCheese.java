package algorithm.leetcode.medium.m;

import java.util.ArrayList;
import java.util.List;

public class MiceAndCheese {

    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int length = reward1.length;
        int ans = 0;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(new int[]{reward1[i] - reward2[i], i});
        }
        list.sort((a,b)-> b[0] - a[0]);
        for (int i = 0; i < k && i < list.size(); i++) {
            ans += reward1[list.get(i)[1]];
        }
        for (int i = k; i < list.size(); i++) {
            ans += reward2[list.get(i)[1]];
        }
        return ans;
    }

    public static void main(String[] args) {
        MiceAndCheese miceAndCheese = new MiceAndCheese();
        System.out.println(1 == miceAndCheese.miceAndCheese(
                new int[]{1}, new int[]{4}, 1));
        System.out.println(24 == miceAndCheese.miceAndCheese(
                new int[]{1,4,4,6,4}, new int[]{6,5,3,6,1}, 1));
        System.out.println(2 == miceAndCheese.miceAndCheese(
                new int[]{1,1}, new int[]{1,1}, 2));
        System.out.println(15 == miceAndCheese.miceAndCheese(
                new int[]{1,1,3,4}, new int[]{4,4,1,1}, 2));
    }
}
