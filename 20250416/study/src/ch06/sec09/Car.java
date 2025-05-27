package ch06.sec09;

public class Car {
    String model;
    int speed;

    public Car(String model){
        this.model = model;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void run(){
        System.out.printf("%s가 달립니다.(시속: %dkm/h)",this.model,getSpeed());
    }

}
