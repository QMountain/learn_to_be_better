package javase;

public class LearnClassLoader {

    public static void main(String[] args) {
        ClassLoader classLoader = String.class.getClassLoader();
        System.out.println(classLoader);

        ClassLoader classLoader1 = LearnClassLoader.class.getClassLoader();
        System.out.println(classLoader1);
    }
}
