package algorithm.leetcode.easy.a;

public class AddStrings {

    public String addStrings(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        int maxLength = Math.max(l1,l2);
        int carry = 0;
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (index < maxLength) {
            int n1 = 0;
            if (l1-1 >= index) {
                n1 = Integer.parseInt(num1.charAt(l1 - 1 - index)+"");
            }
            int n2 = 0;
            if (l2-1 >= index) {
                n2 = Integer.parseInt(num2.charAt(l2 - 1 - index)+"");
            }
            int sum = n1 + n2 + carry;
            carry = (sum) /10;
            sb.insert(0,sum%10);
            index++;
        }
        if (carry == 1) {
            sb.insert(0,1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AddStrings addStrings = new AddStrings();
        System.out.println(addStrings.addStrings("11", "123"));
    }
}
