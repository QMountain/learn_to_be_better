package algorithm.leetcode.medium.g;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetImportance {

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer,Integer> valueMap = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee.subordinates);
            valueMap.put(employee.id, employee.importance);
        }
        List<Integer> ids = new ArrayList<>();
        ids.add(id);
        int ans = 0;
        while (!ids.isEmpty()) {
            List<Integer> next = new ArrayList<>();
            for (Integer leader : ids) {
                ans += valueMap.get(leader);
                List<Integer> list = map.get(leader);
                if (list != null && !list.isEmpty()) {
                    next.addAll(list);
                }
            }
            ids = next;
        }
        return ans;
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee();
        employee1.id = 1;
        employee1.importance = 5;
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(3);
        employee1.subordinates = list1;

        Employee employee2 = new Employee();
        employee2.id = 2;
        employee2.importance = 3;

        Employee employee3 = new Employee();
        employee3.id = 3;
        employee3.importance = 3;

        List<Employee> list = new ArrayList<>();
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        GetImportance getImportance = new GetImportance();
        System.out.println(11 == getImportance.getImportance(list, 1));
    }
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}
