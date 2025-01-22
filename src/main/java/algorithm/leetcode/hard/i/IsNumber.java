package algorithm.leetcode.hard.i;

public class IsNumber {

    public boolean isNumber(String s) {
        return s.matches("^[+-]?(\\d+\\.?|\\.\\d+)\\d*(([eE])[+-]?\\d+)?$");
    }

}
