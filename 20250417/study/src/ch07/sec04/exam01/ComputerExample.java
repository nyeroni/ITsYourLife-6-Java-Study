package ch07.sec04.exam01;

public class ComputerExample {
    public static void main(String[] args) {

        Computer computer = new Computer();
        Calculator calculator = new Calculator();

        System.out.println(computer.areaCircle(5));
        System.out.println();
        System.out.println(calculator.areaCircle(5));

    }
}
