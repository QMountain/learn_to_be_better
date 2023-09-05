package algorithm.leetcode.medium.c;

import algorithm.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize1(TreeNode root) {
        if (root == null) {
            return "()";
        }
        return "("+root.val+","+serialize(root.left)+","+serialize(root.right)+")";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize1(String data) {
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

    public String serialize(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        String str = list.toString();
        return str.substring(1, str.length() - 1);
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] arr = data.split(", ");
        Deque<Integer> stack = new ArrayDeque<>();
        for (String s : arr) {
            stack.push(Integer.parseInt(s));
        }
        return construct(Integer.MIN_VALUE, Integer.MAX_VALUE, stack);
    }

    private void postOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }

    private TreeNode construct(int lower, int upper, Deque<Integer> stack) {
        if (stack.isEmpty() || stack.peek() < lower || stack.peek() > upper) {
            return null;
        }
        int val = stack.pop();
        TreeNode root = new TreeNode(val);
        root.right = construct(val, upper, stack);
        root.left = construct(lower, val, stack);
        return root;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        String serialize = codec.serialize(new TreeNode(2, new TreeNode(1), new TreeNode(3)));
        System.out.println(serialize);
        TreeNode deserialize = codec.deserialize(serialize);
        System.out.println(deserialize);
    }
}
