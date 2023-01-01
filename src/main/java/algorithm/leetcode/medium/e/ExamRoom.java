package algorithm.leetcode.medium.e;

import java.util.ArrayList;
import java.util.TreeSet;

public class ExamRoom {

    int n;
    int left;
    int right;
    TreeSet<Integer> set;

    public ExamRoom(int n) {
        this.n = n;
        this.left = -1;
        this.right = -1;
        set = new TreeSet<>();
    }

    public int seat() {
        if (left == -1) {
            set.add(0);
            left = 0;
            return 0;
        }
        if (right == -1) {
            set.add(n-1);
            right = n-1;
            return right;
        }
        int leftDistance = left;
        int rightDistance = n-1 - right;
        int midMaxPossibleDistance = (left + right) / 2;
        int lrMax = Math.max(leftDistance, rightDistance);
        int max = Math.max(lrMax, midMaxPossibleDistance);
        if (leftDistance == max) {
            set.add(0);
            left = 0;
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<>(set);
        int midMaxDistance = 0;
        int midMaxStart = 0;
        for (int i = 0; i < list.size()-1; i++) {
            int distance = (list.get(i + 1) - list.get(i)) / 2;
            if (distance > midMaxDistance) {
                midMaxDistance = distance;
                midMaxStart = list.get(i);
            }
        }
        if (midMaxDistance > lrMax) {
            int seat = midMaxStart + midMaxDistance;
            set.add(seat);
            return seat;
        }
        if (midMaxDistance == lrMax) {
            if (lrMax == leftDistance) {
                set.add(0);
                left = 0;
                return 0;
            }
            int seat = midMaxStart + midMaxDistance;
            set.add(seat);
            return seat;
        }
        if (lrMax == leftDistance) {
            set.add(0);
            left = 0;
            return 0;
        }
        set.add(n-1);
        right = n-1;
        return right;
    }

    public void leave(int p) {
        ArrayList<Integer> list = new ArrayList<>(set);
        if (p == list.get(0)) {
            set.remove(list.get(0));
            if (list.size() > 1) {
                left = list.get(1);
            } else if (right != p){
                left = right;
            } else {
                left = -1;
                right = -1;
            }
        } else if (p == list.get(list.size()-1)){
            set.remove(list.get(list.size()-1));
            if (list.size() > 1) {
                right = list.get(list.size()-2);
            } else if (left != p) {
                right = left;
            } else {
                left = -1;
                right = -1;
            }
        } else {
            set.remove(p);
        }
    }

    public static void main(String[] args) {
        /*ExamRoom examRoom = new ExamRoom(10);
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        examRoom.leave(4);
        System.out.println(examRoom.seat());*/

        /*ExamRoom examRoom = new ExamRoom(4);
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        examRoom.leave(1);
        examRoom.leave(3);
        System.out.println(examRoom.seat());*/

        ExamRoom examRoom = new ExamRoom(10);
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        examRoom.leave(0);
        examRoom.leave(9);
        System.out.println(examRoom.seat());
    }

}
