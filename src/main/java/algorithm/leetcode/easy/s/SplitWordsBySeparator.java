package algorithm.leetcode.easy.s;

import java.util.ArrayList;
import java.util.List;

public class SplitWordsBySeparator {

    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> ansList = new ArrayList<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != separator) {
                    sb.append(word.charAt(i));
                } else if (sb.length() > 0) {
                    ansList.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
            if (sb.length() > 0) {
                ansList.add(sb.toString());
            }
        }
        return ansList;
    }

}
