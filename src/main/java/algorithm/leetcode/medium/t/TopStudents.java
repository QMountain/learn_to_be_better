package algorithm.leetcode.medium.t;

import java.util.*;

public class TopStudents {

    public List<Integer> topStudents(String[] positive_feedback,
                                     String[] negative_feedback,
                                     String[] report, int[] student_id, int k) {
        HashSet<String> positiveSet = new HashSet<>(Arrays.asList(positive_feedback));
        HashSet<String> negativeSet = new HashSet<>(Arrays.asList(negative_feedback));
        int length = student_id.length;
        // 分数不同，按照分数从高到低；分数相同，按照id从小到大
        // 0 student_id 1 score
        PriorityQueue<int[]> queue = new PriorityQueue<>(k, (a,b)->{
            if (a[1] != b[1]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        for (int i = 0; i < length; i++) {
            int score = 0;
            String r = report[i];
            String[] split = r.split(" ");
            for (String s : split) {
                if (positiveSet.contains(s)) {
                    score += 3;
                }
                else if (negativeSet.contains(s)) {
                    score -= 1;
                }
            }
            queue.add(new int[]{student_id[i], score});
        }
        List<Integer> ans = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            ans.add(queue.poll()[0]);
        }
        return ans;
    }

    public static void main(String[] args) {
        TopStudents topStudents = new TopStudents();
        System.out.println(topStudents.topStudents(
                new String[]{"smart","brilliant","studious"},
                new String[]{"not"},
                new String[]{"this student is not studious","the student is smart"},
                new int[]{1,2},
                2));
        System.out.println(topStudents.topStudents(new String[]{"smart", "brilliant", "studious"},
                new String[]{"not"},
                new String[]{"this student is studious","the student is smart"},
                new int[]{1,2},
                2));
    }
}
