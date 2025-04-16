package ch06.sec08.exam04;


public class CalculatorExample {
    public static void main(String[] args) {
        Calculator myCalculator = new Calculator();
        double result1 = myCalculator.areaRectangle(10);

        double result2 = myCalculator.areaRectangle(10, 20);

        System.out.println("정사각형 넓이=" + result1);
        System.out.println("직사각형 넓이=" + result2);
    }
}
