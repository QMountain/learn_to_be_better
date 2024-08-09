package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

// 数组排列求和
public class SumArrayArrangement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // nums = 1 8 9 7 4 2 5 6 3
        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // nums_sorted = 1 2 3 4 5 6 7 8 9
        int[] nums_sorted = Arrays.stream(nums).sorted().toArray();

        int n = nums.length;

        // 如果想要最后S最大，则 8 9 必须一组， 6 7 必须一组，4 5 必须一组，剩余1,2,3任意选哪一组都可以
        // 比如 1 8 9 一组, 4 2 5 一组, 6 3 7 一组， 可得最大S和为：8 + 4 + 6 = 18

        // 假设我们认为 8 9 是第三组，6 7 是第二组, 4 5 是第一组，1 2 3是第0组（第0组表示全适配
        // 那么讲nums[i] 映射为组号 groups[i]得规则如下
        int[] groups = Arrays.stream(nums).map(num -> {
            int idx = Arrays.binarySearch(nums_sorted, num);

            if (idx < n / 3) {
                // 对于处于nums_sorted数组前 n/3 个得元素都属于第0组
                return 0;
            } else {
                // 对于处于nums_sorted数组后 n * 2/3 个元素，每两个元素一组，从第1组开始计数
                return (idx - n / 3) / 2 + 1;
            }

        }).toArray();

        // 打印组号
        // System.out.println(Arrays.toString(groups));

        System.out.println(solution(groups));
    }

    public static int solution(int[] groups) {
        LinkedList<Integer> link = new LinkedList<>();
        for (int group : groups) {
            link.add(group);
        }

        LinkedList<Integer> link_reverse = new LinkedList<>(link);
        Collections.reverse(link_reverse);

        return Math.min(getCount(link), getCount(link_reverse));
    }

    public static int getCount(LinkedList<Integer> link) {
        int deposit_tail_zero = 0; // 等待插入的0的数量
        int count = 0; // 插入次数

        while (link.size() > 1) {
            // 取前三个数
            Integer g1 = link.removeFirst();
            Integer g2 = link.removeFirst();
            Integer g3 = link.removeFirst();

            // 状态: 0 x x
            // 含义是：第一个数为0，第二个、第三个数相同且不为0
            if (g1 == 0 && g2 != 0 && g2.equals(g3)) {
                continue;
            }

            // 状态: x 0 x
            if (g2 == 0 && g1 != 0 && g1.equals(g3)) {
                continue;
            }

            // 状态: x x 0
            if (g3 == 0 && g1 != 0 && g1.equals(g2)) {
                continue;
            }

            // 状态: 0 0 x 和 状态: 0 x 0
            if (g1 == 0 && g2 == 0 || g1 == 0 && g3 == 0) {
                // 上面状态多了一个0, 我们需要相办法讲多出的0插入到需要的地方
                // 但是该把多出的0插入到哪里呢？
                // 如果deposit_tail_zero < 0,  则前面循环中，有借0动作，因此本轮多了一个0，可以借给之前轮次, 因此本轮多出的0不需要消耗插入次数
                if (deposit_tail_zero >= 0) {
                    // 如果deposit_tail_zero >= 0, 则前面循环中，不需要借此轮多出的0，因此本轮多出的0要消耗一次插入次数，等待找到合适位置插入
                    count++;
                    link.addLast(g1); // 多出的0先记录到link尾部，原因是避免link元素数量不是3的倍数
                }

                // 等待插入的0数量+1
                deposit_tail_zero++;

                // g1被提取出去了， 剩下的两个数g2,g3重新头插获取
                link.addFirst(g3);
                link.addFirst(g2);
                continue;
            }

            // 状态: x 0 0
            if (g2 == 0 && g3 == 0) {
                // 逻辑和前面状态: 0 0 x 和 状态: 0 x 0一样
                if (deposit_tail_zero >= 0) {
                    count++;
                    link.addLast(g2);
                }
                deposit_tail_zero++;

                link.addFirst(g3);
                link.addFirst(g1);
                continue;
            }

            link.addFirst(g3);

            // 状态: 0 x y
            if (g1 == 0) {
                count++;
                link.remove(g2);
                continue;
            }

            // 状态: x 0 y
            if (g2 == 0) {
                count++;
                link.remove(g1);
                continue;
            }

            // 状态: x x y
            if (g1.equals(g2)) {
                if (deposit_tail_zero > 0) {
                    // 有等待插入得0,
                    link.removeLast();
                } else {
                    count++;
                }
                deposit_tail_zero--;
            } else {
                // 状态: x y z
                if (deposit_tail_zero > 0) {
                    // 有等待插入的0
                    link.removeLast();
                    deposit_tail_zero--;

                    // 等待插入0和开头x组合，则还需要一个x组的
                    link.remove(g1);
                    count++;
                } else {
                    count++;
                    link.add(link.indexOf(g1), g1);
                }

                link.addFirst(g2);

            }
        }

        return count;
    }
}
