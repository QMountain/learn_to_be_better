package algorithm.leetcode.medium.s;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {

    public String simplifyPath2(String path) {
        if (path.equals("/.")) {
            return "/";
        }
        while (path.contains("/./")) {
            path = path.replaceFirst("/\\./","/");
        }
        while (path.contains("//")) {
            path = path.replaceAll("//","/");
        }
        while (path.contains("/../")) {
            int index = path.indexOf("/../");
            int preIndex = -1;
            for (int i = index-1; i >= 0; i--) {
                if (path.charAt(i) == '/') {
                    preIndex = i;
                    break;
                }
            }
            if (preIndex == -1) {
                path = path.replaceFirst("/../","/");
            } else {
                path = path.substring(0,preIndex) + path.substring(index+3);
            }
        }
        if (path.equals("/")) {
            return path;
        }
        if (path.endsWith("/.")) {
            path = path.substring(0,path.length()-2);
        }
        if (path.endsWith("/..")) {
            int preIndex = -1;
            for (int i = path.length()-3-1; i >= 0; i--) {
                if (path.charAt(i) == '/') {
                    preIndex = i;
                    break;
                }
            }
            if (preIndex == -1) {
                return "/";
            } else {
                path = path.substring(0,preIndex);
            }
        }
        if (path.equals("")) {
            return "/";
        }
        while (path.length() > 1 && path.endsWith("/")) {
            path = path.substring(0,path.length()-1);
        }
        return path;
    }

    public String simplifyPath(String path) {
        String[] names = path.split("/");
        Deque<String> stack = new ArrayDeque<String>();
        for (String name : names) {
            if ("..".equals(name)) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (name.length() > 0 && !".".equals(name)) {
                stack.offerLast(name);
            }
        }
        StringBuilder ans = new StringBuilder();
        if (stack.isEmpty()) {
            ans.append('/');
        } else {
            while (!stack.isEmpty()) {
                ans.append('/');
                ans.append(stack.pollFirst());
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        SimplifyPath simplifyPath = new SimplifyPath();
        System.out.println("/AagbK/iavh/M/rmKaS/tXD/lND".equals(simplifyPath.simplifyPath("/AagbK/////iavh/M/rmKaS/tXD/././lND//")));
        System.out.println("/".equals(simplifyPath.simplifyPath("///eHx/..")));
        System.out.println("/is/here".equals(simplifyPath.simplifyPath("/home/of/foo/../../bar/../../is/./here/.")));
        System.out.println("/".equals(simplifyPath.simplifyPath("/home/../../..")));
        System.out.println("/a/b/c".equals(simplifyPath.simplifyPath("/a//b////c/d//././/..")));
        System.out.println("/c".equals(simplifyPath.simplifyPath("/a/../../b/../c//.//")));
        System.out.println(simplifyPath.simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyPath.simplifyPath("/home//foo/"));
        System.out.println(simplifyPath.simplifyPath("/../"));
        System.out.println(simplifyPath.simplifyPath("/home/"));
    }
}
