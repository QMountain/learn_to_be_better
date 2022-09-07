package algorithm.leetcode.medium.k;

import java.util.*;

public class KSmallestPairs {

    List<List<Integer>> ansList;

    int[] nums1;

    int[] nums2;

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        List<Integer> list1 = new ArrayList<>();
        list1.add(nums1[0]);
        List<Integer> list2 = new ArrayList<>();
        list2.add(nums2[0]);
        int index1 = 1;
        int index2 = 1;
        while (list1.size() * list2.size() <= k) {
            if (index1 < length1 && index2 < length2) {
                int agg1 = nums1[index1] - nums1[index1 - 1];
                int agg2 = nums2[index2] - nums2[index2 - 1];
                if (agg1 < agg2) {
                    list1.add(nums1[index1++]);
                } else if (agg1 == agg2) {
                    list1.add(nums1[index1++]);
                    list2.add(nums2[index2++]);
                } else {
                    list2.add(nums2[index2++]);
                }
            } else if (index1 < length1) {
                list1.add(nums1[index1++]);
            } else if (index2 < length2) {
                list2.add(nums2[index2++]);
            } else {
                break;
            }
        }
        if (index1 < length1 && index2 < length2) {
            int oldIndex1 = index1;
            while (index1 < length1 && nums1[index1] + nums2[0] <= nums1[oldIndex1-1]+nums2[index2-1]) {
                list1.add(nums1[index1++]);
            }
            int oldIndex2 = index2;
            while (index2 < length2 && nums1[0] + nums2[index2] <= nums1[index1-1]+nums2[oldIndex2-1]) {
                list2.add(nums2[index2++]);
            }
        }
        List<List<Integer>> sortList = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(j);
                sortList.add(list);
            }
        }
        sortList.sort((a, b) -> {
            if (nums1[a.get(0)] + nums2[a.get(1)] != nums1[b.get(0)] + nums2[b.get(1)]) {
                return nums1[a.get(0)] + nums2[a.get(1)] - nums1[b.get(0)] - nums2[b.get(1)];
            }
            if (a.get(0) + a.get(1) != b.get(0) + b.get(1)) {
                return a.get(0) + a.get(1) - b.get(0) - b.get(1);
            }
            if (Math.min(a.get(0), a.get(1)) != Math.min(b.get(0), b.get(1))) {
                return Math.min(a.get(0), a.get(1)) - Math.min(b.get(0), b.get(1));
            }
            return 1;
        });
        List<List<Integer>> ansList = new ArrayList<>();
        for (List<Integer> list : sortList) {
            List<Integer> ans = new ArrayList<>();
            ans.add(nums1[list.get(0)]);
            ans.add(nums2[list.get(1)]);
            ansList.add(ans);
        }
        return ansList.subList(0, Math.min(k,ansList.size()));
    }

    public void insert(int i, int j) {
        List<Integer> list = new ArrayList<>();
        list.add(i);
        list.add(j);
        if (ansList.isEmpty()) {
            ansList.add(list);
            return;
        }
        List<Integer> first = ansList.get(0);
        if (nums1[i]+nums2[j] < nums1[first.get(0)] + nums2[first.get(1)]) {
            ansList.add(0,list);
            return;
        } else if (nums1[i]+nums2[j] == nums1[first.get(0)] + nums2[first.get(1)]) {
            if (i+j < first.get(0) + first.get(1)) {
                ansList.add(0,list);
                return;
            } else if (i+j == first.get(0) + first.get(1)) {
                if (i < first.get(0)) {
                    ansList.add(0,list);
                    return;
                }
            }
        }
        List<Integer> last = ansList.get(ansList.size()-1);

    }

    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ansList = new ArrayList<>();
        int length1 = nums1.length;
        int length2 = nums2.length;
        int index1 = 0;
        int index2 = 0;
        Set<String> set = new HashSet<>();
        int[] used1 = new int[length1];
        int[] used2 = new int[length2];
        int finishedIndex1 = -1;
        int finishedIndex2 = -1;
        while ((finishedIndex1 < length1 || finishedIndex2 < length2) && k > 0) {
            List<Integer> list = new ArrayList<>();
            list.add(nums1[index1]);
            list.add(nums2[index2]);
            ansList.add(list);
            set.add(index1+","+index2);
            if (++used1[index1] == length2) {
                finishedIndex1++;
            }
            if (++used2[index2] == length1) {
                finishedIndex2++;
            }
            if (finishedIndex1 == length1-1 && finishedIndex2 == length2-1) {
                break;
            }
            if (finishedIndex1 < length1-1) {
                index1 = finishedIndex1+1;
            }
            if (finishedIndex2 < length2-1) {
                index2 = finishedIndex2+1;
            }
            int i1add = 0;
            while (set.contains((index1+i1add)+","+index2)) {
                i1add++;
            }
            int i2add = 0;
            while (set.contains(index1+","+(index2+i2add))) {
                i2add++;
            }
            if (index2 + i2add >= length2 || (index1 + i1add < length1 && nums1[index1+i1add] +nums2[index2] <= nums1[index1]+nums2[index2+i2add])) {
                index1 += i1add;
            } else {
                index2 += i2add;
            }
            k--;
        }
        return ansList;
    }

    public static void main(String[] args) {
        KSmallestPairs kSmallestPairs = new KSmallestPairs();
        System.out.println(kSmallestPairs.kSmallestPairs(new int[]{1, 2, 4,5,6}, new int[]{3, 5, 7,9}, 3));
        System.out.println(kSmallestPairs.kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2));
        System.out.println(kSmallestPairs.kSmallestPairs(new int[]{-10,-4,0,0,6}, new int[]{3,5,6,7,8,100}, 10));
        System.out.println(kSmallestPairs.kSmallestPairs(new int[]{1, 2}, new int[]{3}, 3));

        System.out.println(kSmallestPairs.kSmallestPairs(new int[]{1, 2, 4}, new int[]{-1, 1, 2}, 100));
        System.out.println(kSmallestPairs.kSmallestPairs(new int[]{1, 1,2}, new int[]{1,2,3}, 10));
        System.out.println(kSmallestPairs.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));

        System.out.println(kSmallestPairs.kSmallestPairs(new int[]{1, 2,4}, new int[]{-1,1,2}, 100));


    }
}
