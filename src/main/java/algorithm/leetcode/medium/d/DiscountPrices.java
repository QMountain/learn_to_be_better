package algorithm.leetcode.medium.d;

public class DiscountPrices {

    public String discountPrices(String sentence, int discount) {
        StringBuilder sb = new StringBuilder();
        int countNumber = 0;
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (c == ' ') {
                if (word.charAt(0) == '$' && word.length() > 1 && word.length() - 1 == countNumber) {
                    sb.append("$");
                    long n = Long.parseLong(word.substring(1));
                    n *= 100 - discount;
                    String s = String.valueOf(n);
                    if (n >= 100) {
                        sb.append(s, 0, s.length()-2);
                        sb.append(".");
                        sb.append(s, s.length()-2, s.length());
                    } else {
                        sb.append("0.");
                        if (n < 10) {
                            sb.append("0");
                        }
                        sb.append(n);
                    }
                } else {
                    sb.append(word);
                }
                sb.append(" ");
                word = new StringBuilder();
                countNumber = 0;
            } else {
                word.append(c);
                if (c >= '0' && c <= '9') {
                    countNumber++;
                }
            }
        }
        if (word.charAt(0) == '$' && word.length() > 1 && word.length() - 1 == countNumber) {
            sb.append("$");
            long n = Long.parseLong(word.substring(1));
            n *= 100 - discount;
            String s = String.valueOf(n);
            if (n >= 100) {
                sb.append(s, 0, s.length()-2);
                sb.append(".");
                sb.append(s, s.length()-2, s.length());
            } else {
                sb.append("0.");
                if (n < 10) {
                    sb.append("0");
                }
                sb.append(n);
            }
        } else {
            sb.append(word);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        DiscountPrices discountPrices = new DiscountPrices();
        System.out.println(discountPrices.discountPrices(
                "1 2 $3 4 $5 $6 7 8$ $9 $10$", 100));
        System.out.println(discountPrices.discountPrices(
                "706hzu76jjh7yufr5x9ot60v149k5 $7651913186 pw2o $6", 28));
        System.out.println(discountPrices.discountPrices(
                "tc7fr$$roqdozd0 $1391", 69));
        System.out.println(discountPrices.discountPrices(
                "$76111 ab $6 $", 48));

        System.out.println(discountPrices.discountPrices(
                "there are $1 $2 and 5$ candies in the shop", 50));
    }
}
