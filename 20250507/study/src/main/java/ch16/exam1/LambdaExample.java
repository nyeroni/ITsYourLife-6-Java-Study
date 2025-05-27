package ch16.exam1;

public class LambdaExample {
    public static void main(String[] args) {
        Person person = new Person();

        person.action(new Workable() {
            @Override
            public void work() {
                System.out.println("출근을 합니다.");
                System.out.println("일을 합니다.");
                System.out.println("점심을 먹습니다.");
            }
        });

        person.action(()-> {
            System.out.println("낮잠을 잡니다.");
            System.out.println("일을 합니다.");
            System.out.println("퇴근 합니다.");
        });
    }
}