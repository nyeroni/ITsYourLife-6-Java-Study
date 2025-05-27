package ch06.sec07.exam05;

public class Car {

    String company = "현대자동차";
    String model;
    String color;
    int maxSpeed;

    public Car() {
    }

    //매개변수로 model만 가지는 생성자
    public Car(String model) {
        this(model, "은색", 250);
    }

    //매개변수로 model과 color를 가지는 생성자
    public Car(String model,String color) {
        this(model, color, 250);
    }

    //매개변수로 model, color, maxSpeed를 가지는 생성자
    public Car(String model, String color, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

}


