package algorithm.leetcode.medium.f;

import java.util.HashMap;
import java.util.Map;

public class FindSubstringInWraproundString {

    public int findSubstringInWraproundString(String p) {
        int length = p.length();
        if (length == 1) {
            return 1;
        }
        Map<Character,Integer> map = new HashMap<>(26);
        int startIndex = 0;
        while (startIndex <= length-1) {
            int endIndex = length;
            for (int i = startIndex+1; i < length; i++) {
                if ((p.charAt(i) == 'a' && p.charAt(i-1) != 'z') ||
                        (p.charAt(i) != 'a' && p.charAt(i) - p.charAt(i-1) != 1)) {
                    endIndex = i;
                    break;
                }
            }
            String substring = p.substring(startIndex, endIndex);
            for (char c = 'a'; c <= 'z'; c++) {
                int index = substring.indexOf(c + "");
                if (index != -1) {
                    int l = endIndex-startIndex-index;
                    Integer oldMax = map.getOrDefault(c,0);
                    map.put(c,Math.max(oldMax,l));
                }
            }
            startIndex = endIndex;
        }
        int ans = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            ans += value;
        }
        return ans;
    }

    public static void main(String[] args) {
        FindSubstringInWraproundString findSubstringInWraproundString = new FindSubstringInWraproundString();
        System.out.println(findSubstringInWraproundString.findSubstringInWraproundString("zip"));
        System.out.println(findSubstringInWraproundString.findSubstringInWraproundString("zab"));
        System.out.println(findSubstringInWraproundString.findSubstringInWraproundString("a"));
        System.out.println(findSubstringInWraproundString.findSubstringInWraproundString("cac"));
    }
}
