package algorithm.leetcode.medium.c;

import java.util.ArrayList;
import java.util.List;

public class CamelMatch {

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ansList = new ArrayList<>(queries.length);
        for (String query : queries) {
            int qi = 0;
            int pi = 0;
            while (qi < query.length() && pi < pattern.length()) {
                char qc = query.charAt(qi);
                char pc = pattern.charAt(pi);
                if (qc == pc) {
                    qi++;
                    pi++;
                    continue;
                }
                if (Character.isUpperCase(qc)) {
                    ansList.add(false);
                    break;
                }
                qi++;
            }

            if (qi == query.length() && pi == pattern.length()) {
                ansList.add(true);
                continue;
            }
            if (qi == query.length()) {
                ansList.add(false);
                continue;
            }
            if (pi == pattern.length()) {
                boolean match = true;
                for (int i = qi; i < query.length(); i++) {
                    if (Character.isUpperCase(query.charAt(i))) {
                        match = false;
                        break;
                    }
                }
                ansList.add(match);
            }
        }
        return ansList;
    }

    public static void main(String[] args) {
        CamelMatch camelMatch = new CamelMatch();
        System.out.println(camelMatch.camelMatch(new String[]{"CompetitiveProgramming","CounterPick","ControlPanel"}, "CooP"));
        System.out.println(camelMatch.camelMatch(new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"}, "FoBaT"));
        System.out.println(camelMatch.camelMatch(new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"}, "FoBa"));
        System.out.println(camelMatch.camelMatch(new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"}, "FB"));
    }
}
