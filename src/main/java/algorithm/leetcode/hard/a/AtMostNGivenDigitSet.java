package algorithm.leetcode.hard.a;

public class AtMostNGivenDigitSet {

    String[] digits;
    int dl;

    public int atMostNGivenDigitSet(String[] digits, int n) {
        this.digits = digits;
        this.dl = digits.length;
        String ns = String.valueOf(n);
        int nl = ns.length();
        int ans = 0;
        int base = dl;
        for (int i = 0; i < nl-1; i++) {
            ans += base;
            base *= dl;
        }
        base /= dl;
        int i0 = search(ns.charAt(0));
        if (i0 != -1) {
            if (ans == 0) {
                ans += i0+1;
            } else {
                int count = 0;
                for (int i = 0; i < nl; i++) {
                    int search = search(ns.charAt(i));
                    if (search != -1) {
                        if (digits[search].charAt(0) < ns.charAt(i) || i == nl-1) {
                            count += base * (search+1);
                            break;
                        } else {
                            count += base * search;
                        }
                    } else {
                        break;
                    }
                    base /= dl;
                }
                ans += count;
            }
        }
        return ans;
    }

    public int search(char target) {
        for (int i = 0; i < dl; i++) {
            if (digits[i].charAt(0) > target) {
                return i-1;
            }
        }
        return dl-1;
    }

    public static void main(String[] args) {
        AtMostNGivenDigitSet atMostNGivenDigitSet = new AtMostNGivenDigitSet();
        System.out.println(20 == atMostNGivenDigitSet.atMostNGivenDigitSet(new String[]{"2","3","4","6","8"}, 61));
        System.out.println(6 == atMostNGivenDigitSet.atMostNGivenDigitSet(new String[]{"5","7","8"}, 59));
        System.out.println(171 == atMostNGivenDigitSet.atMostNGivenDigitSet(new String[]{"1","2","3","4","6","7","9"}, 333));
        System.out.println(10 == atMostNGivenDigitSet.atMostNGivenDigitSet(new String[]{"1","7"}, 231));
        System.out.println(18 == atMostNGivenDigitSet.atMostNGivenDigitSet(new String[]{"3","4","5","6"}, 64));
        System.out.println(2 == atMostNGivenDigitSet.atMostNGivenDigitSet(new String[]{"3","4","8"}, 4));
        System.out.println(20 == atMostNGivenDigitSet.atMostNGivenDigitSet(new String[]{"1","3","5","7"}, 100));
        System.out.println(29523 == atMostNGivenDigitSet.atMostNGivenDigitSet(new String[]{"1","4","9"}, 1000000000));
        System.out.println(1 == atMostNGivenDigitSet.atMostNGivenDigitSet(new String[]{"7"}, 8));
    }
}
