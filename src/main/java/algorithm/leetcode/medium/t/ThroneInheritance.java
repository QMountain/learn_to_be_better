package algorithm.leetcode.medium.t;

import java.util.*;

public class ThroneInheritance {

    private final String kingName;
    Map<String, List<String>> childrenMap;
    Map<String, String> parentMap;
    Set<String> deadSet;

    public ThroneInheritance(String kingName) {
        this.kingName = kingName;
        childrenMap = new HashMap<>();
        parentMap = new HashMap<>();
        deadSet = new HashSet<>();
    }

    // 最多调用 10^5 次birth 和 death
    public void birth(String parentName, String childName) {
        List<String> list = childrenMap.getOrDefault(parentName, new ArrayList<>());
        list.add(childName);
        childrenMap.put(parentName, list);
        parentMap.put(childName, parentName);
    }

    public void death(String name) {
        deadSet.add(name);
    }

    public String successor(String x, Set<String> curOrder) {
        if (!childrenMap.containsKey(x)
                || curOrder.containsAll(childrenMap.get(x))) {
            if (x.equals(kingName)) {
                return null;
            }
            return successor(parentMap.get(x), curOrder);
        }
        for (String child : childrenMap.get(x)) {
            if (!curOrder.contains(child)) {
                return child;
            }
        }
        return null;
    }

    public List<String> getInheritanceOrder() {
        List<String> curOrder = new ArrayList<>();
        curOrder.add(kingName);
        Set<String> curOrderSet = new HashSet<>();
        String x = kingName;
        while (true) {
            String successor = successor(x, curOrderSet);
            if (successor == null) {
                break;
            }
            curOrder.add(successor);
            curOrderSet.add(successor);
            x = successor;
        }
        List<String> inheritanceOrder = new ArrayList<>();
        for (String s : curOrder) {
            if (!deadSet.contains(s)) {
                inheritanceOrder.add(s);
            }
        }
        return inheritanceOrder;
    }

    public static void main(String[] args) {
        ThroneInheritance throneInheritance = new ThroneInheritance("king");
        throneInheritance.birth("king", "andy");
        throneInheritance.birth("king", "bob");
        throneInheritance.birth("king", "catherine");
        throneInheritance.birth("andy", "matthew");
        throneInheritance.birth("bob", "alex");
        throneInheritance.birth("bob", "asha");
        System.out.println(throneInheritance.getInheritanceOrder());
        throneInheritance.death("bob");
        System.out.println(throneInheritance.getInheritanceOrder());
    }
}
