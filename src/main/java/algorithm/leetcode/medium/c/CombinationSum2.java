package algorithm.leetcode.medium.c;

import java.util.*;

public class CombinationSum2 {

    // 1 <= candidates.length <= 100
    // 1 <= candidates[i] <= 50
    // 1 <= target <= 30
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        LinkedList<Integer> elementList = new LinkedList<>();
        int sum = 0;
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] == target) {
                List<Integer> list = Collections.singletonList(candidates[i]);
                if (set.add(list.toString())) {
                    ans.add(list);
                }
            } else if (candidates[i] < target) {
                stack.push(i);
                elementList.addLast(candidates[i]);
                sum += candidates[i];
                break;
            }
        }
        while (!stack.isEmpty()) {
            if (sum >= target || set.contains(elementList.toString())) {
                if (set.add(elementList.toString()) && sum == target) {
                    ans.add(new ArrayList<>(elementList));
                }
                Integer lastIndex = stack.pop();
                Integer lastElement = elementList.pollLast();
                sum -= lastElement;
                set.add(elementList.toString());
                if (lastIndex == candidates.length - 1) {
                    if (stack.isEmpty()) {
                        return ans;
                    }
                    lastIndex = stack.pop();
                    lastElement = elementList.pollLast();
                    sum -= lastElement;

                }
                stack.push(lastIndex+1);
                elementList.addLast(candidates[lastIndex+1]);
                sum += candidates[lastIndex+1];
            } else {
                Integer lastIndex = stack.peek();
                if (lastIndex == candidates.length - 1) {
                    stack.pop();
                    Integer lastElement = elementList.pollLast();
                    sum -= lastElement;
                    set.add(elementList.toString());

                    if (stack.isEmpty()) {
                        return ans;
                    }
                } else {
                    stack.push(lastIndex+1);
                    elementList.addLast(candidates[lastIndex+1]);
                    sum += candidates[lastIndex+1];
                }
            }
        }
        return ans;
    }

    // 超时
    public List<List<Integer>> combinationSum2_1(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ansList = new LinkedList<>();
        int length = candidates.length;
        int sum = 0;
        int index = 0;
        LinkedList<Integer> elementQueue = new LinkedList<>();
        LinkedList<Integer> indexQueue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        while (true) {
            sum += candidates[index];
            elementQueue.offer(candidates[index]);
            indexQueue.offer(index);
            if (sum < target) {
                if (index < length-1) {
                    index++;
                } else {
                    if (indexQueue.size() > 1) {
                        indexQueue.pollLast();
                        sum -= elementQueue.peekLast();
                        elementQueue.pollLast();
                        Integer peek = indexQueue.peekLast();
                        sum -= elementQueue.peekLast();
                        elementQueue.pollLast();
                        indexQueue.pollLast();
                        index = peek+1;
                    } else {
                        break;
                    }
                }
                continue;
            }
            int iqSize = indexQueue.size();
            if (sum == target && set.add(elementQueue.toString())) {
                ansList.add(new LinkedList<>(elementQueue));
                if (iqSize == 1) {
                    Integer peek = indexQueue.peekLast();
                    sum -= elementQueue.peekLast();
                    elementQueue.pollLast();
                    indexQueue.pollLast();
                    if (peek < length-1) {
                        elementQueue.offer(candidates[peek+1]);
                        sum += candidates[peek+1];
                        indexQueue.offer(peek+1);
                    } else {
                        break;
                    }
                } else {
                    indexQueue.pollLast();
                    sum -= elementQueue.peekLast();
                    elementQueue.pollLast();
                    Integer peek = indexQueue.peekLast();
                    indexQueue.pollLast();
                    sum -= elementQueue.peekLast();
                    elementQueue.pollLast();
                    index = peek+1;
                }
            } else {
                indexQueue.pollLast();
                sum -= elementQueue.peekLast();
                elementQueue.pollLast();
                if (indexQueue.size() > 0) {
                    Integer peek = indexQueue.peekLast();
                    indexQueue.pollLast();
                    sum -= elementQueue.peekLast();
                    elementQueue.pollLast();
                    if (peek < length-1) {
                        index = peek+1;
                    } else {
                        if (indexQueue.size() > 0) {
                            Integer nPeek = indexQueue.peek();
                            indexQueue.offer(nPeek+1);
                            elementQueue.offer(candidates[nPeek+1]);
                            sum += candidates[nPeek+1];
                        } else {
                            break;
                        }
                    }
                } else {
                    break;
                }
            }
        }
        return ansList;
    }

    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        System.out.println(combinationSum2.combinationSum2(new int[]{1,1}, 1));
        System.out.println(combinationSum2.combinationSum2(new int[]{4,1,1,4,4,4,4,2,3,5}, 10));
        System.out.println(combinationSum2.combinationSum2(new int[]{3,1,3,5,1,1}, 8));
        System.out.println(combinationSum2.combinationSum2(new int[]{2,5,2,1,2}, 5));
        System.out.println(combinationSum2.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }
}
