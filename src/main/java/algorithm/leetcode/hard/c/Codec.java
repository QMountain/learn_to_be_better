package algorithm.leetcode.hard.c;

import algorithm.TreeNode;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "{}";
        }
        return "{"+root.val+","+
                serialize(root.left)+","+
                serialize(root.right)+"}";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("{}")) {
            return null;
        }
        int i = data.indexOf(",");
        String rootVal = data.substring(1, i);
        int val = Integer.parseInt(rootVal);
        int countLeft = 1;
        int countRight = 0;
        int length = data.length();
        int leftNodeEnd = -1;
        for (int j = i+2; j < length; j++) {
            if (data.charAt(j) == '{') {
                countLeft++;
            } else if (data.charAt(j) == '}') {
                countRight++;
            }
            if (countLeft == countRight) {
                leftNodeEnd = j;
                break;
            }
        }
        String leftNodeStr = data.substring(i+1,leftNodeEnd+1);
        String rightNodeStr = data.substring(leftNodeEnd+2,length-1);
        TreeNode leftNode = deserialize(leftNodeStr);
        TreeNode rightNode = deserialize(rightNodeStr);
        return new TreeNode(val,leftNode,rightNode);
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        String serialize = codec.serialize(new TreeNode(1, new TreeNode(2),
                new TreeNode(3,
                        new TreeNode(4), new TreeNode(5))));
        System.out.println(serialize);
        TreeNode node = codec.deserialize(serialize);
        System.out.println(node);
    }
}
