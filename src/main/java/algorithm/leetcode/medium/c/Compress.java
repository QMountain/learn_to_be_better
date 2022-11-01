package algorithm.leetcode.medium.c;

public class Compress {

    public int compress(char[] chars) {
        int ans = 0;
        char lastChar = chars[0];
        int count = 0;
        int length = chars.length;
        int writeIndex = 0;
        for (int i = 0; i < length; i++) {
            char aChar = chars[i];
            if (aChar == lastChar) {
                count++;
                if (i == length-1) {
                    String countStr = String.valueOf(count);
                    chars[writeIndex++] = lastChar;
                    if (count > 1) {
                        ans += String.valueOf(count).length()+1;
                        for (int j = 0; j < countStr.length(); j++) {
                            chars[writeIndex++] = countStr.charAt(j);
                        }
                    } else {
                        ans++;
                    }
                }
            } else {
                String countStr = String.valueOf(count);
                chars[writeIndex++] = lastChar;
                if (count > 1) {
                    ans += countStr.length()+1;
                    for (int j = 0; j < countStr.length(); j++) {
                        chars[writeIndex++] = countStr.charAt(j);
                    }
                } else {
                    ans++;
                }
                lastChar = aChar;
                count = 1;
                if (i == length-1) {
                    ans++;
                    chars[writeIndex++] = lastChar;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Compress compress = new Compress();
        System.out.println(3 == compress.compress(new char[]{'a','b','c'}));
        System.out.println(4 == compress.compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
        System.out.println(1 == compress.compress(new char[]{'a'}));
        System.out.println(6 == compress.compress(new char[]{'a','a','b','b','c','c','c'}));
    }
}
