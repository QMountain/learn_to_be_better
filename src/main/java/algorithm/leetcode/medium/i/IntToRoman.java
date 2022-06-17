package algorithm.leetcode.medium.i;

public class IntToRoman {

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[]{1000,900,500,400,100,
                90,50,40,10,9,
                5,4,1};
        String[] strings = new String[]{"M","CM","D","CD","C",
                "XC","L","XL","X","IX",
                "V","IV","I"};
        for (int i = 0; i < 13; i++) {
            int count = num / arr[i];
            for (int j = 0; j < count; j++) {
                sb.append(strings[i]);
            }
            num %= arr[i];
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        IntToRoman intToRoman = new IntToRoman();
        System.out.println(intToRoman.intToRoman(1994));
        System.out.println(intToRoman.intToRoman(58));
        System.out.println(intToRoman.intToRoman(9));
        System.out.println(intToRoman.intToRoman(4));
        System.out.println(intToRoman.intToRoman(3));
    }
}
