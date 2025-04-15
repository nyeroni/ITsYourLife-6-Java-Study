package ch03.sec01;

public class OneToHundred {
    public static void main(String[] args) {
        int answer = 0;
        for(int i=1; i<=100; i++) {
            if(i%3==0) {
                answer += i;
            }
        }
        System.out.println("3의 배수  : " + answer);
    }
}
