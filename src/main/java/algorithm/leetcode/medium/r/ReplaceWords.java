package algorithm.leetcode.medium.r;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReplaceWords {

    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> set = new HashSet<>(dictionary);
        String[] split = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            int length = s.length();
            boolean replace = false;
            for (int i = 0; i < length; i++) {
                String substring = s.substring(0, i);
                if (set.contains(substring)) {
                    sb.append(" ").append(substring);
                    replace = true;
                    break;
                }
            }
            if (!replace) {
                sb.append(" ").append(s);
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        ReplaceWords replaceWords = new ReplaceWords();
        List<String> dictionary = new ArrayList<>();
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");
        System.out.println(replaceWords.replaceWords(dictionary, "the cattle was rattled by the battery"));
    }
}
