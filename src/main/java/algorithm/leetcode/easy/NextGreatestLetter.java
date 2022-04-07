package algorithm.leetcode.easy;

public class NextGreatestLetter {

    public char nextGreatestLetter(char[] letters, char target) {
        int length = letters.length;
        int left = 0;
        int right = length-1;
        while (left < right) {
            if (left == right-1) {
                if (letters[left] > target) {
                    return letters[left];
                }
                if (letters[right] > target) {
                    return letters[right];
                }
                return letters[0];
            }
            int mid = (right-left)/2+left;
            if (letters[mid] == target) {
                if (mid == length-1) {
                    return letters[0];
                }
                left = mid;
            } else if (letters[mid] > target) {
                if (mid == 0) {
                    return letters[0];
                } else {
                    if (letters[mid-1] > target) {
                        right = mid;
                    } else {
                        return letters[mid];
                    }
                }
            } else {
                left = mid;
            }
        }

        return letters[0];
    }

    public static void main(String[] args) {
        NextGreatestLetter nextGreatestLetter = new NextGreatestLetter();
        System.out.println(nextGreatestLetter.nextGreatestLetter(
                new char[]{'e', 'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n'}, 'e'));
        System.out.println(nextGreatestLetter.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j'));
        System.out.println(nextGreatestLetter.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
        System.out.println(nextGreatestLetter.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
        System.out.println(nextGreatestLetter.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd'));
    }
}
