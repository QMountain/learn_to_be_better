package algorithm.leetcode.easy.f;

import java.util.ArrayList;
import java.util.List;

public class FindWordsContaining {

    /**
     * 2942. 查找包含给定字符的单词
     * 给你一个下标从 0 开始的字符串数组 words 和一个字符 x 。
     * 请你返回一个 下标数组 ，表示下标在数组中对应的单词包含字符 x 。
     * 注意 ，返回的数组可以是 任意 顺序。
     */
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (words[i].charAt(j) == x) {
                    ans.add(i);
                    break;
                }
            }
        }
        return ans;
    }

}
