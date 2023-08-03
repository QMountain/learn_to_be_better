package algorithm.leetcode.medium.r;

import java.util.LinkedList;
import java.util.List;

public class RemoveComments {

    public List<String> removeComments(String[] source) {
        LinkedList<String> ansList = new LinkedList<>();
        boolean duringBlock = false;
        for (int i = 0; i < source.length; i++) {
            String s = source[i];
            if (duringBlock) {
                while (duringBlock) {
                    int firstBlockEnd = s.indexOf("*/");
                    if (firstBlockEnd == -1) {
                        s = "";
                        break;
                    }
                    // 暂时块注释结束
                    duringBlock = false;
                    s = s.substring(firstBlockEnd+2);
                    int rowIndex = s.indexOf("//");
                    int blockStartIndex = s.indexOf("/*");
                    // 行注释生效
                    if (rowIndex != -1 && (blockStartIndex == -1 || rowIndex < blockStartIndex)) {
                        s = s.substring(0, rowIndex);
                        break;
                    }
                    // 块注释生效
                    if (blockStartIndex != -1 && (rowIndex == -1 || blockStartIndex < rowIndex)) {
                        duringBlock = true;
                        ansList.add(s.substring(0, blockStartIndex));
                        s = s.substring(blockStartIndex+2);
                    }
                }
                if (s.length() > 0) {
                    ansList.add(ansList.pollLast()+s);
                }
                continue;
            }
            // 不在块注释中
            int rowIndex = s.indexOf("//");
            int blockStartIndex = s.indexOf("/*");
            // 行注释生效
            // 1. 有行注释
            // 2. 没有块注释，或者块注释在后面
            if (rowIndex != -1 && (blockStartIndex == -1 || rowIndex < blockStartIndex)) {
                String substring = s.substring(0, rowIndex);
                if (substring.length() > 0) {
                    ansList.add(s.substring(0, rowIndex));
                }
                continue;
            }
            // 块注释生效
            // 1. 有块注释
            // 2. 没有行注释，或者行注释在后面
            if (blockStartIndex != -1 && (rowIndex == -1 || blockStartIndex < rowIndex)) {
                int blockEndIndex = s.indexOf("*/", blockStartIndex+2);
                if (blockEndIndex == -1) {
                    duringBlock = true;
                    String substring = s.substring(0, blockStartIndex);
                    if (substring.length() > 0) {
                        ansList.add(s.substring(0, blockStartIndex));
                    }
                    continue;
                } else {
                    source[i] = s.substring(0, blockStartIndex) + s.substring(blockEndIndex+2);
                    i--;
                }
                continue;
            }
            // 两种注释都不生效，视为有效代码
            if (s.length() > 0) {
                ansList.add(s);
            }
        }
        return ansList;
    }

    public static void main(String[] args) {
        RemoveComments removeComments = new RemoveComments();
        System.out.println(removeComments.removeComments(new String[]{
                "a/*/b//*c", "blank", "d/*/e*//f"}));
        System.out.println("[int main(), { ,   , int a, b, c;, a = b + c;, }]".equals(
                removeComments.removeComments(
                        new String[]{"/*Test program */", "int main()", "{ ",
                                "  // variable declaration ", "int a, b, c;", "/* This is a test",
                                "   multiline  ", "   comment for ", "   testing */",
                                "a = b + c;", "}"}).toString()));
        System.out.println(removeComments.removeComments(
                new String[]{"struct Node{", "    /*/ declare members;/**/",
                        "    int size;", "    /**/int val;", "};"}));
        System.out.println(removeComments.removeComments(
                new String[]{"class test{", "public: ", "   int x = 1;", "   /*double y = 1;*/",
                        "   char c;", "};"}));
        System.out.println("[ab]".equals(removeComments.removeComments(
                new String[]{"a/*comment", "line", "more_comment*/b"}).toString()));

        System.out.println("[af]".equals(removeComments.removeComments(
                new String[]{"a/*/b//*c","blank","d//*e/*/f"}).toString()));
        System.out.println("[main() {,   Node* p;,   ,    p->val = 1;,    , },  ]".equals(
                removeComments.removeComments(
                        new String[]{"main() {", "  Node* p;", "  /* declare a Node",
                                "  /*float f = 2.0", "   p->val = f;", "   /**/",
                                "   p->val = 1;", "   //*/ cout << success;*/", "}",
                                " "}).toString()));
    }
}
