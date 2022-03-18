package algorithm.nowcoder;

import java.util.HashMap;
import java.util.Map;

public class HuaweiTwo {

    public static String poker(String s1, String s2) {
        String[] split1 = s1.split("-");
        String[] split2 = s2.split("-");
        Map<String,Integer> charCountMap = new HashMap<>(12);
        for (String s : split1) {
            Integer oldCount = charCountMap.getOrDefault(s, 0);
            charCountMap.put(s, oldCount + 1);
        }
        for (String s : split2) {
            Integer oldCount = charCountMap.getOrDefault(s, 0);
            charCountMap.put(s, oldCount + 1);
        }
        StringBuilder combine = new StringBuilder();
        for (int i = 3; i < 11; i++) {
            Integer count = charCountMap.getOrDefault(i+"", 0);
            if (count < 4) {
                combine.append(i);
            }
        }
        if (charCountMap.getOrDefault("J",0) < 4) {
            combine.append("J");
        }
        if (charCountMap.getOrDefault("Q",0) < 4) {
            combine.append("Q");
        }
        if (charCountMap.getOrDefault("K",0) < 4) {
            combine.append("K");
        }
        if (charCountMap.getOrDefault("A",0) < 4) {
            combine.append("A");
        }
        String com = combine.toString();
        com = com.replaceFirst("10","B");
        int length = com.length();
        if (length < 5) {
            return "NO-CHAIN";
        }
        String longest = "3456789BJQKA";
        int longestLen = longest.length();
        int cutSize = 0;
        String preparedStr = "";
        while (cutSize <= longestLen-5) {
            int leftSize = longestLen-cutSize;
            for (int i = 0; i <= cutSize; i++) {
                String substring = longest.substring(i, i + leftSize);
                if (com.contains(substring)) {
                    preparedStr = substring;
                    cutSize = longestLen;
                    break;
                }
            }
            cutSize++;
        }
        if ("".equals(preparedStr)) {
            return "NO-CHAIN";
        }
        StringBuilder resStr = new StringBuilder(preparedStr.charAt(0) + "");
        int pl = preparedStr.length();
        for (int i = 1; i < pl; i++) {
            resStr.append("-").append(preparedStr.charAt(i));
        }
        String res = resStr.toString();

        return res.replaceFirst("B","10");
    }

    public static void main(String[] args) {
        System.out.println(HuaweiTwo.poker(
                "3-3-3-3-4-4-5-5-6-7-8-9-10-J-Q-K-A",
                "4-5-6-7-8-8-8"));
        System.out.println(HuaweiTwo.poker(
                "3-3-3-3-8-8-8-8",
                "K-K-K-K"));
    }
}
