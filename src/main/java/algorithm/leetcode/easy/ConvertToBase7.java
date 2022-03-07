package algorithm.leetcode.easy;

public class ConvertToBase7 {

    public String convertToBase7(int num) {
        if (num < 7 && num > -7) {
            return num+"";
        }
        int offset = 0;
        StringBuilder str = new StringBuilder();
        if (num < 0) {
            offset = 1;
            str.append("-");
            num = -num;
        }
        while (num >= 7 || num <= -7) {
            str.insert(offset,num%7);
            num = num / 7;
            if (num < 7 && num > -7) {
                str.insert(offset,num);
            }
        }

        return str.toString();
    }

    public static void main(String[] args) {
        ConvertToBase7 convert = new ConvertToBase7();
        System.out.println("202".equals(convert.convertToBase7(100)));
        System.out.println("-10".equals(convert.convertToBase7(-7)));
        System.out.println("-11".equals(convert.convertToBase7(-8)));
    }

}
