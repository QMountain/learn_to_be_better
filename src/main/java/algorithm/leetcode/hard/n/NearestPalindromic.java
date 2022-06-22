package algorithm.leetcode.hard.n;

public class NearestPalindromic {

    public String nearestPalindromic(String n) {
        int length = n.length();
        if (length > 1 && n.startsWith("1")) {
            boolean allZero = true;
            for (int i = 1; i < length-1; i++) {
                if (n.charAt(i) != '0') {
                    allZero = false;
                    break;
                }
            }
            if (allZero && (n.charAt(length-1) == '1' || n.charAt(length-1) == '0')) {
                char[] chars = new char[length-1];
                for (int i = 0; i < length - 1; i++) {
                    chars[i] = '9';
                }
                return new String(chars);
            }
        }
        if (length > 1 && n.startsWith("9")) {
            boolean allNine = true;
            for (int i = 0; i < length; i++) {
                if (n.charAt(i) != '9') {
                    allNine = false;
                    break;
                }
            }
            if (allNine) {
                StringBuilder sb = new StringBuilder("1");
                for (int i = 0; i < length-1; i++) {
                    sb.append("0");
                }
                sb.append("1");
                return sb.toString();
            }
        }
        char[] chars = n.toCharArray();
        if (length == 1) {
            chars[0]--;
            return new String(chars);
        }
        boolean isPalindromic = true;
        for (int i = 0; i < length / 2; i++) {
            if (chars[length-1-i] != chars[i]) {
                isPalindromic = false;
                break;
            }
        }
        if (isPalindromic) {
            if (length % 2 == 0) {
                int middleRight = length/2;
                int middleLeft = middleRight - 1;
                if (middleLeft == 0) {
                    if (n.equals("11")) {
                        return "9";
                    }
                    if (n.equals("99")) {
                        return "101";
                    }
                    chars[middleLeft]--;
                    chars[middleRight]--;
                    return new String(chars);
                }
                if (chars[middleLeft] == '0') {
                    for (int i = middleLeft-1; i >= 0; i--) {
                        if (n.charAt(i) != '0') {
                            chars[i]--;
                            chars[length-1-i] = chars[i];
                            for (int j = i+1; j < length-i-1; j++) {
                                chars[j] = '9';
                            }
                            return new String(chars);
                        }
                    }
                }
                chars[middleLeft]--;
                chars[middleRight]--;
                return new String(chars);
            }
            int middle = length/2;
            if (n.charAt(middle) == '0') {
                chars[middle]++;
                return new String(chars);
            }
            chars[middle]--;
            return new String(chars);
        }
        if (length % 2 == 0) {
            int middleRight = length/2;
            int middleLeft = middleRight - 1;
            while (chars[middleLeft] == chars[middleRight]) {
                if (middleLeft == 0 && middleRight == length-1) {
                    break;
                }
                middleLeft--;
                middleRight++;
            }
            if (middleLeft == 0) {
                int nl = Integer.parseInt(chars[middleLeft]+"");
                int nr = Integer.parseInt(chars[middleRight]+"");
                if (chars[middleLeft] == '1') {
                    int diff1 = nr + 1;
                    int diff2 = Math.abs(nl-nr);
                    int diff3 = nl+10-nr;
                    int min = Math.min(Math.min(diff1,diff2),diff3);
                    if (diff1 == min) {
                        return "9";
                    } else if (diff2 == min) {
                        chars[middleRight] = chars[middleLeft];
                        return new String(chars);
                    } else {
                        chars[middleLeft]++;
                        chars[middleRight] = chars[middleLeft];
                        return new String(chars);
                    }
                }
                int diff1 = nr + 1;
                int diff2 = Math.abs(nl-nr);
                int diff3 = nl+10-nr;
                int min = Math.min(Math.min(diff1,diff2),diff3);
                if (diff1 == min) {
                    chars[middleLeft]--;
                    chars[middleRight] = chars[middleLeft];
                    return new String(chars);
                } else if (diff2 == min) {
                    chars[middleRight] = chars[middleLeft];
                    return new String(chars);
                } else {
                    chars[middleLeft]++;
                    chars[middleRight] = chars[middleLeft];
                    return new String(chars);
                }
            }
            if (middleLeft + 1 == middleRight) {
                int nl = Integer.parseInt(chars[middleLeft]+"");
                int nr = Integer.parseInt(chars[middleRight]+"");
                if (nl < nr) {
                    for (int i = 0; i < middleLeft; i++) {
                        chars[length-1-i] = chars[i];
                    }
                    chars[middleRight] = chars[middleLeft];
                    int diff1 = getDiff(n.substring(middleLeft),new String(chars).substring(middleLeft));
                    chars[middleLeft]++;
                    chars[middleRight] = chars[middleLeft];
                    int diff2 = getDiff(n.substring(middleLeft),new String(chars).substring(middleLeft));
                    int min = Math.min(diff1,diff2);
                    if (diff1 == min) {
                        chars[middleLeft]--;
                        chars[middleRight] = chars[middleLeft];
                        return new String(chars);
                    }
                    return new String(chars);
                }
                chars[middleLeft]--;
                for (int i = 0; i <= middleLeft; i++) {
                    chars[length-1-i] = chars[i];
                }
                int diff1 = getDiff(n.substring(middleLeft),new String(chars).substring(middleLeft));
                chars[middleLeft]++;
                chars[middleRight] = chars[middleLeft];
                int diff2 = getDiff(n.substring(middleLeft),new String(chars).substring(middleLeft));
                int min = Math.min(diff1,diff2);
                if (diff1 == min) {
                    chars[middleLeft]--;
                    chars[middleRight] = chars[middleLeft];
                    return new String(chars);
                }
                for (int i = 0; i <= middleLeft; i++) {
                    chars[length-1-i] = chars[i];
                }
                return new String(chars);
            }
            for (int i = 0; i <= middleLeft; i++) {
                chars[length-1-i] = chars[i];
            }
            return new String(chars);
        }
        int middleLeft = length/2-1;
        int middleRight = middleLeft + 2;
        while (chars[middleLeft] == chars[middleRight]) {
            if (middleLeft == 0 && middleRight == length-1) {
                break;
            }
            middleLeft--;
            middleRight++;
        }
        if (chars[length/2] == '0' && chars[middleLeft] == '1' && chars[middleRight] == '0') {
            char[] chars1 = new char[length-1];
            if (middleLeft - 1 >= 0) System.arraycopy(chars, 0, chars1, 0, middleLeft - 1);
            for (int i = middleLeft; i < middleRight; i++) {
                chars1[i] = '9';
            }
            for (int i = middleRight+1; i < length; i++) {
                chars1[i-1] = chars[length-2-i];
            }
            return new String(chars1);
        }
        int nl = Integer.parseInt(chars[middleLeft]+"");
        int nr = Integer.parseInt(chars[middleRight]+"");
        if (nl > nr) {
            char[] chars1 = n.toCharArray();
            for (int i = 0; i <= middleLeft; i++) {
                chars1[length-1-i] = chars1[i];
            }

            boolean allZero = true;
            for (int i = middleLeft+1; i < middleRight; i++) {
                if (chars[i] != '0') {
                    allZero = false;
                    break;
                }
            }
            if (allZero) {
                for (int i = middleLeft+1; i < middleRight; i++) {
                    chars1[i] = '9';
                }
                chars1[middleLeft]--;
                chars1[middleRight] = chars1[middleLeft];
            } else {
                for (int i = middleRight-1; i >= length/2; i--) {
                    if (chars1[i] != 0) {
                        chars1[i]--;
                        chars1[length-1-i] = chars1[i];
                        break;
                    }
                }
            }
            int diff1 = getDiff(n.substring(middleLeft),new String(chars1).substring(middleLeft));
            for (int i = 0; i <= middleLeft; i++) {
                chars[length-1-i] = chars[i];
            }
            int diff2 = getDiff(n.substring(middleLeft),new String(chars).substring(middleLeft));
            int min = Math.min(diff1,diff2);
            if (diff1 == min) {
                return new String(chars1);
            }
            return new String(chars);
        }
        int diff1 = nr - nl;
        int diff2 = 10-nr+nl;
        int min = Math.min(diff1,diff2);
        if (diff1 == min) {
            for (int i = 0; i <= middleLeft; i++) {
                chars[length-1-i] = chars[i];
            }
            return new String(chars);
        }
        for (int i = 0; i <= middleLeft; i++) {
            chars[length-1-i] = chars[i];
        }
        chars[length/2]++;
        return new String(chars);
    }

    public int getDiff(String s1, String s2) {
        long l1 = Long.parseLong(s1);
        long l2 = Long.parseLong(s2);
        long abs = Math.abs(l2 - l1);
        return (int)abs;
    }

    public static void main(String[] args) {
        NearestPalindromic nearestPalindromic = new NearestPalindromic();
        System.out.println(nearestPalindromic.nearestPalindromic("9009"));
        System.out.println("505".equals(nearestPalindromic.nearestPalindromic("500")));
        System.out.println(nearestPalindromic.nearestPalindromic("123892133"));
        System.out.println(nearestPalindromic.nearestPalindromic("98765"));

        System.out.println(nearestPalindromic.nearestPalindromic("1325060231"));
        System.out.println(nearestPalindromic.nearestPalindromic("1805170081"));
        System.out.println(nearestPalindromic.nearestPalindromic("1837722381"));
        System.out.println(nearestPalindromic.nearestPalindromic("12389"));
        System.out.println(nearestPalindromic.nearestPalindromic("10001"));
        System.out.println(nearestPalindromic.nearestPalindromic("11011"));
        System.out.println(nearestPalindromic.nearestPalindromic("11911"));
        System.out.println(nearestPalindromic.nearestPalindromic("1234"));
        System.out.println(nearestPalindromic.nearestPalindromic("9"));
        System.out.println("999".equals(nearestPalindromic.nearestPalindromic("1000")));

        System.out.println(nearestPalindromic.nearestPalindromic("999"));
        System.out.println(nearestPalindromic.nearestPalindromic("99"));
        System.out.println(nearestPalindromic.nearestPalindromic("100"));
        System.out.println(nearestPalindromic.nearestPalindromic("807045053224792883"));
        System.out.println("1221".equals(nearestPalindromic.nearestPalindromic("1213")));
        System.out.println("9".equals(nearestPalindromic.nearestPalindromic("10")));

        System.out.println(nearestPalindromic.nearestPalindromic("123"));
        System.out.println(nearestPalindromic.nearestPalindromic("1"));
    }
}
