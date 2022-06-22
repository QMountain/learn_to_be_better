package algorithm.leetcode.hard;

import java.util.*;

public class FindSubstring {

    public List<Integer> findSubstring(String s, String[] words) {
        int sl = s.length();
        int wl = words[0].length();
        int wordSize = words.length;
        int matchSize = wl*wordSize;
        Map<String,Integer> map = new HashMap<>(wordSize);
        for (String word : words) {
            map.put(word,map.getOrDefault(word,0)+1);
        }
        List<Integer> list = new ArrayList<>(wordSize);
        for (int i = 0; i <= sl - matchSize; i++) {
            Map<String,Integer> cutMap = new HashMap<>(map);
            for (int j = 0; j < wordSize; j++) {
                String substring = s.substring(i + j * wl, i + j * wl + wl);
                if (!cutMap.containsKey(substring)) {
                    break;
                }
                Integer oldValue = cutMap.get(substring);
                if (oldValue > 1) {
                    cutMap.put(substring,oldValue-1);
                } else {
                    cutMap.remove(substring);
                }
                if (cutMap.size() == 0) {
                    list.add(i);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        FindSubstring findSubstring = new FindSubstring();
        System.out.println(findSubstring.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}));
        System.out.println(findSubstring.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
    }
}
