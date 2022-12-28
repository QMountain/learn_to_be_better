package algorithm.leetcode.medium.v;

public class ValidIPAddress {

    public String validIPAddress(String queryIP) {
        if (queryIP.contains(".")) {
            return validIPV4(queryIP);
        }
        return validIPV6(queryIP);
    }

    public String validIPV4(String queryIP) {
        int lastPointIndex = 0;
        for (int i = 0; i < 3; i++) {
            int nextPointIndex = queryIP.indexOf(".",lastPointIndex);
            if (nextPointIndex == -1) {
                return "Neither";
            }
            String firstPartStr = queryIP.substring(lastPointIndex, nextPointIndex);
            if (checkNotIPV4Part(firstPartStr)) {
                return "Neither";
            }
            lastPointIndex = nextPointIndex+1;
        }
        if (checkNotIPV4Part(queryIP.substring(lastPointIndex))) {
            return "Neither";
        }
        return "IPv4";
    }

    public boolean checkNotIPV4Part(String partStr) {
        int length = partStr.length();
        if (partStr.startsWith("0") && length > 1) {
            return true;
        }
        if (length < 1 || length > 3) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(partStr.charAt(i))) {
                return true;
            }
        }
        int partNum = Integer.parseInt(partStr);
        return partNum > 255;
    }

    public String validIPV6(String queryIP) {
        int lastPointIndex = 0;
        for (int i = 0; i < 7; i++) {
            int nextPointIndex = queryIP.indexOf(":",lastPointIndex);
            if (nextPointIndex == -1) {
                return "Neither";
            }
            String partStr = queryIP.substring(lastPointIndex, nextPointIndex);
            if (checkNotIPV6Part(partStr)) {
                return "Neither";
            }
            lastPointIndex = nextPointIndex+1;
        }
        if (checkNotIPV6Part(queryIP.substring(lastPointIndex))) {
            return "Neither";
        }
        return "IPv6";
    }

    public boolean checkNotIPV6Part(String partStr) {
        int length = partStr.length();
        if (length < 1 || length > 4) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            char c = partStr.charAt(i);
            if (!Character.isDigit(c)) {
                if (c >= 'a' && c <= 'f') {
                    continue;
                }
                if (c >= 'A' && c <= 'F') {
                    continue;
                }
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ValidIPAddress validIPAddress = new ValidIPAddress();
        System.out.println(validIPAddress.validIPAddress("1.0.1."));
        System.out.println(validIPAddress.validIPAddress("256.256.256.256"));
        System.out.println(validIPAddress.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        System.out.println(validIPAddress.validIPAddress("172.16.254.1"));
    }
}
