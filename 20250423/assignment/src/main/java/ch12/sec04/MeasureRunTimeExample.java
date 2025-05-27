package ch12.sec04;

public class MeasureRunTimeExample {
    public static void main(String[] args) {

        int sum = 0;
        long start = System.nanoTime();

        for(int i = 1; i<=1000000; i++){
            sum+=i;
        }

        long end = System.nanoTime();

        System.out.println("소요시간: " + (end-start) + "ns");
        System.out.println("sum: " + sum);

    }
}
