package algorithm.leetcode.easy.h;

public class HaveConflict {

    public boolean haveConflict(String[] event1, String[] event2) {
        return !(smaller(event1[1], event2[0]) || smaller(event2[1], event1[0]));
    }

    public boolean smaller(String s1, String s2) {
        int h1 = Integer.parseInt(s1.substring(0, 2));
        int h2 = Integer.parseInt(s2.substring(0, 2));
        if (h1 < h2) {
            return true;
        }
        if (h1 > h2) {
            return false;
        }
        int m1 = Integer.parseInt(s1.substring(3));
        int m2 = Integer.parseInt(s2.substring(3));
        return m1 < m2;
    }

    public static void main(String[] args) {
        HaveConflict haveConflict = new HaveConflict();
        System.out.println(haveConflict.haveConflict(new String[]{"10:00","11:00"}, new String[]{"14:00","15:00"}));
        System.out.println(haveConflict.haveConflict(new String[]{"01:00","02:00"}, new String[]{"01:20","03:00"}));
        System.out.println(haveConflict.haveConflict(new String[]{"01:15", "02:00"}, new String[]{"02:00", "03:00"}));
    }
}
