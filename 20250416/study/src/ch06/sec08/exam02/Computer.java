package ch06.sec08.exam02;

public class Computer {

    public int sum(int a, int b, int c) {
        return a + b + c;
    }

    public int sum(int a, int b, int c, int d, int e) {
        return a + b + c + d + e;
    }

    public int sum(int [] num){
        int sum = 0;
        for (int i : num) sum+=i;

        return sum;
    }

}
