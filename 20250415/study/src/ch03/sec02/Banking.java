package ch03.sec02;

import java.util.Scanner;

public class Banking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int money= 0, num= 0;
        while(true) {
            System.out.println("----------------------------------");
            System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
            System.out.println("----------------------------------");

            System.out.print("선택> ");
            int choice = scanner.nextInt();
            if(choice == 4) {
                break;
            }
            switch (choice) {
                case 1:
                    System.out.print("예금액>");
                    num = scanner.nextInt();
                    money += num;
                    break;
                case 2:
                    System.out.print("출금액>");
                    num = scanner.nextInt();
                    money -= num;
                    break;
                case 3:
                    System.out.println("잔고>" + money);
                    break;
                case 4:
                    break;
            }
        }
        System.out.println("프로그램 종료");
    }
}
