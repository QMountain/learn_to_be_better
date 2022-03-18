package algorithm.nowcoder;

import java.util.ArrayList;
import java.util.List;

public class HuaweiOne {

    public static String combine(String s) {
        String[] split = s.split(",");
        List<String> stringList = new ArrayList<>(split.length);
        int minLength = s.length();
        for (String s1 : split) {
            stringList.add(s1);
            minLength = Math.min(minLength,s1.length());
        }

        StringBuilder maxStr = new StringBuilder();
        for (int i = 0; i < minLength; i++) {
            maxStr.append("0");
        }
        String max = maxStr.toString();
        String needRemove = "";
        for (String s1 : split) {
            String substring = s1.substring(0, minLength);
            if (substring.compareTo(max) > 0) {
                max = substring;
                needRemove = s1;
            }
        }
        stringList.remove(needRemove);
        return needRemove + getFromList(stringList);
    }

    public static String getFromList(List<String> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        int minLength = list.get(0).length();
        for (String s : list) {
            minLength = Math.min(minLength,s.length());
        }
        StringBuilder maxStr = new StringBuilder();
        for (int i = 0; i < minLength; i++) {
            maxStr.append("0");
        }
        String max = maxStr.toString();
        String needRemove = "";
        for (String s : list) {
            String substring = s.substring(0, minLength);
            if (substring.compareTo(max) > 0) {
                max = substring;
                needRemove = s;
            }
        }
        list.remove(needRemove);
        return needRemove + getFromList(list);
    }

    public static void main(String[] args) {
        System.out.println(HuaweiOne.combine("22,221"));
        System.out.println(HuaweiOne.combine("4589,101,41425,9999"));
        System.out.println(HuaweiOne.combine(""));
    }
}
