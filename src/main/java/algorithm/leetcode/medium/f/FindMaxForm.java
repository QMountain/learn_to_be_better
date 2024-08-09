package algorithm.leetcode.medium.f;

import java.util.*;

public class FindMaxForm {

    static class Element {
        String str;
        Integer countZero;
        Integer countOne;
        public Element(String str) {
            this.str = str;
            int countZero = 0;
            int countOne = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0'){
                    countZero++;
                } else {
                    countOne++;
                }
            }
            this.countZero = countZero;
            this.countOne = countOne;
        }

        public int compare(Element another) {
            if (Objects.equals(this.countZero, another.countZero)) {
                return this.countOne.compareTo(another.countOne);
            }
            if (this.countZero.compareTo(another.countZero) > 0) {
                if (this.countOne.compareTo(another.countOne) >= 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
            if (this.countOne.compareTo(another.countOne) <= 0) {
                return -1;
            }
            return 0;
        }
    }

    // 1 <= strs.length <= 600
    // 1 <= strs[i].length <= 100
    public int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length;
        int[][] arr = new int[length][2];
        for (int i = 0; i < length; i++) {
            String str = strs[i];
            int[] count = new int[2];
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    count[0]++;
                } else {
                    count[1]++;
                }
            }
            arr[i] = count;
        }
        Arrays.sort(arr, (a,b)->{
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return 0;
        });
        int startIndex = 0;
        int sumZero = 0;
        int sumOne = 0;
        int ans = 0;
        for (int i = 0; i < length-1; i++) {
            sumZero += arr[i][0];
            sumOne += arr[i][1];
            if (arr[i][0] < arr[i+1][0] && arr[i][1] <= arr[i+1][1]) {
                int currLevelLength = i - startIndex + 1;
                if (sumZero <= m && sumOne <= n) {
                   ans += currLevelLength;
                   m -= sumZero;
                   n -= sumOne;
                   if (m == 0 && n == 0) {
                       return ans;
                   }
                } else {
                    // 0 不够， 1 够
                    if (sumZero > m && sumOne <= n) {
                        int[] zeroArr = new int[currLevelLength];
                        for (int j = startIndex; j <= i; j++) {
                            zeroArr[j-startIndex] = arr[j][0];
                        }
                        Arrays.sort(zeroArr);
                        for (int j = i - startIndex; j >= 0; j--) {
                            sumZero -= zeroArr[j];
                            if (sumZero <= m) {
                                return j + startIndex;
                            }
                        }
                    } else
                        // 0 够， 1不够
                        if (sumZero <= m) {
                        int[] oneArr = new int[currLevelLength];
                        for (int j = startIndex; j <= i; j++) {
                            oneArr[j-startIndex] = arr[j][1];
                        }
                        Arrays.sort(oneArr);
                        for (int j = i - startIndex; j >= 0; j--) {
                            sumOne -= oneArr[j];
                            if (sumOne <= m) {
                                return j + startIndex;
                            }
                        }
                    } else {
                        // 0 和 1 都不够

                    }
                }
                sumZero = 0;
                sumOne = 0;
                startIndex = i+1;
            }
        }
        /*if (countUsedOne <= n) {
            return list.size();
        }
        list.sort(Comparator.comparingInt(a -> a[1]));
        for (int i = list.size()-1; i >= 0; i--) {
            countUsedOne -= list.get(i)[1];
            if (countUsedOne <= n) {
                return i+1;
            }
        }*/
        return 0;
    }

    public int findMaxForm2(String[] strs, int m, int n) {
        HashSet<Element> headElementSet = new HashSet<>();
        HashSet<String> nextLevelSet = new HashSet<>();

        headElementSet.add(new Element(strs[0]));
        for (int i = 1; i < strs.length; i++) {
            Element element = new Element(strs[i]);
            boolean next = false;
            HashSet<Element> removeSet = new HashSet<>();
            for (Element head : headElementSet) {
                int compare = head.compare(element);
                if (compare > 0) {
                    removeSet.add(head);
                } else if (compare < 0) {
                    next = true;
                }
            }
            if (!next) {
                headElementSet.add(element);
            }
            if (!removeSet.isEmpty()) {
                headElementSet.removeAll(removeSet);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        FindMaxForm findMaxForm = new FindMaxForm();
        System.out.println(4 == findMaxForm.findMaxForm(
                new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
    }
}
