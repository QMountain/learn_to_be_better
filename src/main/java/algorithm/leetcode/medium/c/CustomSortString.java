package algorithm.leetcode.medium.c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomSortString {

    public String customSortString(String order, String s) {
        int ol = order.length();
        Map<Character,Integer> map = new HashMap<>();
        List<List<Character>> totalList = new ArrayList<>(ol);
        for (int i = 0; i < ol; i++) {
            totalList.add(new ArrayList<>());
            map.put(order.charAt(i),i);
        }
        StringBuilder sb = new StringBuilder();
        int sl = s.length();
        for (int i = 0; i < sl; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                totalList.get(map.get(c)).add(c);
            } else {
                sb.append(c);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (List<Character> list : totalList) {
            for (Character c : list) {
                ans.append(c);
            }
        }
        ans.append(sb);
        return ans.toString();
    }

    public static void main(String[] args) {
        CustomSortString customSortString = new CustomSortString();
        System.out.println(customSortString.customSortString("cbafg", "abcd"));
        System.out.println(customSortString.customSortString("cba", "abcd"));
    }
}
