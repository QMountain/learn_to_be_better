package algorithm.leetcode.medium.c;

public class CompareVersion {

    public int compareVersion(String version1, String version2) {
        int lastIndex1 = 0;
        int lastIndex2 = 0;
        int length1 = version1.length();
        int length2 = version2.length();
        while (lastIndex1 < length1 || lastIndex2 < length2) {
            int index1 = version1.indexOf(".", lastIndex1);
            int index2 = version2.indexOf(".", lastIndex2);
            int num1;
            if (index1 != -1) {
                num1 = Integer.parseInt(version1.substring(lastIndex1,index1));
                lastIndex1 = index1+1;
            } else if (lastIndex1 < length1){
                num1 = Integer.parseInt(version1.substring(lastIndex1));
                lastIndex1 = length1;
            } else {
                num1 = 0;
                lastIndex1 = length1;
            }
            int num2;
            if (index2 != -1) {
                num2 = Integer.parseInt(version2.substring(lastIndex2,index2));
                lastIndex2 = index2+1;
            } else if (lastIndex2 < length2){
                num2 = Integer.parseInt(version2.substring(lastIndex2));
                lastIndex2 = length2;
            } else {
                num2 = 0;
                lastIndex2 = length2;
            }
            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        CompareVersion compareVersion = new CompareVersion();
        System.out.println(compareVersion.compareVersion("0.1", "1.1"));
        System.out.println(compareVersion.compareVersion("1.0", "1.0.0"));
        System.out.println(compareVersion.compareVersion("1.01", "1.001"));
    }
}
