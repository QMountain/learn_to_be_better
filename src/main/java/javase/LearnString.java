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

        String q1 = "mountain1";
        String q2 = "mountain12";
        System.out.println((q1+"2").equals(q2));
        System.out.println((q1+"2").intern().equals(q2.intern()));

        // String::intern()是一个本地方法，
        // 它的作用是如果字符串常量池中已经包含一个等于（equals比较）此String对象的字符串，
        // 则返回代表常量池中这个字符串的String对象的引用;
        // 否则，会将此String对象包含的字符串添加到常量池中，并且返回此String对象的引用。

        // jdk 1.6 false  jdk 1.7 true
        String st1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(st1.intern() == st1);
        // jdk 1.6 字符串常量池在永久代里，
        // st1 在堆里被创建，st1.intern() 才将 "计算机软件" 复制到字符串常量池
        // 所以 字符串常量池里的 st1.intern() 不等于 堆里的 st1
        // jdk 1.7 字符串常量池在堆里
        // st1 在堆里被创建，st1.intern() 才将 "计算机软件" 的《引用》复制到字符串常量池
        // 所以 位于堆里的字符串常量池里的 st1.intern() 等于 堆里的 st1

        // jdk 1.6 false  jdk 1.7 false
        String st2 = new StringBuilder("Ja").append("va").toString();
        System.out.println(st2.intern() == st2);
        // 基本逻辑同上，特殊点在于 Java 这个常量在虚拟机启动的过程中就已经被存进常量池
        // st2.intern() 返回的是常量池中 Java 字符串的引用，
        // 而st2指向堆中new StringBuilder("Ja").append("va").toString();生成的对象，所以为false。
    }
}
