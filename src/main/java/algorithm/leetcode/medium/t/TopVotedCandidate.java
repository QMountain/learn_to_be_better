package algorithm.leetcode.medium.t;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TopVotedCandidate
 * @Description 在线选举
 * @Author qsf
 * Date   2021-12-12  16:32
 */
public class TopVotedCandidate {

    int[] persons;
    int[] times;
    Map<Integer,Integer> personTicketMap = new HashMap<>();
    Map<Integer, Integer> timeWinnerMap = new HashMap<>();
    int average;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.persons = persons;
        this.times = times;

        int tl = times.length;
        int maxTime = times[tl - 1];
        average = maxTime / (tl-1);

        int winner = persons[0];
        for (int i = 0; i < times.length; i++) {
            int time = times[i];
            int person = persons[i];
            Integer newValue = personTicketMap.getOrDefault(person,0)+1;
            personTicketMap.put(person,newValue);

            Integer lastMax = personTicketMap.getOrDefault(winner,0);
            if (newValue >= lastMax) {
                winner = person;
            }
            timeWinnerMap.put(time,winner);
        }
    }

    public int q(int t) {
        for (int time : times) {
            if (t == time) {
                return timeWinnerMap.get(t);
            }
        }
        int p = t / average;
        if (p >= times.length) {
            p = times.length-1;
            while (p-1 >= 0 && times[p] > t) {
                p--;
            }
            return timeWinnerMap.get(times[p]);
        }
        if (p == times.length-1) {
            if (times[p] <= t) {
                return timeWinnerMap.get(times[p]);
            }
            while (p-1 >= 0 && times[p] > t) {
                p--;
            }
            return timeWinnerMap.get(times[p]);
        }
        if (p == 0) {
            while (p+1 < times.length && times[p] < t) {
                p++;
            }
            if (p == 0) {
                return timeWinnerMap.get(times[0]);
            }
            return timeWinnerMap.get(times[p-1]);
        }
        if (times[p] <= t && times[p+1] > t) {
            return timeWinnerMap.get(times[p]);
        } else if (times[p-1] <= t && times[p] > t) {
            return timeWinnerMap.get(times[p-1]);
        } else if (times[++p] < t) {
            while (p+1 < times.length && times[p] < t) {
                p++;
            }
            return timeWinnerMap.get(times[p-1]);
        } else {
            while (p-1 >= 0 && times[p] > t) {
                p--;
            }
            return timeWinnerMap.get(times[p]);
        }

    }

    public static void main(String[] args) {

        /*TopVotedCandidate topVotedCandidate = new TopVotedCandidate(
                new int[]{0, 1, 1, 0, 0, 1, 0}, new int[]{0, 5, 10, 15, 20, 25, 30});
        System.out.println(topVotedCandidate.q(3));
        System.out.println(topVotedCandidate.q(12));
        System.out.println(topVotedCandidate.q(25));
        System.out.println(topVotedCandidate.q(15));
        System.out.println(topVotedCandidate.q(24));
        System.out.println(topVotedCandidate.q(8));*/

        /*TopVotedCandidate topVotedCandidate1 = new TopVotedCandidate(
                new int[]{0,0,0,0,1}, new int[]{0,6,39,52,75});
        System.out.println(topVotedCandidate1.q(45));
        System.out.println(topVotedCandidate1.q(49));
        System.out.println(topVotedCandidate1.q(59));
        System.out.println(topVotedCandidate1.q(68));
        System.out.println(topVotedCandidate1.q(42));
        System.out.println(topVotedCandidate1.q(37));
        System.out.println(topVotedCandidate1.q(99));
        System.out.println(topVotedCandidate1.q(26));
        System.out.println(topVotedCandidate1.q(78));
        System.out.println(topVotedCandidate1.q(43));*/

        /*TopVotedCandidate topVotedCandidate2 = new TopVotedCandidate(
                new int[]{0,0,0,0,0}, new int[]{5,8,50,87,88});
        System.out.println(topVotedCandidate2.q(80));
        System.out.println(topVotedCandidate2.q(87));
        System.out.println(topVotedCandidate2.q(30));
        System.out.println(topVotedCandidate2.q(67));
        System.out.println(topVotedCandidate2.q(14));
        System.out.println(topVotedCandidate2.q(84));
        System.out.println(topVotedCandidate2.q(37));
        System.out.println(topVotedCandidate2.q(96));
        System.out.println(topVotedCandidate2.q(50));
        System.out.println(topVotedCandidate2.q(8));*/

        /*TopVotedCandidate topVotedCandidate3 = new TopVotedCandidate(
                new int[]{0,1,0,2,1,3,4,3,2,4}, new int[]{9,14,17,25,32,66,80,82,88,99});
        System.out.println(topVotedCandidate3.q(66));
        System.out.println(topVotedCandidate3.q(25));
        System.out.println(topVotedCandidate3.q(98));
        System.out.println(topVotedCandidate3.q(80));
        System.out.println(topVotedCandidate3.q(10));
        System.out.println(topVotedCandidate3.q(83));
        System.out.println(topVotedCandidate3.q(26));
        System.out.println(topVotedCandidate3.q(87));
        System.out.println(topVotedCandidate3.q(15));
        System.out.println(topVotedCandidate3.q(16));*/

        /*TopVotedCandidate topVotedCandidate4 = new TopVotedCandidate(
                new int[]{0,0,1,1,0,1,1,0,0,1}, new int[]{0,5,33,56,63,74,81,86,95,98});
        System.out.println(topVotedCandidate4.q(100));
        System.out.println(topVotedCandidate4.q(34));
        System.out.println(topVotedCandidate4.q(75));
        System.out.println(topVotedCandidate4.q(85));
        System.out.println(topVotedCandidate4.q(70));
        System.out.println(topVotedCandidate4.q(79));
        System.out.println(topVotedCandidate4.q(82));
        System.out.println(topVotedCandidate4.q(27));
        System.out.println(topVotedCandidate4.q(28));
        System.out.println(topVotedCandidate4.q(40));
        System.out.println(topVotedCandidate4.q(2));
        System.out.println(topVotedCandidate4.q(91));
        System.out.println(topVotedCandidate4.q(81));
        System.out.println(topVotedCandidate4.q(13));
        System.out.println(topVotedCandidate4.q(33));
        System.out.println(topVotedCandidate4.q(61));
        System.out.println(topVotedCandidate4.q(49));
        System.out.println(topVotedCandidate4.q(44));
        System.out.println(topVotedCandidate4.q(41));
        System.out.println(topVotedCandidate4.q(96));*/

        /*TopVotedCandidate topVotedCandidate5 = new TopVotedCandidate(
                new int[]{0,1,2,3,2,4,0,3,1,5}, new int[]{2,9,29,31,35,62,69,91,95,99});
        System.out.println(topVotedCandidate5.q(50));
        System.out.println(topVotedCandidate5.q(29));
        System.out.println(topVotedCandidate5.q(68));
        System.out.println(topVotedCandidate5.q(38));
        System.out.println(topVotedCandidate5.q(93));
        System.out.println(topVotedCandidate5.q(12));
        System.out.println(topVotedCandidate5.q(64));
        System.out.println(topVotedCandidate5.q(99));
        System.out.println(topVotedCandidate5.q(54));
        System.out.println(topVotedCandidate5.q(78));
        System.out.println(topVotedCandidate5.q(16));
        System.out.println(topVotedCandidate5.q(49));
        System.out.println(topVotedCandidate5.q(86));
        System.out.println(topVotedCandidate5.q(89));
        System.out.println(topVotedCandidate5.q(81));
        System.out.println(topVotedCandidate5.q(69));
        System.out.println(topVotedCandidate5.q(82));
        System.out.println(topVotedCandidate5.q(9));
        System.out.println(topVotedCandidate5.q(11));
        System.out.println(topVotedCandidate5.q(6));*/

        TopVotedCandidate topVotedCandidate6 = new TopVotedCandidate(
                new int[]{0,0,0,1,1,1,1,0,1,0,0,1,0,1,0}, new int[]{9,10,19,21,29,31,38,47,51,52,57,61,75,90,95});
        System.out.println(topVotedCandidate6.q(52));
        System.out.println(topVotedCandidate6.q(58));
        System.out.println(topVotedCandidate6.q(61));
        System.out.println(topVotedCandidate6.q(11));
        System.out.println(topVotedCandidate6.q(62));
        System.out.println(topVotedCandidate6.q(21));
        System.out.println(topVotedCandidate6.q(32));
        System.out.println(topVotedCandidate6.q(74));
        System.out.println(topVotedCandidate6.q(48));
        System.out.println(topVotedCandidate6.q(38));
        System.out.println(topVotedCandidate6.q(29));
        System.out.println(topVotedCandidate6.q(46));
        System.out.println(topVotedCandidate6.q(20));
        System.out.println(topVotedCandidate6.q(9));
        System.out.println(topVotedCandidate6.q(94));
        System.out.println(topVotedCandidate6.q(57));
        System.out.println(topVotedCandidate6.q(75));
        System.out.println(topVotedCandidate6.q(96));
    }
}
