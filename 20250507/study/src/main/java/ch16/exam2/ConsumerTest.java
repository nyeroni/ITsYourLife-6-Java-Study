package ch16.exam2;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerTest {
    public static void main(String[] args) {

        Consumer<String> printString = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("s1 = " + s);
            }
        };

        printString.accept("지금은 2시 11분");

        Consumer<String> printString2 = (String s2) -> {
            System.out.println("S2 = "+ s2);
        };

        printString2.accept("람다식 변환 성공");

        BiConsumer<String, Integer> printNameAge
                = (String s, Integer age) ->
                System.out.println("s = "+ s + " age = " + age);

        printNameAge.accept("홍길동", 25);
    }
}