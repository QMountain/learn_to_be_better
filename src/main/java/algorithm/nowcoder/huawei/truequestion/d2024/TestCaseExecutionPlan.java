package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 测试用例执行计划
public class TestCaseExecutionPlan {

    static class TestCase {
        int id;
        int priority;

        public TestCase(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] tmp = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = tmp[0];
        int m = tmp[1];

        int[] features = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            features[i] = Integer.parseInt(sc.nextLine());
        }

        ArrayList<TestCase> cases = new ArrayList<>();

        for (int i = 1; i <= m; i++) {
            int priority =
                    Arrays.stream(sc.nextLine().split(" "))
                            .map(Integer::parseInt)
                            .map(id -> features[id])
                            .reduce(Integer::sum)
                            .orElse(0);

            cases.add(new TestCase(i, priority));
        }

        cases.stream()
                .sorted((a, b) -> a.priority != b.priority ? b.priority - a.priority : a.id - b.id)
                .map(testcase -> testcase.id)
                .forEach(System.out::println);
    }
}
