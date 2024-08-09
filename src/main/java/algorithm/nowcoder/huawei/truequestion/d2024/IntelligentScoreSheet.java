package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringJoiner;

// 智能成绩表
public class IntelligentScoreSheet {

    static class Student {
        String name; // 学生姓名
        int[] rank; // 排名要素

        public Student(String name, int[] rank) {
            this.name = name;
            this.rank = rank;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 学生人数
        int n = sc.nextInt();

        // 科目数量
        int m = sc.nextInt();

        // key是科目名称，val是科目出现顺序的序号
        HashMap<String, Integer> subject_rankIdx = new HashMap<>();
        for (int i = 0; i < m; i++) {
            subject_rankIdx.put(sc.next(), i);
        }

        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // 学生姓名
            String name = sc.next();

            // rank记录学生排名的要素（0~m-1索引上记录的是各科成绩，m索引上记录的是总分）
            int[] rank = new int[m + 1];
            // 学生的总分
            int score_sum = 0;

            // m 个科目成绩
            for (int j = 0; j < m; j++) {
                rank[j] = sc.nextInt();
                score_sum += rank[j];
            }

            rank[m] = score_sum;

            students.add(new Student(name, rank));
        }

        // 输入用作排名的科目名称
        // 根据用作排名的科目名称获取对应排名要素序号，如果不存在，则按总分排序，排名要素序号取m
        int rankIdx = subject_rankIdx.getOrDefault(sc.next(), m);

        students.sort(
                (a, b) ->
                        a.rank[rankIdx] != b.rank[rankIdx]
                                ? b.rank[rankIdx] - a.rank[rankIdx]
                                : a.name.compareTo(b.name));

        StringJoiner sj = new StringJoiner(" ");
        for (Student student : students) {
            sj.add(student.name);
        }

        System.out.println(sj);
    }
}
