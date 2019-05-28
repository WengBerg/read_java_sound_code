package string;

/**
 * 测试final string
 *
 */
public class TestFinalString {
    public static void main(String[] args) {
        String s = "123hello";
        final String s1 = "123";
        final String s2 = "hello";

        final String f = testStr("hello");

        String s3 = "123" + f;

        // 这里为false的原因是因为 testStr
        // 传的值是可以修改的，这里的 f 不变的引用指向的是一个方法的引用，
        // 而不是某一个string的
        System.out.println(s==s3);

        new StringBuffer("12");

        // 打印实际的地址进行测试
        System.out.println("*******************");

        final String str1 = "123";

        String str2 = "12";

        System.out.println(System.identityHashCode(str1));
        System.out.println(System.identityHashCode((str2+"3").intern()));
        System.gc();

    }

    public static String testStr(String s) {
        return s;
    }
}
