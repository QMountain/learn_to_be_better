package algorithm.leetcode.easy;

import java.util.List;

public class ReadBinaryWatch {

    public List<String> readBinaryWatch(int turnedOn) {
        for (int i = 0; i <= 4 && i <= turnedOn; i++) {
            String h = "";
            if (i == 0) {
                h = "0";
            } else if (i == 1) {
                h = "1";
                h = "2";
                h = "4";
                h = "8";
            }
            for (int j = 0; j <= 6 && j <= turnedOn-i; j++) {

            }
        }
        return null;
    }

}
