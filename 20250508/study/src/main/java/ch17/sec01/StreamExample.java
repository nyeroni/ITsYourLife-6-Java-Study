package ch17.sec01;

import java.util.HashSet;
import java.util.Set;

public class StreamExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("홍길동");
        set.add("신용권");
        set.add("감자바");

        set.stream().forEach(System.out::println);
    }
}
