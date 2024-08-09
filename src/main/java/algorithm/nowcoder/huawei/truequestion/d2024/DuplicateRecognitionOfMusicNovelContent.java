package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 音乐小说内容重复识别
public class DuplicateRecognitionOfMusicNovelContent {

    // ufs可以判断任意两个字符串是否相似
    static UnionFindSet ufs = new UnionFindSet();

    // 记录字符串和其对应的正则串
    static HashMap<String, String> map = new HashMap<>();

    // 记录相似对
    static ArrayList<String> simi = new ArrayList<>();
    // 记录不相似对
    static ArrayList<String> diff = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.nextLine();
        String b = sc.nextLine();

        while (sc.hasNextLine()) {
            String[] words = sc.nextLine().split(" ");

            for (String word : words) {
                if (word.contains("***")) {
                    // *** 的功能起始就是 .* 正则功能, 因此我想使用正则.*来代替***完成匹配能力，但是用例又把***和()放在一起，而()又是正则元字符，但是用例意思又是把()当成普通字符，那我只能转义了
                    // 同理处理 '[', ']' 字符的转义
                    map.put(word, word.replace("***", ".*").replace("(", "\\(").replace(")", "\\)").replace("[", "\\[").replace("]", "\\]"));
                } else {
                    // 不含***的字符，就是普通字符匹配
                    map.put(word, word);
                }
            }

            // ufs并查集改造，用于关联相似字符串
            ufs.init(words);
            for (int i = 1; i < words.length; i++) {
                ufs.union(words[0], words[i]);
            }

            // 如果一行输入只有一个单词，则这个单词和客串""相似
            if (words.length == 1) {
                ufs.union(words[0], "");
                map.put("", "");
            }
        }

        // 比对a,b串
        compare(a, b);

        if (diff.isEmpty()) {
            // 如果没有不相似串
            System.out.println("True");
            simi.forEach(System.out::println);
        } else {
            // 如果有不相似串
            System.out.println("False");
            diff.forEach(System.out::println);
        }
    }

    public static void compare(String a, String b) {
        if (a.isEmpty() && b.isEmpty()) {
            return;
        }

        // 开头优先相似对比较（字符对比）
//        for (String word1 : ufs.fa.keySet()) {
//            if (!a.startsWith(word1)) continue;
//
//            for (String word2 : ufs.fa.keySet()) {
//                if (!b.startsWith(word2)) continue;
//
//                if (word1.isEmpty() && word2.isEmpty()) continue;
//
//                // a以word1开头，b以word2开头
//                // word1和word2相似
//                if (ufs.find(word1).equals(ufs.find(word2))) {
//                    simi.add(word1 + " " + word2);
//                    // a去除word1头部, b去除word2头部后，继续比较剩余部分
//                    compare(a.substring(word1.length()), b.substring(word2.length()));
//                    return;
//                }
//            }
//        }

        // a,b开头优先进行相似对比较（模式对比）
        for (String word1 : map.keySet()) {
            String regex1 = map.get(word1);
            Matcher matcher1 = Pattern.compile(regex1).matcher(a);
            if (!matcher1.find() || matcher1.start() != 0) continue;

            for (String word2 : map.keySet()) {
                String regex2 = map.get(word2);
                Matcher matcher2 = Pattern.compile(regex2).matcher(b);
                if (!matcher2.find() || matcher2.start() != 0) continue;

                if (word1.isEmpty() && word2.isEmpty()) continue;

                // a串以word1匹配开头，b串以word2匹配开头
                // word1和word2相似
                if (ufs.find(word1).equals(ufs.find(word2))) {
                    // word1和word2不相等
                    if (!word1.equals(word2)) {
                        simi.add(word1 + " " + word2);
                    }
                    compare(a.substring(matcher1.group().length()), b.substring(matcher2.group().length()));
                    return;
                }
            }
        }

        // a,b开头如果无法形成相似对，则逐个字符比较
        if (!a.isEmpty() && !b.isEmpty() && a.charAt(0) == b.charAt(0)) {
            compare(a.substring(1), b.substring(1));
        } else {
            // 如果a,b开头无法形成相似对，且开头字符也不一样，则整体不相似
            // 比如题目用例认为：成语 和 论语 整体不相似，而不是 成 和 论 局部不相似
            diff.add(a + " " + b);
        }
    }

    // 字符串并查集实现
    static class UnionFindSet {
        HashMap<String, String> fa = new HashMap<>();

        public void init(String[] words) {
            for (String word : words) {
                fa.putIfAbsent(word, word);
            }
        }

        public String find(String s) {
            if (!this.fa.containsKey(s) || s.equals(this.fa.get(s))) {
                return s;
            } else {
                this.fa.put(s, this.find(this.fa.get(s)));
                return this.fa.get(s);
            }
        }

        public void union(String x, String y) {
            String x_fa = this.find(x);
            String y_fa = this.find(y);

            if (!x_fa.equals(y_fa)) {
                this.fa.put(y_fa, x_fa);
            }
        }
    }
}
