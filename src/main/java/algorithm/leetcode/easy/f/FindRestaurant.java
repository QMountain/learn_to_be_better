package algorithm.leetcode.easy.f;

import java.util.*;

public class FindRestaurant {

    public String[] findRestaurant(String[] list1, String[] list2) {

        int l1 = list1.length;
        int l2 = list2.length;

        int index1 = 0;
        int index2 = 0;
        Set<String> set1 = new HashSet<>(l1);
        Set<String> set2 = new HashSet<>(l2);

        int indexSum = l1 + l2;
        while (index1 < l1 || index2 < l2) {
            if (index1 >= l1-1) {
                index1 = l1-1;
            }
            if (index2 >= l2-1) {
                index2 = l2-1;
            }
            String s1 = list1[index1];
            String s2 = list2[index2];
            if (Objects.equals(s1, s2)) {
                indexSum = Math.min(indexSum,index1 + index2);
            }
            if (set2.contains(s1)) {
                int matchIndex2 = 0;
                for (int i = 0; i <= index2; i++) {
                    if (Objects.equals(list2[i], s1)) {
                        matchIndex2 = i;
                        break;
                    }
                }
                indexSum = Math.min(indexSum,index1 + matchIndex2);
            }
            if (set1.contains(s2)) {
                int matchIndex1 = 0;
                for (int i = 0; i <= index1; i++) {
                    if (Objects.equals(list1[i], s2)) {
                        matchIndex1 = i;
                        break;
                    }
                }
                indexSum = Math.min(index2 + matchIndex1,indexSum);
            }
            set1.add(s1);
            set2.add(s2);
            index1++;
            index2++;
        }
        Set<String> stringSet = new HashSet<>(indexSum+1);
        int extendIndex1Max = Math.min(indexSum,l1-1);
        int extendIndex2Max = Math.min(indexSum,l2-1);
        for (int i = 0; i <= extendIndex1Max; i++) {
            for (int j = 0; j <= extendIndex2Max; j++) {
                if (i+j == indexSum) {
                    if (Objects.equals(list1[i], list2[j])) {
                        stringSet.add(list1[i]);
                    }
                }
                if (i+j < indexSum) {
                    if (Objects.equals(list1[i], list2[j])) {
                        stringSet = new HashSet<>(indexSum);
                        stringSet.add(list1[i]);
                    }
                }
            }
        }
        List<String> strings = new ArrayList<>(stringSet);
        String[] res = new String[strings.size()];
        for (int i = 0; i < strings.size(); i++) {
            res[i] = strings.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        FindRestaurant findRestaurant = new FindRestaurant();
        System.out.println(Arrays.toString(findRestaurant.findRestaurant(
                new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"})));
        System.out.println(Arrays.toString(findRestaurant.findRestaurant(
                new String[]{"Shogun","Tapioca Express","Burger King","KFC"},
                new String[]{"KFC","Burger King","Tapioca Express","Shogun"})));
        System.out.println(Arrays.toString(findRestaurant.findRestaurant(
                new String[]{"Shogun","Tapioca Express","Burger King","KFC"},
                new String[]{"KNN","KFC","Burger King","Tapioca Express","Shogun"})));
    }
}
