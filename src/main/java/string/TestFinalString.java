package string;

/**
 * ����final string
 *
 */
public class TestFinalString {
    public static void main(String[] args) {
        String s = "123hello";
        final String s1 = "123";
        final String s2 = "hello";

        final String f = testStr("hello");

        String s3 = "123" + f;

        // ����Ϊfalse��ԭ������Ϊ testStr
        // ����ֵ�ǿ����޸ĵģ������ f ���������ָ�����һ�����������ã�
        // ������ĳһ��string��
        System.out.println(s==s3);

        new StringBuffer("12");

        // ��ӡʵ�ʵĵ�ַ���в���
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
