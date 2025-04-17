package ch07.sec07.exam02;

public class ChildExample {
    public static void main(String [] args) {
        Child child = new Child();
        Parent parent = child;

        parent.method1();
        parent.method2();
//        parent.method3();
        // 부모는 자식 클래스를 상속받을 수 없음
    }
}
