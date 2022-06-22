package algorithm.leetcode.hard.r;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class RangeModule {

    List<int[]> segments;

    public RangeModule() {
        segments = new LinkedList<>();
    }

    public void addRange(int left, int right) {
        if (segments.size() == 0) {
            int[] arr = new int[2];
            arr[0] = left;
            arr[1] = right;
            segments.add(0,arr);
            return;
        }
        int min = segments.get(0)[0];
        int max = segments.get(segments.size()-1)[1];
        if (left <= min && right >= max) {
            int[] arr = new int[2];
            arr[0] = left;
            arr[1] = right;
            segments = Collections.singletonList(arr);
            return;
        }
        if (right < min) {
            int[] arr = new int[2];
            arr[0] = left;
            arr[1] = right;
            segments.add(0,arr);
            return;
        }
        if (right == min) {
            int[] arr = segments.get(0);
            arr[0] = left;
            return;
        }
        if (left > max) {
            int[] arr = new int[2];
            arr[0] = left;
            arr[1] = right;
            segments.add(arr);
            return;
        }
        if (left == max) {
            int[] arr = segments.get(segments.size()-1);
            arr[1] = right;
            return;
        }
        int size = segments.size();
        for (int[] arr : segments) {
            if (right <= arr[0] || left >= arr[1]) {
                continue;
            }
            if (right <= arr[1]) {
                if (left < arr[0]) {
                    addRange(left, arr[0]);
                    return;
                }
                return;
            }
            if (left < arr[0]) {
                addRange(left,arr[0]);
                addRange(arr[1],right);
                return;
            }
            addRange(arr[1], right);
        }
        int putIndex = -1;
        for (int i = 0; i < size-1; i++) {
            int[] arr = segments.get(i);
            int[] next = segments.get(i + 1);
            if (left >= arr[1] && right <= next[0]) {
                putIndex = i+1;
                break;
            }
        }
        int[] arr = new int[2];
        arr[0] = left;
        arr[1] = right;
        segments.add(putIndex,arr);
    }

    public boolean queryRange(int left, int right) {
        if (segments.size() == 0) {
            return false;
        }
        for (int[] segment : segments) {
            if (segment[0] >= right) {
                return false;
            }
            if (segment[1] <= left) {
                continue;
            }
            if (left >= segment[0]) {
                if (right <= segment[1]) {
                    return true;
                }
                return queryRange(segment[1],right);
            }
        }
        return false;
    }

    public void removeRange(int left, int right) {
        if (segments.size() == 0) {
            return;
        }
        for (int[] segment : segments) {
            if (segment[0] >= right) {
                return;
            }
            if (segment[1] <= left) {
                continue;
            }
            if (left >= segment[0]) {
                int old = segment[1];
                segment[1] = left;
                if (right <= segment[1]) {
                    addRange(right,old);
                    return;
                }
                return;
            }
        }
    }

    public static void main(String[] args) {
        RangeModule rangeModule = new RangeModule();
        System.out.println(rangeModule.queryRange(21, 34));
        System.out.println(rangeModule.queryRange(27, 87));
        rangeModule.addRange(44,53);
        rangeModule.addRange(69,89);
        System.out.println(rangeModule.queryRange(23, 26));
        System.out.println(rangeModule.queryRange(80, 84));
        System.out.println(rangeModule.queryRange(11, 12));
        rangeModule.removeRange(86,91);
        rangeModule.addRange(87,94);

        rangeModule.removeRange(1,3);
        rangeModule.addRange(1,8);


        System.out.println(rangeModule.queryRange(4, 6));
    }
}
