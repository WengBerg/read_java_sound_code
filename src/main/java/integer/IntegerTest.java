package integer;

public class IntegerTest {
    public static void main(String[] args) {
        Integer i = 1;
        Integer j = 1;
        System.out.println(i == j);

        Integer h =128;
        Integer k = 128;
        final Integer l = 129;
        System.out.println(h == k);
        System.out.println(l == 129);
        System.out.println(System.identityHashCode(h));
        System.out.println(System.identityHashCode(k));
        System.out.println(Integer.hashCode(128));
        System.out.println(h.hashCode());
        System.out.println(k.hashCode());
    }
}
