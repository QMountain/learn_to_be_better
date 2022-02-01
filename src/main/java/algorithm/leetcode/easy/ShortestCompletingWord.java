package algorithm.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @ClassName ShortestCompletingWord
 * @Description 最短补全词
 * @Author qsf
 * Date   2021-12-10  0:11
 */
public class ShortestCompletingWord {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> charCount = this.getCharCount(licensePlate);

        String s = "";
        for (String word : words) {
            Map<Character, Integer> charCountOfWord = this.getCharCount(word);
            AtomicBoolean match = new AtomicBoolean(true);
            charCount.forEach((key, value) -> {
                if (charCountOfWord.getOrDefault(key, 0) < value) {
                    match.set(false);
                }
            });
            if (match.get()) {
                if (Objects.equals(s, "")) {
                    s = word;
                } else {
                    if (word.length() < s.length()) {
                        s = word;
                    }
                }
            }
        }
        return s;
    }

    public Map<Character,Integer> getCharCount(String str) {
        Map<Character,Integer> map = new HashMap<>(str.length());
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            boolean isSmallAToZ = c >= 'a' && c <= 'z';
            boolean isBigAToZ = c >= 'A' && c <= 'Z';
            if (isSmallAToZ || isBigAToZ) {
                if (isBigAToZ) {
                    c = (char) (c+32);
                }
                if (map.containsKey(c)) {
                    map.put(c,map.get(c)+1);
                } else {
                    map.put(c,1);
                }
            }
        }
        return map;
    }

    public static void main(String[] args) {

        ShortestCompletingWord shortestCompletingWord = new ShortestCompletingWord();

        String s = shortestCompletingWord.shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"});
        System.out.println(s);

        String s1 = shortestCompletingWord.shortestCompletingWord("1s3 456", new String[]{"looks", "pest", "stew", "show"});
        System.out.println(s1);

        String s2 = shortestCompletingWord.shortestCompletingWord("Ah71752", new String[]{"suggest","letter","of","husband","easy","education","drug","prevent","writer","old"});
        System.out.println(s2);
    }

}
