package ch03.sec01;

public class Function {
    public static void main(String[] args) {
        for(int i=1; i<=10; i++) {
            for(int j=1; j<=10; j++) {
                if(4*i + 5 * j == 60) {
                    System.out.println("(" + i + ", " + j + ")");
                }
            }
        }
    }
}
