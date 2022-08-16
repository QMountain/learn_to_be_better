package algorithm.leetcode.medium.r;

import java.util.ArrayList;
import java.util.List;

public class ReverseWords {

    public String reverseWords(String s) {
        List<String> list = new ArrayList<>();
        int length = s.length();
        int lastIndex = 0;
        while (lastIndex < length) {
            int index = s.indexOf(" ",lastIndex);
            if (index == -1) {
                list.add(s.substring(lastIndex).trim());
                break;
            }
            String substring = s.substring(lastIndex, index).trim();
            if (!substring.equals("")) {
                list.add(substring);
            }
            lastIndex = index+1;
        }
        int size = list.size();
        String[] arr = new String[size];
        for (int i = 0; i < size; i++) {
            arr[i] = list.get(i);
        }
        for (int i = 0; i < size / 2; i++) {
            String temp = arr[i];
            arr[i] = arr[size-1-i];
            arr[size-1-i] = temp;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]);
        for (int i = 1; i < size; i++) {
            sb.append(" ");
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        System.out.println(reverseWords.reverseWords("a good   example"));
        System.out.println(reverseWords.reverseWords("  hello world  "));
        System.out.println(reverseWords.reverseWords("the sky is blue"));
    }
}
