package algorithm.leetcode.easy.c;

public class CountStudents {

    public int countStudents(int[] students, int[] sandwiches) {
        int countStudent0 = 0;
        int countSandwich0 = 0;
        int length = students.length;
        for (int i = 0; i < length; i++) {
            if (students[i] == 0) {
                countStudent0++;
            }
            if (sandwiches[i] == 0) {
                countSandwich0++;
            }
        }
        if (countStudent0 == countSandwich0) {
            return 0;
        }
        if (countStudent0 > countSandwich0) {
            int count = countStudent0 - countSandwich0;
            for (int i = length-1; i >= 0; i--) {
                if (sandwiches[i] == 1) {
                    count--;
                    if (count == 0) {
                        return length-i;
                    }
                }
            }
        }
        int count = countSandwich0 - countStudent0;
        for (int i = length-1; i >= 0; i--) {
            if (sandwiches[i] == 0) {
                count--;
                if (count == 0) {
                    return length-i;
                }
            }
        }
        return 0;
    }

}
