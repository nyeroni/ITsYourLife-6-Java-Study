package ch17.sec04.exam02;

import java.util.Arrays;

public class StreamExample {
    public static void main(String[] args) {
        String [] strArray = {"홍길동","신용권","김미나"};
        int [] intArray = {1,2,3,4,5};

        Arrays.stream(strArray).forEach(item -> System.out.print(item+","));
        System.out.println();
        Arrays.stream(intArray).forEach(item -> System.out.print(item+","));
        System.out.println();
    }
}
