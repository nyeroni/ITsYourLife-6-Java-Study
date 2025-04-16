package ch06.심화.sec02;

public class InputTest {
    public static void main(String[] args) {
        String name1 = Input.read("이름");
        System.out.println("입력값: " + name1);
        String name2 = Input.read("이름", "홍길동");
        System.out.println("입력값: " + name2);
        int age = Input.readInt("나이: ");
        System.out.println("입력값: " + age);
        boolean confirm1 = Input.confirm("종료할까요?", true);
        System.out.println("입력값: " + confirm1);
        boolean confirm2 = Input.confirm("종료할까요?", true);
        System.out.println("입력값: " + confirm2);


    }
}
