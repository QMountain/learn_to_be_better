package algorithm.leetcode.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @ClassName ScheduleCourse
 * @Description 课程表Ⅲ
 * @Author qsf
 * Date   2021-12-14  0:12
 */
public class ScheduleCourse {

    public int scheduleCourse(int[][] courses) {
        List<Integer> needDelete = new ArrayList<>(courses.length/3);
        for (int i = 0; i < courses.length; i++) {
            if (courses[i][0] > courses[i][1]) {
                needDelete.add(i);
            }
        }
        int[][] newCourses = new int[courses.length-needDelete.size()][2];
        if (needDelete.size() == 0) {
            newCourses = courses;
        } else {
            int j = 0;
            for (int i = 0; i < courses.length; i++) {
                if (!needDelete.contains(i)) {
                    newCourses[j][0] = courses[i][0];
                    newCourses[j][1] = courses[i][1];
                    j++;
                }
            }
        }
        if (newCourses.length == 0) {
            return 0;
        }
        if (newCourses.length == 1) {
            if (newCourses[0][0] > newCourses[0][1]) {
                return 0;
            }
            return 1;
        }

        Map<Integer,Integer> priorityMap = new TreeMap<>();
        for (int[] newCourse : newCourses) {
            priorityMap.put(newCourse[1], newCourse[0]);
        }
        int res = 0;
        int finishDay = 0;
        for (Map.Entry<Integer, Integer> entry : priorityMap.entrySet()) {
            Integer lastDay = entry.getKey();
            Integer duration = entry.getValue();
            if (finishDay + duration > lastDay) {
                return res;
            }
            finishDay += duration;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        ScheduleCourse scheduleCourse = new ScheduleCourse();
        /*System.out.println(scheduleCourse.scheduleCourse(new int[][]{{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}}));
        System.out.println(scheduleCourse.scheduleCourse(new int[][]{{1, 2}}));
        System.out.println(scheduleCourse.scheduleCourse(new int[][]{{3, 2},{4,3}}));*/
        System.out.println(scheduleCourse.scheduleCourse(new int[][]{{5, 5},{4,6},{2,6}}));
    }
}
