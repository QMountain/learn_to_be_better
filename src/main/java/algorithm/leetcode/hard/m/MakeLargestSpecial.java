package algorithm.leetcode.hard.m;

public class MakeLargestSpecial {

    int lastIndex;
    public String makeLargestSpecial(String s) {
        lastIndex = 0;
        while (0 <= lastIndex && lastIndex < s.length()) {
            String make = makeFromIndex(s,lastIndex);
            while (0 <= lastIndex && lastIndex < s.length() && make.equals(s)) {
                make = makeFromIndex(s,lastIndex);
            }
            s = make;
        }
        return s;
    }

    public String makeFromIndex(String s, int index) {
        int length = s.length();
        int zeroIndex = s.indexOf("0", index);
        int oneIndex = s.indexOf("1", zeroIndex);
        if (oneIndex == -1) {
            lastIndex = oneIndex;
            return s;
        }
        int lengthOfOne = 0;
        int sizeOfZero = oneIndex-zeroIndex;
        int preSizeOfOne = 0;
        int prePartStartIndex = 0;
        for (int i = zeroIndex-1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                sizeOfZero++;
            } else {
                preSizeOfOne++;
            }
            if (sizeOfZero == preSizeOfOne) {
                for (int j = i; j < zeroIndex; j++) {
                    if (s.charAt(j) == '1') {
                        lengthOfOne++;
                    } else {
                        break;
                    }
                }
                prePartStartIndex = i;
                break;
            }
        }
        int consecutiveOneLength = 1;
        boolean consecutive = true;
        int count1 = 1;
        int count0 = 0;
        for (int i = oneIndex+1; i < length; i++) {
            if (s.charAt(i) == '1') {
                if (consecutive) {
                    consecutiveOneLength++;
                }
                count1++;
            } else {
                consecutive = false;
                count0++;
            }
            if (!consecutive && count1 == count0) {
                if (consecutiveOneLength > lengthOfOne) {
                    lastIndex = 0;
                    return s.substring(0,prePartStartIndex)+s.substring(oneIndex,i+1) +s.substring(prePartStartIndex,oneIndex)+s.substring(i+1);
                }
                String prePart = s.substring(prePartStartIndex, oneIndex);
                String nextPart = s.substring(oneIndex, i+1);
                if (nextPart.compareTo(prePart) > 0) {
                    lastIndex = 0;
                    return s.substring(0,prePartStartIndex)+s.substring(oneIndex,i+1) +s.substring(prePartStartIndex,oneIndex)+s.substring(i+1);
                }

                lastIndex = oneIndex;
                break;
            }

        }
        return s;
    }

    public static void main(String[] args) {
        MakeLargestSpecial makeLargestSpecial = new MakeLargestSpecial();
        System.out.println(makeLargestSpecial.makeLargestSpecial("11101010110001101000111110110010000011110100011000").equals("11111100101000001111010001100011110010101001101000"));
        System.out.println(makeLargestSpecial.makeLargestSpecial("10101101100110011000101101110000").equals("11110001001110011001100100101010"));
        System.out.println(makeLargestSpecial.makeLargestSpecial("11101001111001010000110010").equals("11111001010001101000110010"));
        System.out.println(makeLargestSpecial.makeLargestSpecial("101110110011010000").equals("111101001100100010"));
        System.out.println(makeLargestSpecial.makeLargestSpecial("11011000"));
    }
}
