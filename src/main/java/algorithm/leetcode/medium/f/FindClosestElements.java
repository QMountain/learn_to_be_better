package algorithm.leetcode.medium.f;

import java.util.ArrayList;
import java.util.List;

public class FindClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ansList = new ArrayList<>();
        int leftClosest = getLeftClosest(arr,x);
        int rightClosest = getRightClosest(arr, x);
        if (arr[leftClosest] == x || leftClosest == rightClosest) {
            ansList.add(arr[leftClosest--]);
            rightClosest++;
            k--;
        }
        while (k > 0) {
            if (leftClosest < 0) {
                for (int i = 0; i < k; i++) {
                    ansList.add(arr[rightClosest++]);
                }
                break;
            }
            if (rightClosest == arr.length) {
                for (int i = 0; i < k; i++) {
                    ansList.add(0,arr[leftClosest--]);
                }
                break;
            }
            int distLeft = Math.abs(x - arr[leftClosest]);
            int distRight = Math.abs(arr[rightClosest] - x);
            if (distLeft > distRight) {
                ansList.add(arr[rightClosest++]);
            } else {
                ansList.add(0,arr[leftClosest--]);
            }
            k--;
        }
        return ansList;
    }

    public int getLeftClosest(int[] arr, int x) {
        int left = 0;
        int right = arr.length-1;
        while (left < right) {
            int mid = (left+right)/2;
            if (arr[mid] > x) {
                right = mid;
            } else if (arr[mid] == x) {
                return mid;
            } else {
                if (left == mid) {
                    if (arr[right] < x) {
                        return right;
                    } else if (arr[right] == x) {
                        return right;
                    } else {
                        return left;
                    }
                } else {
                    left = mid;
                }
            }
        }
        return left;
    }

    public int getRightClosest(int[] arr, int x) {
        int left = 0;
        int right = arr.length-1;
        while (left < right) {
            int mid = (left+right)/2;
            if (arr[mid] > x) {
                right = mid;
            } else if (arr[mid] == x) {
                return mid;
            } else {
                if (left == mid) {
                    left++;
                } else {
                    left = mid;
                }
            }
        }
        return left;
    }

    public static void main(String[] args) {
        FindClosestElements findClosestElements = new FindClosestElements();
        System.out.println(findClosestElements.findClosestElements(new int[]{1,2,3,4,5}, 4, -1));
        System.out.println(findClosestElements.findClosestElements(new int[]{1,2,3,4,5}, 4, 3));
    }
}
