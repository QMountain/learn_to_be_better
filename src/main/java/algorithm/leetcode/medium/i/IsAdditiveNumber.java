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
        int firstNum = Integer.parseInt(num.substring(0,firstNumLength));
        int secondNum = Integer.parseInt(num.substring(firstNumLength,firstNumLength+secondNumLength));
        StringBuilder sb = new StringBuilder();
        sb.append(firstNum);
        sb.append(secondNum);
        while (true) {
            if (!sb.toString().equals(num.substring(0,sb.length()))) {
                return false;
            }
            int thirdNum = firstNum+secondNum;
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

    public static void main(String[] args) {
        IsAdditiveNumber isAdditiveNumber = new IsAdditiveNumber();
        System.out.println(isAdditiveNumber.isAdditiveNumber("121474836472147483648"));
        System.out.println(isAdditiveNumber.isAdditiveNumber("1023"));
        System.out.println(isAdditiveNumber.isAdditiveNumber("199111992"));
        System.out.println(isAdditiveNumber.isAdditiveNumber("199100199"));
        System.out.println(isAdditiveNumber.isAdditiveNumber("112358"));
    }
}
