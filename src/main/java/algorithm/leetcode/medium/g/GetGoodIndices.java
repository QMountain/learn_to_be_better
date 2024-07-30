package algorithm.leetcode.medium.g;

import java.util.ArrayList;
import java.util.List;

public class GetGoodIndices {

    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < variables.length; i++) {
            int[] variable = variables[i];
            variable[0] %= 10;
            int prefix = 1;
            while (variable[1] > 1) {
                if (variable[1] % 2 == 1) {
                    prefix *= variable[0];
                    variable[1]--;
                }
                variable[0] *= variable[0];
                variable[0] %= 10;
                variable[1] >>= 1;
            }
            prefix *= variable[0];
            prefix %= 10;
            prefix %= variable[3];
            if (prefix < 2) {
                if (prefix == target) {
                    ans.add(i);
                }
                continue;
            }
            int suffix = 1;
            while (variable[2] > 1) {
                if (variable[2] % 2 == 1) {
                    suffix *= prefix;
                    suffix %= variable[3];
                    variable[2]--;
                }
                prefix *= prefix;
                prefix %= variable[3];
                variable[2] >>= 1;
            }
            suffix *= prefix;
            suffix %= variable[3];
            if (suffix == target) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        GetGoodIndices getGoodIndices = new GetGoodIndices();
        System.out.println(getGoodIndices.getGoodIndices(
                new int[][]{{2,2,3,2},{1,3,3,2},{3,2,2,3},{3,1,2,3},{1,2,3,1},{2,2,2,2},{2,1,3,1},{3,2,2,2},{2,1,3,1},{3,3,1,3}}
                , 0));
        System.out.println(getGoodIndices.getGoodIndices(
                new int[][]{{39,3,1000,1000}}, 17));
        System.out.println(getGoodIndices.getGoodIndices(
                new int[][]{{2,3,3,10},{3,3,3,1},{6,1,1,4}}, 2));
    }
}
