package algorithm.leetcode.medium.s;

import java.util.ArrayList;
import java.util.List;

public class SolveEquation {

    public String solveEquation(String equation) {
        String[] split = equation.split("=");
        int[] leftArr = compact(split[0]);
        int[] rightArr = compact(split[1]);
        int xs = leftArr[0] - rightArr[0];
        int zs = rightArr[1] - leftArr[1];
        if (xs == 0) {
            if (zs == 0) {
                return "Infinite solutions";
            }
            return "No solution";
        }
        return "x="+(zs/xs);
    }

    public int[] compact(String s) {
        int[] arr = new int[2];
        List<String> list = new ArrayList<>();
        int lastIndex = 0;
        if (s.startsWith("-")) {
            list.add("-");
            lastIndex = 1;
        }
        while (true) {
            int plusIndex = s.indexOf("+", lastIndex);
            int minusIndex = s.indexOf("-",lastIndex);
            if (plusIndex == -1 && minusIndex == -1) {
                list.add(s.substring(lastIndex));
                break;
            }
            if (plusIndex == -1) {
                list.add(s.substring(lastIndex,minusIndex));
                lastIndex = minusIndex+1;
                list.add("-");
                continue;
            }
            if (minusIndex == -1) {
                list.add(s.substring(lastIndex,plusIndex));
                lastIndex = plusIndex+1;
                list.add("+");
                continue;
            }
            if (plusIndex < minusIndex) {
                list.add(s.substring(lastIndex,plusIndex));
                lastIndex = plusIndex+1;
                list.add("+");
            } else if (minusIndex < plusIndex){
                list.add(s.substring(lastIndex,minusIndex));
                lastIndex = minusIndex+1;
                list.add("-");
            } else {
                break;
            }
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String s1 = list.get(i);
            if (s1.equals("+") || s1.equals("-")) {
                continue;
            }
            if (s1.endsWith("x")) {
                if (i == 0) {
                    if (s1.length() == 1) {
                        arr[0] += 1;
                    } else {
                        arr[0] += Integer.parseInt(s1.substring(0,s1.length()-1));
                    }
                } else {
                    String s2 = list.get(i - 1);
                    if (s2.equals("-")) {
                        if (s1.length() == 1) {
                            arr[0] -= 1;
                        } else {
                            arr[0] -= Integer.parseInt(s1.substring(0,s1.length()-1));
                        }
                    } else {
                        if (s1.length() == 1) {
                            arr[0] += 1;
                        } else {
                            arr[0] += Integer.parseInt(s1.substring(0,s1.length()-1));
                        }
                    }
                }
            } else {
                if (i == 0) {
                    arr[1] += Integer.parseInt(s1);
                } else {
                    String s2 = list.get(i - 1);
                    if (s2.equals("-")) {
                        arr[1] -= Integer.parseInt(s1);
                    } else {
                        arr[1] += Integer.parseInt(s1);
                    }
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        SolveEquation solveEquation = new SolveEquation();
        System.out.println(solveEquation.solveEquation("-x=-1"));
        System.out.println(solveEquation.solveEquation("2x=x"));
        System.out.println(solveEquation.solveEquation("x=x"));
        System.out.println(solveEquation.solveEquation("x+5-3+x=6+x-2"));
    }
}
