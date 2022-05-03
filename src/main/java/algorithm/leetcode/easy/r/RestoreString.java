package algorithm.leetcode.easy.r;

public class RestoreString {

    public String restoreString(String s, int[] indices) {
        char[] chars = s.toCharArray();
        int length = indices.length;
        while (true) {
            boolean changed = false;
            for (int i = 0; i < length; i++) {
                int left = indices[i];
                if (left > 0) {
                    int right = indices[left];
                    if (left != right && right >= 0) {
                        changed = true;
                        char temp = chars[i];
                        chars[i] = chars[left];
                        chars[left] = temp;
                        int t = indices[i];
                        indices[i] = indices[left];
                        indices[left] = -t;
                    }
                }
            }
            if (!changed) {
                break;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        RestoreString restoreString = new RestoreString();
        System.out.println(restoreString.restoreString("codeleet", new int[]{4,5,6,7,0,2,1,3}));
    }
}
