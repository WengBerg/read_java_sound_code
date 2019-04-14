package ploymorphism;

public class TestPloymorphism {

    public void test1() {
        System.out.println("super");
    }

    public static void main(String[] args) {
        TestPloymorphism t = new TestPloymorphismSub();
        t.test1();
    }
}

class TestPloymorphismSub extends TestPloymorphism {

    @Override
    public void test1() {
        System.out.println("sub");
    }
}
