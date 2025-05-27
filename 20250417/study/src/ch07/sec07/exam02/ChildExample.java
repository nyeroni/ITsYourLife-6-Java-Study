package ch07.sec07.exam02;

public class ChildExample {
    public static void main(String[] args) {
        Child child = new Child();
        Parent parent = child;

        parent.method1();
        parent.method2();
        //parent.method3(); 호출이 불가능함 ! parent에는 method3() 메서드가 존재하지 않음 !

    }
}
