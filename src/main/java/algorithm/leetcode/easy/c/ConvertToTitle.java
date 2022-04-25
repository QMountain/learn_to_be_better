package algorithm.leetcode.easy.c;

public class ConvertToTitle {

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 26) {
            int left = columnNumber % 26;
            if (left == 0) {
                left = 26;
                sb.insert(0,(char) (left+64));
                columnNumber -= 26;
            } else {
                sb.insert(0,(char) (left+64));
            }
            columnNumber = columnNumber / 26;
        }
        sb.insert(0,(char) (columnNumber+64));
        return sb.toString();
    }

    public static void main(String[] args) {
        ConvertToTitle convertToTitle = new ConvertToTitle();
        System.out.println(convertToTitle.convertToTitle(52));
        System.out.println(convertToTitle.convertToTitle(26));
        System.out.println(convertToTitle.convertToTitle(27));
        System.out.println(convertToTitle.convertToTitle(28));
        System.out.println(convertToTitle.convertToTitle(701));
        System.out.println(convertToTitle.convertToTitle(2147483647));
    }
}
