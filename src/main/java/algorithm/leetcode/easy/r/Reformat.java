package algorithm.leetcode.easy.r;

import java.util.ArrayList;
import java.util.List;

public class Reformat {

    public String reformat(String s) {
        int length = s.length();
        List<Character> charList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                intList.add(Integer.parseInt(c+""));
            } else {
                charList.add(c);
            }
        }
        int cSize = charList.size();
        int iSize = intList.size();
        if (cSize > iSize) {
            if (cSize - iSize > 1) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < iSize; i++) {
                sb.append(charList.get(i));
                sb.append(intList.get(i));
            }
            for (int i = iSize; i < cSize; i++) {
                sb.append(charList.get(i));
            }
            return sb.toString();
        }
        if (iSize - cSize > 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cSize; i++) {
            sb.append(intList.get(i));
            sb.append(charList.get(i));
        }
        for (int i = cSize; i < iSize; i++) {
            sb.append(intList.get(i));
        }
        return sb.toString();
    }

}
