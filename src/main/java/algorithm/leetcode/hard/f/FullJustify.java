package algorithm.leetcode.hard.f;

import java.util.ArrayList;
import java.util.List;

public class FullJustify {

    // 1 <= words.length <= 300
    // 1 <= words[i].length <= 20
    // words[i] 由小写英文字母和符号组成
    // 1 <= maxWidth <= 100
    // words[i].length <= maxWidth
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int wordCount = 0;
        int totalLength = 0;
        for (int i = 0; i < words.length; i++) {
            int currLength = words[i].length();
            if (totalLength + currLength + wordCount > maxWidth) {
                int readIndex = i - wordCount;
                if (wordCount == 1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(words[readIndex]);
                    for (int j = 0; j < maxWidth - totalLength; j++) {
                        sb.append(" ");
                    }
                    ans.add(sb.toString());

                    totalLength = currLength;
                    continue;
                }
                int totalSpace = maxWidth - totalLength;
                int eachSpace = totalSpace / (wordCount - 1);
                int moreSpaceCount = totalSpace - (eachSpace * (wordCount - 1));
                StringBuilder sb = new StringBuilder();

                for (int j = 0; j < moreSpaceCount; j++) {
                    sb.append(words[readIndex++]);
                    for (int s = 0; s < eachSpace + 1; s++) {
                        sb.append(" ");
                    }
                }
                for (int j = 0; j < wordCount-moreSpaceCount-1; j++) {
                    sb.append(words[readIndex++]);
                    for (int s = 0; s < eachSpace; s++) {
                        sb.append(" ");
                    }
                }
                sb.append(words[i-1]);
                ans.add(sb.toString());

                wordCount = 1;
                totalLength = currLength;
            } else {
                wordCount++;
                totalLength += currLength;
            }
        }

        int lastSpace = maxWidth - (totalLength + wordCount - 1);
        StringBuilder sb = new StringBuilder();
        int readIndex = words.length - wordCount;
        for (int i = 0; i < wordCount - 1; i++) {
            sb.append(words[readIndex++]).append(" ");
        }
        sb.append(words[readIndex]);
        for (int i = 0; i < lastSpace; i++) {
            sb.append(" ");
        }
        ans.add(sb.toString());
        return ans;
    }

    public static void main(String[] args) {
        FullJustify fullJustify = new FullJustify();
        System.out.println(fullJustify.fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"}, 16));
        System.out.println(fullJustify.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
    }
}
