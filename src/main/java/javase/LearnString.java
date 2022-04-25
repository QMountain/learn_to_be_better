package javase;

/**
 * @ClassName LearnString
 * @Description
 * @Author qsf
 * Date   2021-11-21  20:33
 */
public class LearnString {

    public static void main(String[] args) {
        String s1 = "tomcat";
        String s2 = "tomcat";
        String s3 = new String("tomcat");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        String str1 = "tomcat";
        String str2 = "tom";
        String str3 = "cat";
        System.out.println(str1 == str2+str3);

        String str4 = "tomcat";
        String str5 = "tom";
        System.out.println(str4 == str5+"cat");
    }
}
