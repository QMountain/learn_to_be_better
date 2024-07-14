package algorithm.leetcode.medium.a;

import java.util.*;

public class AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<Integer>> map = new HashMap<>();
        int groups = accounts.size();
        for (int i = 0; i < groups; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                Set<Integer> list = map.getOrDefault(email, new HashSet<>());
                list.add(i);
                map.put(email, list);
            }
        }
        int[] status = new int[groups];
        for (int i = 0; i < groups; i++) {
            status[i] = i;
        }
        for (Map.Entry<String, Set<Integer>> entry : map.entrySet()) {
            List<Integer> value = new ArrayList<>(entry.getValue());
            if (value.size() > 1) {
                int target = value.get(0);
                while (status[target] != target) {
                    target = status[target];
                }
                for (int i = 1; i < value.size(); i++) {
                    int group = value.get(i);
                    while (status[group] != group) {
                        group = status[group];
                    }
                    if (group == target || accounts.get(group).isEmpty()) {
                        continue;
                    }
                    accounts.get(group).remove(0);
                    accounts.get(target).addAll(accounts.get(group));
                    status[group] = target;
                    accounts.get(group).clear();
                }
            }
        }
        Set<Integer> showed = new HashSet<>();
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < groups; i++) {
            if (!showed.contains(status[i])) {
                if (accounts.get(status[i]).isEmpty()) {
                    continue;
                }
                List<String> list = new ArrayList<>();
                list.add(accounts.get(status[i]).get(0));
                accounts.get(status[i]).remove(0);
                TreeSet<String> set = new TreeSet<>(accounts.get(status[i]));
                while (!set.isEmpty()) {
                    list.add(set.pollFirst());
                }
                ans.add(list);
                showed.add(status[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        AccountsMerge accountsMerge = new AccountsMerge();
        String[][] arr = new String[][]{{"Alex","Alex5@m.co","Alex4@m.co","Alex0@m.co"},{"Ethan","Ethan3@m.co","Ethan3@m.co","Ethan0@m.co"},{"Kevin","Kevin4@m.co","Kevin2@m.co","Kevin2@m.co"},{"Gabe","Gabe0@m.co","Gabe3@m.co","Gabe2@m.co"},{"Gabe","Gabe3@m.co","Gabe4@m.co","Gabe2@m.co"}};
        //String[][] arr = new String[][]{{"David","David0@m.co","David4@m.co","David3@m.co"},{"David","David5@m.co","David5@m.co","David0@m.co"},{"David","David1@m.co","David4@m.co","David0@m.co"},{"David","David0@m.co","David1@m.co","David3@m.co"},{"David","David4@m.co","David1@m.co","David3@m.co"}};
        List<List<String>> groups = new ArrayList<>();
        for (String[] strings : arr) {
            List<String> group = new ArrayList<>();
            for (String string : strings) {
                group.add(string);
            }
            groups.add(group);
        }
        System.out.println(accountsMerge.accountsMerge(groups));
        List<List<String>> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("Alex");
        list1.add("Alex5@m.co");
        list1.add("Alex4@m.co");
        list1.add("Alex0@m.co");
        list.add(list1);
        List<String> list2 = new ArrayList<>();
        list2.add("Ethan");
        list2.add("Ethan3@m.co");
        list2.add("Ethan3@m.co");
        list2.add("Ethan0@m.co");
        list.add(list2);
        List<String> list3 = new ArrayList<>();
        list3.add("Kevin");
        list3.add("Kevin4@m.co");
        list3.add("Kevin2@m.co");
        list3.add("Kevin2@m.co");
        list.add(list3);
        List<String> list4 = new ArrayList<>();
        list4.add("Gabe");
        list4.add("Gabe0@m.co");
        list4.add("Gabe3@m.co");
        list4.add("Gabe2@m.co");
        list.add(list4);
        List<String> list5 = new ArrayList<>();
        list5.add("Gabe");
        list5.add("Gabe3@m.co");
        list5.add("Gabe4@m.co");
        list5.add("Gabe2@m.co");
        list.add(list5);
        /*List<List<String>> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("John");
        list1.add("johnsmith@mail.com");
        list1.add("john00@mail.com");
        list.add(list1);
        List<String> list2 = new ArrayList<>();
        list2.add("John");
        list2.add("johnnybravo@mail.com");
        list.add(list2);
        List<String> list3 = new ArrayList<>();
        list3.add("John");
        list3.add("johnsmith@mail.com");
        list3.add("john_newyork@mail.com");
        list.add(list3);
        List<String> list4 = new ArrayList<>();
        list4.add("Mary");
        list4.add("mary@mail.com");
        list.add(list4);*/
        System.out.println(accountsMerge.accountsMerge(list));
    }
}
