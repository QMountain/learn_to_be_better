package algorithm.leetcode.easy;

import java.util.*;

public class LongestWord {

    public String longestWord(String[] words) {
        Map<Integer,Set<String>> lengthSetMap = new TreeMap<>();
        for (String word : words) {
            int length = word.length();
            Set<String> oldSet = lengthSetMap.getOrDefault(length, new TreeSet<>());
            oldSet.add(word);
            lengthSetMap.put(length,oldSet);
        }
        Set<Map.Entry<Integer, Set<String>>> entries = lengthSetMap.entrySet();
        int size = entries.size();
        List<Map.Entry<Integer, Set<String>>> entryList = new ArrayList<>(entries);
        for (int i = size-1; i >= 0; i--) {
            Map.Entry<Integer, Set<String>> entry = entryList.get(i);
            Integer wordLength = entry.getKey();
            Set<String> wordSet = entry.getValue();
            for (String s : wordSet) {
                boolean canMade = true;
                for (int j = 1; j <= wordLength; j++) {
                    String substring = s.substring(0, j);
                    Set<String> set = lengthSetMap.get(j);
                    if (set == null || set.size() == 0) {
                        canMade = false;
                        break;
                    }
                    if (!set.contains(substring)) {
                        canMade = false;
                        break;
                    }
                }
                if (canMade) {
                    return s;
                }
            }


        }

        return "";
    }

    public static void main(String[] args) {
        LongestWord longestWord = new LongestWord();
        /*System.out.println(longestWord.longestWord(new String[]{"w","wo","wor","worl", "world"}));
        System.out.println(longestWord.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));*/
        System.out.println(longestWord.longestWord(new String[]{"l","le","lel","lelelele"}));
    }
}
