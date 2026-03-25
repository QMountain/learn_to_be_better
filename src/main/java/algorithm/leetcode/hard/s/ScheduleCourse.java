package algorithm.leetcode.hard.s;

import java.util.*;

public class ScheduleCourse {

    /**
     * 630. 课程表 III
     * 这里有 n 门不同的在线课程，按从 1 到 n 编号。
     * 给你一个数组 courses ，其中 courses[i] = [durationi, lastDayi]
     * 表示第 i 门课将会 持续 上 durationi 天课，并且必须在不晚于 lastDayi 的时候完成。
     * 你的学期从第 1 天开始。且不能同时修读两门及两门以上的课程。
     * 返回你最多可以修读的课程数目。
     * 1 <= courses.length <= 10^4
     * 1 <= durationi, lastDayi <= 10^4
     */
    public int scheduleCourse(int[][] courses) {
        // 按照课程的截止日期排序
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        
        // 使用最大堆来存储已选课程的持续时间
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        int currentTime = 0;
        int courseCount = 0;
        
        for (int[] course : courses) {
            int duration = course[0];
            int lastDay = course[1];
            
            // 如果当前课程可以选
            if (currentTime + duration <= lastDay) {
                currentTime += duration;
                maxHeap.offer(duration);
                courseCount++;
            } else if (!maxHeap.isEmpty() && maxHeap.peek() > duration) {
                // 如果当前课程不能选，但之前选的最长课程比当前课程长
                // 则替换掉最长的课程
                currentTime = currentTime - maxHeap.poll() + duration;
                maxHeap.offer(duration);
            }
        }
        
        return courseCount;
    }

    public static void main(String[] args) {
        ScheduleCourse scheduleCourse = new ScheduleCourse();
        // 测试用例1
        System.out.println("测试用例1: " + scheduleCourse.scheduleCourse(new int[][]{{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}}));
        // 预期结果: 3 (选择课程 [100,200], [200,1300], [1000,1250])

        // 测试用例2
        System.out.println("测试用例2: " + scheduleCourse.scheduleCourse(new int[][]{{1, 2}}));
        // 预期结果: 1

        // 测试用例3
        System.out.println("测试用例3: " + scheduleCourse.scheduleCourse(new int[][]{{3, 2},{4,3}}));
        // 预期结果: 0 (两门课都无法完成)

        // 测试用例4
        System.out.println("测试用例4: " + scheduleCourse.scheduleCourse(new int[][]{{5, 5},{4,6},{2,6}}));
        // 预期结果: 2 (选择课程 [2,6] 和 [4,6])

        // 测试用例5
        System.out.println("测试用例5: " + scheduleCourse.scheduleCourse(new int[][]{{7,17},{3,12},{10,20},{9,10},{5,20},{7,19},{4,18}}));
        // 预期结果: 4
    }
}
