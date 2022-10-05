package algorithm.leetcode.medium.s;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisits {

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] s = cpdomain.split(" ");
            int count = Integer.parseInt(s[0]);
            String ss = s[1];
            while (ss.contains(".")) {
                map.put(ss,map.getOrDefault(ss,0)+count);
                int i = ss.indexOf(".");
                ss = ss.substring(i+1);
            }
            map.put(ss,map.getOrDefault(ss,0)+count);
        }
        List<String> ansList = new ArrayList<>();
        map.forEach((k,v)->{
            ansList.add(v+" "+k);
        });
        return ansList;
    }

    public static void main(String[] args) {
        SubdomainVisits subdomainVisits = new SubdomainVisits();
        System.out.println(subdomainVisits.subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
        System.out.println(subdomainVisits.subdomainVisits(new String[]{"9001 discuss.leetcode.com"}));
    }
}
