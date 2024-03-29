package algorithm.leetcode.medium.i;

public class IsAdditiveNumber {

    public boolean isAdditiveNumber(String num) {
        int length = num.length();
        int firstNumMaxLength = length / 2;
        for (int i = 1; i <= firstNumMaxLength; i++) {
            int secondNumMaxLength = (length - i) / 2;
            for (int j = 1; j <= secondNumMaxLength; j++) {
                if (check(i,j,num)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(int firstNumLength, int secondNumLength, String num) {
        if (num.charAt(firstNumLength) == '0' && secondNumLength > 1) {
            return false;
        }
        String firstNum = num.substring(0,firstNumLength);
        String secondNum = num.substring(firstNumLength,firstNumLength+secondNumLength);
        StringBuilder sb = new StringBuilder();
        sb.append(firstNum);
        sb.append(secondNum);
        while (true) {
            if (!sb.toString().equals(num.substring(0,sb.length()))) {
                return false;
            }
            String thirdNum = add(firstNum,secondNum);
            sb.append(thirdNum);
            firstNum = secondNum;
            secondNum = thirdNum;
            if (sb.length() == num.length()) {
                return sb.toString().equals(num);
            }
            if (sb.length() > num.length()) {
                return false;
            }
        }
    }

    public String add(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int index1 = s1.length() - 1;
        int index2 = s2.length() - 1;
        int carry = 0;
        while (index1 >= 0 || index2 >= 0) {
            int num1 = 0;
            if (index1 >= 0) {
                num1 = Integer.parseInt(s1.charAt(index1)+"");
            }
            int num2 = 0;
            if (index2 >= 0) {
                num2 = Integer.parseInt(s2.charAt(index2)+"");
            }
            int res = num1 + num2 + carry;
            carry = res / 10;
            res = res % 10;
            sb.insert(0,res);
            index1--;
            index2--;
        }
        if (carry != 0) {
            sb.insert(0,carry);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        IsAdditiveNumber isAdditiveNumber = new IsAdditiveNumber();
        System.out.println(isAdditiveNumber.isAdditiveNumber("121474836472147483648"));
        System.out.println(isAdditiveNumber.isAdditiveNumber("1023"));
        System.out.println(isAdditiveNumber.isAdditiveNumber("199111992"));
        System.out.println(isAdditiveNumber.isAdditiveNumber("199100199"));
        System.out.println(isAdditiveNumber.isAdditiveNumber("112358"));
    }
}
