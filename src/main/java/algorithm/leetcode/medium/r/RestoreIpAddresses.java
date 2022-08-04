package algorithm.leetcode.medium.r;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> ansList = new ArrayList<>();
        for (int i = 1; i < 4 && i < s.length(); i++) {
            String firstPart = s.substring(0,i);
            if (check(firstPart)) {
                String second = s.substring(i);
                for (int j = 1; j < 4 && j < second.length(); j++) {
                    String secondPart = second.substring(0, j);
                    String third = second.substring(j);
                    if (check(secondPart) && third.length() > 1) {
                        for (int k = 1; k < 4 && k < third.length(); k++) {
                            String thirdPart = third.substring(0, k);
                            String forthPart = third.substring(k);
                            if (check(thirdPart) && check(forthPart)) {
                                String s1 = firstPart + "." + secondPart + "." + thirdPart + "." + forthPart;
                                ansList.add(s1);
                            }
                        }
                    }
                }
            }
        }
        return ansList;
    }

    public boolean check(String s) {
        int length = s.length();
        if (length == 0) {
            return false;
        }
        if (length > 1 && s.startsWith("0")) {
            return false;
        }
        if (length > 3) {
            return false;
        }
        int i = Integer.parseInt(s);
        return i >= 0 && i <= 255;
    }

    public static void main(String[] args) {
        RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
        System.out.println(restoreIpAddresses.restoreIpAddresses("1111"));
        System.out.println(restoreIpAddresses.restoreIpAddresses("101023"));
        System.out.println(restoreIpAddresses.restoreIpAddresses("0000"));
        System.out.println(restoreIpAddresses.restoreIpAddresses("25525511135"));
    }
}
