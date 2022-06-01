package algorithm.leetcode.medium.d;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Deserialize {

    public NestedInteger deserialize(String s) {
        // list
        if (s.startsWith("[")) {
            NestedInteger nestedInteger = new NestedInteger();
            s = s.substring(1,s.length()-1);
            // list的每个元素，有的是list
            while (s.contains("[")) {
                    // 处理开头的非list
                    int index = s.indexOf("[");
                    String substring = s.substring(0, index);
                    String[] split = substring.split(",");
                    for (String s1 : split) {
                        if (!Objects.equals(s1,"")) {
                            nestedInteger.add(new NestedInteger(Integer.parseInt(s1)));
                        }
                    }
                    s = s.substring(index);
                    // 如果中间有 list
                    int countL = 0;
                    int countR = 0;
                    int lastIndex = 0;
                    int length = s.length();
                    for (int i = 0; i < length; i++) {
                        if (s.charAt(i) == '[') {
                            countL++;
                        } else if (s.charAt(i) == ']') {
                            if (countL > countR) {
                                countR++;
                                lastIndex = i;
                                if (countL == countR) {
                                    break;
                                }
                            } else {
                                break;
                            }

                        }
                    }
                    nestedInteger.add(deserialize(s.substring(0,lastIndex+1)));
                    s = s.substring(lastIndex+1);
                    if (s.startsWith(",")) {
                        s = s.substring(1);
                    }
                    if (Objects.equals(s,"")) {
                        break;
                    }
                }

            // list 里全是 single integer
            String[] split = s.split(",");
            for (String s1 : split) {
                if (!Objects.equals(s1,"")) {
                    nestedInteger.add(new NestedInteger(Integer.parseInt(s1)));
                }
            }

            return nestedInteger;
        }

        // single integer
        return new NestedInteger(Integer.parseInt(s));
    }

    public static void main(String[] args) {
        Deserialize deserialize = new Deserialize();
        System.out.println(deserialize.deserialize("[[],[[[[]],-4],[[[]],[0],[[]]]]]"));
        System.out.println(deserialize.deserialize("[123,456,[788,799,833],[[]],10,[]]"));
        System.out.println(deserialize.deserialize("[123,[456,[789]]]"));
        System.out.println(deserialize.deserialize("324"));
    }
}

class NestedInteger {

    private Integer value;
    private List<NestedInteger> nestedList;

    // Constructor initializes an empty nested list.
    public NestedInteger() {
        nestedList = new ArrayList<>();
    };

    // Constructor initializes a single integer.
    public NestedInteger(int value) {
        this.value = value;
    };

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
     public boolean isInteger() {
         return value != null;
     };

     // @return the single integer that this NestedInteger holds, if it holds a single integer
     // Return null if this NestedInteger holds a nested list
     public Integer getInteger() {
         if (value != null) {
             return value;
         }
         return null;
     };

     // Set this NestedInteger to hold a single integer.
     public void setInteger(int value) {
         this.value = value;
     };

     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
     public void add(NestedInteger ni) {
         if (nestedList == null) {
             nestedList = new ArrayList<>();
         }
         nestedList.add(ni);
     };

     // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
     public List<NestedInteger> getList() {
         if (nestedList != null) {
             return nestedList;
         }
         return new ArrayList<>();
     };
}
