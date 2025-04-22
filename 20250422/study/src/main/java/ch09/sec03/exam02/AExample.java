package ch09.sec03.exam02;

import ch09.sec03.exam02.A.B;

public class AExample {
    public static void main(String[] args) {
        A.B b = new A.B();
        System.out.println(b.field1);

        b.method1();

        System.out.println(B.field2);
        A.B.method2();
    }
}
