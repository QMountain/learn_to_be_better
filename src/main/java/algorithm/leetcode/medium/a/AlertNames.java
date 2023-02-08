package algorithm.leetcode.medium.a;

import java.util.*;

public class AlertNames {

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<String>> map = new HashMap<>();
        int length = keyName.length;
        for (int i = 0; i < length; i++) {
            List<String> list;
            if (!map.containsKey(keyName[i])) {
                list = new ArrayList<>();
            } else {
                list = map.get(keyName[i]);
            }
            list.add(keyTime[i]);
            map.put(keyName[i],list);
        }
        Set<String> ns = new HashSet<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String name = entry.getKey();
            List<String> timeList = entry.getValue();
            timeList.sort(this::compareTime);
            int size = timeList.size();
            if (size >= 3) {
                for (int i = 0; i < size - 2; i++) {
                    if (!moreThanOne(timeList.get(i), timeList.get(i+2))) {
                        ns.add(name);
                    }
                }
            }
        }
        ArrayList<String> list = new ArrayList<>(ns);
        Collections.sort(list);
        return list;
    }

    public int compareTime(String a, String b) {
        int h1 = Integer.parseInt(a.substring(0, 2));
        int h2 = Integer.parseInt(b.substring(0, 2));
        if (h1 != h2) {
            return h1 - h2;
        }
        int m1 = Integer.parseInt(a.substring(3));
        int m2 = Integer.parseInt(b.substring(3));
        return m1 - m2;
    }

    // true poll
    public boolean moreThanOne(String first, String last) {
        if (first.equals(last)) {
            return false;
        }
        int h1 = Integer.parseInt(first.substring(0, 2));
        int h2 = Integer.parseInt(last.substring(0, 2));
        if (h1 > h2) {
            return true;
        }
        // h2 - h1 >= 0
        if (h2 - h1 >= 2) {
            return true;
        }
        // h2 - h1 == 0/1
        int m1 = Integer.parseInt(first.substring(3));
        int m2 = Integer.parseInt(last.substring(3));
        if (h2 - h1 == 1) {
            return m1 < m2;
        }
        // h2 == h1
        return m1 > m2;
    }

    public static void main(String[] args) {
        AlertNames alertNames = new AlertNames();
        System.out.println(alertNames.alertNames(
                new String[]{"a","a","a","a","a","b","b","b","b","b","b"},
                new String[]{"23:20","11:09","23:30","23:02","15:28","22:57","23:40","03:43","21:55","20:38","00:19"}));
        System.out.println(alertNames.alertNames(
                new String[]{"leslie","leslie","leslie","clare","clare","clare","clare"},
                new String[]{"13:00","13:20","14:00","18:00","18:51","19:30","19:49"}));
        System.out.println(alertNames.alertNames(
                new String[]{"john","john","john"},
                new String[]{"23:58","23:59","00:01"}));
        System.out.println(alertNames.alertNames(
                new String[]{"alice","alice","alice","bob","bob","bob","bob"},
                new String[]{"12:01","12:00","18:00","21:00","21:20","21:30","23:00"}));
        System.out.println(alertNames.alertNames(new String[]{"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"},
                new String[]{"10:00","10:40","11:00","09:00","11:00","13:00","15:00"}));
    }
}
