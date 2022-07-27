package algorithm.leetcode.medium.f;

import java.util.*;

public class FractionAddition {

    public String fractionAddition(String expression) {
        int length = expression.length();
        int index = 0;
        List<Integer> moleculeList = new ArrayList<>();
        List<Integer> denominatorList = new ArrayList<>();
        while (true) {
            index = expression.indexOf("/", index);
            if (index == -1) {
                break;
            }
            for (int i = index-1; i >= 0; i--) {
                char c = expression.charAt(i);
                if (i == 0) {
                    moleculeList.add(Integer.parseInt(expression.substring(0,index)));
                    break;
                }
                if (c == '+') {
                    moleculeList.add(Integer.parseInt(expression.substring(i+1,index)));
                    break;
                }
                if (c == '-') {
                    moleculeList.add(Integer.parseInt(expression.substring(i,index)));
                    break;
                }
            }
            for (int i = index; i < length; i++) {
                char c = expression.charAt(i);
                if (i == length-1) {
                    denominatorList.add(Integer.parseInt(expression.substring(index+1)));
                    break;
                }
                if (c == '+' || c == '-') {
                    denominatorList.add(Integer.parseInt(expression.substring(index+1,i)));
                    break;
                }
            }
            index++;
        }

        Set<Integer> set = new HashSet<>(denominatorList);
        int commonDenominator = 1;
        for (Integer s : set) {
            commonDenominator *= s;
        }
        int commonMolecule = 0;
        int size = moleculeList.size();
        for (int i = 0; i < size; i++) {
            Integer molecule = moleculeList.get(i);
            Integer denominator = denominatorList.get(i);
            int bs = commonDenominator / denominator;
            commonMolecule += molecule * bs;
        }
        if (commonMolecule == 0) {
            return "0/1";
        }
        if (commonDenominator == 1) {
            return commonMolecule+"/1";
        }
        return discardCommon(commonMolecule,commonDenominator);
    }

    public String discardCommon(int commonMolecule, int commonDenominator) {
        while (true) {
            int common = getCommon(commonMolecule, commonDenominator);
            if (common == 1) {
                break;
            }
            commonMolecule /= common;
            commonDenominator /= common;
        }
        return commonMolecule+"/"+commonDenominator;
    }

    public int getCommon(int num1, int num2) {
        num1 = Math.abs(num1);
        num2 = Math.abs(num2);
        if (num1 == num2) {
            return num1;
        }
        if (num1 < num2) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }
        while (num1 % num2 != 0) {
            int retain = num1 % num2;
            num1 = num2;
            num2 = retain;
        }
        return num2;
    }

    public static void main(String[] args) {
        FractionAddition fractionAddition = new FractionAddition();
        System.out.println(fractionAddition.fractionAddition("1/3-1/2"));
        System.out.println(fractionAddition.fractionAddition("-1/2+1/2+1/3"));
        System.out.println(fractionAddition.fractionAddition("-1/2+1/2"));
        fractionAddition.discardCommon(-10,3);
    }
}
