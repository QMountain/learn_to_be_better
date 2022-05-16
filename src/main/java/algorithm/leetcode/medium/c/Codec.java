package algorithm.leetcode.medium.c;

import algorithm.TreeNode;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "()";
        }
        return "("+root.val+","+serialize(root.left)+","+serialize(root.right)+")";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("()")) {
            return null;
        }
        data = data.substring(1,data.length()-1);
        int index = data.indexOf(",");
        String value = data.substring(0, index);
        int countLeft = 1;
        int countRight = 0;
        int length = data.length();
        int second = index+1;
        for (int i = index+2; i < length; i++) {
            char c = data.charAt(i);
            if (c == '(') {
                countLeft++;
            } else if (c == ')') {
                countRight++;
            }
            if (countLeft == countRight) {
                second = i;
                break;
            }
        }
        String secondStr = data.substring(index+1,second+1);
        String thirdStr = data.substring(second+2);
        return new TreeNode(Integer.parseInt(value),deserialize(secondStr),deserialize(thirdStr));
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        String serialize = codec.serialize(new TreeNode(2, new TreeNode(1), new TreeNode(3)));
        System.out.println(serialize);
        TreeNode deserialize = codec.deserialize(serialize);
        System.out.println(deserialize);
    }
}
