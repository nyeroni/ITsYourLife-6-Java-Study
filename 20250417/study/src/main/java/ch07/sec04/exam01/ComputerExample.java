package ch07.sec04.exam01;

public class ComputerExample {
    private static final int RADIUS = 3;
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println("원의 면적 : "+ calculator.areaCircle(RADIUS));
        Computer computer = new Computer();
        System.out.println("원의 면적 : " + computer.areaCircle(RADIUS));
    }
}
