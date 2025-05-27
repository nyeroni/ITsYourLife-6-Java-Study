package ch16.exam3;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodRefTest {
    public static void main(String[] args) {

        Function<Integer, Integer> abs1 = new Function<Integer, Integer>() {

            @Override
            public Integer apply(Integer integer) {
                return Math.abs(integer);
            }
        };

        System.out.println("abs1.apply(-10) = " + abs1.apply(-10));
        Function<Integer, Integer> abs2 = integer -> Math.abs(integer);
        System.out.println("abs2.apply(-10) = " + abs2.apply(-10));

        Function<Integer, Integer> abs3 = Math::abs;
        System.out.println("abs3.apply(-10) = " + abs3.apply(-10));

        String str = "Hello world";

        Supplier<String> lower1 = new Supplier<String>() {
            @Override
            public String get() {
                return str.toLowerCase();
            }
        };
        Supplier<String> lower2 = ()-> {return str.toLowerCase();};

        Supplier<String> lower3 = str::toLowerCase;

        System.out.println("lower1,get() = " + lower1.get());
        System.out.println("lower2,get() = " + lower2.get());
        System.out.println("lower3,get() = " + lower3.get());


        Function<String , Integer> strLength = String::length;
        System.out.println("Strlength :" + strLength.apply(str));

        System.out.println(strLength.apply("12345"));
        System.out.println(strLength.apply("hello"));


        List<String> nameList = new ArrayList<>();
        nameList.add("John");
        nameList.add("Jane");
        nameList.add("Bob");
        nameList.add("Mary");

        nameList.forEach(item -> System.out.println(item));
        System.out.println("--------");
        nameList.forEach(System.out::println);


        BinaryOperator<Integer> operator1 = (a,b) -> a+b;
        System.out.println("sum1 :" + sumTwoNumbers(operator1, 10,20));
        System.out.println("sum2 :" + sumTwoNumbers((a,b) ->a + b, 10,20));
        System.out.println("sum3 :" + sumTwoNumbers(MethodRefTest::sum, 10,20));
        System.out.println("sum4 :" + sumTwoNumbers(Integer::sum, 10,20));

    }
    public static int sumTwoNumbers(BinaryOperator<Integer> op, int a, int b) {
        return op.apply(a,b);
    }

    public static int sum(int num1, int num2) {
        return num1 + num2;
    }
}