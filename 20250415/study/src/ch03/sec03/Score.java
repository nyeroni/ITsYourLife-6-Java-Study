package ch03.sec03;

import java.util.Scanner;

public class Score {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int student = 0;
        int [] scores = new int[100];
        int maxScore = 0;
        double avgScore = 0;
        while(true) {
            System.out.println("----------------------------------------------------");
            System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
            System.out.println("----------------------------------------------------");

            System.out.print("선택> ");
            int choice = scanner.nextInt();
            if(choice == 5) {
                break;
            }
            switch (choice) {
                case 1:
                    System.out.print("학생수>");
                    student = scanner.nextInt();
                    break;
                case 2:
                    for(int i=0; i<student; i++) {
                        System.out.print("scores[" + i + "]>");
                        scores[i] = scanner.nextInt();
                    }
                    break;
                case 3:
                    for(int i=0; i<student; i++) {
                        System.out.println("scores[" + i + "]: " + scores[i]);
                    }
                    break;
                case 4:
                    int sum = 0;
                    for(int i=0; i<student; i++) {
                       if(maxScore <= scores[i]) {
                           maxScore = scores[i];
                       }
                       sum += scores[i];
                    }
                    avgScore = (double)sum/student;
                    System.out.println("최고 점수: " + maxScore);
                    System.out.println("평균 점수: " + avgScore);
                    break;
                case 5:
                    break;
            }
        }
        System.out.println("프로그램 종료");
    }
}
