package string;

/**
 * 详情参照《java核心技术及面试指南》2.4.2
 */

public class ChangeString {
    public static void main(String[] args) {
/*        Person tom = new Person("Tom");
        ChangeString changeString = new ChangeString();
        changeString.changeStr(tom);
        System.out.println(tom.getName());*/

        String str = "old String";
        changeString(str);
        System.out.println(str);
        System.out.println(System.identityHashCode(str));
    }

    public void changeStr(Person p) {
        Person jack = new Person("Jack");
        p = jack;
        System.out.println(p.getName());
    }

    public static void changeString(String str) {
        System.out.println(str);
        System.out.println(System.identityHashCode(str));
        str = "new String";
        System.out.println(str);
        System.out.println(System.identityHashCode(str));
    }
}

final class Person {
    private String name;
    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
