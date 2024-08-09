package algorithm.leetcode.hard.l;

import java.util.*;

public class LongestAwesome {

    public int longestAwesome(String s) {
        LinkedList<int[]> list = new LinkedList<>();
        list.addLast(new int[]{s.charAt(0) - '0', 1});
        for (int i = 1; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            if (list.peekLast()[0] == num) {
                list.peekLast()[1]++;
            } else {
                list.addLast(new int[]{num, 1});
            }
        }
        int ans = list.get(0)[1];
        Map<Integer, Integer> map = new HashMap<>();
        int countOdd = 0;
        int sum = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i; j < list.size(); j++) {
                int key = list.get(j)[0];
                Integer old = map.getOrDefault(key, 0);
                int currCount = list.get(j)[1];
                if (old % 2 == 0) {
                    if (currCount % 2 == 1) {
                        countOdd++;
                    }
                } else {
                    if (currCount % 2 == 1) {
                        countOdd--;
                    }
                }
                map.put(key, old + currCount);
                sum += currCount;
                if (countOdd <= 1) {
                    ans = Math.max(ans, sum);
                }
                else {
                    int startElement = list.get(i)[0];
                    int endElement = list.get(j)[0];
                    Integer startElementCount = map.get(startElement);
                    Integer endElementCount = map.get(endElement);
                    if (countOdd == 2) {
                        if (startElement != endElement) {
                            if (startElementCount % 2 == 1 ||
                                    endElementCount % 2 == 1) {
                                ans = Math.max(ans, sum - 1);
                            }
                        } else {
                            if (startElementCount % 2 == 1) {
                                ans = Math.max(ans, sum - 1);
                            }
                        }
                    } else if (countOdd == 3 && startElementCount % 2 == 1 && endElementCount % 2 == 1 && startElement != endElement) {
                        ans = Math.max(ans, sum - 2);
                    }
                }
            }

        }
        return ans;
    }

    public int longestAwesome2(String s) {
        Set<Integer> oddCountElementSet = new HashSet<>();
        Map<Integer, LinkedList<Integer>> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int key = s.charAt(i) - '0';
            LinkedList<Integer> oldList = countMap.getOrDefault(key, new LinkedList<>());
            if (oldList.size() % 2 == 0) {
                oddCountElementSet.add(key);
            } else {
                oddCountElementSet.remove(key);
            }
            oldList.add(i);
            countMap.put(key, oldList);
        }
        if (oddCountElementSet.size() < 2) {
            return s.length();
        }
        int ans = 1;
        int left = 0;
        int right = s.length() - 1;
        while (left < right && oddCountElementSet.size() >= 2) {
            int leftNum = s.charAt(left) - '0';
            if (countMap.get(leftNum).size() % 2 == 1) {
                left++;
                countMap.get(leftNum).pollFirst();
                oddCountElementSet.remove(leftNum);
            } else {
                int rightNum = s.charAt(right) - '0';
                if (countMap.get(rightNum).size() % 2 == 1) {
                    right--;
                    countMap.get(rightNum).pollLast();
                    oddCountElementSet.remove(rightNum);
                } else {
                    Set<Integer> leftOddCountSet = new HashSet<>();
                    HashMap<Integer, Integer> leftMap = new HashMap<>();
                    for (int i = left; i <= right; i++) {
                        int key = s.charAt(i) - '0';
                        Integer leftOld = leftMap.getOrDefault(key, 0);
                        if (leftOld % 2 == 1) {
                            leftOddCountSet.remove(key);
                        } else {
                            leftOddCountSet.add(key);
                        }
                        leftMap.put(key, leftOld + 1);
                        if (leftOddCountSet.size() == 1) {
                            ans = Math.max(ans, i - left + 1);
                            Integer num = new ArrayList<>(leftOddCountSet).get(0);
                            if (oddCountElementSet.contains(num)) {
                                left = i + 1;
                                oddCountElementSet.remove(num);
                                break;
                            }
                        }
                    }

                    Set<Integer> rightOddCountSet = new HashSet<>();
                    HashMap<Integer, Integer> rightMap = new HashMap<>();
                    for (int i = right; i >= left; i--) {
                        int key = s.charAt(i) - '0';
                        Integer rightOld = rightMap.getOrDefault(key, 0);
                        if (rightOld % 2 == 1) {
                            rightOddCountSet.remove(key);
                        } else {
                            rightOddCountSet.add(key);
                        }
                        rightMap.put(key, rightOld + 1);
                        if (rightOddCountSet.size() == 1) {
                            ans = Math.max(ans, right - i + 1);
                            Integer num = new ArrayList<>(rightOddCountSet).get(0);
                            if (oddCountElementSet.contains(num)) {
                                right = i - 1;
                                oddCountElementSet.remove(num);
                                break;
                            }
                        }
                    }

                    left++;
                }
            }
        }
        if (oddCountElementSet.isEmpty()) {
            return Math.max(ans, right - left + 2);
        }
        if (oddCountElementSet.size() == 1) {
            return Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestAwesome longestAwesome = new LongestAwesome();
        System.out.println(73 == longestAwesome.longestAwesome("798566608225937863836139032344664054423024310063588022485088201045999139182003515776206531154262"));
        System.out.println(9 == longestAwesome.longestAwesome("98328759459770506098852"));
        System.out.println(2 == longestAwesome.longestAwesome("00"));
        System.out.println(6 == longestAwesome.longestAwesome("213123"));
        System.out.println(3 == longestAwesome.longestAwesome("61914327865214"));
        System.out.println(5 == longestAwesome.longestAwesome("185801630663498"));
        System.out.println(5 == longestAwesome.longestAwesome("14004076378"));
        System.out.println(3 == longestAwesome.longestAwesome("9498331"));
        System.out.println(6 == longestAwesome.longestAwesome("213123"));
        System.out.println(1 == longestAwesome.longestAwesome("12345678"));
        System.out.println(5 == longestAwesome.longestAwesome("3242415"));
    }
}
